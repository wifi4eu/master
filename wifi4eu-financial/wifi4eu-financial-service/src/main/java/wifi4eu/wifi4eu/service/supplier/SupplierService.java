package wifi4eu.wifi4eu.service.supplier;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.Constant;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.dto.security.UserDTO;
import wifi4eu.wifi4eu.mapper.beneficiary.LegalEntityMapper;
import wifi4eu.wifi4eu.mapper.supplier.AccessPointMapper;
import wifi4eu.wifi4eu.mapper.supplier.BenPubSupMapper;
import wifi4eu.wifi4eu.mapper.security.UserMapper;
import wifi4eu.wifi4eu.mapper.supplier.InstallationMapper;
import wifi4eu.wifi4eu.mapper.supplier.SupplierMapper;
import wifi4eu.wifi4eu.repository.beneficiary.LegalEntityRepository;
import wifi4eu.wifi4eu.repository.security.SecurityUserRepository;
import wifi4eu.wifi4eu.repository.supplier.AccessPointRepository;
import wifi4eu.wifi4eu.repository.supplier.BenPubSupRepository;
import wifi4eu.wifi4eu.repository.supplier.InstallationRepository;
import wifi4eu.wifi4eu.repository.supplier.SupplierRepository;
import wifi4eu.wifi4eu.service.beneficiary.BeneficiaryService;
import wifi4eu.wifi4eu.service.security.UserService;
import wifi4eu.wifi4eu.entity.supplier.Supplier;

import java.util.ArrayList;
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
    BenPubSupRepository benPubSupRepository;

    @Autowired
    InstallationRepository installationRepository;

    @Autowired
    AccessPointRepository accessPointRepository;

    @Autowired
    LegalEntityRepository legalEntityRepository;

    @Autowired
    UserService userService;

    @Autowired
    BeneficiaryService beneficiaryService;

    @Autowired
    SupplierMapper supplierMapper;

    @Autowired
    BenPubSupMapper benPubSupMapper;

    @Autowired
    InstallationMapper installationMapper;

    @Autowired
    AccessPointMapper accessPointMapper;

    @Autowired
    LegalEntityMapper legalEntityMapper;


    public List<SupplierDTO> getAllSuppliers() {
        return supplierMapper.toDTOList(Lists.newArrayList(supplierRepository.findAll()));
    }

    public SupplierDTO getSupplierById(Long supplierId) {
        return supplierMapper.toDTO(supplierRepository.findOne(supplierId));
    }

    @Transactional
    public SupplierDTO createSupplier(SupplierDTO supplierDTO) {
        if (supplierDTO.getSuppliedRegions().isEmpty()) {
            return supplierMapper.toDTO(supplierRepository.save(supplierMapper.toEntity(supplierDTO)));
        } else {
            Integer supplierId = supplierDTO.getId();
            List<SuppliedRegionDTO> originalRegions = supplierDTO.getSuppliedRegions();
            List<SuppliedRegionDTO> correctRegions = new ArrayList<>();
            if (supplierId == 0) {
                supplierDTO.setSuppliedRegions(null);
                supplierDTO = supplierMapper.toDTO(supplierRepository.save(supplierMapper.toEntity(supplierDTO)));
                supplierId = supplierDTO.getId();
            }
            for (SuppliedRegionDTO region : originalRegions) {
                region.setSupplierId(supplierId);
                correctRegions.add(region);
            }
            supplierDTO.setSuppliedRegions(correctRegions);
            return supplierMapper.toDTO(supplierRepository.save(supplierMapper.toEntity(supplierDTO)));
        }
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

    public InstallationDTO createInstallation(InstallationDTO installationDTO) {
        return installationMapper.toDTO(installationRepository.save(installationMapper.toEntity(installationDTO)));
    }

    public InstallationDTO getInstallationById(Long installationId) {
        return installationMapper.toDTO(installationRepository.findOne(installationId));
    }

    public List<AccessPointDTO> getAccessPointsByInstallation(Long installationId) {
        return accessPointMapper.toDTOList(Lists.newArrayList(accessPointRepository.findByInstallationId(installationId)));
    }

    public AccessPointDTO createAccessPoint(AccessPointDTO accessPointDTO) {
        return accessPointMapper.toDTO(accessPointRepository.save(accessPointMapper.toEntity(accessPointDTO)));
    }

    public SupplierDTO saveSupplier(SupplierDTO supplierDTO) {
        return supplierMapper.toDTO(supplierRepository.save(supplierMapper.toEntity(supplierDTO)));
    }

    public LegalEntityDTO getLegalEntityByInstallationId(Long installationId) {
        BenPubSupDTO benPubSupDTO = benPubSupMapper.toDTO(benPubSupRepository.findOne(installationId));
        LegalEntityDTO legalEntityDTO = new LegalEntityDTO();
        if (benPubSupDTO != null) {
            legalEntityDTO = legalEntityMapper.toDTO(legalEntityRepository.findOne(benPubSupDTO.getBeneficiaryId()));
        }
        return legalEntityDTO;
    }

}
