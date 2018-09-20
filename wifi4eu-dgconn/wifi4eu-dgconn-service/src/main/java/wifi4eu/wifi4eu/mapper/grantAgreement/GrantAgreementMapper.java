package wifi4eu.wifi4eu.mapper.grantAgreement;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.GrantAgreementDTO;
import wifi4eu.wifi4eu.entity.grantAgreement.GrantAgreement;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GrantAgreementMapper {
    GrantAgreementDTO toDTO(GrantAgreement entity);

    GrantAgreement toEntity(GrantAgreementDTO vo);

    List<GrantAgreementDTO> toDTOList(List<GrantAgreement> list);

    List<GrantAgreement> toEntityList(List<GrantAgreementDTO> list);
}