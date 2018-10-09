package wifi4eu.wifi4eu.common.mapper.call;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import wifi4eu.wifi4eu.common.dto.model.CallDTO;
import wifi4eu.wifi4eu.common.dto.model.TimelineDTO;
import wifi4eu.wifi4eu.common.dto.model.VoucherManagementDTO;
import wifi4eu.wifi4eu.entity.call.Call;
import wifi4eu.wifi4eu.entity.timeline.Timeline;
import wifi4eu.wifi4eu.entity.voucherManagement.VoucherManagement;

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

    @Mapping(source = "entity.voucherCall.id", target = "call_id")
    VoucherManagementDTO toDTO(VoucherManagement entity);

    @Mapping(source = "vo.call_id", target = "voucherCall.id")
    VoucherManagement toEntity(VoucherManagementDTO vo);

}