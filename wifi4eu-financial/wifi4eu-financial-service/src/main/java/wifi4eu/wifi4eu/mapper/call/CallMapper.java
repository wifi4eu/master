package wifi4eu.wifi4eu.common.mapper.call;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.CallDTO;
import wifi4eu.wifi4eu.entity.call.Call;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CallMapper {

    CallDTO toDTO(Call entity);

    Call toEntity(CallDTO vo);

    List<CallDTO> toDTOList(List<Call> list);

    List<Call> toEntityList(List<CallDTO> list);

}
