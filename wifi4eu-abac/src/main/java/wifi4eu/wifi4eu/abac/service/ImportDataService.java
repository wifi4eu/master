package wifi4eu.wifi4eu.abac.service;

import org.apache.commons.lang.text.StrBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import wifi4eu.wifi4eu.abac.data.Constants;
import wifi4eu.wifi4eu.abac.data.dto.BudgetaryCommitmentCSVRow;
import wifi4eu.wifi4eu.abac.data.dto.FileDTO;
import wifi4eu.wifi4eu.abac.data.dto.LegalEntityDocumentCSVRow;
import wifi4eu.wifi4eu.abac.data.dto.LegalEntityInformationCSVRow;
import wifi4eu.wifi4eu.abac.data.entity.BudgetaryCommitmentPosition;
import wifi4eu.wifi4eu.abac.data.entity.Document;
import wifi4eu.wifi4eu.abac.data.entity.LegalEntity;
import wifi4eu.wifi4eu.abac.data.enums.AbacWorkflowStatus;
import wifi4eu.wifi4eu.abac.data.enums.DocumentType;
import wifi4eu.wifi4eu.abac.data.enums.NotificationType;
import wifi4eu.wifi4eu.abac.utils.ZipFileReader;
import wifi4eu.wifi4eu.abac.utils.csvparser.BudgetaryCommitmentCSVFileParser;
import wifi4eu.wifi4eu.abac.utils.csvparser.DocumentCSVFileParser;
import wifi4eu.wifi4eu.abac.utils.csvparser.LegalEntityCSVFileParser;

import java.util.*;

@SuppressWarnings("unchecked")
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

	@Autowired
	private BudgetaryCommitmentService budgetaryCommitmentService;

	@Autowired
	private NotificationService notificationService;

	@Autowired
	private LegalCommitmentService legalCommitmentService;
	
	@Autowired
	ECASUserService ecasUserService;

	private final Logger log = LoggerFactory.getLogger(ImportDataService.class);

	FileDTO documentsCSVFile;
	private Map<String, FileDTO> documentsToBeImported = new TreeMap<>();

	@Transactional(propagation = Propagation.REQUIRED)
	public void importLegalEntities(String filename, byte[] file, String batchRef) {

		importDataViaZipFile(file, batchRef);
		notificationService.createValidationProcessPendingNotification(batchRef, NotificationType.LEF_CREATION, ecasUserService.getCurrentUserDetails().getEmail());
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void importBudgetaryCommitments(String filename, byte[] file, String batchRef) {

		FileDTO fileDTO = new FileDTO();
		fileDTO.setContent(file);
		fileDTO.setSize(new Long(file.length));
		fileDTO.setFileName(filename);

		StrBuilder errors = new StrBuilder();
		List<BudgetaryCommitmentCSVRow> budgetaryCommitmentCSVRows = (List<BudgetaryCommitmentCSVRow>) budgetaryCommitmentCSVFileParser.parseFile(fileDTO);

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

		if (errors != null && !errors.trim().isEmpty()) {
			throw new RuntimeException(errors.toString().trim());
		}
		notificationService.createValidationProcessPendingNotification(batchRef, NotificationType.BC_CREATION, ecasUserService.getCurrentUserDetails().getEmail());
	}

	//Legal Commitments will be treated as a regular upload of documents where the docType is GRANT_AGREEMENT
	@Transactional(propagation = Propagation.REQUIRED)
	public void importLegalCommitments(String filename, byte[] file, String batchRef) {

		importDataViaZipFile(file, batchRef);
		notificationService.createValidationProcessPendingNotification(batchRef, NotificationType.LC_CREATION, ecasUserService.getCurrentUserDetails().getEmail());
	}

	private void importDataViaZipFile(byte[] file, String batchRef) {

		StrBuilder errors = new StrBuilder();

		ZipFileReader zipFileReader = new ZipFileReader(file);

		FileDTO fileDTO = zipFileReader.nextFile();

		while(fileDTO != null) {

			log.info("Processing file {}", fileDTO.getFileName());

			switch (fileDTO.getFileName()) {
				case Constants.IMPORT_LEGAL_ENTITY_INFORMATION_CSV_FILENAME:
					fileDTO.setFileType(FileDTO.FileType.LEGAL_ENTITY_INFORMATION_CSV);
					errors.append(processLegalEntityInformationFile(fileDTO, batchRef));
					break;
				case Constants.IMPORT_LEGAL_ENTITY_DOCUMENTS_CSV_FILENAME:
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
			errors.append(importDocuments(documentsCSVFile, batchRef));
		}

		if (errors != null && !errors.trim().isEmpty()) {
			throw new RuntimeException(errors.toString().trim());
		}
	}

	private String processLegalEntityInformationFile(FileDTO fileDTO, String batchRef) {

		StrBuilder errors = new StrBuilder();
		List<LegalEntityInformationCSVRow> legalEntities = (List<LegalEntityInformationCSVRow>) legalEntityCSVFileParser.parseFile(fileDTO);

		for (LegalEntityInformationCSVRow legalEntityInformationCSVRow : legalEntities) {

			try  {
				LegalEntity legalEntity = legalEntityService.getLegalEntityByMunicipalityPortalIdOrOfficialNameIgnoreCase(legalEntityInformationCSVRow.getMid(), legalEntityInformationCSVRow.getOfficialName());

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

	private void addDocumentsCSVIndexFile(final FileDTO fileDTO) {
		documentsCSVFile = fileDTO;
	}

	private void addDocumentToBeImported(final FileDTO fileDTO) {
		documentsToBeImported.put(fileDTO.getFileName(), fileDTO);
	}

	private String importDocuments(FileDTO fileDTO, String batchRef) {

		StrBuilder errors = new StrBuilder();
		List<LegalEntityDocumentCSVRow> documents = (List<LegalEntityDocumentCSVRow>) documentCSVFileParser.parseFile(fileDTO);

		for (LegalEntityDocumentCSVRow documentCSVRow : documents) {

			try {
				Document document = null;
				if (documentCSVRow.getDocumentPortalId() != null){
					document = documentService.getDocumentByPortalId(documentCSVRow.getDocumentPortalId());
				}

				if (document == null) {
					document = documentService.mapDocumentCSVToEntity(documentCSVRow);
					if(documentsToBeImported.get(documentCSVRow.getDocumentFileName()) != null){
						document.setData(documentsToBeImported.get(documentCSVRow.getDocumentFileName()).getContent());
					}
					documentService.saveDocument(document);

					if(document.getType().equals(DocumentType.GRANT_AGREEMENT)) {
						legalCommitmentService.createLegalCommitment(document, batchRef);
					}
				} else {
					String warn = String.format("Document ID %s: already exists", document.getPortalId(), document.getPortalId(), document.getName());
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