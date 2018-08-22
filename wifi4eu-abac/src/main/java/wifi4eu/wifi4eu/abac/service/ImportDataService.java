package wifi4eu.wifi4eu.abac.service;


import eu.cec.digit.ecas.client.jaas.DetailedUser;
import eu.cec.digit.ecas.client.jaas.SubjectNotFoundException;
import eu.cec.digit.ecas.client.jaas.SubjectUtil;

import eu.europa.ec.research.fp.services.document_management.interfaces.v5.FileDocumentType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import wifi4eu.wifi4eu.abac.data.dto.BudgetaryCommitmentCSVRow;
import wifi4eu.wifi4eu.abac.data.dto.FileDTO;
import wifi4eu.wifi4eu.abac.data.dto.LegalEntityDocumentCSVRow;
import wifi4eu.wifi4eu.abac.data.dto.LegalEntityInformationCSVRow;
import wifi4eu.wifi4eu.abac.data.entity.BudgetaryCommitment;
import wifi4eu.wifi4eu.abac.data.entity.BudgetaryCommitmentPosition;
import wifi4eu.wifi4eu.abac.data.entity.Document;
import wifi4eu.wifi4eu.abac.data.entity.ImportLog;
import wifi4eu.wifi4eu.abac.data.entity.LegalEntity;
import wifi4eu.wifi4eu.abac.data.enums.AbacWorkflowStatus;

import wifi4eu.wifi4eu.abac.data.repository.ImportLogRepository;

import wifi4eu.wifi4eu.abac.data.enums.DocumentType;
import wifi4eu.wifi4eu.abac.data.enums.DocumentWorkflowStatus;

import wifi4eu.wifi4eu.abac.utils.ZipFileReader;
import wifi4eu.wifi4eu.abac.utils.ZipFileWriter;
import wifi4eu.wifi4eu.abac.utils.csvparser.BudgetaryCommitmentCSVFileParser;
import wifi4eu.wifi4eu.abac.utils.csvparser.DocumentCSVFileParser;
import wifi4eu.wifi4eu.abac.utils.csvparser.LegalEntityCSVFileParser;

import javax.transaction.Transactional;

import java.io.IOException;
import java.util.Date;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

