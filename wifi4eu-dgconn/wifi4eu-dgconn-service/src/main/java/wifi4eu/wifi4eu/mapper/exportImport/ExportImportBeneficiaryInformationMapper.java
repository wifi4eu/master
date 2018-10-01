package wifi4eu.wifi4eu.mapper.exportImport;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.ExportImportBeneficiaryInformationDTO;
import wifi4eu.wifi4eu.entity.exportImport.ExportImportBeneficiaryInformation;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ExportImportBeneficiaryInformationMapper {

      ExportImportBeneficiaryInformationDTO toDTO(ExportImportBeneficiaryInformation entity);
      ExportImportBeneficiaryInformation toEntity(ExportImportBeneficiaryInformationDTO vo);
      List<ExportImportBeneficiaryInformationDTO> toDTOList(List<ExportImportBeneficiaryInformation> list);
      List<ExportImportBeneficiaryInformation> toEntityList(List<ExportImportBeneficiaryInformationDTO> list);

}
