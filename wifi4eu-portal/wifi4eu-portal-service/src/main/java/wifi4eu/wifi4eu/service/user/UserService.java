package wifi4eu.wifi4eu.service.user;

import com.google.common.collect.Lists;
import org.apache.commons.lang.time.DateUtils;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import wifi4eu.wifi4eu.common.Constant;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.dto.security.ActivateAccountDTO;
import wifi4eu.wifi4eu.common.dto.security.TempTokenDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.enums.InvitationContactStatus;
import wifi4eu.wifi4eu.common.enums.RegistrationUsersStatus;
import wifi4eu.wifi4eu.common.enums.SupplierUserStatus;
import wifi4eu.wifi4eu.common.exception.AppException;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.security.TokenGenerator;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.entity.invitationContacts.InvitationContact;
import wifi4eu.wifi4eu.entity.mayor.Mayor;
import wifi4eu.wifi4eu.entity.municipality.Municipality;
import wifi4eu.wifi4eu.entity.registration.Registration;
import wifi4eu.wifi4eu.entity.registration.RegistrationUsers;
import wifi4eu.wifi4eu.entity.security.RightConstants;
import wifi4eu.wifi4eu.entity.security.TempToken;
import wifi4eu.wifi4eu.entity.supplier.SupplierUser;
import wifi4eu.wifi4eu.mapper.security.TempTokenMapper;
import wifi4eu.wifi4eu.mapper.supplier.SuppliedRegionMapper;
import wifi4eu.wifi4eu.mapper.supplier.SupplierMapper;
import wifi4eu.wifi4eu.mapper.supplier.SupplierUserMapper;
import wifi4eu.wifi4eu.mapper.user.UserMapper;
import wifi4eu.wifi4eu.repository.invitationContacts.InvitationContactRepository;
import wifi4eu.wifi4eu.repository.mayor.MayorRepository;
import wifi4eu.wifi4eu.repository.municipality.MunicipalityRepository;
import wifi4eu.wifi4eu.repository.registration.RegistrationRepository;
import wifi4eu.wifi4eu.repository.registration.RegistrationUsersRepository;
import wifi4eu.wifi4eu.repository.security.TempTokenRepository;
import wifi4eu.wifi4eu.repository.supplier.SuppliedRegionRepository;
import wifi4eu.wifi4eu.repository.supplier.SupplierRepository;
import wifi4eu.wifi4eu.repository.supplier.SupplierUserRepository;
import wifi4eu.wifi4eu.repository.user.UserRepository;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.supplier.SupplierService;
import wifi4eu.wifi4eu.service.thread.UserThreadsService;
import wifi4eu.wifi4eu.util.MailService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.security.SecureRandom;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Configuration
@PropertySource("classpath:env.properties")
@Service
public class UserService {
    private final Logger _log = LogManager.getLogger(UserService.class);

    @Value("${mail.server.location}")
    private String baseUrl;

    @Value("${ecas.location}")
    private String ecasUrl;

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TempTokenMapper tempTokenMapper;

    @Autowired
    TempTokenRepository tempTokenRepository;

    @Autowired
    MailService mailService;

    @Autowired
    PermissionChecker permissionChecker;

    @Autowired
    MunicipalityService municipalityService;

    @Autowired
    SupplierService supplierService;

    @Autowired
    SupplierMapper supplierMapper;

    @Autowired
    SupplierUserMapper supplierUserMapper;

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    SupplierUserRepository supplierUserRepository;

    @Autowired
    SuppliedRegionMapper suppliedRegionMapper;

    @Autowired
    SuppliedRegionRepository suppliedRegionRepository;

    @Autowired
    UserThreadsService userThreadsService;

    @Autowired
    RegistrationUsersRepository registrationUsersRepository;

    @Autowired
    RegistrationRepository registrationRepository;

    @Autowired
    MayorRepository mayorRepository;

    @Autowired
    MunicipalityRepository municipalityRepository;

    @Autowired
    InvitationContactRepository invitationContactRepository;

    public List<UserDTO> getAllUsers() {
        return userMapper.toDTOList(Lists.newArrayList(userRepository.findAll()));
    }

