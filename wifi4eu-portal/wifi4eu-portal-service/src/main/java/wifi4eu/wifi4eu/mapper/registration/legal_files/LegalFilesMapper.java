package wifi4eu.wifi4eu.mapper.registration.legal_files;

import org.mapstruct.*;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.entity.registration.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LegalFilesMapper {

	@Mappings({
			@Mapping(source = "entity.registration.id", target = "registration")
	})
	LegalFileDTO toDTO(LegalFile entity);

	@Mappings({
			@Mapping(source = "vo.registration", target = "entity.registration.id")
	})
	LegalFile toEntity(LegalFileDTO vo);

	List<LegalFileDTO> toDTOList(List<LegalFile> list);

	List<LegalFile> toEntityList(List<LegalFileDTO> list);

}
