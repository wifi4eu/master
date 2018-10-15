package wifi4eu.wifi4eu.mapper.grantAgreement;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import wifi4eu.wifi4eu.common.dto.model.GrantAgreementDTO;
import wifi4eu.wifi4eu.entity.grantAgreement.GrantAgreement;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GrantAgreementMapper {

    @Mappings({
            @Mapping(source = "entity.application.id", target = "applicationId")
    })
    GrantAgreementDTO toDTO(GrantAgreement entity);

    @Mappings({
            @Mapping(source = "vo.applicationId", target = "application.id")
    })
    GrantAgreement toEntity(GrantAgreementDTO vo);

    List<GrantAgreementDTO> toDTOList(List<GrantAgreement> list);

    List<GrantAgreement> toEntityList(List<GrantAgreementDTO> list);
}