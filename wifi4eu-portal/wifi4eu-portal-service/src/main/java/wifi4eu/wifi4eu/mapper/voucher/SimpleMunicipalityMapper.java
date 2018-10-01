package wifi4eu.wifi4eu.mapper.voucher;


import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.SimpleMunicipalityDTO;
import wifi4eu.wifi4eu.entity.voucher.SimpleMunicipality;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SimpleMunicipalityMapper {



    SimpleMunicipalityDTO toDTO(SimpleMunicipality entity);

    SimpleMunicipality toEntity(SimpleMunicipalityDTO vo);

    List<SimpleMunicipalityDTO> toDTOList(List<SimpleMunicipality> list);
    List<SimpleMunicipality> toEntityList(List<SimpleMunicipalityDTO> list);
}
