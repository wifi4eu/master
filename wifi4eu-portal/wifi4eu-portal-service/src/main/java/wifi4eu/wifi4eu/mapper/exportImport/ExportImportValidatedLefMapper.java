package wifi4eu.wifi4eu.mapper.exportImport;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.ValidateLEFDTO;
import wifi4eu.wifi4eu.entity.exportImport.ValidateLEF;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ExportImportValidatedLefMapper {

      ValidateLEFDTO toDTO(ValidateLEF entity);
      ValidateLEF toEntity(ValidateLEFDTO vo);
      List<ValidateLEFDTO> toDTOList(List<ValidateLEF> list);
      List<ValidateLEF> toEntityList(List<ValidateLEFDTO> list);

}
