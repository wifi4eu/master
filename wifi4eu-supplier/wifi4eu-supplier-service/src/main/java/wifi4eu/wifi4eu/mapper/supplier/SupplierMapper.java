package wifi4eu.wifi4eu.mapper.supplier;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import wifi4eu.wifi4eu.common.dto.model.NutsDTO;
import wifi4eu.wifi4eu.common.dto.model.SuppliedRegionDTO;
import wifi4eu.wifi4eu.common.dto.model.SupplierDTO;
import wifi4eu.wifi4eu.entity.location.Nuts;
import wifi4eu.wifi4eu.entity.supplier.SuppliedRegion;
import wifi4eu.wifi4eu.entity.supplier.Supplier;
import wifi4eu.wifi4eu.mapper.user.UserMapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface SupplierMapper {

    NutsDTO toDTO(Nuts entity);

    SupplierDTO toDTO(Supplier entity);

    Supplier toEntity(SupplierDTO vo);

    @Mappings({
            @Mapping(source = "entity.supplier.id", target = "supplierId"),
            @Mapping(source = "entity.region", target = "regionId")
    })
    SuppliedRegionDTO toDTO(SuppliedRegion entity);

    @Mappings({
            @Mapping(source = "vo.supplierId", target = "supplier.id"),
            @Mapping(source = "vo.regionId.id", target = "region.id")
    })
    SuppliedRegion toEntity(SuppliedRegionDTO vo);

    List<SupplierDTO> toDTOList(List<Supplier> list);

    List<Supplier> toEntityList(List<SupplierDTO> list);
}