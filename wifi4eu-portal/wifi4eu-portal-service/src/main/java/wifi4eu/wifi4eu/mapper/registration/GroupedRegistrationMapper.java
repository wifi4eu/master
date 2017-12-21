package wifi4eu.wifi4eu.mapper.registration;

import wifi4eu.wifi4eu.common.dto.model.GroupedRegistrationDTO;
import wifi4eu.wifi4eu.entity.registration.GroupedRegistration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GroupedRegistrationMapper {
    GroupedRegistrationDTO toDTO(GroupedRegistration entity);
    GroupedRegistration toEntity(GroupedRegistrationDTO vo);
    List<GroupedRegistrationDTO> toDTOList(List<GroupedRegistration> list);
    List<GroupedRegistration> toEntityList(List<GroupedRegistrationDTO> list);
}