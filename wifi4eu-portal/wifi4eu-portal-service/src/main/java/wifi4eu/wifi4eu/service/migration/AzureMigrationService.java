package wifi4eu.wifi4eu.service.migration;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import wifi4eu.wifi4eu.common.utils.AzureBlobConnector;
import wifi4eu.wifi4eu.entity.registration.LegalFile;
import wifi4eu.wifi4eu.entity.registration.Registration;
import wifi4eu.wifi4eu.repository.registration.RegistrationRepository;
import wifi4eu.wifi4eu.repository.registration.legal_files.LegalFilesRepository;

@Service
public class AzureMigrationService implements Runnable {
	
	@Autowired
	private LegalFilesRepository legalFilesRepository;
	
	@Autowired
	private RegistrationRepository registrationRepository;

	private AzureBlobConnector azureBlobConnector = new AzureBlobConnector();
	
    Logger _log = LogManager.getLogger(AzureMigrationService.class);

    @Override
	public void run() {
		this.migrate();
	}

	public void migrate() {
		Iterable<Registration> registrations = registrationRepository.findAll();
		
		for (Registration registration : registrations) {

			Iterable<LegalFile> legalFiles = legalFilesRepository.findByRegistration(registration.getId());
			List<LegalFile> listLegalFiles = new ArrayList<>();
			legalFiles.forEach(listLegalFiles::add);
			
			this.save(registration.getId(), listLegalFiles);
		}
	}

	public void save(Integer registrationId, List<LegalFile> listLegalFiles) {

		long uploadTime = System.currentTimeMillis();

		String containerName = "wifi4eu";
		boolean docUploaded = false;
		
		int i = 0;
		for (LegalFile legalFile : listLegalFiles) {
			_log.info(i++);
			
			
			String fileName = String.valueOf(registrationId) + "_" + legalFile.getFileName() + "_" + String.valueOf(legalFile.getId());
			String content = legalFile.getFileData();
			String uri = null;
			try {
				uri = azureBlobConnector.uploadText(containerName, fileName, content);
				docUploaded = true;
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (docUploaded) {
				legalFile.setId(0);
				legalFile.setFileData(uri);
				legalFile.setUploadTime(uploadTime);
				legalFilesRepository.save(legalFile);
			}
			
			if (i == 10) {
				break;
			}
		}
		_log.info("FININSHED");
	}
}
