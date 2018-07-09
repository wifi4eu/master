package wifi4eu.wifi4eu.mapper.application;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import wifi4eu.wifi4eu.common.dto.model.ApplicationInvalidateReasonDTO;
import wifi4eu.wifi4eu.entity.application.ApplicationInvalidateReason;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApplicationInvalidateReasonMapper {

    @Mapping(target = "applicationId", source = "entity.application.id")
    ApplicationInvalidateReasonDTO toDTO(ApplicationInvalidateReason entity);
    @Mapping(target = "application.id", source = "vo.applicationId")
    ApplicationInvalidateReason toEntity(ApplicationInvalidateReasonDTO vo);

    List<ApplicationInvalidateReasonDTO> toDTOList(List<ApplicationInvalidateReason> list);
    List<ApplicationInvalidateReason> toEntityList(List<ApplicationInvalidateReasonDTO> list);
}
