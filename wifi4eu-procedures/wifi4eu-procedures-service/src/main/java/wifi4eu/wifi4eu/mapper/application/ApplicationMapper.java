package wifi4eu.wifi4eu.common.mapper.application;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import wifi4eu.wifi4eu.common.dto.model.ApplicationDTO;
import wifi4eu.wifi4eu.entity.application.Application;

import java.util.List;

// TODO: code duplication, please, move/join all ApplicationMapper's to one place
@Mapper(componentModel = "spring")
public interface ApplicationMapper {
    @Mappings({
            @Mapping(source = "entity.registration.id", target = "registrationId")
    })
    ApplicationDTO toDTO(Application entity);

    @Mappings({
            @Mapping(source = "vo.registrationId", target = "registration.id")
    })
    Application toEntity(ApplicationDTO vo);
    List<ApplicationDTO> toDTOList(List<Application> list);
    List<Application> toEntityList(List<ApplicationDTO> list);
}