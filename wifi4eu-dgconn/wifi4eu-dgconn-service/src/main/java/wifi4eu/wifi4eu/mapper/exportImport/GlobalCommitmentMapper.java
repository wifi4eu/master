package wifi4eu.wifi4eu.mapper.exportImport;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.GlobalCommitmentDTO;
import wifi4eu.wifi4eu.entity.exportImport.GlobalCommitment;

import java.util.List;


@Mapper(componentModel = "spring")
public interface GlobalCommitmentMapper {

      GlobalCommitmentDTO toDTO(GlobalCommitment entity);
      GlobalCommitment toEntity(GlobalCommitmentDTO vo);
      List<GlobalCommitmentDTO> toDTOList(List<GlobalCommitment> list);
      List<GlobalCommitment> toEntityList(List<GlobalCommitmentDTO> list);

}
