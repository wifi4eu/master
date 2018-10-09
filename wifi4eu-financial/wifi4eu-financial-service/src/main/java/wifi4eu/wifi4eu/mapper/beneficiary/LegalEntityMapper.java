package wifi4eu.wifi4eu.common.mapper.beneficiary;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.LegalEntityDTO;
import wifi4eu.wifi4eu.entity.beneficiary.LegalEntity;

import java.util.List;

/**
 * Created by rgarcita on 09/02/2017.
 */
@Mapper(componentModel = "spring")
public interface LegalEntityMapper {

    LegalEntityDTO toDTO(LegalEntity entity);

    LegalEntity toEntity(LegalEntityDTO vo);

    List<LegalEntityDTO> toDTOList(List<LegalEntity> list);

    List<LegalEntity> toEntityList(List<LegalEntityDTO> list);

}
