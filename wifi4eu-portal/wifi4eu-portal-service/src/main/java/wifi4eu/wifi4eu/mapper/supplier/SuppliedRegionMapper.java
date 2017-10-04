package wifi4eu.wifi4eu.mapper.supplier;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.SuppliedRegionDTO;
import wifi4eu.wifi4eu.entity.supplier.SuppliedRegion;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SuppliedRegionMapper {
    SuppliedRegionDTO toDTO(SuppliedRegion entity);
    SuppliedRegion toEntity(SuppliedRegionDTO vo);
    List<SuppliedRegionDTO> toDTOList(List<SuppliedRegion> list);
    List<SuppliedRegion> toEntityList(List<SuppliedRegionDTO> list);
}