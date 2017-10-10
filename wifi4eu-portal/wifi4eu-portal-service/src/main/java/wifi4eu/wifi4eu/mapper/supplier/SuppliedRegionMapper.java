package wifi4eu.wifi4eu.mapper.supplier;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import wifi4eu.wifi4eu.common.dto.model.SuppliedRegionDTO;
import wifi4eu.wifi4eu.entity.supplier.SuppliedRegion;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SuppliedRegionMapper {
    @Mappings({
            @Mapping(source = "entity.supplier.id", target = "supplierId"),
            @Mapping(source = "entity.region.id", target = "regionId")
    })
    SuppliedRegionDTO toDTO(SuppliedRegion entity);
    @Mappings({
            @Mapping(source = "vo.supplierId", target = "supplier.id"),
            @Mapping(source = "vo.regionId", target = "region.id")
    })
    SuppliedRegion toEntity(SuppliedRegionDTO vo);
    List<SuppliedRegionDTO> toDTOList(List<SuppliedRegion> list);
    List<SuppliedRegion> toEntityList(List<SuppliedRegionDTO> list);
}