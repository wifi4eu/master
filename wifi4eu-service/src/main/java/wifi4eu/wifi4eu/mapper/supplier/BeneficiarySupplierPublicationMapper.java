package wifi4eu.wifi4eu.mapper.supplier;

import wifi4eu.wifi4eu.common.dto.model.BeneficiarySupplierPublicationDTO;
import wifi4eu.wifi4eu.entity.supplier.BeneficiarySupplierPublication;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface BeneficiarySupplierPublicationMapper {
    BeneficiarySupplierPublicationDTO toDTO(BeneficiarySupplierPublication entity);

    BeneficiarySupplierPublication toEntity(BeneficiarySupplierPublicationDTO vo);

    List<BeneficiarySupplierPublicationDTO> toDTOList(List<BeneficiarySupplierPublication> list);

    List<BeneficiarySupplierPublication> toEntityList(List<BeneficiarySupplierPublicationDTO> list);
}