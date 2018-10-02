package wifi4eu.wifi4eu.abac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.abac.data.entity.ImportLog;
import wifi4eu.wifi4eu.abac.data.repository.ImportLogRepository;

@Service
public class ImportLogService {

	@Autowired
	private ImportLogRepository importLogRepository;

	@Autowired
	private ECASUserService ecasUserService;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public ImportLog logImport(String filename, String batchRef, String errors){

		String userId = ecasUserService.getCurrentUsername();

		ImportLog importLog = new ImportLog();
		importLog.setFileName(filename);
		importLog.setBatchRef(batchRef);
		importLog.setUserId(userId);
		importLog.setErrors(errors);
		return importLogRepository.save(importLog);
	}

}
