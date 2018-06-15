package wifi4eu.wifi4eu.mapper.registrationWarning;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import wifi4eu.wifi4eu.common.dto.model.RegistrationWarningDTO;
import wifi4eu.wifi4eu.entity.warnings.RegistrationWarning;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RegistrationWarningMapper {

    @Mappings({
            @Mapping(source = "entity.registration", target = "registrationId"),
    })
    RegistrationWarningDTO toDTO(RegistrationWarning entity);

    @Mappings({
            @Mapping(source = "vo.registrationId", target = "registration"),
    })
    RegistrationWarning toEntity(RegistrationWarningDTO vo);

    List<RegistrationWarningDTO> toDTOList(List<RegistrationWarning> list);

    List<RegistrationWarning> toEntityList(List<RegistrationWarningDTO> list);

}
