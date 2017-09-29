package wifi4eu.wifi4eu.mapper;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.RepresentationDTO;
import wifi4eu.wifi4eu.entity.Representation;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RepresentationMapper {
    RepresentationDTO toDTO(Representation entity);
    Representation toEntity(RepresentationDTO vo);
    List<RepresentationDTO> toDTOList(List<Representation> list);
    List<Representation> toEntityList(List<RepresentationDTO> list);
}