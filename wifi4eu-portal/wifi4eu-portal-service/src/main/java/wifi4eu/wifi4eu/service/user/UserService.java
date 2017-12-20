package wifi4eu.wifi4eu.service.user;

import com.google.common.collect.Lists;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.security.ActivateAccountDTO;
import wifi4eu.wifi4eu.common.dto.security.TempTokenDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.mapper.security.TempTokenMapper;
import wifi4eu.wifi4eu.mapper.user.UserMapper;
import wifi4eu.wifi4eu.repository.security.TempTokenRepository;
import wifi4eu.wifi4eu.repository.user.UserRepository;
import wifi4eu.wifi4eu.util.MailService;

import java.security.SecureRandom;
import java.util.Date;
import java.util.List;

@Configuration
@PropertySource("classpath:env.properties")
@Service
public class UserService {
    private final Logger _log = LoggerFactory.getLogger(UserService.class);

    public final static int TIMEFRAME_ACTIVATE_ACCOUNT_HOURS = 2;
    public final static String BASE_URL = "http://wifi4eu.everisdigitalchannels.com:8080/wifi4eu/#/";
    public final static String RESET_PASS_URL = BASE_URL + "forgot;token=";
    public final static String ACTIVATE_ACCOUNT_URL = BASE_URL + "activation;token=";

    @Value("${mail.server.location}")
    private String mailServer;

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
        UserDTO searchUser = getUserByEmail(userDTO.getEmail());
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
            return resUser;
        } else {
            throw new Exception("User doesn't exist.");
        }
    }

    @Transactional
    public UserDTO getUserByUserContext(UserContext userContext) {

        _log.debug("[i] getUserByEcasPerId");

        UserDTO userDTO = userMapper.toDTO( userRepository.findByEcasUsername(userContext.getUsername()));

        _log.debug("after search userDTO: " + userDTO);

        if(userDTO == null){

            userDTO = new UserDTO();
            userDTO.setAccessDate(new Date().getTime());
            userDTO.setEcasEmail(userContext.getEmail());
            userDTO.setEcasUsername(userContext.getUsername());
            userDTO.setName(userContext.getFirstName());
            userDTO.setSurname(userContext.getLastName());
            userDTO.setEmail(userContext.getEmail());

            userDTO = userMapper.toDTO(userRepository.save(userMapper.toEntity(userDTO)));
        }

        _log.debug("after create userDTO: " + userDTO);

        _log.debug("[f] getUserByEcasPerId");
        return userDTO;
    }

    public UserDTO deleteUser(int userId) {
        UserDTO userDTO = userMapper.toDTO(userRepository.findOne(userId));
        if (userDTO != null) {
            userRepository.delete(userMapper.toEntity(userDTO));
            return userDTO;
        } else {
            return null;
        }
    }

    public List<UserDTO> getUsersByType(int type) {
        return userMapper.toDTOList(Lists.newArrayList(userRepository.findByType(type)));
    }

    public UserDTO login(UserDTO userDTO) {
        UserDTO resUser = userMapper.toDTO(userRepository.findByEmail(userDTO.getEmail()));
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
                if(userContext != null){
                    //ECAS user
                    user = getUserByUserContext(userContext);
                    if(tempToken.getUserId() != user.getId()){
                        throw new Exception("Token doesn't match with the ECAS user");
                    }
                }else{
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
    public void sendActivateAccountMail(UserDTO userDTO) {
        Date now = new Date();
        TempTokenDTO tempTokenDTO = new TempTokenDTO();
        tempTokenDTO.setEmail(userDTO.getEmail());
        tempTokenDTO.setUserId(userDTO.getId());
        tempTokenDTO.setCreateDate(now.getTime());
        tempTokenDTO.setExpiryDate(DateUtils.addHours(now, UserService.TIMEFRAME_ACTIVATE_ACCOUNT_HOURS).getTime());
        SecureRandom secureRandom = new SecureRandom();
        String token = Long.toString(secureRandom.nextLong()).concat(Long.toString(now.getTime())).replaceAll("-", "");
        tempTokenDTO.setToken(token);
        tempTokenDTO = tempTokenMapper.toDTO(tempTokenRepository.save(tempTokenMapper.toEntity(tempTokenDTO)));
        //TODO: Translate subject and msgBody
        String subject = "Welcome to WiFi4EU";
        String msgBody = "You have successfully registered to WiFi4EU, access to the next link and activate your account: " + UserService.ACTIVATE_ACCOUNT_URL + tempTokenDTO.getToken();

        // If it is localhost it wont send mail
        if (!mailServer.contains("localhost")) {
            mailService.sendEmail(userDTO.getEmail(), MailService.FROM_ADDRESS, subject, msgBody);
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

        if(user == null){
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
                    tempTokenDTO.setExpiryDate(DateUtils.addHours(now, UserService.TIMEFRAME_ACTIVATE_ACCOUNT_HOURS).getTime());
                    SecureRandom secureRandom = new SecureRandom();
                    String token = Long.toString(secureRandom.nextLong()).concat(Long.toString(now.getTime())).replaceAll("-", "");
                    tempTokenDTO.setToken(token);

                    tempTokenRepository.save(tempTokenMapper.toEntity(tempTokenDTO));

                    /* Send email with */
                    String fromAddress = MailService.FROM_ADDRESS;
                    //TODO: translate subject and msgBody
                    String subject = "wifi4eu portal Forgot Password";
                    String msgBody = "you can access to the next link and reset your password " + RESET_PASS_URL + tempTokenDTO.getToken();
                    mailService.sendEmail(email, fromAddress, subject, msgBody);
                } else {
                    throw new Exception("trying to forgetPassword with an unregistered user");
                }
            } else {
                throw new Exception("trying to forgetPassword without an email");
            }
        }else{
            throw new Exception("ECAS user has to go throw ECAS portal to manage the password");
        }
    }
}