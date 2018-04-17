package wifi4eu.wifi4eu.mapper.security;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.security.UserDTO;
//import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.entity.security.User;
//import wifi4eu.wifi4eu.entity.user.User;
import java.util.List;

@Mapper(componentModel = "spring", uses = RoleMapper.class)
public interface UserMapper {
    UserDTO toDTO(User entity);

    User toEntity(UserDTO vo);

    List<UserDTO> toDTOList(List<User> list);

    List<User> toEntityList(List<UserDTO> list);
}