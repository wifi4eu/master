package wifi4eu.wifi4eu.abac.service;


import eu.cec.digit.ecas.client.jaas.DetailedUser;
import eu.cec.digit.ecas.client.jaas.SubjectNotFoundException;

import org.apache.commons.lang.text.StrBuilder;
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
import javax.wsdl.Import;

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

	public ImportLog importLegalEntities(String filename, byte[] file) {

		//generate a unique batch file ID
		String batchRef = UUID.randomUUID().toString();

		String errors = importDataViaZipFile(file, batchRef);

		//log the imported file
		ImportLog importLog = logImport(filename, batchRef, ecasUserService.getCurrentUsername(), errors);

		//create user notification
		notificationService.createValidationProcessPendingNotification(batchRef, NotificationType.LEF_CREATION);

		return importLog;
	}

	@Transactional
	public ImportLog importBudgetaryCommitments(String filename, byte[] file) {

		FileDTO fileDTO = new FileDTO();
		fileDTO.setContent(file);
		fileDTO.setSize(new Long(file.length));
		fileDTO.setFileName(filename);

		List<BudgetaryCommitmentCSVRow> budgetaryCommitmentCSVRows = (List<BudgetaryCommitmentCSVRow>) budgetaryCommitmentCSVFileParser.parseFile(fileDTO);

		//generate a unique batch file ID
		String batchRef = UUID.randomUUID().toString();

		StrBuilder errors = new StrBuilder();

		for (BudgetaryCommitmentCSVRow budgetaryCommitmentCSVRow : budgetaryCommitmentCSVRows) {

			try {
				BudgetaryCommitmentPosition budgetaryCommitmentPosition = budgetaryCommitmentService.getBCPosition(budgetaryCommitmentCSVRow.getMunicipalityPortalId(), budgetaryCommitmentCSVRow.getAbacCommitmentLevel2Position());

				if(budgetaryCommitmentPosition == null) {
					log.info("importing BC {} for mid {}", budgetaryCommitmentCSVRow.getAbacGlobalCommitmentLevel1PositionKey(), budgetaryCommitmentCSVRow.getMunicipalityPortalId());

					budgetaryCommitmentPosition = budgetaryCommitmentService.mapBudgetaryCommitmentCSVToEntity(budgetaryCommitmentCSVRow);

					budgetaryCommitmentPosition.getBudgetaryCommitment().setBatchRef(batchRef);

					budgetaryCommitmentService.saveBCPosition(budgetaryCommitmentPosition);
				} else {
					String warn = String.format("Municipality ID %s: Commitment Level 2 Position %s already exists",
							budgetaryCommitmentCSVRow.getMunicipalityPortalId(),
							budgetaryCommitmentCSVRow.getAbacCommitmentLevel2Position());
					errors.appendln(warn);
					log.warn(warn);
				}
			} catch(Exception e) {
				String error = String.format("Municipality ID %s: %s", budgetaryCommitmentCSVRow.getMunicipalityPortalId(), e.getMessage());
				errors.appendln(error);
				log.error(error);
			}
		}

		//log the imported file
		ImportLog importLog = logImport(filename, batchRef, ecasUserService.getCurrentUsername(), errors.toString());

		//create user notification
		notificationService.createValidationProcessPendingNotification(batchRef, NotificationType.BC_CREATION);

		return importLog;
	}

	/**
	 * Legal Commitments will be treated as a regular upload of documents where the docType is GRANT_AGREEMENT
	 * @param file
	 */
	@Transactional(Transactional.TxType.REQUIRED)
	public ImportLog importLegalCommitments(String filename, byte[] file) {

		//generate a unique batch file ID
		String batchRef = UUID.randomUUID().toString();

		String errors = importDataViaZipFile(file, batchRef);

		//create the lines in the database
		if(StringUtils.isEmpty(errors)) {
			legalCommitmentService.createLegalCommitments(batchRef);
		}

		//log the imported file
		ImportLog importLog = logImport(filename, batchRef, ecasUserService.getCurrentUsername(), errors);

		//create user notification
		notificationService.createValidationProcessPendingNotification(batchRef, NotificationType.LC_CREATION);

		return importLog;
	}

	@Transactional(Transactional.TxType.REQUIRES_NEW)
	public String importDataViaZipFile(byte[] file, String batchRef) {

		StrBuilder errors = new StrBuilder();

		ZipFileReader zipFileReader = new ZipFileReader(file);

		FileDTO fileDTO = zipFileReader.nextFile();

		while(fileDTO != null) {

			log.info("Processing file {}", fileDTO.getFileName());

			switch (fileDTO.getFileName()) {
				case LEGAL_ENTITY_INFORMATION_CSV_FILENAME:
					fileDTO.setFileType(FileDTO.FileType.LEGAL_ENTITY_INFORMATION_CSV);
					errors.appendln(processLegalEntityInformationFile(fileDTO, batchRef));
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
			errors.appendln(importDocuments(documentsCSVFile));
		}

		return errors.toString();
	}

	private String processLegalEntityInformationFile(FileDTO fileDTO, String batchRef) {
		List<LegalEntityInformationCSVRow> legalEntities = (List<LegalEntityInformationCSVRow>) legalEntityCSVFileParser.parseFile(fileDTO);

		StrBuilder errors = new StrBuilder();

		for (LegalEntityInformationCSVRow legalEntityInformationCSVRow : legalEntities) {

			try  {
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
					String warn = String.format("Municipality ID %s: %s", legalEntityInformationCSVRow.getMid(), "Already exists");
					errors.appendln(warn);
					log.warn(warn);
				}
			} catch(Exception e) {
				String error = String.format("Municipality ID %s: %s", legalEntityInformationCSVRow.getMid(), e.getMessage());
				errors.appendln(error);
				log.error(error);
			}
		}
		return  errors.toString();
	}

	private ImportLog logImport(String filename, String batchRef, String userId, String errors){
		ImportLog importLog = new ImportLog();
		importLog.setFileName(filename);
		importLog.setBatchRef(batchRef);
		importLog.setUserId(userId);
		importLog.setErrors(errors);
		return importLogRepository.save(importLog);
	}

	private void addDocumentsCSVIndexFile(final FileDTO fileDTO) {
		documentsCSVFile = fileDTO;
	}

	private void addDocumentToBeImported(final FileDTO fileDTO) {
		documentsToBeImported.put(fileDTO.getFileName(), fileDTO);
	}

	private String importDocuments(FileDTO fileDTO) {
		List<LegalEntityDocumentCSVRow> documents = (List<LegalEntityDocumentCSVRow>) documentCSVFileParser.parseFile(fileDTO);
		StrBuilder errors = new StrBuilder();
		for (LegalEntityDocumentCSVRow documentCSVRow : documents) {

			try {
				Document document = documentService.getDocumentByPortalId(documentCSVRow.getDocumentPortalId());

				if (document == null) {
					document = documentService.mapDocumentCSVToEntity(documentCSVRow);
					if(documentsToBeImported.get(documentCSVRow.getDocumentFileName()) != null){
						document.setData(documentsToBeImported.get(documentCSVRow.getDocumentFileName()).getContent());
					}
					documentService.saveDocument(document);
				} else {
					String warn = String.format("Document ID %s: Portal ID/Name %s/%s already exists in the DB", document.getPortalId(), document.getName());
					errors.appendln(warn);
					log.warn(warn);
				}
			} catch(Exception e) {
				String error = String.format("Document ID %s: %s", documentCSVRow.getDocumentPortalId(), e.getMessage());
				errors.appendln(error);
				log.error(error);
			}
		}
		return errors.toString();
	}
}