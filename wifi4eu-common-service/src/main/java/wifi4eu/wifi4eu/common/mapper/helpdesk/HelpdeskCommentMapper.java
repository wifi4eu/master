package wifi4eu.wifi4eu.common.mapper.helpdesk;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import wifi4eu.wifi4eu.common.dto.model.HelpdeskCommentDTO;
import wifi4eu.wifi4eu.entity.helpdesk.HelpdeskComment;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HelpdeskCommentMapper {
    @Mapping(source = "entity.issue.id", target = "issueId")
    HelpdeskCommentDTO toDTO(HelpdeskComment entity);
    @Mapping(source = "vo.issueId", target = "issue.id")
    HelpdeskComment toEntity(HelpdeskCommentDTO vo);
    List<HelpdeskCommentDTO> toDTOList(List<HelpdeskComment> list);
    List<HelpdeskComment> toEntityList(List<HelpdeskCommentDTO> list);
}