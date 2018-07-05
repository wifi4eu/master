package wifi4eu.wifi4eu.mapper.location;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.MunicipalityDTO;
import wifi4eu.wifi4eu.entity.location.Municipality;

import java.util.List;

/**
 * 
 * @author kieuhuu
 *
 */
@Mapper(componentModel = "spring")
public interface MunicipalityMapper {

    MunicipalityDTO toDTO(Municipality entity);

    Municipality toEntity(MunicipalityDTO dto);

    List<MunicipalityDTO> toDTOList(List<Municipality> list);

    List<Municipality> toEntityList(List<MunicipalityDTO> list);
}
