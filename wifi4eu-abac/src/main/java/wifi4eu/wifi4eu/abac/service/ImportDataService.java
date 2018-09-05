package wifi4eu.wifi4eu.abac.service;


import eu.cec.digit.ecas.client.jaas.DetailedUser;
import eu.cec.digit.ecas.client.jaas.SubjectNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import wifi4eu.wifi4eu.abac.data.dto.BudgetaryCommitmentCSVRow;
import wifi4eu.wifi4eu.abac.data.dto.FileDTO;
import wifi4eu.wifi4eu.abac.data.dto.LegalEntityDocumentCSVRow;
import wifi4eu.wifi4eu.abac.data.dto.LegalEntityInformationCSVRow;
import wifi4eu.wifi4eu.abac.data.entity.*;
import wifi4eu.wifi4eu.abac.data.enums.AbacWorkflowStatus;

import wifi4eu.wifi4eu.abac.data.enums.NotificationType;
import wifi4eu.wifi4eu.abac.data.repository.ImportLogRepository;

import wifi4eu.wifi4eu.abac.utils.ZipFileReader;
import wifi4eu.wifi4eu.abac.utils.ZipFileWriter;
import wifi4eu.wifi4eu.abac.utils.csvparser.BudgetaryCommitmentCSVFileParser;
import wifi4eu.wifi4eu.abac.utils.csvparser.DocumentCSVFileParser;
import wifi4eu.wifi4eu.abac.utils.csvparser.LegalCommitmentCSVFileParser;
import wifi4eu.wifi4eu.abac.utils.csvparser.LegalEntityCSVFileParser;

import javax.print.Doc;
import javax.transaction.Transactional;

import java.io.IOException;

import java.util.*;

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

	@Autowired
	private BudgetaryCommitmentService budgetaryCommitmentService;

	@Autowired
	private ImportLogRepository importLogRepository;

	@Autowired
	private NotificationService notificationService;

	@Autowired
	private LegalCommitmentService legalCommitmentService;
	
	@Autowired
	ECASUserService ecasUserService;


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
		FileDTO fileDTO = new FileDTO();
		fileDTO.setContent(file);
		fileDTO.setSize(new Long(file.length));
		fileDTO.setFileName("import_LC_from_portal");

		importDataViaZipFile(file);
		//generate a unique batch file ID
		String batchRef = UUID.randomUUID().toString();
		//create the lines in the database
		legalCommitmentService.createLegalCommitments(batchRef);

		//log the imported file
		logImport(fileDTO, batchRef, ecasUserService.getCurrentUsername());

		//create user notification
		notificationService.createValidationProcessPendingNotification(batchRef, NotificationType.LC_CREATION);
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

		for (LegalEntityInformationCSVRow legalEntityInformationCSVRow : legalEntities) {

			LegalEntity legalEntity = legalEntityService.getLegalEntityByMunicipalityPortalId(legalEntityInformationCSVRow.getMid());

			if (legalEntity == null) {
				//map the csv row to the LegalEntity object
				legalEntity = legalEntityService.mapLegalEntityCSVToEntity(legalEntityInformationCSVRow);

				//set the current user
                legalEntity.setUserImported(ecasUserService.getCurrentUsername());

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
		logImport(fileDTO, batchRef, ecasUserService.getCurrentUsername());

		//create user notification
		notificationService.createValidationProcessPendingNotification(batchRef, NotificationType.LEF_CREATION);
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
		fileDTO.setFileName("portal_EXP_TO_AIRGAP_BC.csv");

		List<BudgetaryCommitmentCSVRow> budgetaryCommitmentCSVRows = (List<BudgetaryCommitmentCSVRow>) budgetaryCommitmentCSVFileParser.parseFile(fileDTO);

		//generate a unique batch file ID
		String batchRef = UUID.randomUUID().toString();

		for (BudgetaryCommitmentCSVRow budgetaryCommitmentCSVRow : budgetaryCommitmentCSVRows) {

			BudgetaryCommitmentPosition budgetaryCommitmentPosition = budgetaryCommitmentService.getBCPosition(budgetaryCommitmentCSVRow.getMunicipalityPortalId(), budgetaryCommitmentCSVRow.getAbacCommitmentLevel2Position());

			if(budgetaryCommitmentPosition == null) {
				log.info(String.format("importing BC %s for mid %s", budgetaryCommitmentCSVRow.getAbacGlobalCommitmentLevel1PositionKey(), budgetaryCommitmentCSVRow.getMunicipalityPortalId()));

				budgetaryCommitmentPosition = budgetaryCommitmentService.mapBudgetaryCommitmentCSVToEntity(budgetaryCommitmentCSVRow);

				BudgetaryCommitment budgetaryCommitment = budgetaryCommitmentService.getByMunicipalityPortalId(budgetaryCommitmentCSVRow.getMunicipalityPortalId());
				if (budgetaryCommitment != null) {
					budgetaryCommitmentPosition.setBudgetaryCommitment(budgetaryCommitment);
				}

				budgetaryCommitmentPosition.getBudgetaryCommitment().setBatchRef(batchRef);

				budgetaryCommitmentService.saveBCPosition(budgetaryCommitmentPosition);
			} else {
				//TODO update or ignore?
				log.info(String.format("Legal entity mid %s already has a Budgetary commitment position %s. Ignoring it for now",
										budgetaryCommitmentCSVRow.getMunicipalityPortalId(),
										budgetaryCommitmentCSVRow.getAbacCommitmentLevel2Position()));
			}
		}

		//log the imported file
		logImport(fileDTO, batchRef, ecasUserService.getCurrentUsername());

		//create user notification
		notificationService.createValidationProcessPendingNotification(batchRef, NotificationType.BC_CREATION);
	}
}