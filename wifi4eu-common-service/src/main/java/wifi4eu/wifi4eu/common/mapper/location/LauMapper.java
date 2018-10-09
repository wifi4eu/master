package wifi4eu.wifi4eu.common.mapper.location;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.LauDTO;
import wifi4eu.wifi4eu.entity.location.Lau;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LauMapper {
    LauDTO toDTO(Lau entity);
    Lau toEntity(LauDTO vo);
    List<LauDTO> toDTOList(List<Lau> list);
    List<Lau> toEntityList(List<LauDTO> list);
}