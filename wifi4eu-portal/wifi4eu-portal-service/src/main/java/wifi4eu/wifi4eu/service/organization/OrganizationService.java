package wifi4eu.wifi4eu.service.organization;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.OrganizationDTO;
import wifi4eu.wifi4eu.mapper.organization.OrganizationMapper;
import wifi4eu.wifi4eu.repository.organization.OrganizationRepository;

import java.util.List;

@Service
public class OrganizationService {
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
        return organizationMapper.toDTOList(Lists.newArrayList(organizationRepository.findByCountry(country)));
    }
}