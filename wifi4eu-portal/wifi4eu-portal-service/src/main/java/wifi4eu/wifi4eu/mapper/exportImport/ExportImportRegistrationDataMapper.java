package wifi4eu.wifi4eu.mapper.exportImport;

import org.mapstruct.Mapper;
import java.util.List;

import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import wifi4eu.wifi4eu.common.dto.model.ExportImportRegistrationDataDTO;
import wifi4eu.wifi4eu.common.dto.model.MunicipalityDTO;
import wifi4eu.wifi4eu.common.dto.model.RegistrationDTO;
import wifi4eu.wifi4eu.entity.exportImport.ExportImportRegistrationData;
import wifi4eu.wifi4eu.entity.municipality.Municipality;
import wifi4eu.wifi4eu.entity.registration.Registration;

@Mapper(componentModel = "spring")
public interface ExportImportRegistrationDataMapper {

      ExportImportRegistrationDataDTO toDTO(ExportImportRegistrationData entity);
      ExportImportRegistrationData toEntity(ExportImportRegistrationDataDTO vo);
      List<ExportImportRegistrationDataDTO> toDTOList(List<ExportImportRegistrationData> list);
      List<ExportImportRegistrationData> toEntityList(List<ExportImportRegistrationDataDTO> list);

}
