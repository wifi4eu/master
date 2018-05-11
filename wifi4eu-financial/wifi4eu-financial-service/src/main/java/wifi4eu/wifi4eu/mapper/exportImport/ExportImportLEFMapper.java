package wifi4eu.wifi4eu.mapper.exportImport;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.ExportImportRegistrationDataDTO;
import wifi4eu.wifi4eu.entity.exportImport.ExportImportLEFData;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ExportImportLEFMapper {

      ExportImportRegistrationDataDTO toDTO(ExportImportLEFData entity);
      ExportImportLEFData toEntity(ExportImportRegistrationDataDTO vo);
      List<ExportImportRegistrationDataDTO> toDTOList(List<ExportImportLEFData> list);
      List<ExportImportLEFData> toEntityList(List<ExportImportRegistrationDataDTO> list);

}
