package wifi4eu.wifi4eu.common.mapper.helpdesk;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import wifi4eu.wifi4eu.common.dto.model.HelpdeskCommentDTO;
import wifi4eu.wifi4eu.common.dto.model.HelpdeskIssueDTO;
import wifi4eu.wifi4eu.entity.helpdesk.HelpdeskComment;
import wifi4eu.wifi4eu.entity.helpdesk.HelpdeskIssue;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HelpdeskIssueMapper {
    HelpdeskIssueDTO toDTO(HelpdeskIssue entity);
    HelpdeskIssue toEntity(HelpdeskIssueDTO vo);
    @Mapping(source = "entity.issue.id", target = "issueId")
    HelpdeskCommentDTO toDTO(HelpdeskComment entity);
    @Mapping(source = "vo.issueId", target = "issue.id")
    HelpdeskComment toEntity(HelpdeskCommentDTO vo);
    List<HelpdeskIssueDTO> toDTOList(List<HelpdeskIssue> list);
    List<HelpdeskIssue> toEntityList(List<HelpdeskIssueDTO> list);
}