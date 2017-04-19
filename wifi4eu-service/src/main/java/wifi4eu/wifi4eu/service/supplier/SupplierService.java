package wifi4eu.wifi4eu.service.supplier;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.Constant;
import wifi4eu.wifi4eu.common.dto.model.BenPubSupDTO;
import wifi4eu.wifi4eu.common.dto.model.LegalEntityDTO;
import wifi4eu.wifi4eu.common.dto.model.SupplierDTO;
import wifi4eu.wifi4eu.common.dto.security.UserDTO;
import wifi4eu.wifi4eu.mapper.supplier.BenPubSupMapper;
import wifi4eu.wifi4eu.mapper.security.UserMapper;
import wifi4eu.wifi4eu.mapper.supplier.SupplierMapper;
import wifi4eu.wifi4eu.repository.security.SecurityUserRepository;
import wifi4eu.wifi4eu.repository.supplier.BenPubSupRepository;
import wifi4eu.wifi4eu.repository.supplier.SupplierRepository;
import wifi4eu.wifi4eu.service.beneficiary.BeneficiaryService;
import wifi4eu.wifi4eu.service.security.UserService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by rfguri on 27/03/2017.
 */
@Service
public class SupplierService {

    private final static Logger _log = LoggerFactory.getLogger(SupplierService.class);

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    SecurityUserRepository securityUserRepository;

    @Autowired
    BenPubSupRepository benPubSupRepository;

    @Autowired
    UserService userService;

    @Autowired
    BeneficiaryService beneficiaryService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    SupplierMapper supplierMapper;

    @Autowired
    BenPubSupMapper benPubSupMapper;

    public List<SupplierDTO> getAllSuppliers() {
        return supplierMapper.toDTOList(Lists.newArrayList(supplierRepository.findAll()));
    }

    public SupplierDTO getSupplierById(Long supplierId) {
        return supplierMapper.toDTO(supplierRepository.findOne(supplierId));
    }

    @Transactional
    public SupplierDTO createSupplier(SupplierDTO supplierDTO) {

        _log.info("[i] create Supplier");

        /*
            TODO: enable a validation to avoid user duplicity
        */

        // get supplier email
        String email = supplierDTO.getContactEmail();

        UserDTO persUserDTO = getUserByEmail(email);

        if (persUserDTO == null) {

            // create supplier user
            UserDTO userDTO = new UserDTO();
            userDTO.setCreateDate(new Date());
            userDTO.setEmail(email);
            userDTO.setUserType(Constant.ROLE_SUPPLIER);

            // create temporal password
            String password = UUID.randomUUID().toString().replace("-", "").substring(0, 7);
            userDTO.setPassword(password);
            _log.info("create user: " + userDTO.toString());


            //create supplier entity
            SupplierDTO perSupplierDTO = supplierMapper.toDTO(supplierRepository.save(supplierMapper.toEntity(supplierDTO)));

            //link supplier and user and store user
            userDTO.setUserTypeId(perSupplierDTO.getSupplierId());
            userDTO = userMapper.toDTO(securityUserRepository.save(userMapper.toEntity(userDTO)));

            //send activate account mail

            userService.sendActivateAccountMail(userDTO);

            _log.info("[f] create Supplier");

            return perSupplierDTO;
        } else {
            _log.warn("trying to duplicate user");
            return null;
        }
    }

    private UserDTO getUserByEmail(String email) {
        return userMapper.toDTO(securityUserRepository.findByEmail(email));
    }

    public List<LegalEntityDTO> getSelectedMe(Long supplierId) {
        List<BenPubSupDTO> benPubSupDTOList = benPubSupMapper.toDTOList(Lists.newArrayList(benPubSupRepository.findSelectedMeBySupplierId(supplierId)));
        List<LegalEntityDTO> legalEntityDTOList = Lists.newArrayList();

        for (BenPubSupDTO benPubSupDTO : benPubSupDTOList) {
            if (benPubSupDTO != null) {
                legalEntityDTOList.add(beneficiaryService.getLegalEntity(benPubSupDTO.getBeneficiaryId()));
            }
        }
        return legalEntityDTOList;
    }

    public List<LegalEntityDTO> getAwardedMunicipalities() {
        List<BenPubSupDTO> benPubSupDTOList = benPubSupMapper.toDTOList(Lists.newArrayList(benPubSupRepository.findAllByAwarded(true)));
        List<LegalEntityDTO> legalEntityDTOList = Lists.newArrayList();

        for (BenPubSupDTO benPubSupDTO : benPubSupDTOList) {
            if (benPubSupDTO != null) {
                legalEntityDTOList.add(beneficiaryService.getLegalEntity(benPubSupDTO.getBeneficiaryId()));
            }
        }
        return legalEntityDTOList;
    }

}
