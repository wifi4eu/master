package wifi4eu.wifi4eu.common.mapper.application;

import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.model.CorrectionRequestEmailDTO;
import wifi4eu.wifi4eu.entity.application.CorrectionRequestEmail;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CorrectionRequestEmailMapper {
    CorrectionRequestEmailDTO toDTO(CorrectionRequestEmail entity);
    CorrectionRequestEmail toEntity(CorrectionRequestEmailDTO vo);
    List<CorrectionRequestEmailDTO> toDTOList(List<CorrectionRequestEmail> list);
    List<CorrectionRequestEmail> toEntityList(List<CorrectionRequestEmailDTO> list);
}