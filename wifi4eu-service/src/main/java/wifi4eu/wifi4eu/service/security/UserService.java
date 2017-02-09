package wifi4eu.wifi4eu.service.security;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.BeneficiaryDTO;
import wifi4eu.wifi4eu.common.dto.security.UserDTO;
import wifi4eu.wifi4eu.entity.beneficiary.Representative;
import wifi4eu.wifi4eu.entity.security.User;
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

    private final static Logger _log = Logger.getLogger(UserService.class);

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

        _log.debug("create beneficiary");

        UserDTO userDTO = new UserDTO();
        userDTO.setCreateDate(new Date());

        legalEntityRepository.save(legalEntityMapper.toEntity(beneficiaryDTO.getLegalEntityDTO()));
        mayorRepository.save(mayorMapper.toEntity(beneficiaryDTO.getMayorDTO()));

        if(beneficiaryDTO.getRepresentativeDTO() != null){
            //it is a representative
            representativeRepository.save(representativeMapper.toEntity(beneficiaryDTO.getRepresentativeDTO()));
            userDTO.setEmail(beneficiaryDTO.getRepresentativeDTO().getEmail());
        }else{
            //it is a mayor
            userDTO.setEmail(beneficiaryDTO.getMayorDTO().getEmail());
        }

        securityUserRepository.save(userMapper.toEntity(userDTO));

    }

/*    @Transactional
    public UserDTO create(SupplierDTO supplierDTO){

    }*/
}
