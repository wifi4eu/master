package wifi4eu.wifi4eu.mapper.municipality;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.MunicipalitiesAbacDTO;
import wifi4eu.wifi4eu.entity.municipality.MunicipalitiesAbac;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MunicipalitiesAbacMapper {

    MunicipalitiesAbac toEntity(MunicipalitiesAbacDTO municipalitiesAbacDTO);
    MunicipalitiesAbacDTO toDTO(MunicipalitiesAbac municipalitiesAbac);
    List<MunicipalitiesAbacDTO> toDTOList(List<MunicipalitiesAbac> municipalitiesAbacList);
    List<MunicipalitiesAbac> toEntityList(List<MunicipalitiesAbacDTO> municipalitiesAbacDTOList);

}
