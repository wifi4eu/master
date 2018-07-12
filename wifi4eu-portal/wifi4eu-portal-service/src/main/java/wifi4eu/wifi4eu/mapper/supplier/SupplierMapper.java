package wifi4eu.wifi4eu.mapper.supplier;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.NutsDTO;
import wifi4eu.wifi4eu.common.dto.model.SuppliedRegionDTO;
import wifi4eu.wifi4eu.common.dto.model.SupplierDTO;
import wifi4eu.wifi4eu.entity.location.Nuts;
import wifi4eu.wifi4eu.entity.supplier.SuppliedRegion;
import wifi4eu.wifi4eu.entity.supplier.Supplier;

import java.util.List;

@Mapper(componentModel = "spring", uses = SupplierUserMapper.class)
public interface SupplierMapper {

    NutsDTO toDTO(Nuts entity);

    SupplierDTO toDTO(Supplier entity);

    Supplier toEntity(SupplierDTO vo);

    SuppliedRegionDTO toDTO(SuppliedRegion entity);

    SuppliedRegion toEntity(SuppliedRegionDTO vo);
    List<SupplierDTO> toDTOList(List<Supplier> list);
    List<Supplier> toEntityList(List<SupplierDTO> list);
}