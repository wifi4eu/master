package wifi4eu.wifi4eu.mapper.registration;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import wifi4eu.wifi4eu.common.dto.model.LegalFileDTO;
import wifi4eu.wifi4eu.entity.registration.LegalFile;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LegalFileMapper {
    @Mapping(source = "entity.registration.id", target = "registrationId")
    LegalFileDTO toDTO(LegalFile entity);
    @Mapping(source = "vo.registrationId", target = "registration.id")
    LegalFile toEntity(LegalFileDTO vo);
    List<LegalFileDTO> toDTOList(List<LegalFile> list);
    List<LegalFile> toEntityList(List<LegalFileDTO> list);
}