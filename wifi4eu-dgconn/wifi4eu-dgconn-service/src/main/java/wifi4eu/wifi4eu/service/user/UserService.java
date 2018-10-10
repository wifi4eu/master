package wifi4eu.wifi4eu.service.user;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.exception.AppException;
import wifi4eu.wifi4eu.common.mapper.user.UserMapper;
import wifi4eu.wifi4eu.common.security.TokenGenerator;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.entity.security.RightConstants;
import wifi4eu.wifi4eu.repository.user.UserRepository;
import wifi4eu.wifi4eu.service.security.PermissionChecker;

import javax.servlet.http.Cookie;
import java.util.Date;
import java.util.List;

@Configuration
@PropertySource("classpath:env.properties")
@Service
public class UserService {
    private final Logger _log = LoggerFactory.getLogger(UserService.class);

    @Value("${mail.server.location}")
    private String baseUrl;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PermissionChecker permissionChecker;


    public UserDTO getUserById(int userId) {
        return userMapper.toDTO(userRepository.findOne(userId));
    }

    public UserDTO getMainUserByIdFromRegistration(Integer registrationId) {
        UserDTO user = userMapper.toDTO(userRepository.findMainUserFromRegistration(registrationId));
        return user;
    }

    public List<UserDTO> getUsersByIdFromRegistration(Integer registrationId) {
        List<UserDTO> users = userMapper.toDTOList(userRepository.findUsersFromRegistration(registrationId));
        return users;
    }

    @Transactional
    public UserDTO getUserByUserContext(UserContext userContext) {
        if (userContext == null) {
            throw new AppException("User context not defined", HttpStatus.SC_FORBIDDEN, "");
        }
        _log.debug("User Email: {} and User PerId: {}", userContext.getEmail(), userContext.getPerId());

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

    public String getChangePassword() {
        return "https://ecas.ec.europa.eu/cas/change/changePassword.cgi";
    }

    public String getBaseUrl() {
        return baseUrl;
    }

}