    public UserDTO getUserById(int userId) {
        return userMapper.toDTO(userRepository.findOne(userId));
    }

    public UserDTO getUserByEmail(String email) {
        return userMapper.toDTO(userRepository.findByEmail(email));
    }

    public UserDTO getUserByEcasEmail(String email) {
        return userMapper.toDTO(userRepository.findByEcasEmail(email));
    }

    @Transactional
    public UserDTO createUser(UserDTO userDTO) throws Exception {
        UserDTO searchUser = getUserByEmail(userDTO.getEcasEmail());
        if (searchUser != null) {
            userDTO.setPassword(searchUser.getPassword());
            throw new Exception("User already registered.");
        }
        UserDTO resUser = userMapper.toDTO(userRepository.save(userMapper.toEntity(userDTO)));
        sendActivateAccountMail(resUser);
        return resUser;
    }

    @Transactional
    public UserDTO saveUserChanges(UserDTO userDTO) throws Exception {
        UserDTO searchUser = getUserById(userDTO.getId());
        if (searchUser != null) {
            userDTO.setPassword(searchUser.getPassword());
            UserDTO resUser = userMapper.toDTO(userRepository.save(userMapper.toEntity(userDTO)));
            permissionChecker.addTablePermissions(userDTO, Integer.toString(resUser.getId()),
                    RightConstants.USER_TABLE, "[USER] - id: " + userDTO.getId() + " - Email: " + userDTO.getEcasEmail() + " - EcasUsername: " + userDTO.getEcasUsername());
            return resUser;
        } else {
            throw new Exception("User doesn't exist.");
        }
    }

    @Transactional
    public UserDTO getUserByUserContext(UserContext userContext) {
        if (userContext == null) {
            throw new AppException("User context not defined", HttpStatus.SC_FORBIDDEN, "");
        }
        _log.debug("User Email: " + userContext.getEmail() + " and User PerId: " + userContext.getPerId());

        UserDTO userDTO = userMapper.toDTO(userRepository.findByEcasUsername(userContext.getUsername()));

        if (userDTO == null) {
            userDTO = new UserDTO();
            userDTO.setAccessDate(new Date().getTime());
            userDTO.setEcasEmail(userContext.getEmail());
            userDTO.setEcasUsername(userContext.getUsername());
            userDTO.setName(userContext.getFirstName());
            userDTO.setSurname(userContext.getLastName());
            userDTO.setEmail(userContext.getEmail());
            userDTO = userMapper.toDTO(userRepository.save(userMapper.toEntity(userDTO)));
            permissionChecker.addTablePermissions(userDTO, Integer.toString(userDTO.getId()),
                    RightConstants.USER_TABLE, "[USER] - id: " + userDTO.getId() + " - Email: " + userDTO.getEcasEmail() + " - EcasUsername: " + userDTO.getEcasUsername());
        }
        return userDTO;
    }

