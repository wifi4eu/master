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
import wifi4eu.wifi4eu.abac.data.dto.BankAccountInformationCSVRow;
import wifi4eu.wifi4eu.abac.data.dto.BudgetaryCommitmentCSVRow;
import wifi4eu.wifi4eu.abac.data.dto.DocumentCSVRow;
import wifi4eu.wifi4eu.abac.data.dto.FileDTO;
import wifi4eu.wifi4eu.abac.data.dto.LegalEntityInformationCSVRow;
import wifi4eu.wifi4eu.abac.data.entity.BankAccount;
import wifi4eu.wifi4eu.abac.data.entity.BudgetaryCommitmentPosition;
import wifi4eu.wifi4eu.abac.data.entity.Document;
import wifi4eu.wifi4eu.abac.data.entity.LegalEntity;
import wifi4eu.wifi4eu.abac.data.enums.AbacWorkflowStatus;
import wifi4eu.wifi4eu.abac.data.enums.DocumentType;
import wifi4eu.wifi4eu.abac.data.enums.NotificationType;
import wifi4eu.wifi4eu.abac.utils.ZipFileReader;
import wifi4eu.wifi4eu.abac.utils.csvparser.BankAccountCSVFileParser;
import wifi4eu.wifi4eu.abac.utils.csvparser.BankAccountDocumentCSVFileParser;
import wifi4eu.wifi4eu.abac.utils.csvparser.BudgetaryCommitmentCSVFileParser;
import wifi4eu.wifi4eu.abac.utils.csvparser.LegalEntityCSVFileParser;
import wifi4eu.wifi4eu.abac.utils.csvparser.LegalEntityDocumentCSVFileParser;

import java.util.*;

@SuppressWarnings("unchecked")
@Service
public class ImportDataService {
	
	private static enum ZipImportMode{LEF, LC, BAF}

	@Autowired
	private LegalEntityCSVFileParser legalEntityCSVFileParser;

	@Autowired
	private LegalEntityDocumentCSVFileParser legalEntityDocumentCSVFileParser;

	@Autowired
	private BudgetaryCommitmentCSVFileParser budgetaryCommitmentCSVFileParser;
	
	@Autowired
	private BankAccountCSVFileParser bankAccountCSVFileParser;

	@Autowired
	private BankAccountDocumentCSVFileParser bankAccountDocumentCSVFileParser;
	
	@Autowired
	private LegalEntityService legalEntityService;

	@Autowired
	private BudgetaryCommitmentService budgetaryCommitmentService;
	
	@Autowired
	private LegalCommitmentService legalCommitmentService;

	@Autowired
	private BankAccountService bankAccountService;
	
	@Autowired
	private DocumentService documentService;

	@Autowired
	private NotificationService notificationService;
	
	@Autowired
	ECASUserService ecasUserService;
	
	private final Logger log = LoggerFactory.getLogger(ImportDataService.class);

