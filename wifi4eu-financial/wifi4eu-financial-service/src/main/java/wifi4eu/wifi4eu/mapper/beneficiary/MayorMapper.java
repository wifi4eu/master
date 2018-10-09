package wifi4eu.wifi4eu.common.mapper.beneficiary;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.MayorDTO;
import wifi4eu.wifi4eu.entity.beneficiary.Mayor;

import java.util.List;

/**
 * Created by rgarcita on 09/02/2017.
 */
@Mapper(componentModel = "spring")
public interface MayorMapper {

    MayorDTO toDTO(Mayor entity);

    Mayor toEntity(MayorDTO vo);

    List<MayorDTO> toDTOList(List<Mayor> list);

    List<Mayor> toEntityList(List<MayorDTO> list);
}
