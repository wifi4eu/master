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
        UserDTO userDTO = new UserDTO();
        LegalEntityDTO legalEntityDTO = beneficiaryDTO.getLegalEntityDTO();
        MayorDTO mayorDTO = beneficiaryDTO.getMayorDTO();
        RepresentativeDTO representativeDTO = beneficiaryDTO.getRepresentativeDTO();
        boolean represented = false;

        /* create LegalEntityDTO */
        _log.info("create legalEntity: " + legalEntityDTO.toString());
        legalEntityDTO = legalEntityMapper.toDTO(legalEntityRepository.save(legalEntityMapper.toEntity(legalEntityDTO)));
        _log.info("created legalEntity: " + legalEntityDTO.toString());

        if (representativeDTO != null && representativeDTO.getEmail() != null && !representativeDTO.getEmail().isEmpty()) {
            represented = true;
        }

        String mayorMail = mayorDTO.getEmail();
        UserDTO mayorUserDTO = getUserByEmail(mayorMail);
        if (mayorUserDTO == null) {
            mayorDTO.setLegalEntityId(legalEntityDTO.getLegalEntityId());
            mayorDTO = mayorMapper.toDTO(mayorRepository.save(mayorMapper.toEntity(mayorDTO)));
            mayorUserDTO = new UserDTO();
            mayorUserDTO.setEmail(mayorMail);
            mayorUserDTO.setCreateDate(new Date());
            mayorUserDTO.setUserType(Constant.ROLE_MAYOR);
            mayorUserDTO.setUserTypeId(mayorDTO.getMayorId());
            String password = UUID.randomUUID().toString().replace("-", "").substring(0, 7);
            mayorUserDTO.setPassword(password);
            _log.info("create mayor user: " + mayorUserDTO.toString());
            mayorUserDTO = userMapper.toDTO(securityUserRepository.save(userMapper.toEntity(mayorUserDTO)));
            userService.sendActivateAccountMail(mayorUserDTO);

            if (represented) {
                String representativeMail = beneficiaryDTO.getRepresentativeDTO().getEmail();
                UserDTO representativeUserDTO = getUserByEmail(representativeMail);
                if (representativeUserDTO == null) {
                    representativeDTO.setMayorId(mayorDTO.getMayorId());
                    representativeDTO = representativeMapper.toDTO(representativeRepository.save(representativeMapper.toEntity(representativeDTO)));
                    representativeUserDTO = new UserDTO();
                    representativeUserDTO.setEmail(representativeMail);
                    representativeUserDTO.setCreateDate(new Date());
                    representativeUserDTO.setUserType(Constant.ROLE_REPRESENTATIVE);
                    representativeUserDTO.setUserTypeId(representativeDTO.getRepresentativeId());
                    password = UUID.randomUUID().toString().replace("-", "").substring(0, 7);
                    representativeUserDTO.setPassword(password);
                    _log.info("create representative user: " + representativeUserDTO.toString());
                    representativeUserDTO = userMapper.toDTO(securityUserRepository.save(userMapper.toEntity(representativeUserDTO)));
                    userService.sendActivateAccountMail(representativeUserDTO);
                    return representativeUserDTO;
                } else {
                    _log.error("trying to register the representative twice");
                    return null;
                }
            } else {
                return mayorUserDTO;
            }
        } else {
            _log.error("trying to register the mayor twice");
            return null;
        }
    }

    public BeneficiaryDTO update(BeneficiaryDTO beneficiaryDTO) {
        BeneficiaryDTO updatedBeneficiaryDTO = null;
        if (beneficiaryDTO != null) {
            updatedBeneficiaryDTO = new BeneficiaryDTO();
            String email;
            if (beneficiaryDTO.getRepresentativeDTO() != null) {
                email = beneficiaryDTO.getRepresentativeDTO().getEmail();
                beneficiaryDTO.setRepresented(true);
                updatedBeneficiaryDTO.setRepresented(true);
                updatedBeneficiaryDTO.setRepresentativeDTO(representativeMapper.toDTO(representativeRepository.save(representativeMapper.toEntity(beneficiaryDTO.getRepresentativeDTO()))));
                updatedBeneficiaryDTO.setMayorDTO(mayorMapper.toDTO(mayorRepository.save(mayorMapper.toEntity(beneficiaryDTO.getMayorDTO()))));
            } else {
                email = beneficiaryDTO.getMayorDTO().getEmail();
                updatedBeneficiaryDTO.setRepresented(false);
                updatedBeneficiaryDTO.setRepresentativeDTO(null);
                updatedBeneficiaryDTO.setMayorDTO(mayorMapper.toDTO(mayorRepository.save(mayorMapper.toEntity(beneficiaryDTO.getMayorDTO()))));
            }
            updatedBeneficiaryDTO.setLegalEntityDTO(beneficiaryDTO.getLegalEntityDTO());

            UserDTO userDTO = getUserByEmail(email);
            if (userDTO != null) {
                /* TODO: update data */
                userMapper.toDTO(securityUserRepository.save(userMapper.toEntity(userDTO)));
            }
        }
        return updatedBeneficiaryDTO;
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

    public BenPubSupDTO findByBeneficiaryIdAndPublicationId(Long beneficiaryId, Long publicationId) {
        BenPubSupDTO benPubSupDTO = benPubSupMapper.toDTO(benPubSupRepository.findByBeneficiaryIdAndPublicationId(beneficiaryId, publicationId));
        return benPubSupDTO;
    }

    public BenPubSupDTO selectSupplier(Long supplierId, Long beneficiaryId, Long publicationId) {
        BenPubSupDTO benPubSupDTO = benPubSupMapper.toDTO(benPubSupRepository.findByBeneficiaryIdAndPublicationId(beneficiaryId, publicationId));
        if (benPubSupDTO != null) {
            benPubSupDTO.setSupplierId(supplierId);
            return benPubSupMapper.toDTO(benPubSupRepository.save(benPubSupMapper.toEntity(benPubSupDTO)));
        }
        return benPubSupDTO;
    }

    public MayorDTO getMayorById(Long mayorId) {
        return mayorMapper.toDTO(mayorRepository.findOne(mayorId));
    }

    public RepresentativeDTO getRepresentativeById(Long representativeId) {
        return representativeMapper.toDTO(representativeRepository.findOne(representativeId));
    }

}
