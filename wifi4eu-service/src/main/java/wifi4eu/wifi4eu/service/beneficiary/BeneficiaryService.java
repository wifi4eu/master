package wifi4eu.wifi4eu.service.beneficiary;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.Constant;
import wifi4eu.wifi4eu.common.dto.model.BeneficiaryDTO;
import wifi4eu.wifi4eu.common.dto.model.BenPubSupDTO;
import wifi4eu.wifi4eu.common.dto.model.LegalEntityDTO;
import wifi4eu.wifi4eu.common.dto.model.MayorDTO;
import wifi4eu.wifi4eu.common.dto.model.RepresentativeDTO;
import wifi4eu.wifi4eu.common.dto.security.UserDTO;
import wifi4eu.wifi4eu.mapper.beneficiary.LegalEntityMapper;
import wifi4eu.wifi4eu.mapper.beneficiary.MayorMapper;
import wifi4eu.wifi4eu.mapper.beneficiary.RepresentativeMapper;
import wifi4eu.wifi4eu.mapper.security.TempTokenMapper;
import wifi4eu.wifi4eu.mapper.security.UserMapper;
import wifi4eu.wifi4eu.mapper.supplier.BenPubSupMapper;
import wifi4eu.wifi4eu.repository.beneficiary.LegalEntityRepository;
import wifi4eu.wifi4eu.repository.beneficiary.MayorRepository;
import wifi4eu.wifi4eu.repository.beneficiary.RepresentativeRepository;
import wifi4eu.wifi4eu.repository.security.SecurityTempTokenRepository;
import wifi4eu.wifi4eu.repository.security.SecurityUserRepository;
import wifi4eu.wifi4eu.repository.supplier.BenPubSupRepository;
import wifi4eu.wifi4eu.util.MailService;
import wifi4eu.wifi4eu.service.security.UserService;

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
    BenPubSupRepository benPubSupRepository;

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
    BenPubSupMapper benPubSupMapper;

    @Autowired
    MailService mailService;

    @Autowired
    UserService userService;

    @Transactional
    public UserDTO create(BeneficiaryDTO beneficiaryDTO) {

        _log.info("Creating beneficiary...");

        String email;
        boolean representative = false;

        /* check if it is a mayor or a representative */
        if (beneficiaryDTO.getRepresentativeDTO() != null && beneficiaryDTO.getRepresentativeDTO().getEmail() != null && !beneficiaryDTO.getRepresentativeDTO().getEmail().isEmpty()) {
            email = beneficiaryDTO.getRepresentativeDTO().getEmail();
            representative = true;
        } else {
            email = beneficiaryDTO.getMayorDTO().getEmail();
        }

        UserDTO persUserDTO = getUserByEmail(email);

        if (persUserDTO == null) {

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
            if (representative) {
                //it is a representative
                _log.info("create representant: " + beneficiaryDTO.getRepresentativeDTO().toString());
                RepresentativeDTO representativeDTO = beneficiaryDTO.getRepresentativeDTO();
                representativeDTO.setMayorId(mayorDTO.getMayorId());
                representativeDTO = representativeMapper.toDTO(representativeRepository.save(representativeMapper.toEntity(beneficiaryDTO.getRepresentativeDTO())));
                userDTO.setUserType(Constant.ROLE_REPRESENTATIVE);
                userDTO.setUserTypeId(representativeDTO.getRepresentativeId());
            } else {
                //it is a mayor
                userDTO.setUserType(Constant.ROLE_MAYOR);
                userDTO.setUserTypeId(mayorDTO.getMayorId());
            }

            String password = UUID.randomUUID().toString().replace("-", "").substring(0, 7);
            userDTO.setPassword(password);
            _log.info("create user: " + userDTO.toString());
            userDTO = userMapper.toDTO(securityUserRepository.save(userMapper.toEntity(userDTO)));

            userService.sendActivateAccountMail(userDTO);

            return userDTO;

        } else {
            _log.error("trying to register twice");
            return null;
        }

    }

    @Transactional
    public void update(BeneficiaryDTO beneficiaryDTO) {

        if (beneficiaryDTO != null) {

            String email;

            if (beneficiaryDTO.getRepresentativeDTO() != null) {
                email = beneficiaryDTO.getRepresentativeDTO().getEmail();
                beneficiaryDTO.setRepresented(true);
            } else {
                email = beneficiaryDTO.getMayorDTO().getEmail();
            }

            UserDTO userDTO = getUserByEmail(email);

            if (userDTO != null) {

                /* TODO: update data */

            }

        }


    }

    public LegalEntityDTO getLegalEntity(Long legalEntityId) {

        LegalEntityDTO legalEntityDTO = legalEntityMapper.toDTO(legalEntityRepository.findOne(legalEntityId));

        _log.info("legalEntityDTO: " + legalEntityDTO);

        return legalEntityDTO;
    }

    private UserDTO getUserByEmail(String email) {
        return userMapper.toDTO(securityUserRepository.findByEmail(email));
    }

    public BenPubSupDTO apply(Long beneficiaryId, Long publicationId) {
        BenPubSupDTO benPubSupDTO = new BenPubSupDTO(null, beneficiaryId, publicationId, false, null);
        return benPubSupMapper.toDTO(benPubSupRepository.save(benPubSupMapper.toEntity(benPubSupDTO)));
    }

    public BenPubSupDTO findIfApplied(Long beneficiaryId, Long publicationId) {
        BenPubSupDTO benPubSupDTO = benPubSupMapper.toDTO(benPubSupRepository.findByBeneficiaryIdAndPublicationId(beneficiaryId, publicationId));
        return benPubSupDTO;
    }

}
