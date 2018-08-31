package wifi4eu.wifi4eu.mapper.registration;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import wifi4eu.wifi4eu.common.dto.model.LegalFileCorrectionReasonDTO;
import wifi4eu.wifi4eu.entity.registration.LegalFileCorrectionReason;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LegalFileCorrectionReasonMapper {
    @Mapping(source = "entity.registration.id", target = "registrationId")
LegalFileCorrectionReasonDTO toDTO(LegalFileCorrectionReason entity);
    @Mapping(source = "vo.registrationId", target = "registration.id")
    LegalFileCorrectionReason toEntity(LegalFileCorrectionReasonDTO vo);
    List<LegalFileCorrectionReasonDTO> toDTOList(List<LegalFileCorrectionReason> list);
    List<LegalFileCorrectionReason> toEntityList(List<LegalFileCorrectionReasonDTO> list);
}