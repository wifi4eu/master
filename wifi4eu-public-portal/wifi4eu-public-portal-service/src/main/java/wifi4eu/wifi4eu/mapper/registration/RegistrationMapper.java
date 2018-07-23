package wifi4eu.wifi4eu.mapper.registration;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import wifi4eu.wifi4eu.common.dto.model.RegistrationDTO;
import wifi4eu.wifi4eu.entity.registration.Registration;
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
}