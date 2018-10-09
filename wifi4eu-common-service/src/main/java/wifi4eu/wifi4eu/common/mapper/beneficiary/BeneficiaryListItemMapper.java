package wifi4eu.wifi4eu.common.mapper.beneficiary;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.BeneficiaryListItemDTO;
import wifi4eu.wifi4eu.entity.beneficiary.BeneficiaryListItem;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BeneficiaryListItemMapper {
    BeneficiaryListItemDTO toDTO(BeneficiaryListItem entity);
    BeneficiaryListItem toEntity(BeneficiaryListItemDTO vo);
    List<BeneficiaryListItemDTO> toDTOList(List<BeneficiaryListItem> list);
    List<BeneficiaryListItem> toEntityList(List<BeneficiaryListItemDTO> list);
}