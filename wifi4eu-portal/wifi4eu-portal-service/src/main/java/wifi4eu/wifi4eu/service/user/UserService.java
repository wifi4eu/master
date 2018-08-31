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
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
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
import wifi4eu.wifi4eu.common.utils.Utils;
import wifi4eu.wifi4eu.entity.invitationContacts.InvitationContact;
import wifi4eu.wifi4eu.entity.mayor.Mayor;
import wifi4eu.wifi4eu.entity.municipality.Municipality;
import wifi4eu.wifi4eu.entity.registration.Registration;
import wifi4eu.wifi4eu.entity.registration.RegistrationUsers;
import wifi4eu.wifi4eu.entity.security.RightConstants;
import wifi4eu.wifi4eu.entity.security.TempToken;
import wifi4eu.wifi4eu.entity.supplier.SupplierUser;
import wifi4eu.wifi4eu.entity.user.User;
import wifi4eu.wifi4eu.entity.user.UserContactDetails;
import wifi4eu.wifi4eu.mapper.security.TempTokenMapper;
import wifi4eu.wifi4eu.mapper.supplier.SuppliedRegionMapper;
import wifi4eu.wifi4eu.mapper.supplier.SupplierMapper;
import wifi4eu.wifi4eu.mapper.supplier.SupplierUserMapper;
import wifi4eu.wifi4eu.mapper.user.UserMapper;
import wifi4eu.wifi4eu.repository.invitationContacts.InvitationContactRepository;
import wifi4eu.wifi4eu.repository.mayor.MayorRepository;
import wifi4eu.wifi4eu.repository.municipality.MunicipalityRepository;
import wifi4eu.wifi4eu.repository.registration.ConditionsAgreementRepository;
import wifi4eu.wifi4eu.repository.registration.RegistrationRepository;
import wifi4eu.wifi4eu.repository.registration.RegistrationUsersRepository;
import wifi4eu.wifi4eu.repository.security.RightRepository;
import wifi4eu.wifi4eu.repository.security.TempTokenRepository;
import wifi4eu.wifi4eu.repository.supplier.SuppliedRegionRepository;
import wifi4eu.wifi4eu.repository.supplier.SupplierRepository;
import wifi4eu.wifi4eu.repository.supplier.SupplierUserRepository;
import wifi4eu.wifi4eu.repository.user.UserRepository;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.supplier.SupplierService;
import wifi4eu.wifi4eu.service.thread.UserThreadsService;
import wifi4eu.wifi4eu.util.MailService;
import wifi4eu.wifi4eu.util.RedisUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.security.SecureRandom;
import java.time.LocalDate;
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

    @Value("${server.address}")
    private String serverAddress;

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

    @Autowired
    ConditionsAgreementRepository conditionsAgreementRepository;
    
    @Autowired
    ApplicationService applicationService;

    @Autowired
    RightRepository rightRepository;

    @Autowired
    private RedisUtil redisUtil;

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
        if (userDTO.getId() != 0) {
            _log.warn("Call to a create method with id set, the value has been removed ({})", userDTO.getId());
            userDTO.setId(0);
        }
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
    public UserDTO checkIfInvitedUser(UserDTO userDTO){
        if (userDTO.getType() == 0){
            InvitationContact invitationContact = invitationContactRepository.findByEmailInvitedAndStatus(userDTO.getEcasEmail(), InvitationContactStatus.PENDING.getValue());
            if (Validator.isNotNull(invitationContact)){
                userDTO.setUserInvited(true);
                long hours = Utils.getHoursBetweenDates(invitationContact.getLastModified(), new Date());
                if (hours >= 24){
                    userDTO.setUserInvitedFor(0);
                } else {
                    if (Validator.isNotNull(invitationContact.getIdRegistration()) && invitationContact.getIdRegistration() != 0){
                        userDTO.setUserInvitedFor((int) Constant.ROLE_REPRESENTATIVE);
                    } else if (Validator.isNotNull(invitationContact.getIdSupplier()) && invitationContact.getIdSupplier() != 0){
                        userDTO.setUserInvitedFor((int) Constant.ROLE_SUPPLIER);
                    }
                }
            }
        }
        return userDTO;
    }

    public boolean createAddContact(UserDTO userDTO, UserDTO userConnected){
        if (Validator.isNotNull(userDTO)) {
            InvitationContact invitationContact = invitationContactRepository.findByEmailInvitedAndStatus(userConnected.getEcasEmail(), InvitationContactStatus.PENDING.getValue());
            if (Validator.isNotNull(invitationContact) && checkFieldsContactDetails(userDTO, invitationContact.getType())) {
                userConnected.setName(userDTO.getName());
                userConnected.setSurname(userDTO.getSurname());
                if (invitationContact.getIdRegistration() != null && invitationContact.getIdRegistration() != 0) {
                    userConnected.setCity(userDTO.getCity());
                    userConnected.setCountry(userDTO.getCountry());
                    userConnected.setAddress(userDTO.getAddress());
                    userConnected.setAddressNum(userDTO.getAddressNum());
                    userConnected.setPostalCode(userDTO.getPostalCode());
                    userConnected.setType(((Long) Constant.ROLE_REPRESENTATIVE).intValue());
                    createRegistrationUser(userConnected, invitationContact.getIdRegistration());
                } else if (invitationContact.getIdSupplier() != null && invitationContact.getIdSupplier() != 0) {
                    userConnected.setPhonePrefix(userDTO.getPhonePrefix());
                    userConnected.setPhoneNumber(userDTO.getPhoneNumber());
                    userConnected.setType(((Long) Constant.ROLE_SUPPLIER).intValue());
                    createSupplierUser(userConnected, invitationContact.getIdSupplier());
                } else {
                    return false;
                }
                UserDTO userDTOInvitatorDTO = getUserById(invitationContact.getIdUserRequest());
                userConnected.setLang(userDTOInvitatorDTO.getLang());
                userRepository.save(userMapper.toEntity(userConnected));
                invitationContact.setStatus(InvitationContactStatus.OK.getValue());
                invitationContact.setLastModified(new Date());
                invitationContactRepository.save(invitationContact);
                return true;
            }
        }
        return false;
    }

    private boolean checkFieldsContactDetails(UserDTO userDTO, int type){
        if (type == ((Long) Constant.ROLE_REPRESENTATIVE).intValue()) {
            return Validator.isNotNull(userDTO.getName()) && Validator.isNotNull(userDTO.getSurname())
                    && Validator.isNotNull(userDTO.getAddress()) && Validator.isNotNull(userDTO.getAddressNum())
                    && Validator.isNotNull(userDTO.getCity()) && Validator.isNotNull(userDTO.getCountry())
                    && Validator.isNotNull(userDTO.getPostalCode()) && !userDTO.getAddress().isEmpty()
                    && !userDTO.getAddressNum().isEmpty() && !userDTO.getCity().isEmpty()
                    && !userDTO.getCountry().isEmpty() && !userDTO.getPostalCode().isEmpty()
                    && !userDTO.getName().isEmpty() && !userDTO.getSurname().isEmpty();
        } else if (type == ((Long) Constant.ROLE_SUPPLIER).intValue()) {
            return Validator.isNotNull(userDTO.getName()) && Validator.isNotNull(userDTO.getSurname())
                    && Validator.isNotNull(userDTO.getPhoneNumber()) && Validator.isNotNull(userDTO.getPhonePrefix())
                    && !userDTO.getName().isEmpty() && !userDTO.getSurname().isEmpty()
                    && !userDTO.getPhoneNumber().isEmpty() && !userDTO.getPhonePrefix().isEmpty();
        }

        return false;
    }


    private void createRegistrationUser(UserDTO userDTO, Integer registrationId){
        RegistrationUsers registrationUsers = new RegistrationUsers();
        registrationUsers.setContactEmail(userDTO.getEcasEmail());
        registrationUsers.setCreationDate(new Date());
        registrationUsers.setMain(0);
        registrationUsers.setRegistrationId(registrationId);
        registrationUsers.setStatus(RegistrationUsersStatus.REGISTERED.getValue());
        registrationUsers.setUserId(userDTO.getId());
        Registration registration = registrationRepository.findOne(registrationId);
        Mayor mayor = mayorRepository.findByMunicipalityId(registration.getMunicipality().getId());
        permissionChecker.addTablePermissions(userDTO, Integer.toString(mayor.getId()),
                RightConstants.MAYORS_TABLE, "[MAYORS] - id: " + mayor.getId() + " - Email: " + mayor.getEmail() + " - Municipality Id: " + mayor.getMunicipality().getId());
        permissionChecker.addTablePermissions(userDTO, Integer.toString(registration.getId()),
                RightConstants.REGISTRATIONS_TABLE, "[REGISTRATIONS] - id: " + registration.getId() + " - Role: " + registration.getRole() + " - Municipality Id: " + registration.getMunicipality().getId());
        permissionChecker.addTablePermissions(userDTO, Integer.toString(registration.getMunicipality().getId()),
                RightConstants.MUNICIPALITIES_TABLE, "[MUNICIPALITIES] - id: " + registration.getMunicipality().getId() + " - Country: " + registration.getMunicipality().getCountry() + " - Lau Id: " + registration.getMunicipality().getLau().getId());
        registrationUsers = registrationUsersRepository.save(registrationUsers);

        if (Validator.isNotNull(registrationUsers)) {
            redisUtil.sync(userDTO.getId());
        }
    }

    private void createSupplierUser(UserDTO userDTO, Integer supplierId){
        SupplierUser supplierUser = new SupplierUser();
        supplierUser.setEmail(userDTO.getEcasEmail());
        supplierUser.setCreationDate(new Date());
        supplierUser.setMain(0);
        supplierUser.setSupplierId(supplierId);
        supplierUser.setStatus(RegistrationUsersStatus.REGISTERED.getValue());
        supplierUser.setUserId(userDTO.getId());

        SupplierDTO supplierDTO = supplierService.getSupplierById(supplierId);

        permissionChecker.addTablePermissions(userDTO, Integer.toString(supplierId),
                RightConstants.USER_TABLE, "[SUPPLIERS] - id: " + supplierId + " - Email: " + supplierDTO.getContactEmail());
        supplierUserRepository.save(supplierUser);
    }

    @Transactional
    public void deleteInvitationByUser(String email){
        invitationContactRepository.delete(invitationContactRepository.findByEmailInvited(email));
    }

    @Transactional
    public ResponseDTO deleteUser(int userId, HttpServletRequest request) {
        UserDTO userDTO = userMapper.toDTO(userRepository.findOne(userId));
        if (Validator.isNotNull(userDTO)) {
            switch (userDTO.getType()) {
                case (int) Constant.ROLE_REPRESENTATIVE:

                    if(applicationService.applicationsByListOfMunicipalities(userDTO.getId()).size() == 0){

                        for (MunicipalityDTO municipality : municipalityService.getMunicipalitiesByUserId(userDTO.getId())) {
                            municipalityService.deleteMunicipality(municipality.getId(), request);
                        }
                        for (UserThreadsDTO userThread : userThreadsService.getUserThreadsByUserId(userDTO.getId())) {
                            userThreadsService.deleteUserThreads(userThread.getId());
                        }

                        removeTempToken(userDTO);
                        deleteUserRights(userDTO.getId());
                        deleteUserConditionAgreements(userDTO.getId());
                        deleteInvitationByUser(userDTO.getEcasEmail());

                        userDTO.setType(0);
                        userRepository.save(userMapper.toEntity(userDTO));

                        redisUtil.sync(userId);
                    }else{
                        // Application detected for this user id
                        _log.warn("ECAS Username: " + userDTO.getEcasUsername() + " - User registrations cannot be deleted due to one registration is applied");
                        return new ResponseDTO(false, null, new ErrorDTO(10, "benefPortal.withdraw.existingApplication.error"));
                    }

                    break;
                case (int) Constant.ROLE_SUPPLIER:

                    //first remove connections with suppliers by setting the status to deleted
                    List<SupplierUser> supplierUsers = supplierUserRepository.findByUserId(userDTO.getId());
                    for (SupplierUser sUser : supplierUsers) {
                        sUser.setStatus(SupplierUserStatus.DELETED.getStatus());
                    }
                    supplierUserRepository.save(supplierUsers);

                    removeTempToken(userDTO);
                    removeSuppliedRegion(userDTO);

                    SupplierDTO supplier = supplierService.getSupplierByUserId(userDTO.getId());
                    if (supplier != null) {
                        supplierService.deleteSupplier(supplier.getId());
                    }
                    userDTO.setType(0);
                    userRepository.save(userMapper.toEntity(userDTO));
                    break;
            }
            userDTO.setPassword(null);
            return new ResponseDTO(true, userDTO, null);
        } else {
            return new ResponseDTO(false, null, null);
        }
    }

    @Transactional
    public void deleteUserRights(Integer userId){
        rightRepository.deleteByUserId(userId);
    }

    @Transactional
    public void deleteUserConditionAgreements(Integer userId){
        conditionsAgreementRepository.deleteByUserId(userId);
    }

    @Transactional
    public ResponseDTO updateUserDetails(UserDTO userConnected, List<UserContactDetails> users) {
        //verifying data
        List<UserDTO> usersToSave = new ArrayList<UserDTO>();
        for (UserContactDetails userDetails : users) {
            UserDTO user = getUserById(userDetails.getId());
            user.setName(userDetails.getName());
            user.setSurname(userDetails.getSurname());
            user.setAddress(userDetails.getAddress());
            user.setAddressNum(userDetails.getAddressNum());
            user.setPostalCode(userDetails.getPostalCode());
            user.setCity(userDetails.getCity());
            user.setCountry(userDetails.getCountry());
            if (Validator.isNull(userDetails) || !checkFieldsContactDetails(user, userDetails.getType())) {
                _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - The user details cannot been updated");
                return new ResponseDTO(false, null, new ErrorDTO(org.springframework.http.HttpStatus.BAD_REQUEST.value(), org.springframework.http
                        .HttpStatus.BAD_REQUEST.getReasonPhrase()));
            } else {
                usersToSave.add(user);
            }
        }

        for (UserDTO user : usersToSave) {
            userRepository.save(userMapper.toEntity(user));
        }

        return new ResponseDTO(true, "sucess", null);
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

    @Transactional
    public void sendSupplierRegistrationEmail(UserDTO userDTO) {
        Locale locale = new Locale(UserConstants.DEFAULT_LANG);
        if (userDTO.getLang() != null) {
            locale = new Locale(userDTO.getLang());
        }
        ResourceBundle bundle = ResourceBundle.getBundle("MailBundle", locale);
        String subject = bundle.getString("mail.supplierRegistration.subject");
        String msgBody = bundle.getString("mail.supplierRegistration.body");

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

    public String getServerAddress(){
        return serverAddress;
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

    public boolean checkIfApplied(UserDTO userDTO) {
        return applicationService.applicationsByListOfMunicipalities(userDTO.getId()).size() == 0;
    }

    public boolean checkIfVoucherAwarded(UserDTO userDTO) {
        List<Integer> voucherAwarded = userRepository.getIfUserHasVouchersAwarded(userDTO.getId());
        if (Validator.isNotNull(voucherAwarded)) {
            for (int vouch : voucherAwarded) {
                if (vouch == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public ResponseDTO deactivateRegistrationUser(Integer registrationId, Integer userId, String logInfo) throws Exception {
        ResponseDTO responseDTO = new ResponseDTO();
        //has municipality more than one user associated?
        if (registrationUsersRepository.countRegistrationUsersByRegistrationIdAndStatusNot(registrationId,RegistrationUsersStatus.DEACTIVATED.getValue()) > 1) {
            //setting user as deactivated
            RegistrationUsers registrationUsers = registrationUsersRepository.findByUserIdAndRegistrationId(userId, registrationId);
            if(registrationUsers.getStatus() != RegistrationUsersStatus.DEACTIVATED.getValue()) {
                registrationUsers.setStatus(RegistrationUsersStatus.DEACTIVATED.getValue());
                registrationUsers = registrationUsersRepository.save(registrationUsers);

                if (Validator.isNotNull(registrationUsers)) {
                    redisUtil.sync(userId.longValue());
                }

                //if user doesn't have more registrations associated we put type to deactivated
                if (registrationUsersRepository.countRegistrationUsersByUserIdAndStatusNot(userId, RegistrationUsersStatus.DEACTIVATED.getValue()) <= 1) {
                    setUserTypeToDeactivate(userId);
                }

                //taking off user rights for this registration
                Registration registration = registrationRepository.findOne(registrationId);
                Municipality municipality = registration.getMunicipality();
                Mayor mayor;
                if (!Validator.isNull(municipality)) {
                    mayor = mayorRepository.findByMunicipalityId(municipality.getId());
                    if (Validator.isNull(mayor)) {
                        throw new Exception("Inconsistency in data, mayor from municipality " + municipality.getId() + " is null");
                    }
                } else {
                    throw new Exception("Inconsistency in data, municipality from registration " + registrationId + " is null");
                }

                permissionChecker.dropTablePermissions(userId, Integer.toString(registrationId), RightConstants.REGISTRATIONS_TABLE);
                permissionChecker.dropTablePermissions(userId, Integer.toString(mayor.getId()), RightConstants.MAYORS_TABLE);
                permissionChecker.dropTablePermissions(userId, Integer.toString(municipality.getId()), RightConstants.MUNICIPALITIES_TABLE);
                responseDTO.setSuccess(true);
                responseDTO.setData("success");
                _log.info("ECAS Username: " + logInfo + "- Registration contact with the id "+userId+" deactivated successfully");
            } else{
                responseDTO.setSuccess(false);
                responseDTO.setData("");
                responseDTO.setError(new ErrorDTO(1, "User already deactivated."));
                _log.info("ECAS Username: " + logInfo + "- User "+userId+ " already deactivated.");
            }
        } else {
            responseDTO.setSuccess(false);
            responseDTO.setData("");
            responseDTO.setError(new ErrorDTO(1, "There has to be minimum 1 user per registration."));
            _log.info("ECAS Username: " + logInfo + "- Registration " + registrationId + " has to have minimum 1 user per registration. Could not " +
                    "deactive user " + userId + ".");
        } return responseDTO;
    }

    public void setUserTypeToDeactivate(Integer userId){
        User contactToDeactivate = userRepository.findOne(userId);
        contactToDeactivate.setType((int) Constant.ROLE_DEACTIVATED);
        userRepository.save(contactToDeactivate);
    }

}