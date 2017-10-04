package wifi4eu.wifi4eu.mapper.helpdesk;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.HelpdeskIssueDTO;
import wifi4eu.wifi4eu.entity.helpdesk.HelpdeskIssue;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HelpdeskIssueMapper {
    HelpdeskIssueDTO toDTO(HelpdeskIssue entity);
    HelpdeskIssue toEntity(HelpdeskIssueDTO vo);
    List<HelpdeskIssueDTO> toDTOList(List<HelpdeskIssue> list);
    List<HelpdeskIssue> toEntityList(List<HelpdeskIssueDTO> list);
}