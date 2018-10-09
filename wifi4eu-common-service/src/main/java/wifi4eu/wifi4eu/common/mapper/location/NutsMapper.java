package wifi4eu.wifi4eu.common.mapper.location;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.NutsDTO;
import wifi4eu.wifi4eu.entity.location.Nuts;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NutsMapper {
    NutsDTO toDTO(Nuts entity);
    Nuts toEntity(NutsDTO vo);
    List<NutsDTO> toDTOList(List<Nuts> list);
    List<Nuts> toEntityList(List<NutsDTO> list);
}