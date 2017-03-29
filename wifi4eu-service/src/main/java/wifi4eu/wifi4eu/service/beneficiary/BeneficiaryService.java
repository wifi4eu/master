package wifi4eu.wifi4eu.service.beneficiary;

import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.BeneficiaryDTO;
import wifi4eu.wifi4eu.common.dto.model.LegalEntityDTO;
import wifi4eu.wifi4eu.common.dto.model.MayorDTO;
import wifi4eu.wifi4eu.common.dto.model.RepresentativeDTO;
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
import wifi4eu.wifi4eu.service.security.UserService;

import java.security.SecureRandom;
import java.util.Date;
import java.util.UUID;

/**
 * Created by rgarcita on 29/03/2017.
 */

@Service
public class BeneficiaryService {

    private final static Logger _log = Logger.getLogger(BeneficiaryService.class);

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
    UserMapper userMapper;

    @Autowired
    LegalEntityMapper legalEntityMapper;

    @Autowired
    MayorMapper mayorMapper;

    @Autowired
    RepresentativeMapper representativeMapper;

    @Autowired
    TempTokenMapper tempTokenMapper;

    @Autowired
    MailService mailService;

    @Transactional
    public void create(BeneficiaryDTO beneficiaryDTO) {

        _log.info("Creating beneficiary...");

        String email;

        /* check if it is a mayor or a representative */
        email = beneficiaryDTO.getRepresentativeDTO() != null ? beneficiaryDTO.getRepresentativeDTO().getEmail() : beneficiaryDTO.getMayorDTO().getEmail();

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
        tempTokenDTO.setExpiryDate(DateUtils.addHours(now,UserService.TIMEFRAME_ACTIVATE_ACCOUNT_HOURS));
        SecureRandom secureRandom = new SecureRandom();
        String token = Long.toString(secureRandom.nextLong()).concat(Long.toString(now.getTime())).replaceAll("-","");
        tempTokenDTO.setToken(token);
        tempTokenDTO = tempTokenMapper.toDTO(securityTempTokenRepository.save(tempTokenMapper.toEntity(tempTokenDTO)));

        String subject = "Welcome to wifi4eu";
        String msgBody = "You have successfully registered to wifi4eu, access to the next link and activate your account "+UserService.ACTIVATE_ACCOUNT_URL+tempTokenDTO.getToken();

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

    private UserDTO getUserByEmail(String email){
        return userMapper.toDTO(securityUserRepository.findByEmail(email));
    }

}
