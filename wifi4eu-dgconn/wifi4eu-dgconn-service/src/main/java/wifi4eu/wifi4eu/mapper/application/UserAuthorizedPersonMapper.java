package wifi4eu.wifi4eu.mapper.application;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.UserAuthorizedPersonDTO;
import wifi4eu.wifi4eu.entity.user.UserAuthorizedPerson;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserAuthorizedPersonMapper {

    UserAuthorizedPersonDTO toDTO(UserAuthorizedPerson entity);

    UserAuthorizedPerson toEntity(UserAuthorizedPersonDTO vo);

    List<UserAuthorizedPersonDTO> toDTOList(List<UserAuthorizedPerson> list);

    List<UserAuthorizedPerson> toEntityList(List<UserAuthorizedPersonDTO> list);
}
