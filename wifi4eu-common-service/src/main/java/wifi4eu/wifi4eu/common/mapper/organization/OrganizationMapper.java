package wifi4eu.wifi4eu.common.mapper.organization;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.OrganizationDTO;
import wifi4eu.wifi4eu.entity.organization.Organization;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {
    OrganizationDTO toDTO(Organization entity);
    Organization toEntity(OrganizationDTO vo);
    List<OrganizationDTO> toDTOList(List<Organization> list);
    List<Organization> toEntityList(List<OrganizationDTO> list);
}