package wifi4eu.wifi4eu.common.mapper.beneficiary;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.RepresentativeDTO;
import wifi4eu.wifi4eu.entity.beneficiary.Representative;


import java.util.List;

/**
 * Created by rgarcita on 09/02/2017.
 */
@Mapper(componentModel = "spring")
public interface RepresentativeMapper {

    RepresentativeDTO toDTO(Representative entity);

    Representative toEntity(RepresentativeDTO vo);

    List<RepresentativeDTO> toDTOList(List<Representative> list);

    List<Representative> toEntityList(List<RepresentativeDTO> list);
}
