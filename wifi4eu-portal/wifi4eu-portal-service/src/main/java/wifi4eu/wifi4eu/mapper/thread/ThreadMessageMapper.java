package wifi4eu.wifi4eu.mapper.thread;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import wifi4eu.wifi4eu.common.dto.model.ThreadMessageDTO;
import wifi4eu.wifi4eu.entity.thread.ThreadMessage;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ThreadMessageMapper {
    @Mappings({
            @Mapping(source = "entity.thread.id", target = "threadId"),
            @Mapping(source = "entity.author.id", target = "authorId"),
            @Mapping(source = "entity.registration", target = "registrationId")
    })
    ThreadMessageDTO toDTO(ThreadMessage entity);
    @Mappings({
            @Mapping(source = "vo.threadId", target = "thread.id"),
            @Mapping(source = "vo.authorId", target = "author.id"),
            @Mapping(source = "vo.registrationId", target = "registration")
    })
    ThreadMessage toEntity(ThreadMessageDTO vo);
    List<ThreadMessageDTO> toDTOList(List<ThreadMessage> list);
    List<ThreadMessage> toEntityList(List<ThreadMessageDTO> list);
}