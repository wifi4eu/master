package wifi4eu.wifi4eu.service.security;

import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import wifi4eu.wifi4eu.common.dto.model.BeneficiaryDTO;
import wifi4eu.wifi4eu.common.dto.model.LegalEntityDTO;
import wifi4eu.wifi4eu.common.dto.model.MayorDTO;
import wifi4eu.wifi4eu.common.dto.model.RepresentativeDTO;
import wifi4eu.wifi4eu.common.dto.security.ActivateAccountDTO;
import wifi4eu.wifi4eu.common.dto.security.TempTokenDTO;
import wifi4eu.wifi4eu.common.dto.security.UserDTO;
import wifi4eu.wifi4eu.mapper.beneficiary.LegalEntityMapper;
import wifi4eu.wifi4eu.mapper.beneficiary.MayorMapper;
import wifi4eu.wifi4eu.mapper.beneficiary.RepresentativeMapper;
import wifi4eu.wifi4eu.mapper.security.TempTokenMapper;
import wifi4eu.wifi4eu.mapper.security.UserMapper;
import wifi4eu.wifi4eu.repository.beneficiary.LegalEntityRepository;
import wifi4eu.wifi4eu.repository.beneficiary.MayorRepository;
import wifi4eu.wifi4eu.repository.beneficiary.RepresentativeRepository;
import wifi4eu.wifi4eu.repository.security.SecurityTempTokenRepository;
import wifi4eu.wifi4eu.repository.security.SecurityUserRepository;
import wifi4eu.wifi4eu.util.MailService;
import java.security.SecureRandom;

import java.util.Date;
import java.util.UUID;

/**
 * Created by rgarcita on 09/02/2017.
 */
@Service
public class UserService {

    private final static Logger _log = Logger.getLogger(UserService.class);

    private final static int TIMEFRAME_ACTIVATE_ACCOUNT_HOURS = 2;

    private final static String RESET_PASS_URL = "http://wifi4eu.everisdigitalchannels.com:7001/wifi4eu/#/forgot;token=";
    private final static String ACTIVATE_ACCOUNT_URL = "http://wifi4eu.everisdigitalchannels.com:7001/wifi4eu/#/activation;token=";

    @Autowired
    LegalEntityRepository legalEntityRepository;

    @Autowired
    MayorRepository mayorRepository;

    @Autowired
    RepresentativeRepository representativeRepository;

    @Autowired
    SecurityUserRepository securityUserRepository;

    @Autowired
    SecurityTempTokenRepository securityTempTokenRepository;

    @Autowired
    LegalEntityMapper legalEntityMapper;

    @Autowired
    MayorMapper mayorMapper;

    @Autowired
    RepresentativeMapper representativeMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    TempTokenMapper tempTokenMapper;

    @Autowired
    MailService mailService;

    @Transactional
    public void create(BeneficiaryDTO beneficiaryDTO) {

        _log.info("create beneficiary");

        String email;

        /* check if it is a mayor or a representative */
        if (beneficiaryDTO.getRepresentativeDTO() != null) {
            email = beneficiaryDTO.getRepresentativeDTO().getEmail();
        }else{
            email = beneficiaryDTO.getMayorDTO().getEmail();
        }


        /*
        TODO: enable a validation to avoid user duplicity
        UserDTO persUserDTO = getUserByEmail(email);

        if(persUserDTO != null) {
        */
            /* create userDTO*/
            UserDTO userDTO = new UserDTO();
            userDTO.setCreateDate(new Date());
            userDTO.setEmail(email);

            /* create LegalEntityDTO */
            _log.info("create legalEntity: " + beneficiaryDTO.getLegalEntityDTO().toString());
            LegalEntityDTO legalEntityDTO = legalEntityMapper.toDTO(legalEntityRepository.save(legalEntityMapper.toEntity(beneficiaryDTO.getLegalEntityDTO())));

            _log.info("created legalEntity: " + legalEntityDTO.toString());

            /* create Mayor DTO */
            MayorDTO mayorDTO = beneficiaryDTO.getMayorDTO();
            mayorDTO.setLegalEntityId(legalEntityDTO.getLegalEntityId());

            _log.info("create mayor: " + mayorDTO.toString());
            mayorDTO = mayorMapper.toDTO(mayorRepository.save(mayorMapper.toEntity(mayorDTO)));

            /* create representativeDTO if apply */
            if (beneficiaryDTO.getRepresentativeDTO() != null) {
                //it is a representative
                _log.info("create representant: " + beneficiaryDTO.getRepresentativeDTO().toString());
                RepresentativeDTO representativeDTO = beneficiaryDTO.getRepresentativeDTO();
                representativeDTO.setMayorId(mayorDTO.getMayorId());
                representativeRepository.save(representativeMapper.toEntity(beneficiaryDTO.getRepresentativeDTO()));
            }


            String password = UUID.randomUUID().toString().replace("-", "").substring(0, 7);
            userDTO.setPassword(password);
            _log.info("create user: " + userDTO.toString());
            userDTO = userMapper.toDTO(securityUserRepository.save(userMapper.toEntity(userDTO)));

            /* create a temporal token */

            Date now = new Date();

            TempTokenDTO tempTokenDTO = new TempTokenDTO();
            tempTokenDTO.setEmail(email);
            tempTokenDTO.setUserId(userDTO.getUserId());
            tempTokenDTO.setCreateDate(now);
            tempTokenDTO.setExpiryDate(DateUtils.addHours(now,TIMEFRAME_ACTIVATE_ACCOUNT_HOURS));
            SecureRandom secureRandom = new SecureRandom();
            String token = Long.toString(secureRandom.nextLong()).concat(Long.toString(now.getTime())).replaceAll("-","");
            tempTokenDTO.setToken(token);
            tempTokenDTO = tempTokenMapper.toDTO(securityTempTokenRepository.save(tempTokenMapper.toEntity(tempTokenDTO)));

            String subject = "Welcome to wifi4eu";
            String msgBody = "You have successfully registered to wifi4eu, access to the next link and activate your account "+ACTIVATE_ACCOUNT_URL+tempTokenDTO.getToken();

            mailService.sendEmail(email, MailService.FROM_ADDRESS, subject, msgBody);

        /*
        }else{
            _log.warn("trying to register twice");
        }
        */
    }

