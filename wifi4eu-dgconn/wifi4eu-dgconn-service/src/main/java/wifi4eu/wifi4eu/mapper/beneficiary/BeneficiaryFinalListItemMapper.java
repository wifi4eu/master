package wifi4eu.wifi4eu.mapper.beneficiary;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.BeneficiaryFinalListItemDTO;
import wifi4eu.wifi4eu.common.dto.model.BeneficiaryListItemDTO;
import wifi4eu.wifi4eu.entity.beneficiary.BeneficiaryFinalListItem;
import wifi4eu.wifi4eu.entity.beneficiary.BeneficiaryListItem;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BeneficiaryFinalListItemMapper {
    BeneficiaryFinalListItemDTO toDTO(BeneficiaryFinalListItem entity);
    BeneficiaryFinalListItem toEntity(BeneficiaryFinalListItemDTO vo);
    List<BeneficiaryFinalListItemDTO> toDTOList(List<BeneficiaryFinalListItem> list);
    List<BeneficiaryFinalListItem> toEntityList(List<BeneficiaryFinalListItemDTO> list);
}