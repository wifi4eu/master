package wifi4eu.wifi4eu.service.organization;

import com.google.common.collect.Lists;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.OrganizationDTO;
import wifi4eu.wifi4eu.mapper.organization.OrganizationMapper;
import wifi4eu.wifi4eu.repository.organization.OrganizationRepository;
import wifi4eu.wifi4eu.service.beneficiary.BeneficiaryService;

import java.util.List;

@Service("portalOrganizationService")
public class OrganizationService {
    private final Logger _log = LogManager.getLogger(OrganizationService.class);
    
    @Autowired
    OrganizationMapper organizationMapper;

    @Autowired
    OrganizationRepository organizationRepository;

    public List<OrganizationDTO> getAllOrganizations() {
        return organizationMapper.toDTOList(Lists.newArrayList(organizationRepository.findAll()));
    }

    public OrganizationDTO getOrganizationById(int organizationId) {
        return organizationMapper.toDTO(organizationRepository.findOne(organizationId));
    }
    
    public OrganizationDTO createOrganization(OrganizationDTO organizationDTO) {
		if (organizationDTO.getId() != 0) {
			_log.warn("Call to a create method with id set, the value has been removed ({})", organizationDTO.getId());
			organizationDTO.setId(0);	
		}
		return organizationMapper.toDTO(organizationRepository.save(organizationMapper.toEntity(organizationDTO)));
    }

    public OrganizationDTO saveOrganization(OrganizationDTO organizationDTO) {
        return organizationMapper.toDTO(organizationRepository.save(organizationMapper.toEntity(organizationDTO)));
    }

    public OrganizationDTO deleteOrganization(int organizationId) {
        OrganizationDTO organizationDTO = organizationMapper.toDTO(organizationRepository.findOne(organizationId));
        if (organizationDTO != null) {
            organizationRepository.delete(organizationMapper.toEntity(organizationDTO));
            return organizationDTO;
        } else {
            return null;
        }
    }

    @Cacheable(value = "portalGetOrganizationsByCountry")
    public List<OrganizationDTO> getOrganizationsByCountry(String country) {
        return organizationMapper.toDTOList(Lists.newArrayList(organizationRepository.findByCountryOrderByName(country)));
    }
}