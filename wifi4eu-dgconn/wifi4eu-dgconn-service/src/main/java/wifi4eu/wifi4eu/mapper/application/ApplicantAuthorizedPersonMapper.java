package wifi4eu.wifi4eu.mapper.application;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import wifi4eu.wifi4eu.common.dto.model.ApplicationAuthorizedPersonDTO;
import wifi4eu.wifi4eu.entity.application.ApplicationAuthorizedPerson;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApplicantAuthorizedPersonMapper {

    @Mappings({
            @Mapping(target = "authorized_person", source = "entity.authorizedPerson"),
            @Mapping(source = "entity.application.id", target = "applicationId")
    })
    ApplicationAuthorizedPersonDTO toDTO(ApplicationAuthorizedPerson entity);

    @Mappings({
            @Mapping(source = "vo.authorized_person", target = "authorizedPerson"),
            @Mapping(source = "vo.applicationId", target = "application.id")
    })
    ApplicationAuthorizedPerson toEntity(ApplicationAuthorizedPersonDTO vo);

    List<ApplicationAuthorizedPersonDTO> toDTOList(List<ApplicationAuthorizedPerson> list);
    List<ApplicationAuthorizedPerson> toEntityList(List<ApplicationAuthorizedPersonDTO> list);

}