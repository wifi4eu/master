package wifi4eu.wifi4eu.mapper.registration.legal_files;

import org.mapstruct.*;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.entity.registration.*;

@Mapper(componentModel = "spring")
public interface LegalFilesMapper {

	RegistrationFilesDTO toDTO(RegistrationFiles entity);
	RegistrationFiles toEntity(RegistrationFilesDTO vo);
}
