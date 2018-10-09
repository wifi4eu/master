package wifi4eu.wifi4eu.service.user;

import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.exception.AppException;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.common.mapper.user.UserMapper;
import wifi4eu.wifi4eu.repository.user.UserRepository;

@Configuration
@PropertySource("classpath:env.properties")
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRepository userRepository;

    private final Logger _log = LogManager.getLogger(UserService.class);

    @Value("${mail.server.location}")
    private String baseUrl;

    @Value("${ecas.location}")
    private String ecasUrl;

    public boolean isLocalHost() {
        return baseUrl.contains(UserConstants.LOCAL);
    }

    @Transactional
    public UserDTO getUserByUserContext(UserContext userContext) {
        if (userContext == null) {
            throw new AppException("User context not defined", HttpStatus.SC_FORBIDDEN, "");
        }
        _log.debug("User Email: " + userContext.getEmail() + " and User PerId: " + userContext.getPerId());
        UserDTO userDTO = userMapper.toDTO(userRepository.findByEcasUsername(userContext.getUsername()));
        if (userDTO == null) {
            throw new AppException("User " + userContext.getEmail() + "does not exist");
        }
        return userDTO;
    }
}
