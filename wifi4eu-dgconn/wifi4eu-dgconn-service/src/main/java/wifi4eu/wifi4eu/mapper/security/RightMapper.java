package wifi4eu.wifi4eu.mapper.security;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import wifi4eu.wifi4eu.common.dto.security.RightDTO;
import wifi4eu.wifi4eu.entity.security.Right;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RightMapper {
    @Mappings({
            @Mapping(source = "entity.user.id", target = "userId"),
    })
    RightDTO toDTO(Right entity);
    @Mappings({
            @Mapping(source = "vo.userId", target = "user.id"),
    })
    Right toEntity(RightDTO vo);
    List<RightDTO> toDTOList(List<Right> list);
    List<Right> toEntityList(List<RightDTO> list);
}