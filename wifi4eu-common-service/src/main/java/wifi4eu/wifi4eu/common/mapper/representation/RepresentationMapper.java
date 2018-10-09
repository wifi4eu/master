package wifi4eu.wifi4eu.common.mapper.representation;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import wifi4eu.wifi4eu.common.dto.model.RepresentationDTO;
import wifi4eu.wifi4eu.entity.representation.Representation;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RepresentationMapper {
    @Mappings({
            @Mapping(source = "entity.municipality.id", target = "municipalityId"),
            @Mapping(source = "entity.mayor.id", target = "mayorId")
    })
    RepresentationDTO toDTO(Representation entity);
    @Mappings({
            @Mapping(source = "vo.municipalityId", target = "municipality.id"),
            @Mapping(source = "vo.mayorId", target = "mayor.id")
    })
    Representation toEntity(RepresentationDTO vo);
    List<RepresentationDTO> toDTOList(List<Representation> list);
    List<Representation> toEntityList(List<RepresentationDTO> list);
}