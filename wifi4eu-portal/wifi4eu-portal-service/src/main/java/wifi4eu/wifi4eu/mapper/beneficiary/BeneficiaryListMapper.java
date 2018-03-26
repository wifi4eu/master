package wifi4eu.wifi4eu.mapper.beneficiary;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.BeneficiaryListDTO;
import wifi4eu.wifi4eu.entity.beneficiary.BeneficiaryList;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BeneficiaryListMapper {

    BeneficiaryListDTO toDTO(BeneficiaryList entity);

    BeneficiaryList toEntity(BeneficiaryListDTO vo);

    List<BeneficiaryListDTO> toDTOList(List<BeneficiaryList> list);

    List<BeneficiaryList> toEntityList(List<BeneficiaryListDTO> list);

}
