package wifi4eu.wifi4eu.service.user;

import com.google.common.collect.Lists;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.exception.AppException;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.entity.security.RightConstants;
import wifi4eu.wifi4eu.mapper.security.TempTokenMapper;
import wifi4eu.wifi4eu.mapper.user.UserMapper;
import wifi4eu.wifi4eu.repository.security.RightRepository;
import wifi4eu.wifi4eu.repository.security.TempTokenRepository;
import wifi4eu.wifi4eu.repository.user.UserRepository;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.supplier.SupplierService;

import java.util.Date;
import java.util.List;
import java.util.Locale;

@Configuration
@Service
public class UserService {
    private final Logger _log = LoggerFactory.getLogger(UserService.class);


    @Value("${mail.server.location}")
    private String baseUrl;

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TempTokenMapper tempTokenMapper;

    @Autowired
    TempTokenRepository tempTokenRepository;

    @Autowired
    RightRepository rightRepository;

    @Autowired
    PermissionChecker permissionChecker;

    @Autowired
    SupplierService supplierService;

    /**
     * The language used in user browser
     */
    private String lang = null;


    public List<UserDTO> getAllUsers() {
        return userMapper.toDTOList(Lists.newArrayList(userRepository.findAll()));
    }

    public UserDTO getUserById(int userId) {
        return userMapper.toDTO(userRepository.findOne(userId));
    }

    public UserDTO getUserByEmail(String email) {
        return userMapper.toDTO(userRepository.findByEmail(email));
    }

    @Transactional
    public UserDTO createUser(UserDTO userDTO) throws Exception {
        UserDTO searchUser = getUserByEmail(userDTO.getEcasEmail());
        if (searchUser != null) {
            userDTO.setPassword(searchUser.getPassword());
            throw new Exception("User already registered.");
        }
        UserDTO resUser = userMapper.toDTO(userRepository.save(userMapper.toEntity(userDTO)));
        /*sendActivateAccountMail(resUser);*/
        return resUser;
    }

    @Transactional
    public UserDTO getUserByUserContext(UserContext userContext) {

        if (userContext == null) {
            throw new AppException("User context not defined", HttpStatus.SC_FORBIDDEN, "");
        }

        if (_log.isDebugEnabled()) {
            _log.debug("user Email: " + userContext.getEmail() + " user PerId: " + userContext.getPerId());
        }

        _log.debug("[i] getUserByEcasPerId");

        UserDTO userDTO = userMapper.toDTO(userRepository.findByEcasUsername(userContext.getUsername()));

        _log.debug("after search userDTO: " + userDTO);

        if (userDTO == null) {
            userDTO = new UserDTO();
            userDTO.setAccessDate(new Date().getTime());
            userDTO.setEcasEmail(userContext.getEmail());
            userDTO.setEcasUsername(userContext.getUsername());
            userDTO.setName(userContext.getFirstName());
            userDTO.setSurname(userContext.getLastName());
            userDTO.setEmail(userContext.getEmail());
            userDTO.setIdRole(1);

            userDTO = userMapper.toDTO(userRepository.save(userMapper.toEntity(userDTO)));

            permissionChecker.addTablePermissions(userDTO, Integer.toString(userDTO.getId()),
                    RightConstants.USER_TABLE, "[USER] - id: " + userDTO.getId() + " - Email: " + userDTO.getEcasEmail() + " - EcasUsername: " + userDTO.getEcasUsername());

        }

        _log.debug("after create userDTO: " + userDTO);

        _log.debug("[f] getUserByEcasPerId");
        return userDTO;
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

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getLang() {
        return this.lang;
    }

    public boolean isLocalHost() {
        return baseUrl.contains(UserConstants.LOCAL);
    }

    public Locale initLocale() {
        Locale locale;

        if (lang != null) {
            locale = new Locale(lang);

        } else {
            locale = new Locale(UserConstants.DEFAULT_LANG);
        }

        return locale;
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

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}