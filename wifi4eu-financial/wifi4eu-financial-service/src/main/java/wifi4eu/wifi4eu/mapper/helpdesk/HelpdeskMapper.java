package wifi4eu.wifi4eu.common.mapper.helpdesk;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.HelpdeskIssueDTO;
import wifi4eu.wifi4eu.entity.helpdesk.Helpdesk;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HelpdeskMapper {

    HelpdeskIssueDTO toDTO(Helpdesk entity);

    Helpdesk toEntity(HelpdeskIssueDTO vo);

    List<HelpdeskIssueDTO> toDTOList(List<Helpdesk> list);

    List<Helpdesk> toEntityList(List<HelpdeskIssueDTO> list);

}
