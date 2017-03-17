package wifi4eu.wifi4eu.service.supplier;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.BeneficiarySupplierPublicationDTO;
import wifi4eu.wifi4eu.mapper.supplier.BeneficiarySupplierPublicationMapper;
import wifi4eu.wifi4eu.repository.supplier.BeneficiarySupplierPublicationRepository;

import java.util.List;

@Service
public class BeneficiarySupplierPublicationService {

    Logger _log = LoggerFactory.getLogger(BeneficiarySupplierPublicationService.class);

    @Autowired
    BeneficiarySupplierPublicationRepository beneficiarySupplierPublicationRepository;

    @Autowired
    BeneficiarySupplierPublicationMapper beneficiarySupplierPublicationMapper;


    public List<BeneficiarySupplierPublicationDTO> getAllBeneficiarySupplierPublications() {
        return beneficiarySupplierPublicationMapper.toDTOList(Lists.newArrayList(beneficiarySupplierPublicationRepository.findAll()));
    }

    public BeneficiarySupplierPublicationDTO getBeneficiarySupplierPublication(Long benSupplierPublicationId) {
        return beneficiarySupplierPublicationMapper.toDTO(beneficiarySupplierPublicationRepository.findOne(benSupplierPublicationId));
    }

    public BeneficiarySupplierPublicationDTO createBeneficiarySupplierPublication(BeneficiarySupplierPublicationDTO beneficiarySupplierPublicationDTO) {
        return beneficiarySupplierPublicationMapper.toDTO(beneficiarySupplierPublicationRepository.save(beneficiarySupplierPublicationMapper.toEntity(beneficiarySupplierPublicationDTO)));
    }

}
