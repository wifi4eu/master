package wifi4eu.wifi4eu.common.mapper.security;

import wifi4eu.wifi4eu.common.dto.security.RightDTO;
import wifi4eu.wifi4eu.entity.security.Right;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses=RoleMapper.class)
public interface RightMapper {
    @Mappings(
            @Mapping(target = "roles", ignore = true)
    )
    RightDTO toDTO(Right entity);

    Right toEntity(RightDTO vo);

    List<RightDTO> toDTOList(List<Right> list);

    List<Right> toEntityList(List<RightDTO> list);
}

