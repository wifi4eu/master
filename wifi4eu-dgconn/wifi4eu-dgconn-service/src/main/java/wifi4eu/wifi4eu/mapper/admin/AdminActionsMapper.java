package wifi4eu.wifi4eu.mapper.admin;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.AdminActionsDTO;
import wifi4eu.wifi4eu.entity.admin.AdminActions;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdminActionsMapper {
    AdminActions toEntity(AdminActionsDTO dto);
    AdminActionsDTO toDTO(AdminActions entity);
    List<AdminActions> toEntityList(List<AdminActionsDTO> dtoList);
    List<AdminActionsDTO> toDtoList(List<AdminActions> entityList);
}
