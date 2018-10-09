package wifi4eu.wifi4eu.common.mapper.audit;


import org.mapstruct.Mapper;
import wifi4eu.wifi4eu.common.dto.audit.AuditDataDTO;
import wifi4eu.wifi4eu.entity.audit.AuditData;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuditMapper {

    AuditDataDTO toDTO(AuditData entity);

    AuditData toEntity(AuditDataDTO vo);

    List<AuditDataDTO> toDTOList(List<AuditData> list);

    List<AuditData> toEntityList(List<AuditDataDTO> list);
}
