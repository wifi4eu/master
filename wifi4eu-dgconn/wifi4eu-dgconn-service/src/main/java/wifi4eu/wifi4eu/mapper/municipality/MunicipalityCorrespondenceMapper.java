package wifi4eu.wifi4eu.mapper.municipality;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.LogEmailDTO;
import wifi4eu.wifi4eu.entity.logEmails.LogEmail;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MunicipalityCorrespondenceMapper {

    LogEmail toEntity(LogEmailDTO dto);
    LogEmailDTO toDTO(LogEmail entity);
    List<LogEmail> toEntityList(List<LogEmailDTO> logEmailDTOList);
    List<LogEmailDTO> toDTOList(List<LogEmail> logEmails);
}
