package wifi4eu.wifi4eu.common.mapper.supplier;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.AccessPointDTO;
import wifi4eu.wifi4eu.entity.supplier.AccessPoint;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccessPointMapper {
    AccessPointDTO toDTO(AccessPoint entity);

    AccessPoint toEntity(AccessPointDTO vo);

    List<AccessPointDTO> toDTOList(List<AccessPoint> list);

    List<AccessPoint> toEntityList(List<AccessPointDTO> list);
}