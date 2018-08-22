package wifi4eu.wifi4eu.mapper.exportImport;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.ValidatedLEFDTO;
import wifi4eu.wifi4eu.entity.exportImport.ValidatedLEF;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ExportImportValidatedLefMapper {

      ValidatedLEFDTO toDTO(ValidatedLEF entity);
      ValidatedLEF toEntity(ValidatedLEFDTO vo);
      List<ValidatedLEFDTO> toDTOList(List<ValidatedLEF> list);
      List<ValidatedLEF> toEntityList(List<ValidatedLEFDTO> list);

}
