package wifi4eu.wifi4eu.mapper.call;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import wifi4eu.wifi4eu.common.dto.model.CallDTO;
import wifi4eu.wifi4eu.common.dto.model.TimelineDTO;
import wifi4eu.wifi4eu.entity.call.Call;
import wifi4eu.wifi4eu.entity.timeline.Timeline;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CallMapper {
    CallDTO toDTO(Call entity);
    Call toEntity(CallDTO vo);
    @Mapping(source = "entity.call.id", target = "callId")
    TimelineDTO toDTO(Timeline entity);
    @Mapping(source = "vo.callId", target = "call.id")
    Timeline toEntity(TimelineDTO vo);
    List<CallDTO> toDTOList(List<Call> list);
    List<Call> toEntityList(List<CallDTO> list);
}