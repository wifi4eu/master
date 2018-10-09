package wifi4eu.wifi4eu.common.mapper.timeline;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.TimelineDTO;
import wifi4eu.wifi4eu.entity.timeline.Timeline;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TimelineMapper {
    TimelineDTO toDTO(Timeline entity);
    Timeline toEntity(TimelineDTO vo);
    List<TimelineDTO> toDTOList(List<Timeline> list);
    List<Timeline> toEntityList(List<TimelineDTO> list);
}