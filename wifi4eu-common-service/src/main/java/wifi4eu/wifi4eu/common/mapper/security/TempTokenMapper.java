package wifi4eu.wifi4eu.common.mapper.security;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import wifi4eu.wifi4eu.common.dto.security.TempTokenDTO;
import wifi4eu.wifi4eu.entity.security.TempToken;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TempTokenMapper {
    @Mapping(source = "entity.user.id", target = "userId")
    TempTokenDTO toDTO(TempToken entity);
    @Mapping(source = "vo.userId", target = "user.id")
    TempToken toEntity(TempTokenDTO vo);
    List<TempTokenDTO> toDTOList(List<TempToken> list);
    List<TempToken> toEntityList(List<TempTokenDTO> list);
}