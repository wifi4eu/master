package wifi4eu.wifi4eu.abac.service;

import eu.europa.ec.research.fp.services.document_management.v5.DocumentFault;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.abac.data.dto.LegalEntityDocumentCSVRow;
import wifi4eu.wifi4eu.abac.data.entity.Document;
import wifi4eu.wifi4eu.abac.data.entity.LegalEntity;
import wifi4eu.wifi4eu.abac.data.enums.DocumentType;
import wifi4eu.wifi4eu.abac.data.enums.DocumentWorkflowStatus;
import wifi4eu.wifi4eu.abac.data.repository.DocumentRepository;
import wifi4eu.wifi4eu.abac.data.repository.DocumentTypeMetadataRepository;
import wifi4eu.wifi4eu.abac.integration.hrs.HermesDocumentServiceClient;

import javax.transaction.Transactional;
import java.util.List;

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

	public Document saveDocument(Document document) {
		return documentRepository.save(document);
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

	@Transactional(Transactional.TxType.REQUIRES_NEW)
	public Document addDocumentInAres(Document document) throws DocumentFault {

        try {
            document = hermesDocumentServiceClient.saveDocumentInAres(document);
            document.setWfStatus(DocumentWorkflowStatus.ARCHIVED_IN_ARES);
        } catch (Exception e) {
            log.error("ERROR Saving document in ARES {}", document.getId(), e);
			document.setWfStatus(DocumentWorkflowStatus.ARES_ERROR);
        }

        return saveDocument(document);
    }


	@Transactional
    public List<Document> submitDocumentsToAres(Integer startPage, Integer maxRecords) {
        Pageable pageable = PageRequest.of(startPage, maxRecords);
        List<Document> documents = documentRepository.findByWfStatusOrderByDateCreated(DocumentWorkflowStatus.IMPORTED, pageable);

        if (!documents.isEmpty()) {
            log.info(String.format("Found %s documents ready to be sent to ARES...", documents.size()));
        }

        try {
            for (Document document : documents) {
                addDocumentInAres(document);
            }
        } catch (Exception e){
            log.error(String.format("Error sending document to ARES: %s", e.getMessage()), e);
        }

        return documents;
    }


	public List<Document> getDocumentsByTypeAndStatus(DocumentType grantAgreement, DocumentWorkflowStatus waitingCountersignature) {
    	return documentRepository.findByTypeAndWfStatus(grantAgreement, waitingCountersignature);
	}

	public Document getDocumentsByLegalEntityIdAndType(Long legalEntityId, DocumentType documentType) {
    	return documentRepository.findByLegalEntityIdAndType(legalEntityId, documentType);
	}
}
