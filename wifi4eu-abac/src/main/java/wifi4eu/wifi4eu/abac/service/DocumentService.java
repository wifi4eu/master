package wifi4eu.wifi4eu.abac.service;

import eu.europa.ec.research.fp.services.document_management.v5.DocumentFault;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.abac.data.dto.LegalEntityDocumentCSVRow;
import wifi4eu.wifi4eu.abac.data.entity.Document;
import wifi4eu.wifi4eu.abac.data.entity.LegalEntity;
import wifi4eu.wifi4eu.abac.data.enums.DocumentType;
import wifi4eu.wifi4eu.abac.data.enums.DocumentWorkflowStatus;
import wifi4eu.wifi4eu.abac.data.repository.DocumentRepository;
import wifi4eu.wifi4eu.abac.data.repository.DocumentTypeMetadataRepository;
import wifi4eu.wifi4eu.abac.integration.hrs.HermesDocumentServiceClient;


import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {

    private final Logger log = LoggerFactory.getLogger(DocumentService.class);

	@Autowired
	private DocumentRepository documentRepository;

	@Autowired
    private DocumentTypeMetadataRepository documentTypeMetadataRepository;

	@Autowired
    LegalEntityService legalEntityService;

    @Autowired
    HermesDocumentServiceClient hermesDocumentServiceClient;

	@Transactional
	public Document saveDocument(Document document) {
		return documentRepository.save(document);
	}

	@Transactional( propagation = Propagation.REQUIRES_NEW )
	public Document updateStatusInNewTransaction(Document document, DocumentWorkflowStatus workflowStatus){
		document.setWfStatus(workflowStatus);
		saveDocument(document);
		return document;
	}

	public Document getDocumentByPortalId(Long portalId) {
		return documentRepository.findByPortalId(portalId);
	}

	public Document mapDocumentCSVToEntity(LegalEntityDocumentCSVRow documentCSVRow) {
		Document document = new Document();

		document.setPortalId(documentCSVRow.getDocumentPortalId());
		document.setName(documentCSVRow.getDocumentName());
		document.setFileName(documentCSVRow.getDocumentFileName());
		document.setMimetype(documentCSVRow.getDocumentMimeType());
		document.setPortalDate(documentCSVRow.getDocumentDate());
		document.setType(documentCSVRow.getDocumentType());
		document.setAresReference(documentCSVRow.getAresReference());

		LegalEntity legalEntity = legalEntityService.getLegalEntityByMunicipalityPortalId(documentCSVRow.getMunicipalityPortalId());
		document.setLegalEntity(legalEntity);

		return document;
	}

	@Transactional( propagation = Propagation.REQUIRES_NEW )
	public Document addDocumentInAres(Document document) throws Exception {
		hermesDocumentServiceClient.createFile(document);
		hermesDocumentServiceClient.createDocument(document);
		hermesDocumentServiceClient.uploadAttachment(document);
		//hermesDocumentServiceClient.fileDocument(document); THIS IS FAILING
		hermesDocumentServiceClient.registerDocument(document);

        return saveDocument(document);
    }





	public List<Document> getDocumentsByTypeAndStatus(DocumentType grantAgreement, DocumentWorkflowStatus waitingCountersignature) {
    	return documentRepository.findByTypeAndWfStatus(grantAgreement, waitingCountersignature);
	}

	public Document getDocumentsByLegalEntityIdAndType(Long legalEntityId, DocumentType documentType) {
    	return documentRepository.findByLegalEntityIdAndType(legalEntityId, documentType);
	}

	public List<Document> getDocumentsByStatus(DocumentWorkflowStatus workflowStatus, Pageable pageable) {
		return documentRepository.findByWfStatusOrderByDateCreated(workflowStatus, pageable);
	}

}
