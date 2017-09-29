package wifi4eu.wifi4eu.mapper;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.RegistrationDTO;
import wifi4eu.wifi4eu.entity.Registration;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RegistrationMapper {
    RegistrationDTO toDTO(Registration entity);
    Registration toEntity(RegistrationDTO vo);
    List<RegistrationDTO> toDTOList(List<Registration> list);
    List<Registration> toEntityList(List<RegistrationDTO> list);
}