    @Transactional
    public void saveInvitedUserModified(UserDTO userDTO){
        // Missing supplier part
        if (userDTO.getType() == 0){
            userDTO.setType(((Long)Constant.ROLE_REPRESENTATIVE_CONTACT).intValue());
            userDTO.setLang(UserConstants.DEFAULT_LANG);
            userRepository.save(userMapper.toEntity(userDTO));
            InvitationContact invitationContact = invitationContactRepository.findByEmailInvitedAndStatus(userDTO.getEcasEmail(), InvitationContactStatus.PENDING.getValue());
            if (Validator.isNotNull(invitationContact)){
                long idUser = userRepository.findByEcasUsername(userDTO.getEcasUsername()).getId();
                Date today = new Date();
                invitationContact.setStatus(InvitationContactStatus.OK.getValue());
                invitationContact.setLastModified(today);
                RegistrationUsers registrationUsers = new RegistrationUsers();
                registrationUsers.setContactEmail(userDTO.getEcasEmail());
                registrationUsers.setCreationDate(today);
                registrationUsers.setMain(0);
                registrationUsers.setRegistrationId(invitationContact.getIdRegistration());
                registrationUsers.setStatus(RegistrationUsersStatus.REGISTERED.getValue());
                registrationUsers.setUserId((int) idUser);
                Registration registration = registrationRepository.findOne(invitationContact.getIdRegistration());
                Mayor mayor = mayorRepository.findByMunicipalityId(registration.getMunicipality().getId());
                permissionChecker.addTablePermissions(userDTO, Integer.toString(mayor.getId()),
                        RightConstants.MAYORS_TABLE, "[MAYORS] - id: " + mayor.getId() + " - Email: " + mayor.getEmail() + " - Municipality Id: " + mayor.getMunicipality().getId());
                permissionChecker.addTablePermissions(userDTO, Integer.toString(registration.getId()),
                        RightConstants.REGISTRATIONS_TABLE, "[REGISTRATIONS] - id: " + registration.getId() + " - Role: " + registration.getRole() + " - Municipality Id: " + registration.getMunicipality().getId());
                permissionChecker.addTablePermissions(userDTO, Integer.toString(registration.getMunicipality().getId()),
                        RightConstants.MUNICIPALITIES_TABLE, "[MUNICIPALITIES] - id: " + registration.getMunicipality().getId() + " - Country: " + registration.getMunicipality().getCountry() + " - Lau Id: " + registration.getMunicipality().getLau().getId());
                registrationUsersRepository.save(registrationUsers);
                invitationContactRepository.save(invitationContact);
            }
        }
    }

    @Transactional
    public void saveInvitedUser(String userEmail, UserDTO userDTO) {
        List<RegistrationUsers> registrationUsers = registrationUsersRepository.findByContactEmailAndStatus(userEmail, RegistrationUsersStatus.UNREGISTERED.getValue());

        for (RegistrationUsers resRegistrationUser : registrationUsers) {
            if ((resRegistrationUser.getCreationDate().toInstant().plus(24, ChronoUnit.HOURS).compareTo(new Date().toInstant()) < 0)) {
                if (userDTO.getType() == 0) {
                    userDTO.setType(((Long)Constant.ROLE_REPRESENTATIVE_CONTACT).intValue());
                    userDTO.setLang(UserConstants.DEFAULT_LANG);
                    userRepository.save(userMapper.toEntity(userDTO));
                }

                if (resRegistrationUser.getUserId() == null) {
                    resRegistrationUser.setUserId(userRepository.findByEcasUsername(userDTO.getEcasUsername()).getId());
                    registrationUsersRepository.save(resRegistrationUser);
                    Registration registration = registrationRepository.findOne(resRegistrationUser.getRegistrationId());
                    Municipality municipality = municipalityRepository.findOne(registration.getMunicipality().getId());
                    Mayor mayor = mayorRepository.findByMunicipalityId(municipality.getId());
                    permissionChecker.addTablePermissions(userDTO, Integer.toString(mayor.getId()),
                            RightConstants.MAYORS_TABLE, "[MAYORS] - id: " + mayor.getId() + " - Email: " + mayor.getEmail() + " - Municipality Id: " + mayor.getMunicipality().getId());
                    permissionChecker.addTablePermissions(userDTO, Integer.toString(registration.getId()),
                            RightConstants.REGISTRATIONS_TABLE, "[REGISTRATIONS] - id: " + registration.getId() + " - Role: " + registration.getRole() + " - Municipality Id: " + registration.getMunicipality().getId());
                    permissionChecker.addTablePermissions(userDTO, Integer.toString(municipality.getId()),
                            RightConstants.MUNICIPALITIES_TABLE, "[MUNICIPALITIES] - id: " + municipality.getId() + " - Country: " + municipality.getCountry() + " - Lau Id: " + municipality.getLau().getId());
                }
            }
        }

        List<SupplierUser> supplierUsers = supplierUserRepository.findByEmailAndStatus(userDTO.getEmail(), SupplierUserStatus.NOT_REGISTERED.getStatus());
        List<SupplierUser> supplierUsersToUpdate = new ArrayList<>();
        int userId = userRepository.findByEcasUsername(userDTO.getEcasUsername()).getId();

        if (supplierUsers != null && ((userDTO.getType() == 0) || (userDTO.getType() == 1))){
            for(SupplierUser supplierUser:supplierUsers){
                if (supplierUser.getUserId() == null){
                    if (supplierService.createdLessThan24HBefore(supplierUserMapper.toDTO(supplierUser))){
                        if(userDTO.getType() == 0){
                            userDTO.setType(((Long)Constant.ROLE_SUPPLIER_CONTACT).intValue());
                            userDTO.setLang(UserConstants.DEFAULT_LANG);
                            userRepository.save(userMapper.toEntity(userDTO));
                        }
                        supplierUser.setUserId(userId);
                        supplierUser.setStatus(SupplierUserStatus.ALREADY_REGISTERED.getStatus());
                        supplierUsersToUpdate.add(supplierUser);
                    }
                }
            }
            supplierUserRepository.save(supplierUsersToUpdate);
        }
    }

