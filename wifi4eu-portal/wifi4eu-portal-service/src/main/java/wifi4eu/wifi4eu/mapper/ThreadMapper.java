package wifi4eu.wifi4eu.mapper;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.ThreadDTO;
import wifi4eu.wifi4eu.entity.Thread;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ThreadMapper {
    ThreadDTO toDTO(Thread entity);
    Thread toEntity(ThreadDTO vo);
    List<ThreadDTO> toDTOList(List<Thread> list);
    List<Thread> toEntityList(List<ThreadDTO> list);
}