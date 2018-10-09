package wifi4eu.wifi4eu.common.mapper.thread;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import wifi4eu.wifi4eu.common.dto.model.ThreadDTO;
import wifi4eu.wifi4eu.common.dto.model.ThreadMessageDTO;
import wifi4eu.wifi4eu.entity.thread.Thread;
import wifi4eu.wifi4eu.entity.thread.ThreadMessage;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ThreadMapper {
    //    @Mapping(source = "entity.lau.id", target = "lauId")
    ThreadDTO toDTO(Thread entity);

    //    @Mapping(source = "vo.lauId", target = "lau.id")
    Thread toEntity(ThreadDTO vo);

    @Mappings({
            @Mapping(source = "entity.thread.id", target = "threadId"),
            @Mapping(source = "entity.author.id", target = "authorId")
    })
    ThreadMessageDTO toDTO(ThreadMessage entity);

    @Mappings({
            @Mapping(source = "vo.threadId", target = "thread.id"),
            @Mapping(source = "vo.authorId", target = "author.id")
    })
    ThreadMessage toEntity(ThreadMessageDTO vo);

    List<ThreadDTO> toDTOList(List<Thread> list);

    List<Thread> toEntityList(List<ThreadDTO> list);
}

