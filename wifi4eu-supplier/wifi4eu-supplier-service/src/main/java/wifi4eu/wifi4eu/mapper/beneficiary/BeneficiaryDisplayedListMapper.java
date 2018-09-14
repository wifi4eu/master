package wifi4eu.wifi4eu.mapper.beneficiary;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import wifi4eu.wifi4eu.common.dto.model.BeneficiaryDisplayedListDTO;
import wifi4eu.wifi4eu.entity.beneficiary.BeneficiaryDisplayedList;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BeneficiaryDisplayedListMapper {

    @Mappings({
            @Mapping(source = "name", target= "name"),
            @Mapping(source = "id", target="id")
    })
    BeneficiaryDisplayedListDTO toDTO(BeneficiaryDisplayedList entity);
    @Mappings({
            @Mapping(source = "vo.name", target= "name"),
            @Mapping(source = "vo.id", target="id")
    })
    BeneficiaryDisplayedList toEntity(BeneficiaryDisplayedListDTO vo);
    List<BeneficiaryDisplayedListDTO> toDTOList(List<BeneficiaryDisplayedList> list);
    List<BeneficiaryDisplayedList> toEntityList(List<BeneficiaryDisplayedListDTO> list);
}
