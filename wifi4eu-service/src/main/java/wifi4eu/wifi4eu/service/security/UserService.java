package wifi4eu.wifi4eu.service.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import wifi4eu.wifi4eu.common.dto.model.BeneficiaryDTO;
import wifi4eu.wifi4eu.common.dto.model.LegalEntityDTO;
import wifi4eu.wifi4eu.common.dto.model.MayorDTO;
import wifi4eu.wifi4eu.common.dto.model.RepresentativeDTO;
import wifi4eu.wifi4eu.common.dto.security.UserDTO;
import wifi4eu.wifi4eu.mapper.beneficiary.LegalEntityMapper;
import wifi4eu.wifi4eu.mapper.beneficiary.MayorMapper;
import wifi4eu.wifi4eu.mapper.beneficiary.RepresentativeMapper;
import wifi4eu.wifi4eu.mapper.security.UserMapper;
import wifi4eu.wifi4eu.repository.beneficiary.LegalEntityRepository;
import wifi4eu.wifi4eu.repository.beneficiary.MayorRepository;
import wifi4eu.wifi4eu.repository.beneficiary.RepresentativeRepository;
import wifi4eu.wifi4eu.repository.security.SecurityUserRepository;
import wifi4eu.wifi4eu.util.MailService;

import java.util.Date;
import java.util.UUID;

/**
 * Created by rgarcita on 09/02/2017.
 */
@Service
public class UserService {

    private final static Logger _log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    LegalEntityRepository legalEntityRepository;

    @Autowired
    MayorRepository mayorRepository;

    @Autowired
    RepresentativeRepository representativeRepository;

    @Autowired
    SecurityUserRepository securityUserRepository;

    @Autowired
    LegalEntityMapper legalEntityMapper;

    @Autowired
    MayorMapper mayorMapper;

    @Autowired
    RepresentativeMapper representativeMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    MailService mailService;

    @Transactional
    public void create(BeneficiaryDTO beneficiaryDTO) {

        _log.info("create beneficiary");

        String email;

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
            UserDTO userDTO = new UserDTO();
            userDTO.setCreateDate(new Date());
            userDTO.setEmail(email);

            _log.info("create legalEntity: " + beneficiaryDTO.getLegalEntityDTO().toString());
            LegalEntityDTO legalEntityDTO = legalEntityMapper.toDTO(legalEntityRepository.save(legalEntityMapper.toEntity(beneficiaryDTO.getLegalEntityDTO())));

            _log.info("created legalEntity: " + legalEntityDTO.toString());

            _log.info("create mayor: " + beneficiaryDTO.getMayorDTO().toString());
            MayorDTO mayorDTO = mayorMapper.toDTO(mayorRepository.save(mayorMapper.toEntity(beneficiaryDTO.getMayorDTO())));

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
            securityUserRepository.save(userMapper.toEntity(userDTO));

            mailService.sendEmail(email, "portales.everis@gmail.com", "Welcome to wifi4eu", "You have successfully registered to wifi4eu, you can login with your email and password: " + password);

        /*
        }else{
            _log.warn("trying to register twice");
        }
        */
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

    public void forgotPassword(String email){

        if(email != null && !StringUtils.isEmpty(email)){

            UserDTO userDTO = getUserByEmail(email);

            if(userDTO != null) {

                /* TODO: Create a temporal key for activation and reset password functionalities */

                /* TODO: replace with the reset password link */
                mailService.sendEmail(email,"portales.everis@gmail.com","wifi4eu portal Forgot Password",
                        "you can access to the next link and reset your password <a href=\"http://www.wifi4eu.eu\">http://www.wifi4eu.eu");
            }else{
                _log.error("trying to forgetPassword with an unregistered user");
            }

        }else{
            _log.error("trying to forgetPassword without an email");
        }

    }

    private UserDTO getUserByEmail(String email){
        return userMapper.toDTO(securityUserRepository.findByEmail(email));
    }


}
