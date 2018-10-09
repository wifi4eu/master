package wifi4eu.wifi4eu.common.mapper.security;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.security.TempTokenDTO;
import wifi4eu.wifi4eu.entity.security.TempToken;

import java.util.List;

/**
 * Created by rgarcita on 21/02/2017.
 */
@Mapper(componentModel = "spring")
public interface TempTokenMapper {
    TempTokenDTO toDTO(TempToken entity);

    TempToken toEntity(TempTokenDTO dto);

    List<TempTokenDTO> toDTOList(List<TempToken> list);

    List<TempToken> toEntityList(List<TempTokenDTO> list);
}
