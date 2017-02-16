package wifi4eu.wifi4eu.mapper.security;

import wifi4eu.wifi4eu.common.dto.security.UserDTO;
import wifi4eu.wifi4eu.common.dto.security.RoleDTO;
import wifi4eu.wifi4eu.entity.security.User;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring",uses=RoleMapper.class)
public interface UserMapper {
    UserDTO toDTO(User entity);

    User toEntity(UserDTO vo);

    List<UserDTO> toDTOList(List<User> list);

    List<User> toEntityList(List<UserDTO> list);
}