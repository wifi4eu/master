package wifi4eu.wifi4eu.service.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

import java.util.Date;

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

    @Transactional
    public void create(BeneficiaryDTO beneficiaryDTO){

        _log.info("create beneficiary");

        UserDTO userDTO = new UserDTO();
        userDTO.setCreateDate(new Date());

        _log.info("create legalEntity: " + beneficiaryDTO.getLegalEntityDTO().toString());
        LegalEntityDTO legalEntityDTO = legalEntityMapper.toDTO(legalEntityRepository.save(legalEntityMapper.toEntity(beneficiaryDTO.getLegalEntityDTO())));

        _log.info("created legalEntity: " + legalEntityDTO.toString());

        _log.info("create mayor: " + beneficiaryDTO.getMayorDTO().toString());
        MayorDTO mayorDTO = mayorMapper.toDTO(mayorRepository.save(mayorMapper.toEntity(beneficiaryDTO.getMayorDTO())));

        if(beneficiaryDTO.getRepresentativeDTO() != null){
            //it is a representative
            _log.info("create representant: " + beneficiaryDTO.getRepresentativeDTO().toString());
            RepresentativeDTO representativeDTO =  beneficiaryDTO.getRepresentativeDTO();
            representativeDTO.setMayorId(mayorDTO.getMayorId());
            representativeRepository.save(representativeMapper.toEntity(beneficiaryDTO.getRepresentativeDTO()));
            userDTO.setEmail(beneficiaryDTO.getRepresentativeDTO().getEmail());
        }else{
            //it is a mayor
            userDTO.setEmail(beneficiaryDTO.getMayorDTO().getEmail());
        }

        _log.info("create user: " + userDTO.toString());
        securityUserRepository.save(userMapper.toEntity(userDTO));

    }

    public LegalEntityDTO getLegalEntity(Long legalEntityId){

        LegalEntityDTO legalEntityDTO = legalEntityMapper.toDTO(legalEntityRepository.findOne(legalEntityId));

        _log.info("legalEntityDTO: " + legalEntityDTO);

        return legalEntityDTO;
    }

    public MayorDTO getMayor(Long mayorId){

        MayorDTO mayorDTO = mayorMapper.toDTO(mayorRepository.findOne(mayorId));

        _log.info("mayorDTO: " + mayorDTO);

        return mayorDTO;

    }

/*    @Transactional
    public UserDTO create(SupplierDTO supplierDTO){

    }*/
}
