package wifi4eu.wifi4eu.mapper.thread;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import wifi4eu.wifi4eu.common.dto.model.ThreadDTO;
import wifi4eu.wifi4eu.common.dto.model.ThreadMessageDTO;
import wifi4eu.wifi4eu.entity.thread.Thread;
import wifi4eu.wifi4eu.entity.thread.ThreadMessage;

import java.util.List;

@Mapper(componentModel = "spring", uses = ThreadMessageMapper.class)
public interface ThreadMapper {
    //    @Mapping(source = "entity.lau.id", target = "lauId")
    ThreadDTO toDTO(Thread entity);

    //    @Mapping(source = "vo.lauId", target = "lau.id")
    Thread toEntity(ThreadDTO vo);

    List<ThreadDTO> toDTOList(List<Thread> list);

    List<Thread> toEntityList(List<ThreadDTO> list);
}

