package wifi4eu.wifi4eu.service.security;

import com.google.common.collect.Lists;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import wifi4eu.wifi4eu.common.dto.model.BeneficiaryDTO;
import wifi4eu.wifi4eu.common.dto.security.ActivateAccountDTO;
import wifi4eu.wifi4eu.common.dto.security.TempTokenDTO;
import wifi4eu.wifi4eu.common.dto.security.UserDTO;
import wifi4eu.wifi4eu.common.mapper.security.TempTokenMapper;
import wifi4eu.wifi4eu.common.mapper.security.UserMapper;
import wifi4eu.wifi4eu.repository.security.SecurityTempTokenRepository;
import wifi4eu.wifi4eu.repository.security.SecurityUserRepository;
import wifi4eu.wifi4eu.util.MailService;

import java.security.SecureRandom;
import java.util.Date;
import java.util.List;

/**
 * Created by rgarcita on 09/02/2017.
 */
@Service
public class UserService {

    public final static int TIMEFRAME_ACTIVATE_ACCOUNT_HOURS = 2;
    public final static String BASE_URL = "http://wifi4eu.everisdigitalchannels.com:8080/wifi4eu/#/";
    public final static String RESET_PASS_URL = BASE_URL + "forgot;token=";
    public final static String ACTIVATE_ACCOUNT_URL = BASE_URL + "activation;token=";
    private final static Logger _log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    SecurityUserRepository securityUserRepository;

    @Autowired
    SecurityTempTokenRepository securityTempTokenRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    TempTokenMapper tempTokenMapper;

    @Autowired
    MailService mailService;

    public UserDTO login(UserDTO userDTO) {

        UserDTO persUserDTO = getUserByEmail(userDTO.getEcasEmail());

        if (persUserDTO != null && userDTO.getPassword().equals(persUserDTO.getPassword())) {
            persUserDTO.setAccessDate(new Date());
            return saveUser(persUserDTO);
        } else {
            throw new UsernameNotFoundException("Can't login");
        }
    }

    public void resendEmail(BeneficiaryDTO beneficiaryDTO) {
        if (beneficiaryDTO != null) {

            String email;

            if (beneficiaryDTO.getRepresentativeDTO().getEmail() != null) {
                email = beneficiaryDTO.getRepresentativeDTO().getEmail();
                beneficiaryDTO.setRepresented(true);
            } else {
                email = beneficiaryDTO.getMayorDTO().getEmail();
            }

            UserDTO userDTO = getUserByEmail(email);

            if (userDTO != null) {
                sendActivateAccountMail(userDTO);
            } else {
                _log.error("Trying to resend activation account email with an unregistered user");
            }

        } else {
            _log.error("Trying to resend activation account email with an unregistered beneficiary");
        }
    }

    public void sendActivateAccountMail(UserDTO userDTO) {
        // create a temporal token

        Date now = new Date();

        TempTokenDTO tempTokenDTO = new TempTokenDTO();
        tempTokenDTO.setEmail(userDTO.getEcasEmail());
        tempTokenDTO.setUserId(userDTO.getUserId());
        tempTokenDTO.setCreateDate(now);
        tempTokenDTO.setExpiryDate(DateUtils.addHours(now, UserService.TIMEFRAME_ACTIVATE_ACCOUNT_HOURS));
        SecureRandom secureRandom = new SecureRandom();
        String token = Long.toString(secureRandom.nextLong()).concat(Long.toString(now.getTime())).replaceAll("-", "");
        tempTokenDTO.setToken(token);
        tempTokenDTO = tempTokenMapper.toDTO(securityTempTokenRepository.save(tempTokenMapper.toEntity(tempTokenDTO)));

        String subject = "Welcome to wifi4eu";
        String msgBody = "You have successfully registered to wifi4eu, access to the next link and activate your account " + UserService.ACTIVATE_ACCOUNT_URL + tempTokenDTO.getToken();

        mailService.sendEmail(userDTO.getEcasEmail(), MailService.FROM_ADDRESS, subject, msgBody);
    }


    /*
    * Forgot Password validates if the user exists,
    * creates a temporal Token for 2h and
    * send an email to the user.
    *
    * */

    public void forgotPassword(String email) {

        /* validate email variable is not null or empty */
        if (email != null && !StringUtils.isEmpty(email)) {

            UserDTO userDTO = getUserByEmail(email);

            /* validate if user exist in wifi4eu portal */
            if (userDTO != null) {

                /* Create a temporal key for activation and reset password functionalities */

                TempTokenDTO tempTokenDTO = tempTokenMapper.toDTO(securityTempTokenRepository.findByEmail(email));

                if (tempTokenDTO == null) {
                    tempTokenDTO = new TempTokenDTO();
                    tempTokenDTO.setEmail(email);
                    tempTokenDTO.setUserId(userDTO.getUserId());
                }

                Date now = new Date();
                tempTokenDTO.setCreateDate(now);
                tempTokenDTO.setExpiryDate(DateUtils.addHours(now, TIMEFRAME_ACTIVATE_ACCOUNT_HOURS));
                SecureRandom secureRandom = new SecureRandom();
                String token = Long.toString(secureRandom.nextLong()).concat(Long.toString(now.getTime())).replaceAll("-", "");
                tempTokenDTO.setToken(token);

                securityTempTokenRepository.save(tempTokenMapper.toEntity(tempTokenDTO));

                /* Send email with */
                String fromAddress = MailService.FROM_ADDRESS;
                String subject = "wifi4eu portal Forgot Password";
                String msgBody = "you can access to the next link and reset your password " + RESET_PASS_URL + tempTokenDTO.getToken();
                mailService.sendEmail(email, fromAddress, subject, msgBody);

            } else {
                _log.error("trying to forgetPassword with an unregistered user");
            }

        } else {
            _log.error("trying to forgetPassword without an email");
        }

    }

    /*
    * Activate account or reset password
    * */

    public void activateAccount(ActivateAccountDTO activateAccountDTO) {

        _log.info("[i] activateAccount");

        TempTokenDTO tempTokenDTO = tempTokenMapper.toDTO(securityTempTokenRepository.findByToken(activateAccountDTO.getToken()));

        Date now = new Date();

        /* check if the token exists */
        if (tempTokenDTO != null) {
            /* check if it is expired */
            _log.info("tempToken is not null and expiryDate: " + tempTokenDTO.getExpiryDate());
            if (tempTokenDTO.getExpiryDate().after(now)) {
                /* get user */
                UserDTO userDTO = userMapper.toDTO(securityUserRepository.findByUserId(tempTokenDTO.getUserId()));

                /* update password */
                userDTO.setPassword(activateAccountDTO.getPassword());
                securityUserRepository.save(userMapper.toEntity(userDTO));

            } else {
                _log.warn("trying to access with an expired token");
            }
        } else {
            _log.warn("trying to access with unexisting token");
        }

    }

    public UserDTO getUserByEmail(String email) {
        return userMapper.toDTO(securityUserRepository.findByEmail(email));
    }


    public UserDTO getUserById(long userId) {
        return userMapper.toDTO(securityUserRepository.findOne(userId));
    }

    public UserDTO saveUser(UserDTO userDTO) {
        return userMapper.toDTO(securityUserRepository.save(userMapper.toEntity(userDTO)));
    }

    public List<UserDTO> getAllUsers() {
        return userMapper.toDTOList(Lists.newArrayList(securityUserRepository.findAll()));
    }
}
