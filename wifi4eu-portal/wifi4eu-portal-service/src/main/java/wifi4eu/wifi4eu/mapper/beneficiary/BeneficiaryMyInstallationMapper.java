package wifi4eu.wifi4eu.mapper.beneficiary;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.BeneficiaryListItemDTO;
import wifi4eu.wifi4eu.common.dto.model.BeneficiaryMyInstallationDTO;
import wifi4eu.wifi4eu.entity.beneficiary.BeneficiaryListItem;
import wifi4eu.wifi4eu.entity.beneficiary.BeneficiaryMyInstallation;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BeneficiaryMyInstallationMapper {
    BeneficiaryMyInstallationDTO toDTO(BeneficiaryMyInstallation entity);
    BeneficiaryMyInstallation toEntity(BeneficiaryMyInstallationDTO vo);
    List<BeneficiaryMyInstallationDTO> toDTOList(List<BeneficiaryMyInstallation> list);
    List<BeneficiaryMyInstallation> toEntityList(List<BeneficiaryMyInstallationDTO> list);
}
