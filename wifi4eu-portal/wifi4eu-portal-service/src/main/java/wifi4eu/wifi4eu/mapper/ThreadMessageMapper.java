package wifi4eu.wifi4eu.mapper;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.ThreadMessageDTO;
import wifi4eu.wifi4eu.entity.ThreadMessage;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ThreadMessageMapper {
    ThreadMessageDTO toDTO(ThreadMessage entity);
    ThreadMessage toEntity(ThreadMessageDTO vo);
    List<ThreadMessageDTO> toDTOList(List<ThreadMessage> list);
    List<ThreadMessage> toEntityList(List<ThreadMessageDTO> list);
}