@Service
@SuppressWarnings("unchecked")
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

	@Autowired BudgetaryCommitmentService budgetaryCommitmentService;

	@Autowired
	private ImportLogRepository importLogRepository;

	@Autowired NotificationService notificationService;

	@Autowired
	LegalCommitmentService legalCommitmentService;


	static final String LEGAL_ENTITY_INFORMATION_CSV_FILENAME = "portal_exportBeneficiaryInformation.csv";
	static final String LEGAL_ENTITY_DOCUMENTS_CSV_FILENAME = "portal_exportBeneficiaryDocuments.csv";

	private final Logger log = LoggerFactory.getLogger(ImportDataService.class);

	FileDTO documentsCSVFile;
	private Map<String, FileDTO> documentsToBeImported = new TreeMap<>();

	@Transactional(Transactional.TxType.REQUIRED)
	public void importLegalEntities(byte[] file) {
		importDataViaZipFile(file);
	}

	/**
	 * Legal Commitments will be treated as a regular upload of documents where the docType is GRANT_AGREEMENT
	 * @param file
	 */
	@Transactional(Transactional.TxType.REQUIRED)
	public void importLegalCommitments(byte[] file) {
		importDataViaZipFile(file);
		legalCommitmentService.createLegalCommitments();
	}


	private void importDataViaZipFile(byte[] file) {

		ZipFileReader zipFileReader = new ZipFileReader(file);

		FileDTO fileDTO = zipFileReader.nextFile();

		while(fileDTO != null) {

			log.info(String.format("Processing file %s", fileDTO.getFileName()));

			switch (fileDTO.getFileName()) {
				case LEGAL_ENTITY_INFORMATION_CSV_FILENAME:
					fileDTO.setFileType(FileDTO.FileType.LEGAL_ENTITY_INFORMATION_CSV);
					processLegalEntityInformationFile(fileDTO);
					break;
				case LEGAL_ENTITY_DOCUMENTS_CSV_FILENAME:
					fileDTO.setFileType(FileDTO.FileType.LEGAL_ENTITY_DOCUMENTS_CSV);
					addDocumentsCSVIndexFile(fileDTO);
					break;
				default:
					addDocumentToBeImported(fileDTO);
					break;
			}
			fileDTO = zipFileReader.nextFile();
		}

		if(documentsCSVFile != null) {
			importDocuments(documentsCSVFile);
		}
	}

	private void processLegalEntityInformationFile(FileDTO fileDTO) {
		List<LegalEntityInformationCSVRow> legalEntities = (List<LegalEntityInformationCSVRow>) legalEntityCSVFileParser.parseFile(fileDTO);

		//generate a unique batch file ID
		String batchRef = UUID.randomUUID().toString();

		//get user authenticated
		DetailedUser currentEcasUser = null;
		try {
			currentEcasUser = SubjectUtil.getCurrentEcasUser();
		} catch (SubjectNotFoundException e) {
			log.error("ERROR while trying to retrieve the current user", e);
		}

		for (LegalEntityInformationCSVRow legalEntityInformationCSVRow : legalEntities) {

			LegalEntity legalEntity = legalEntityService.getLegalEntityByMunicipalityPortalId(legalEntityInformationCSVRow.getMid());

			if (legalEntity == null) {
				//map the csv row to the LegalEntity object
				legalEntity = legalEntityService.mapLegalEntityCSVToEntity(legalEntityInformationCSVRow);

				//set the current user
                legalEntity.setUserImported(currentEcasUser.getUid());

                //set the current batch ID
				legalEntity.setBatchRef(batchRef);

				//if the LEF is already created in ABAC ignore the creation phase
				if(!StringUtils.isEmpty(legalEntity.getAbacFelId())){
					legalEntity.setWfStatus(AbacWorkflowStatus.ABAC_VALID);
				}else{
					legalEntity.setWfStatus(AbacWorkflowStatus.IMPORTED);
				}
				//persist the LegalEntity in the database
				legalEntityService.saveLegalEntity(legalEntity);
			} else {
				//TODO update or ignore?
				log.warn("Legal entity already exists in the DB. Ignoring it for now : {}", legalEntity);
			}
		}

		//log the imported file
		logImport(fileDTO, batchRef, currentEcasUser.getUid());

		//create user notification
		notificationService.createLegalEntityProcessPendingNotification(batchRef);
	}

	private void logImport(FileDTO fileDTO, String batchRef, String userId){
		ImportLog importLog = new ImportLog();
		importLog.setFileName(fileDTO.getFileName());
		importLog.setBatchRef(batchRef);
		importLog.setUserId(userId);

		importLogRepository.save(importLog);
	}

	private void addDocumentsCSVIndexFile(final FileDTO fileDTO) {
		documentsCSVFile = fileDTO;
	}

	private void addDocumentToBeImported(final FileDTO fileDTO) {
		documentsToBeImported.put(fileDTO.getFileName(), fileDTO);
	}

	private void importDocuments(FileDTO fileDTO) {
		List<LegalEntityDocumentCSVRow> documents = (List<LegalEntityDocumentCSVRow>) documentCSVFileParser.parseFile(fileDTO);
		for (LegalEntityDocumentCSVRow documentCSVRow : documents) {

			Document document = documentService.getDocumentByPortalId(documentCSVRow.getDocumentPortalId());

			if (document == null) {
				document = documentService.mapDocumentCSVToEntity(documentCSVRow);
				document.setData(documentsToBeImported.get(documentCSVRow.getDocumentFileName()).getContent());
				documentService.saveDocument(document);
			} else {
				//TODO update or ignore?
				log.info(String.format("Document with Portal ID/Name %s/%s already exists in the DB. Ignoring it for now", document.getPortalId(), document.getName()));
			}
		}
	}

	@Transactional
	public void importBudgetaryCommitments(byte[] file) {

		FileDTO fileDTO = new FileDTO();
		fileDTO.setContent(file);
		fileDTO.setSize(new Long(file.length));

		List<BudgetaryCommitmentCSVRow> budgetaryCommitmentCSVRows = (List<BudgetaryCommitmentCSVRow>) budgetaryCommitmentCSVFileParser.parseFile(fileDTO);

		for (BudgetaryCommitmentCSVRow budgetaryCommitmentCSVRow : budgetaryCommitmentCSVRows) {

			BudgetaryCommitmentPosition budgetaryCommitmentPosition = budgetaryCommitmentService.getBCPosition(budgetaryCommitmentCSVRow.getMunicipalityPortalId(), budgetaryCommitmentCSVRow.getAbacCommitmentLevel2Position());

			if(budgetaryCommitmentPosition == null) {
				log.info(String.format("importing BC %s for mid %s", budgetaryCommitmentCSVRow.getAbacGlobalCommitmentLevel1PositionKey(), budgetaryCommitmentCSVRow.getMunicipalityPortalId()));

				budgetaryCommitmentPosition = budgetaryCommitmentService.mapBudgetaryCommitmentCSVToEntity(budgetaryCommitmentCSVRow);

				BudgetaryCommitment budgetaryCommitment = budgetaryCommitmentService.getByMunicipalityPortalId(budgetaryCommitmentCSVRow.getMunicipalityPortalId());
				if (budgetaryCommitment != null) {
					budgetaryCommitmentPosition.setBudgetaryCommitment(budgetaryCommitment);
				}

				budgetaryCommitmentService.saveBCPosition(budgetaryCommitmentPosition);
			} else {
				//TODO update or ignore?
				log.info(String.format("Legal entity mid %s already has a Budgetary commitment position %s. Ignoring it for now",
										budgetaryCommitmentCSVRow.getMunicipalityPortalId(),
										budgetaryCommitmentCSVRow.getAbacCommitmentLevel2Position()));
			}
		}
	}

	public FileDTO exportLegalCommitments() throws IOException {
		ZipFileWriter zipFileWriter = new ZipFileWriter("export.zip");

		List<Document> documents = documentService.getDocumentsByTypeAndStatus(DocumentType.COUNTERSIGNED_GRANT_AGREEMENT, DocumentWorkflowStatus.IMPORTED);

		for (Document document : documents) {
			FileDTO fileDTO = new FileDTO(document.getFileName(), new Long(document.getData().length), document.getData());
			zipFileWriter.addFile(fileDTO);
		}

		return zipFileWriter.finishAndReturnZipfile();
	}
}