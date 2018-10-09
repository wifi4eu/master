package wifi4eu.wifi4eu.common.mapper.helpdesk;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.HelpdeskCommentDTO;
import wifi4eu.wifi4eu.entity.helpdesk.HelpdeskComment;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HelpdeskCommentMapper {

    HelpdeskCommentDTO toDTO(HelpdeskComment entity);

    HelpdeskComment toEntity(HelpdeskCommentDTO vo);

    List<HelpdeskCommentDTO> toDTOList(List<HelpdeskComment> list);

    List<HelpdeskComment> toEntityList(List<HelpdeskCommentDTO> list);

}
