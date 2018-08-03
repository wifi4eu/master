package wifi4eu.wifi4eu.abac.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.abac.data.dto.FileDTO;
import wifi4eu.wifi4eu.abac.data.entity.LegalEntity;
import wifi4eu.wifi4eu.abac.utils.ZipFileReader;
import wifi4eu.wifi4eu.abac.utils.CSVFileParser;

import java.util.List;

@Service
public class ImportDataService {

	@Autowired
	private CSVFileParser CSVFileParser;

	@Autowired
	private LegalEntityService legalEntityService;

	static final String LEGAL_ENTITY_INFORMATION_CSV_FILENAME = "portal_exportBeneficiaryInformation.csv";
	static final String LEGAL_ENTITY_DOCUMENTS_CSV_FILENAME = "portal_exportBeneficiaryDocuments.csv";

	private final Logger log = LoggerFactory.getLogger(ImportDataService.class);

	public void importLegalEntities(byte[] file) {

		ZipFileReader zipFileReader = new ZipFileReader(file);

		FileDTO fileDTO = zipFileReader.nextFile();

		while(fileDTO != null) {

			log.info(String.format("Processing file %s", fileDTO.getFileName()));

			switch (fileDTO.getFileName()) {
				case LEGAL_ENTITY_INFORMATION_CSV_FILENAME:
					processLegalEntityInformationFile(fileDTO);
					break;
				case LEGAL_ENTITY_DOCUMENTS_CSV_FILENAME:
					processLegalEntityDocumentsFile(fileDTO);
					break;
				default:
					processAnnex(fileDTO);
					break;
			}
			fileDTO = zipFileReader.nextFile();
		}
	}

	private void processLegalEntityInformationFile(FileDTO fileDTO) {
		List<LegalEntity> legalEntities = CSVFileParser.parseLegalEntityInformationFile(fileDTO);

		for (LegalEntity legalEntity : legalEntities) {

			LegalEntity legalEntityFromDB = legalEntityService.getLegalEntityByMunicipalityPortalId(legalEntity.getMid());

			if (legalEntityFromDB == null) {
				legalEntityService.saveLegalEntity(legalEntity);
			} else {
				//TODO update or ignore?
				log.info(String.format("Legal entity with MID %s already exists in the DB. Ignoring it for now", legalEntity.getMid()));
			}
		}
	}

	private void processAnnex(FileDTO fileDTO) {
		//TODO implement it
	}

	private void processLegalEntityDocumentsFile(FileDTO fileDTO) {
		CSVFileParser.parseLegalEntityDocumentsFile(fileDTO);
	}

}