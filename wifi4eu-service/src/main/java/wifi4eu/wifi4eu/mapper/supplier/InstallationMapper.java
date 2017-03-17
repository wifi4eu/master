package wifi4eu.wifi4eu.mapper.supplier;

import wifi4eu.wifi4eu.common.dto.model.InstallationDTO;
import wifi4eu.wifi4eu.entity.supplier.Installation;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface InstallationMapper {
    InstallationDTO toDTO(Installation entity);

    Installation toEntity(InstallationDTO vo);

    List<InstallationDTO> toDTOList(List<Installation> list);

    List<Installation> toEntityList(List<InstallationDTO> list);
}