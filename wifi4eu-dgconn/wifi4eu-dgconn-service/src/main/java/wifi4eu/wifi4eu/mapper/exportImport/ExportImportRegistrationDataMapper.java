package wifi4eu.wifi4eu.mapper.exportImport;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import wifi4eu.wifi4eu.common.dto.model.ExportImportRegistrationDataDTO;
import wifi4eu.wifi4eu.entity.exportImport.ExportImportRegistrationData;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ExportImportRegistrationDataMapper {

      @Mappings({
              @Mapping(source = "entity.municipality.id", target = "municipality")
      })
      ExportImportRegistrationDataDTO toDTO(ExportImportRegistrationData entity);

      @Mappings({
              @Mapping(source = "vo.municipality", target = "entity.municipality.id")
      })
      ExportImportRegistrationData toEntity(ExportImportRegistrationDataDTO vo);
      List<ExportImportRegistrationDataDTO> toDTOList(List<ExportImportRegistrationData> list);
      List<ExportImportRegistrationData> toEntityList(List<ExportImportRegistrationDataDTO> list);

}
