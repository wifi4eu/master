package wifi4eu.wifi4eu.mapper.history_action;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.UserHistoryActionDTO;
import wifi4eu.wifi4eu.entity.history_action.UserHistoryAction;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserHistoryActionMapper {
    UserHistoryActionDTO toDTO(UserHistoryAction entity);
    UserHistoryAction toEntity(UserHistoryActionDTO vo);
    List<UserHistoryActionDTO> toDTOList(List<UserHistoryAction> list);
    List<UserHistoryAction> toEntityList(List<UserHistoryActionDTO> list);
}