package wifi4eu.wifi4eu.common.mapper.supplier;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.SupplierDTO;
import wifi4eu.wifi4eu.entity.supplier.Supplier;
import java.util.List;

@Mapper(componentModel = "spring")
public interface SupplierMapper {
    SupplierDTO toDTO(Supplier entity);

    Supplier toEntity(SupplierDTO vo);

    List<SupplierDTO> toDTOList(List<Supplier> list);

    List<Supplier> toEntityList(List<SupplierDTO> list);
}

