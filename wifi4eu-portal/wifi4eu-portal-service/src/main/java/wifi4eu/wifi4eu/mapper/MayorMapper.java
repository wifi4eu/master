package wifi4eu.wifi4eu.mapper;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.MayorDTO;
import wifi4eu.wifi4eu.entity.Mayor;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MayorMapper {
    MayorDTO toDTO(Mayor entity);
    Mayor toEntity(MayorDTO vo);
    List<MayorDTO> toDTOList(List<Mayor> list);
    List<Mayor> toEntityList(List<MayorDTO> list);
}