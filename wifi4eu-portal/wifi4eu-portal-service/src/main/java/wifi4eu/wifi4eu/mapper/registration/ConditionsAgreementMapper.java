package wifi4eu.wifi4eu.mapper.registration;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.ConditionsAgreementDTO;
import wifi4eu.wifi4eu.entity.registration.ConditionsAgreement;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ConditionsAgreementMapper {

    ConditionsAgreementDTO toDTO(ConditionsAgreement entity);
    ConditionsAgreement toEntity(ConditionsAgreementDTO vo);

    List<ConditionsAgreementDTO> toDTOList(List<ConditionsAgreement> list);
    List<ConditionsAgreement> toEntityList(List<ConditionsAgreementDTO> list);
}
