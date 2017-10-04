package wifi4eu.wifi4eu.mapper.municipality;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.MunicipalityDTO;
import wifi4eu.wifi4eu.entity.municipality.Municipality;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MunicipalityMapper {
    MunicipalityDTO toDTO(Municipality entity);
    Municipality toEntity(MunicipalityDTO vo);
    List<MunicipalityDTO> toDTOList(List<Municipality> list);
    List<Municipality> toEntityList(List<MunicipalityDTO> list);
}