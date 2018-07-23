package wifi4eu.wifi4eu.mapper.registration;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import wifi4eu.wifi4eu.common.dto.model.RegistrationDTO;
import wifi4eu.wifi4eu.common.dto.model.RegistrationWarningDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.entity.registration.Registration;
import wifi4eu.wifi4eu.entity.user.User;
import wifi4eu.wifi4eu.entity.warnings.RegistrationWarning;
import wifi4eu.wifi4eu.mapper.user.UserMapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface RegistrationMapper {
    @Mappings({
            @Mapping(source = "entity.municipality.id", target = "municipalityId")
    })
    RegistrationDTO toDTO(Registration entity);

    @Mappings({
            @Mapping(source = "vo.municipalityId", target = "municipality.id")
    })
    Registration toEntity(RegistrationDTO vo);

    List<RegistrationDTO> toDTOList(List<Registration> list);

    List<Registration> toEntityList(List<RegistrationDTO> list);

//    @Mappings({
//            @Mapping(source = "entity.user.id", target = "userId"),
//            @Mapping(source = "entity.municipality.id", target = "municipalityId")
//    })
//    RegistrationDTO toDTO(Registration entity);

    RegistrationWarningDTO toDTO(RegistrationWarning entity);

    RegistrationWarning toEntity(RegistrationWarningDTO vo);

    List<RegistrationWarningDTO> toDTOListRegistrationWarning(List<RegistrationWarning> list);

    List<RegistrationWarning> toEntityListRegistrationWarning(List<RegistrationWarningDTO> list);

}