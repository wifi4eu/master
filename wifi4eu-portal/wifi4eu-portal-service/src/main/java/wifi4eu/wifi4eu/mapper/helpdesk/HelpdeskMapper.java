package wifi4eu.wifi4eu.mapper.helpdesk;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.HelpdeskDTO;
import wifi4eu.wifi4eu.entity.helpdesk.Helpdesk;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HelpdeskMapper {

    HelpdeskDTO toDTO(Helpdesk entity);

    Helpdesk toEntity(HelpdeskDTO vo);

    List<HelpdeskDTO> toDTOList(List<Helpdesk> list);

    List<Helpdesk> toEntityList(List<HelpdeskDTO> list);

}
