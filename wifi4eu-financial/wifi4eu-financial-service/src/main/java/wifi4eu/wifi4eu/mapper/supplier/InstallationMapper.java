package wifi4eu.wifi4eu.common.mapper.supplier;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.InstallationDTO;
import wifi4eu.wifi4eu.entity.supplier.Installation;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InstallationMapper {
    InstallationDTO toDTO(Installation entity);

    Installation toEntity(InstallationDTO vo);

    List<InstallationDTO> toDTOList(List<Installation> list);

    List<Installation> toEntityList(List<InstallationDTO> list);
}