package wifi4eu.wifi4eu.service.registration.legal_files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.LegalFileDTO;
import wifi4eu.wifi4eu.common.enums.LegalFileStatus;
import wifi4eu.wifi4eu.entity.registration.LegalFile;
import wifi4eu.wifi4eu.repository.registration.legal_files.LegalFilesRepository;

@Service("legalFilesService")
public class LegalFilesService {

	@Autowired
	private LegalFilesRepository legalFilesRepository;

	public void setNotNewFile(LegalFileDTO legalFileDTO) {
		LegalFile legalFile = legalFilesRepository.findOne(legalFileDTO.getId());
		if (legalFile.getIsNew() == LegalFileStatus.NEW.getValue()) {
			legalFile.setIsNew(LegalFileStatus.RECENT.getValue());
		}
		legalFilesRepository.save(legalFile);
	}
}