package wifi4eu.wifi4eu.abac.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.abac.data.dto.BudgetaryCommitmentCSVRow;
import wifi4eu.wifi4eu.abac.data.dto.FileDTO;
import wifi4eu.wifi4eu.abac.data.dto.LegalEntityDocumentCSVRow;
import wifi4eu.wifi4eu.abac.data.dto.LegalEntityInformationCSVRow;
import wifi4eu.wifi4eu.abac.data.entity.Document;
import wifi4eu.wifi4eu.abac.data.entity.LegalEntity;
import wifi4eu.wifi4eu.abac.utils.ZipFileReader;
import wifi4eu.wifi4eu.abac.utils.csvparser.BudgetaryCommitmentCSVFileParser;
import wifi4eu.wifi4eu.abac.utils.csvparser.DocumentCSVFileParser;
import wifi4eu.wifi4eu.abac.utils.csvparser.LegalEntityCSVFileParser;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class ImportDataService {

	@Autowired
	private LegalEntityCSVFileParser legalEntityCSVFileParser;

	@Autowired
	private DocumentCSVFileParser documentCSVFileParser;

	@Autowired
	private BudgetaryCommitmentCSVFileParser budgetaryCommitmentCSVFileParser;

	@Autowired
	private LegalEntityService legalEntityService;

	@Autowired
	private DocumentService documentService;

	static final String LEGAL_ENTITY_INFORMATION_CSV_FILENAME = "portal_exportBeneficiaryInformation.csv";
	static final String LEGAL_ENTITY_DOCUMENTS_CSV_FILENAME = "portal_exportBeneficiaryDocuments.csv";

	private final Logger log = LoggerFactory.getLogger(ImportDataService.class);

	FileDTO documentsCSVFile;
	private Map<String, FileDTO> documentsToBeImported = new TreeMap<>();

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
					keepDocumentsCSVToBeProcessedLater(fileDTO);
					break;
				default:
					keepDocumentToBeProcessedLater(fileDTO);
					break;
			}
			fileDTO = zipFileReader.nextFile();
		}

		importDocuments(documentsCSVFile);
	}

	private void processLegalEntityInformationFile(FileDTO fileDTO) {
		List<LegalEntityInformationCSVRow> legalEntities = (List<LegalEntityInformationCSVRow>) legalEntityCSVFileParser.parseFile(fileDTO);

		for (LegalEntityInformationCSVRow legalEntityInformationCSVRow : legalEntities) {

			LegalEntity legalEntity = legalEntityService.getLegalEntityByMunicipalityPortalId(legalEntityInformationCSVRow.getMid());

			if (legalEntity == null) {
				legalEntity = legalEntityService.mapLegalEntityCSVToEntity(legalEntityInformationCSVRow);
				legalEntityService.saveLegalEntity(legalEntity);
			} else {
				//TODO update or ignore?
				log.info(String.format("Legal entity with MID %s already exists in the DB. Ignoring it for now", legalEntity.getMid()));
			}
		}
	}

	private void keepDocumentsCSVToBeProcessedLater(final FileDTO fileDTO) {
		documentsCSVFile = fileDTO;
	}

	private void keepDocumentToBeProcessedLater(final FileDTO fileDTO) {
		documentsToBeImported.put(fileDTO.getFileName(), fileDTO);
	}

	private void importDocuments(FileDTO fileDTO) {
		List<LegalEntityDocumentCSVRow> documents = (List<LegalEntityDocumentCSVRow>) documentCSVFileParser.parseFile(fileDTO);
		for (LegalEntityDocumentCSVRow documentCSVRow : documents) {

			Document document = documentService.getDocumentByPortalId(documentCSVRow.getDocumentPortalId());

			if (document == null) {
				document = documentService.mapDocumentCSVToEntity(documentCSVRow);
				document.setData(documentsToBeImported.get(documentCSVRow.getDocumentFileName()).getContent());
				document.setSize(fileDTO.getSize());
				documentService.saveDocument(document);
			} else {
				//TODO update or ignore?
				log.info(String.format("Document with Portal ID/Name %s/%s already exists in the DB. Ignoring it for now", document.getPortalId(), document.getName()));
			}
		}
	}

	public void importBudgetaryCommitments(byte[] file) {

		FileDTO fileDTO = new FileDTO();
		fileDTO.setContent(file);
		fileDTO.setSize(new Long(file.length));

		List<BudgetaryCommitmentCSVRow> budgetaryCommitmentCSVRows = (List<BudgetaryCommitmentCSVRow>) budgetaryCommitmentCSVFileParser.parseFile(fileDTO);

		for (BudgetaryCommitmentCSVRow budgetaryCommitmentCSVRow : budgetaryCommitmentCSVRows) {
			log.info(String.format("TODO import BC %s for mid %s", budgetaryCommitmentCSVRow.getAbac_globalCommitmentKey(), budgetaryCommitmentCSVRow.getMunicipalityPortalId()));
		}
	}
}