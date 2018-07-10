package wifi4eu.wifi4eu.mapper.exportImport;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.ValidatedBCDTO;
import wifi4eu.wifi4eu.entity.exportImport.ValidatedBC;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ExportImportValidatedBcMapper {

      ValidatedBCDTO toDTO(ValidatedBC entity);
      ValidatedBC toEntity(ValidatedBCDTO vo);
      List<ValidatedBCDTO> toDTOList(List<ValidatedBC> list);
      List<ValidatedBC> toEntityList(List<ValidatedBCDTO> list);

}
