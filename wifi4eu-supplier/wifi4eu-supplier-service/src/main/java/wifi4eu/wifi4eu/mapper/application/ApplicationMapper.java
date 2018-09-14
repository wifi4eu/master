package wifi4eu.wifi4eu.mapper.application;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.ApplicationDTO;
import wifi4eu.wifi4eu.entity.application.Application;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApplicationMapper {
    ApplicationDTO toDTO(Application entity);

    Application toEntity(ApplicationDTO vo);

    List<ApplicationDTO> toDTOList(List<Application> list);

    List<Application> toEntityList(List<ApplicationDTO> list);
}