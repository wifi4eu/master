package wifi4eu.wifi4eu.mapper.supplier;

import wifi4eu.wifi4eu.common.dto.model.InvoiceDTO;
import wifi4eu.wifi4eu.entity.supplier.Invoice;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    InvoiceDTO toDTO(Invoice entity);

    Invoice toEntity(InvoiceDTO vo);

    List<InvoiceDTO> toDTOList(List<Invoice> list);

    List<Invoice> toEntityList(List<InvoiceDTO> list);
}