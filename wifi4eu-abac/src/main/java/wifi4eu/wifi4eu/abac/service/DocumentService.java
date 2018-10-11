package wifi4eu.wifi4eu.abac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import wifi4eu.wifi4eu.abac.data.dto.BankAccountDocumentCSVRow;
import wifi4eu.wifi4eu.abac.data.dto.DocumentCSVRow;
import wifi4eu.wifi4eu.abac.data.dto.LegalEntityDocumentCSVRow;
import wifi4eu.wifi4eu.abac.data.entity.BankAccount;
import wifi4eu.wifi4eu.abac.data.entity.Document;
import wifi4eu.wifi4eu.abac.data.entity.LegalEntity;
import wifi4eu.wifi4eu.abac.data.enums.DocumentType;
import wifi4eu.wifi4eu.abac.data.enums.DocumentWorkflowStatus;
import wifi4eu.wifi4eu.abac.data.repository.DocumentRepository;
import wifi4eu.wifi4eu.abac.integration.hrs.HermesDocumentServiceClient;

@Service
public class DocumentService {

	@Autowired
	private DocumentRepository documentRepository;

	@Autowired
    LegalEntityService legalEntityService;
	
	@Autowired
    BankAccountService bankAccountService;

    @Autowired
    HermesDocumentServiceClient hermesDocumentServiceClient;

    private void validate(Document document) {
    	if (document.getType() == null) throw new RuntimeException("Type is empty or invalid");
    	if (
    		(
				document.getType().equals(DocumentType.COUNTERSIGNED_GRANT_AGREEMENT) ||
				document.getType().equals(DocumentType.GRANT_AGREEMENT) ||
				document.getType().equals(DocumentType.IDENTIFICATION_FORM)
    		) &&
    		document.getLegalEntity() == null 
    	) {
    		throw new RuntimeException("Municipality ID is empty or invalid");
    	}
    	if (document.getType().equals(DocumentType.BANK_ACCOUNT_IDENTIFICATION_FORM) && document.getBankAccount() == null) {
    		throw new RuntimeException("Bank account ID is empty or invalid");
    	}

    	if (StringUtils.isEmpty(document.getName())) throw new RuntimeException("Name is empty");
		if (StringUtils.isEmpty(document.getFileName())) throw new RuntimeException("Filename is empty");
		if (document.getData() == null) throw new RuntimeException(String.format("File %s not found in the zipfile", document.getFileName()));
		if (
			document.getType().equals(DocumentType.IDENTIFICATION_FORM) ||
			document.getType().equals(DocumentType.GRANT_AGREEMENT) ||
			document.getType().equals(DocumentType.BANK_ACCOUNT_IDENTIFICATION_FORM)
		) {
			if(document.getPortalId() == null) throw new RuntimeException("Portal ID is empty");
			if(document.getPortalDate() == null) throw new RuntimeException("Date is empty");
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Document saveDocument(Document document) {
		validate(document);
		return documentRepository.save(document);
	}

	public Document updateStatusInNewTransaction(Document document, DocumentWorkflowStatus workflowStatus){
		document.setWfStatus(workflowStatus);
		saveDocument(document);
		return document;
	}

	public Document getDocumentByPortalId(Long portalId) {
		return documentRepository.findByPortalId(portalId);
	}

	public Document mapDocumentCSVToEntity(DocumentCSVRow documentCSVRow) {
		Document document = new Document();

		document.setPortalId(documentCSVRow.getDocumentPortalId());
		document.setName(documentCSVRow.getDocumentName());
		document.setFileName(documentCSVRow.getDocumentFileName());
		document.setMimetype(documentCSVRow.getDocumentMimeType());
		document.setPortalDate(documentCSVRow.getDocumentDate());
		document.setType(documentCSVRow.getDocumentType());
		document.setAresReference(documentCSVRow.getAresReference());
		
		if(documentCSVRow instanceof LegalEntityDocumentCSVRow) {
			LegalEntity legalEntity = legalEntityService.getLegalEntityByMunicipalityPortalId(((LegalEntityDocumentCSVRow)documentCSVRow).getMunicipalityPortalId());
			document.setLegalEntity(legalEntity);
		}else if(documentCSVRow instanceof BankAccountDocumentCSVRow) {
			BankAccount bankAccount = bankAccountService.getBankAccountByBankAccountPortalId(((BankAccountDocumentCSVRow)documentCSVRow).getBankAccountId());
			document.setBankAccount(bankAccount);
		}

		return document;
	}

	@Transactional( propagation = Propagation.REQUIRES_NEW )
	public Document addDocumentInAres(Document document) throws Exception {
		hermesDocumentServiceClient.createFile(document);
		hermesDocumentServiceClient.uploadAttachment(document);
		hermesDocumentServiceClient.createDocument(document);
		hermesDocumentServiceClient.registerDocumentById(document);

        return saveDocument(document);
    }

	public List<Document> getDocumentsByTypeAndStatus(DocumentType documentType, DocumentWorkflowStatus wfStatus) {
    	return documentRepository.findByTypeAndWfStatus(documentType, wfStatus);
	}

	public List<Document> getDocumentsByStatus(DocumentWorkflowStatus wfStatus, Pageable pageable) {
		return documentRepository.findByWfStatusOrderByDateCreated(wfStatus, pageable);
	}
}