    @Transactional
    public void update(BeneficiaryDTO beneficiaryDTO) {

        if(beneficiaryDTO != null) {

            String email;

            if(beneficiaryDTO.getRepresentativeDTO() != null){
                email = beneficiaryDTO.getRepresentativeDTO().getEmail();
                beneficiaryDTO.setRepresented(true);
            }else{
                email = beneficiaryDTO.getMayorDTO().getEmail();
            }

            UserDTO userDTO = getUserByEmail(email);

            if(userDTO != null){

                /* TODO: update data */

            }

        }


    }

    public LegalEntityDTO getLegalEntity(Long legalEntityId) {

        LegalEntityDTO legalEntityDTO = legalEntityMapper.toDTO(legalEntityRepository.findOne(legalEntityId));

        _log.info("legalEntityDTO: " + legalEntityDTO);

        return legalEntityDTO;
    }

    public String login(UserDTO userDTO) {

        UserDTO persUserDTO = getUserByEmail(userDTO.getEmail());


        if (persUserDTO != null && userDTO.getPassword().equals(persUserDTO.getPassword())) {

            return "{\"data\":\"success\"}";
        } else {
            return "{\"error\":\"error\"}";
        }
    }

    public MayorDTO getMayor(Long mayorId) {

        MayorDTO mayorDTO = mayorMapper.toDTO(mayorRepository.findOne(mayorId));

        _log.info("mayorDTO: " + mayorDTO);

        return mayorDTO;

    }


    /*
    * Forgot Password validates if the user exists,
    * creates a temporal Token for 2h and
    * send an email to the user.
    *
    * */

    public void forgotPassword(String email){

        /* validate email variable is not null or empty */
        if(email != null && !StringUtils.isEmpty(email)){

            UserDTO userDTO = getUserByEmail(email);

            /* validate if user exist in wifi4eu portal */
            if(userDTO != null) {

                /* Create a temporal key for activation and reset password functionalities */

                TempTokenDTO tempTokenDTO = tempTokenMapper.toDTO(securityTempTokenRepository.findByEmail(email));

                if(tempTokenDTO == null){
                    tempTokenDTO = new TempTokenDTO();
                    tempTokenDTO.setEmail(email);
                    tempTokenDTO.setUserId(userDTO.getUserId());
                }

                Date now = new Date();
                tempTokenDTO.setCreateDate(now);
                tempTokenDTO.setExpiryDate(DateUtils.addHours(now,TIMEFRAME_ACTIVATE_ACCOUNT_HOURS));
                SecureRandom secureRandom = new SecureRandom();
                String token = Long.toString(secureRandom.nextLong()).concat(Long.toString(now.getTime())).replaceAll("-","");
                tempTokenDTO.setToken(token);

                securityTempTokenRepository.save(tempTokenMapper.toEntity(tempTokenDTO));

                /* Send email with */
                String fromAddress = MailService.FROM_ADDRESS;
                String subject = "wifi4eu portal Forgot Password";
                String msgBody ="you can access to the next link and reset your password "+RESET_PASS_URL+tempTokenDTO.getToken();
                mailService.sendEmail(email,fromAddress,subject,msgBody);

            }else{
                _log.error("trying to forgetPassword with an unregistered user");
            }

        }else{
            _log.error("trying to forgetPassword without an email");
        }

    }

    /*
    * Activate account or reset password
    * */

    public void activateAccount(ActivateAccountDTO activateAccountDTO){

        TempTokenDTO tempTokenDTO = tempTokenMapper.toDTO(securityTempTokenRepository.findByToken(activateAccountDTO.getToken()));

        Date now = new Date();

        /* check if the token exists */
        if(tempTokenDTO != null){
            /* check if it is expired */
            if(tempTokenDTO.getExpiryDate().after(now)){
                /* get user */
                UserDTO userDTO = userMapper.toDTO(securityUserRepository.findByUserId(tempTokenDTO.getUserId()));

                /* update password */
                userDTO.setPassword(activateAccountDTO.getPassword());
                securityUserRepository.save(userMapper.toEntity(userDTO));

            }else{
                _log.warn("trying to access with an expired token");
            }
        }else{
            _log.warn("trying to access with unexisting token");
        }

    }

    private UserDTO getUserByEmail(String email){
        return userMapper.toDTO(securityUserRepository.findByEmail(email));
    }


}
