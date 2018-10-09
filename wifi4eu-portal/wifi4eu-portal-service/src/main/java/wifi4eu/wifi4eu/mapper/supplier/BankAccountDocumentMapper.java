package wifi4eu.wifi4eu.mapper.supplier;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import wifi4eu.wifi4eu.common.dto.model.BankAccountDocumentDTO;
import wifi4eu.wifi4eu.entity.supplier.BankAccountDocument;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BankAccountDocumentMapper {

    @Mappings ({
        @Mapping(ignore = true, target = "fileData"),
        @Mapping(ignore = true, target = "bankAccountDocumentDTOList")
    })
    BankAccountDocumentDTO toDTO(BankAccountDocument entity);

    BankAccountDocument toEntity(BankAccountDocumentDTO vo);

    List<BankAccountDocumentDTO> toDTOList(List<BankAccountDocument> list);

    List<BankAccountDocument> toEntityList(List<BankAccountDocumentDTO> list);
}
