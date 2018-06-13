package wifi4eu.wifi4eu.service.registration.legal_files;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.mapper.registration.legal_files.*;
import wifi4eu.wifi4eu.repository.registration.legal_files.*;

@Service("legalFilesService")
public class LegalFilesService {

	private final Logger _log = LogManager.getLogger(LegalFilesService.class);

	@Autowired
	LegalFilesRepository legalFilesRepository;

	@Autowired
	LegalFilesMapper legalFilesMapper;

	public LegalFilesDTO getLegalFileByRegistrationIdFileType(Integer registrationId, Integer fileType) {
		return legalFilesMapper.toDTO(legalFilesRepository.findByRegistrationAndFileType(registrationId, fileType));
	}
}