    @Transactional
    public UserDTO deleteUser(int userId, HttpServletRequest request) {
        UserDTO userDTO = userMapper.toDTO(userRepository.findOne(userId));
        if (userDTO != null) {
            switch (userDTO.getType()) {
                case (int) Constant.ROLE_REPRESENTATIVE:

                    //first remove connections with registration by setting the status to deleted
                    List<RegistrationUsers> registrationUsers = registrationUsersRepository.findByUserId(userDTO.getId());
                    for(RegistrationUsers rUser : registrationUsers){
                        rUser.setStatus(RegistrationUsersStatus.DELETED.getValue());
                    }
                    registrationUsersRepository.save(registrationUsers);

                    removeTempToken(userDTO);
                    for (MunicipalityDTO municipality : municipalityService.getMunicipalitiesByUserId(userDTO.getId())) {
                        municipalityService.deleteMunicipality(municipality.getId(), request);
                    }
                    for (UserThreadsDTO userThread : userThreadsService.getUserThreadsByUserId(userDTO.getId())) {
                        userThreadsService.deleteUserThreads(userThread.getId());
                    }
                    break;
                case (int) Constant.ROLE_SUPPLIER:

                    //first remove connections with suppliers by setting the status to deleted
                    List<SupplierUser> supplierUsers = supplierUserRepository.findByUserId(userDTO.getId());
                    for(SupplierUser sUser : supplierUsers){
                        sUser.setStatus(SupplierUserStatus.DELETED.getStatus());
                    }
                    supplierUserRepository.save(supplierUsers);


                    removeTempToken(userDTO);
                    removeSuppliedRegion(userDTO);

                    SupplierDTO supplier = supplierService.getSupplierByUserId(userDTO.getId());
                    if (supplier != null) {
                        supplierService.deleteSupplier(supplier.getId());
                    }
                    break;
            }
            userRepository.delete(userMapper.toEntity(userDTO));
            return userDTO;
        } else {
            return null;
        }
    }

    @Transactional
    public UserDTO updateUserDetails(UserDTO userDTO, String name, String surname) {

        userDTO.setName(name);
        userDTO.setSurname(surname);

        return userMapper.toDTO(userRepository.save(userMapper.toEntity(userDTO)));
    }

    public List<UserDTO> getUsersByType(int type) {
        return userMapper.toDTOList(Lists.newArrayList(userRepository.findByType(type)));
    }

