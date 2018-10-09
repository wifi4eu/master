package wifi4eu.wifi4eu.common.mapper.application;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import wifi4eu.wifi4eu.common.dto.model.ApplicationCommentDTO;
import wifi4eu.wifi4eu.entity.application.ApplicationComment;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApplicationCommentMapper {

    @Mappings({
            @Mapping(source = "dto.applicationId", target = "application.id"),
            @Mapping(source = "dto.userId", target = "user.id")
    })
    ApplicationComment toEntity(ApplicationCommentDTO dto);
    @Mappings({
            @Mapping(source = "entity.application.id", target = "applicationId"),
            @Mapping(source = "entity.user.ecasUsername", target = "username"),
            @Mapping(source = "entity.user.id", target = "userId")
    })
    ApplicationCommentDTO toDTO(ApplicationComment entity);
    List<ApplicationComment> toEntityList(List<ApplicationCommentDTO> applicationCommentDTOList);
    List<ApplicationCommentDTO> toDTOList(List<ApplicationComment> applicationComments);

}
