package wifi4eu.wifi4eu.mapper.exportImport;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.ExportImportBudgetaryCommitmentDTO;
import wifi4eu.wifi4eu.entity.exportImport.ExportImportBudgetaryCommitment;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ExportImportBudgetaryCommitmentMapper {

      ExportImportBudgetaryCommitmentDTO toDTO(ExportImportBudgetaryCommitment entity);
      ExportImportBudgetaryCommitment toEntity(ExportImportBudgetaryCommitmentDTO vo);
      List<ExportImportBudgetaryCommitmentDTO> toDTOList(List<ExportImportBudgetaryCommitment> list);
      List<ExportImportBudgetaryCommitment> toEntityList(List<ExportImportBudgetaryCommitmentDTO> list);

}