    public UserDTO login(UserDTO userDTO) {
        UserDTO resUser = userMapper.toDTO(userRepository.findByEmail(userDTO.getEcasEmail()));
        if (resUser != null && userDTO.getPassword().equals(resUser.getPassword())) {
            resUser.setAccessDate(new Date().getTime());
            resUser = userMapper.toDTO(userRepository.save(userMapper.toEntity(resUser)));
            return resUser;
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }

    public void activateAccount(ActivateAccountDTO activateAccountDTO) throws Exception {
        TempTokenDTO tempToken = tempTokenMapper.toDTO(tempTokenRepository.findByToken(activateAccountDTO.getToken()));
        Date now = new Date();
        if (tempToken != null) {
            if (new Date(tempToken.getExpiryDate()).after(now)) {
                UserContext userContext = UserHolder.getUser();
                UserDTO user;
                if (userContext != null) {
                    //ECAS user
                    user = getUserByUserContext(userContext);
                    if (tempToken.getUserId() != user.getId()) {
                        throw new Exception("Token doesn't match with the ECAS user");
                    }
                } else {
                    //
                    user = userMapper.toDTO(userRepository.findOne(tempToken.getUserId()));
                    user.setPassword(activateAccountDTO.getPassword());
                }
                user.setVerified(true);
                userRepository.save(userMapper.toEntity(user));
            } else {
                throw new Exception("Token has expired.");
            }
        } else {
            throw new Exception("Token doesn't exist.");
        }
    }

    @Transactional
    public Cookie getCSRFCookie() throws AppException {
        Cookie cookie = null;
        cookie = new Cookie("XSRF-TOKEN", generateCSRFToken());
        cookie.setSecure(true);
        cookie.setMaxAge(365 * 24 * 60 * 60);
        cookie.setPath("/");
        return cookie;
    }

    private String generateCSRFToken() throws AppException {
        String token = new TokenGenerator().generate();

        if (token != null && token.length() > 0) {
            UserContext userContext = UserHolder.getUser();
            UserDTO user;
            if (userContext != null) {
                user = getUserByUserContext(userContext);
                if (user != null) {
                    user.setCsrfToken(token);
                    userRepository.save(userMapper.toEntity(user));
                } else {
                    throw new AppException("Contact your administrator", HttpStatus.SC_INTERNAL_SERVER_ERROR, "");
                }
            } else {
                throw new AppException("Contact your administrator", HttpStatus.SC_INTERNAL_SERVER_ERROR, "");
            }
        } else {
            throw new AppException("Contact your administrator", HttpStatus.SC_INTERNAL_SERVER_ERROR, "");
        }

        return token;
    }

    @Transactional
    public void sendActivateAccountMail(UserDTO userDTO) {
        Date now = new Date();
        TempTokenDTO tempTokenDTO = new TempTokenDTO();
        tempTokenDTO.setEmail(userDTO.getEcasEmail());
        tempTokenDTO.setUserId(userDTO.getId());
        tempTokenDTO.setCreateDate(now.getTime());
        tempTokenDTO.setExpiryDate(DateUtils.addHours(now, UserConstants.TIMEFRAME_ACTIVATE_ACCOUNT_HOURS).getTime());
        SecureRandom secureRandom = new SecureRandom();
        String token = Long.toString(secureRandom.nextLong()).concat(Long.toString(now.getTime())).replaceAll("-", "");
        tempTokenDTO.setToken(token);
        tempTokenDTO = tempTokenMapper.toDTO(tempTokenRepository.save(tempTokenMapper.toEntity(tempTokenDTO)));
        permissionChecker.addTablePermissions(userDTO, Long.toString(tempTokenDTO.getId()),
                RightConstants.TEMP_TOKENS_TABLE, "[TEMP_TOKENS] - id: " + tempTokenDTO.getId() + " - User Id: " + tempTokenDTO.getUserId() + " - TOKEN: " + tempTokenDTO.getToken());

        Locale locale = new Locale(UserConstants.DEFAULT_LANG);
        if (userDTO.getLang() != null) {
            locale = new Locale(userDTO.getLang());
        }
        ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
        String subject = bundle.getString("mail.subject");
        String msgBody = bundle.getString("mail.body");

        if (!isLocalHost()) {
            mailService.sendEmail(userDTO.getEcasEmail(), MailService.FROM_ADDRESS, subject, msgBody);
        }
    }

    public boolean resendEmail(String email) {
        UserDTO userDTO = userMapper.toDTO(userRepository.findByEmail(email));
        if (userDTO != null) {
            sendActivateAccountMail(userDTO);
            return true;
        } else {
            return false;
        }
    }


    public void forgotPassword(String email) throws Exception {

        UserContext userContext = UserHolder.getUser();
        UserDTO user = getUserByUserContext(userContext);

        if (user == null) {
            /* validate email variable is not null or empty */
            if (email != null && !StringUtils.isEmpty(email)) {
                UserDTO userDTO = userMapper.toDTO(userRepository.findByEmail(email));
                /* validate if user exist in wifi4eu portal */
                if (userDTO != null) {
                    /* Create a temporal key for activation and reset password functionalities */
                    TempTokenDTO tempTokenDTO = tempTokenMapper.toDTO(tempTokenRepository.findByEmail(email));
                    if (tempTokenDTO == null) {
                        tempTokenDTO = new TempTokenDTO();
                        tempTokenDTO.setEmail(email);
                        tempTokenDTO.setUserId(userDTO.getId());
                    }
                    Date now = new Date();
                    tempTokenDTO.setCreateDate(now.getTime());
                    tempTokenDTO.setExpiryDate(DateUtils.addHours(now, UserConstants.TIMEFRAME_ACTIVATE_ACCOUNT_HOURS).getTime());
                    SecureRandom secureRandom = new SecureRandom();
                    String token = Long.toString(secureRandom.nextLong()).concat(Long.toString(now.getTime())).replaceAll("-", "");
                    tempTokenDTO.setToken(token);

                    tempTokenRepository.save(tempTokenMapper.toEntity(tempTokenDTO));

                    /* Send email with */
                    String fromAddress = MailService.FROM_ADDRESS;
                    //TODO: translate subject and msgBody
                    String subject = "wifi4eu portal Forgot Password";
                    String msgBody = "you can access to the next link and reset your password " + baseUrl + UserConstants.RESET_PASS_URL + tempTokenDTO.getToken();
                    mailService.sendEmail(email, fromAddress, subject, msgBody);
                } else {
                    throw new Exception("trying to forgetPassword with an unregistered user");
                }
            } else {
                throw new Exception("trying to forgetPassword without an email");
            }
        } else {
            throw new Exception("ECAS user has to go throw ECAS portal to manage the password");
        }
    }

    public boolean isLocalHost() {
        return baseUrl.contains(UserConstants.LOCAL);
    }

    public String getLogoutEnviroment() {
        UserContext userContext = UserHolder.getUser();

        if (!UserConstants.MOCKED_MAIL.equals(userContext.getEmail())) {
            return "https://ecas.ec.europa.eu/cas/logout";
        } else {
            return "http://localhost:8080/wifi4eu/#/beneficiary-registration";
        }
    }

    public String getChangePassword() {
        return "https://ecas.ec.europa.eu/cas/change/changePassword.cgi";
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getEcasUrl() {
        return ecasUrl;
    }

    private void removeTempToken(UserDTO userDTO) {
        for (TempToken tempToken : tempTokenRepository.findByUserId(userDTO.getId())) {
            tempTokenRepository.delete(tempToken);
        }
    }

    private void removeSuppliedRegion(UserDTO userDTO) {
        SupplierDTO supplierDTO = supplierService.getSupplierByUserId(userDTO.getId());
        List<SuppliedRegionDTO> suppliedRegionDTOList = supplierDTO.getSuppliedRegions();
        for (SuppliedRegionDTO anElementList : suppliedRegionDTOList) {
            suppliedRegionRepository.delete(suppliedRegionMapper.toEntity(anElementList));
        }
    }

    public UserDTO updateLanguage(UserDTO userDTO, String lang) {
        userDTO.setLang(lang);
        return userMapper.toDTO(userRepository.save(userMapper.toEntity(userDTO)));
    }

    public void createNewRegistrationUser(UserRegistrationDTO userRegistrationDTO) {
        RegistrationUsers registrationUsers = new RegistrationUsers();
        Integer registrationId = registrationRepository.findByMunicipalityId(userRegistrationDTO.getMunicipalityId()).getId();
        registrationUsers.setContactEmail(userRegistrationDTO.getEmail());
        registrationUsers.setCreationDate(new Date());
        registrationUsers.setRegistrationId(registrationId);
        registrationUsers.setStatus(0);
        registrationUsers.setMain(0);
        registrationUsersRepository.save(registrationUsers);
    }
}
