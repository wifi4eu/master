package wifi4eu.wifi4eu.common.mapper.security;

import wifi4eu.wifi4eu.common.dto.security.RoleDTO;
import wifi4eu.wifi4eu.entity.security.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses=RightMapper.class)
public interface RoleMapper {

    RoleDTO toDTO(Role entity);

    Role toEntity(RoleDTO vo);

    List<RoleDTO> toDTOList(List<Role> list);

    List<Role> toEntityList(List<RoleDTO> list);
}
