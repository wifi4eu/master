package wifi4eu.wifi4eu.mapper.supplier;


import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.SupplierListItemDTO;
import wifi4eu.wifi4eu.entity.supplier.SupplierListItem;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SupplierListItemMapper {

    SupplierListItemDTO toDTO(SupplierListItem entity);
    SupplierListItem toEntity(SupplierListItemDTO vo);

    List<SupplierListItemDTO> toDTOList(List<SupplierListItem> list);
    List<SupplierListItem> toEntityList(List<SupplierListItemDTO> list);
}
