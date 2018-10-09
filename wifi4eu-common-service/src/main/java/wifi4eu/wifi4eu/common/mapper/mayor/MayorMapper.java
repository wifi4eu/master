package wifi4eu.wifi4eu.common.mapper.mayor;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import wifi4eu.wifi4eu.common.dto.model.MayorDTO;
import wifi4eu.wifi4eu.entity.mayor.Mayor;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MayorMapper {
    @Mapping(source = "entity.municipality.id", target = "municipalityId")
    MayorDTO toDTO(Mayor entity);
    @Mapping(source = "vo.municipalityId", target = "municipality.id")
    Mayor toEntity(MayorDTO vo);
    List<MayorDTO> toDTOList(List<Mayor> list);
    List<Mayor> toEntityList(List<MayorDTO> list);
}