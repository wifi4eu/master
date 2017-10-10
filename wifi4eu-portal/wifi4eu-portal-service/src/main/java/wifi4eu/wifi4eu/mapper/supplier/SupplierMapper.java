package wifi4eu.wifi4eu.mapper.supplier;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import wifi4eu.wifi4eu.common.dto.model.SuppliedRegionDTO;
import wifi4eu.wifi4eu.common.dto.model.SupplierDTO;
import wifi4eu.wifi4eu.entity.supplier.SuppliedRegion;
import wifi4eu.wifi4eu.entity.supplier.Supplier;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SupplierMapper {
    SupplierDTO toDTO(Supplier entity);
    Supplier toEntity(SupplierDTO vo);
    @Mappings({
            @Mapping(source = "entity.supplier.id", target = "supplierId"),
            @Mapping(source = "entity.region.nutsId", target = "regionId")
    })
    SuppliedRegionDTO toDTO(SuppliedRegion entity);
    @Mappings({
            @Mapping(source = "vo.supplierId", target = "supplier.id"),
            @Mapping(source = "vo.regionId", target = "region.nutsId")
    })
    SuppliedRegion toEntity(SuppliedRegionDTO vo);
    List<SupplierDTO> toDTOList(List<Supplier> list);
    List<Supplier> toEntityList(List<SupplierDTO> list);
}