	@Transactional(propagation = Propagation.REQUIRED)
	public void importLegalEntities(String filename, byte[] file, String batchRef) {

		importDataViaZipFile(ZipImportMode.LEF, file, batchRef);
		notificationService.createValidationProcessPendingNotification(batchRef, NotificationType.LEF_CREATION, ecasUserService.getCurrentUserDetails().getEmail());
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void importLegalCommitments(String filename, byte[] file, String batchRef) {

		importDataViaZipFile(ZipImportMode.LC, file, batchRef);
		notificationService.createValidationProcessPendingNotification(batchRef, NotificationType.LC_CREATION, ecasUserService.getCurrentUserDetails().getEmail());
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void importBankAccounts(String filename, byte[] file, String batchRef) {

		importDataViaZipFile(ZipImportMode.BAF, file, batchRef);
		//TODO: notificationService.createValidationProcessPendingNotification(batchRef, NotificationType.BAF_CREATION, ecasUserService.getCurrentUserDetails().getEmail());
	}
	
	private void importDataViaZipFile(ZipImportMode importMode, byte[] file, String batchRef) {

		StrBuilder errors = new StrBuilder();
		
		Map<String, FileDTO> documents = new TreeMap<>();

		ZipFileReader zipFileReader = new ZipFileReader(file);
		FileDTO fileDTO = zipFileReader.nextFile();
		while(fileDTO != null) {
			documents.put(fileDTO.getFileName(), fileDTO);
			fileDTO = zipFileReader.nextFile();
		}

		if(ZipImportMode.LEF.equals(importMode)) {
			
			if(!documents.containsKey(Constants.IMPORT_LEGAL_ENTITY_INFORMATION_CSV_FILENAME)) {
				errors.appendln(Constants.IMPORT_LEGAL_ENTITY_INFORMATION_CSV_FILENAME + " is missing from the .zip file");
			} else if(!documents.containsKey(Constants.IMPORT_LEGAL_ENTITY_DOCUMENTS_CSV_FILENAME)) {
				errors.appendln(Constants.IMPORT_LEGAL_ENTITY_DOCUMENTS_CSV_FILENAME + " is missing from the .zip file");
			} else {
				errors.appendln(processLegalEntityInformationFile(documents.get(Constants.IMPORT_LEGAL_ENTITY_INFORMATION_CSV_FILENAME), batchRef));
				errors.appendln(importLegalEntityDocuments(documents.get(Constants.IMPORT_LEGAL_ENTITY_DOCUMENTS_CSV_FILENAME), batchRef, documents));
			}
			
		} else if(ZipImportMode.LC.equals(importMode)) {
			
			if(!documents.containsKey(Constants.IMPORT_LEGAL_COMMITMENT_DOCUMENTS_CSV_FILENAME)) {
				errors.appendln(Constants.IMPORT_LEGAL_COMMITMENT_DOCUMENTS_CSV_FILENAME + " is missing from the .zip file");
			} else {
				errors.appendln(importLegalEntityDocuments(documents.get(Constants.IMPORT_LEGAL_COMMITMENT_DOCUMENTS_CSV_FILENAME), batchRef, documents));
			}
			
		} else if(ZipImportMode.BAF.equals(importMode)) {
			
			if(!documents.containsKey(Constants.IMPORT_BANK_ACCOUNT_INFORMATION_CSV_FILENAME)) {
				errors.appendln(Constants.IMPORT_BANK_ACCOUNT_INFORMATION_CSV_FILENAME + " is missing from the .zip file");
			} else if(!documents.containsKey(Constants.IMPORT_BANK_ACCOUNT_DOCUMENTS_CSV_FILENAME)) {
				errors.appendln(Constants.IMPORT_BANK_ACCOUNT_DOCUMENTS_CSV_FILENAME + " is missing from the .zip file");
			} else {
				errors.appendln(processBankAccountInformationFile(documents.get(Constants.IMPORT_BANK_ACCOUNT_INFORMATION_CSV_FILENAME), batchRef));
				errors.appendln(importBankAccountDocuments(documents.get(Constants.IMPORT_BANK_ACCOUNT_DOCUMENTS_CSV_FILENAME), batchRef, documents));
			}
		}
		
		if(!errors.trim().isEmpty()) {
			throw new RuntimeException(errors.toString().trim());
		}
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

	private String processBankAccountInformationFile(FileDTO fileDTO, String batchRef) {
		
		StrBuilder errors = new StrBuilder();
		List<BankAccountInformationCSVRow> bankAccounts = (List<BankAccountInformationCSVRow>) bankAccountCSVFileParser.parseFile(fileDTO);

		for (BankAccountInformationCSVRow bankAccountCSVRow : bankAccounts) {

			try {
				BankAccount bankAccount = bankAccountService.getBankAccountByBankAccountPortalId(bankAccountCSVRow.getBafId());

				if (bankAccount == null) {

					bankAccount = bankAccountService.mapBankAccountCSVToEntity(bankAccountCSVRow);
					bankAccount.setUserImported(ecasUserService.getCurrentUsername());
					bankAccount.setBatchRef(batchRef);
					bankAccount.setWfStatus(AbacWorkflowStatus.IMPORTED);
					bankAccountService.saveBankAccount(bankAccount);
					
				} else {
					String warn = String.format("Bank Account ID %s: %s", bankAccountCSVRow.getBafId(), "Already exists");
					errors.appendln(warn);
					log.warn(warn);
				}
			} catch(Exception e) {
				String error = String.format("Bank Account ID %s: %s", bankAccountCSVRow.getBafId(), e.getMessage());
				errors.appendln(error);
				log.error(error);
			}
		}
		return  errors.toString();
	}
	
	private String importLegalEntityDocuments(FileDTO fileDTO, String batchRef, Map<String, FileDTO> documentsToBeImported) {
		return importDocuments((List<DocumentCSVRow>)legalEntityDocumentCSVFileParser.parseFile(fileDTO), batchRef, documentsToBeImported);
	}
	
	private String importBankAccountDocuments(FileDTO fileDTO, String batchRef, Map<String, FileDTO> documentsToBeImported) {
		return importDocuments((List<DocumentCSVRow>)bankAccountDocumentCSVFileParser.parseFile(fileDTO), batchRef, documentsToBeImported);
	}
	
	private String importDocuments(List<DocumentCSVRow> documentsRows, String batchRef, Map<String, FileDTO> documentsToBeImported) {

		StrBuilder errors = new StrBuilder();

		for (DocumentCSVRow documentCSVRow : documentsRows) {

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