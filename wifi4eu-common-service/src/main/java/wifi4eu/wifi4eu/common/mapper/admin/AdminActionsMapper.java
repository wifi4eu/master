package wifi4eu.wifi4eu.common.mapper.admin;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.AdminActionsDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.entity.admin.AdminActions;
import wifi4eu.wifi4eu.entity.user.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdminActionsMapper {
    AdminActions toEntity(AdminActionsDTO dto);
    AdminActionsDTO toDTO(AdminActions entity);
    List<AdminActions> toEntityList(List<AdminActionsDTO> dtoList);
    List<AdminActionsDTO> toDtoList(List<AdminActions> entityList);
    UserDTO toDTO(User entity);
    User toEntity(UserDTO vo);
}
