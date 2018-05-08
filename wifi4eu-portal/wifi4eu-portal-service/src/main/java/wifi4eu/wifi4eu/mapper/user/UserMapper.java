package wifi4eu.wifi4eu.mapper.user;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.security.RoleDTO;
import wifi4eu.wifi4eu.entity.user.Role;
import wifi4eu.wifi4eu.entity.user.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "entity.idRole.id", target = "idRole")
    UserDTO toDTO(User entity);

    @Mapping(source = "vo.idRole", target = "idRole.id")
    User toEntity(UserDTO vo);

    List<UserDTO> toDTOList(List<User> list);

    List<User> toEntityList(List<UserDTO> list);

    RoleDTO toDTO(Role entity);

    Role toEntity(RoleDTO vo);
}
