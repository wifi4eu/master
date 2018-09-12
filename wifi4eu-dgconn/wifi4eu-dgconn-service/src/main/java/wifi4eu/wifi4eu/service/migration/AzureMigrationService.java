package wifi4eu.wifi4eu.service.migration;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import wifi4eu.wifi4eu.common.service.azureblobstorage.AzureBlobConnector;
import wifi4eu.wifi4eu.entity.registration.LegalFile;
import wifi4eu.wifi4eu.entity.registration.Registration;
import wifi4eu.wifi4eu.repository.registration.RegistrationRepository;
import wifi4eu.wifi4eu.repository.registration.legal_files.LegalFilesRepository;

@Component
@Scope("prototype")
public class AzureMigrationService implements Runnable {
	
	@Autowired
	private LegalFilesRepository legalFilesRepository;
	
	@Autowired
	private RegistrationRepository registrationRepository;

	@Autowired
	private AzureBlobConnector azureBlobConnector;
	
    private static Logger LOGGER = LogManager.getLogger(AzureMigrationService.class);

	@Override
	@Transactional
	public void run() {
		this.migrate();
	}

	public void migrate() {
		long startTime = System.currentTimeMillis();
		
		LOGGER.info("Statring migration process");

		LOGGER.info("Querying registrations");
		List<Registration> registrations = Lists.newArrayList(registrationRepository.findAll());
		int qtyRegistrations = registrations.size();
		
		LOGGER.info("Registrations [{}]", qtyRegistrations);
		
		int i = 0;
		for (Registration registration : registrations) {
			i++;
			LOGGER.info("Registrations Id[{}], [{}]/[{}]", registration.getId(), i, qtyRegistrations);
			List<LegalFile> legalFiles = Lists.newArrayList(legalFilesRepository.findByRegistration(registration.getId()));
			
			LOGGER.info("   legalFiles [{}]", legalFiles.size());
			
			this.save(registration.getId(), legalFiles);
		}
		
		LOGGER.info("Statring migration process. It tool [{}]", System.currentTimeMillis() - startTime);
		
	}

	public void save(Integer registrationId, List<LegalFile> listLegalFiles) {

		String containerName = "wifi4eu";
		
		for (LegalFile legalFile : listLegalFiles) {
			
			String fileName = String.valueOf(registrationId) + "_" + legalFile.getFileName() + "_" + String.valueOf(legalFile.getId());
			String content = legalFile.getFileData();
			String uri = null;
			try {
				uri = azureBlobConnector.uploadText(containerName, fileName, content);
			} catch (Exception e) {
				LOGGER.error("Error uploading file", e);
			}

			if (uri != null) {
				//legalFile.setId(0);
				legalFile.setFileData(uri);
				legalFilesRepository.save(legalFile);
			}
		}
	}
}