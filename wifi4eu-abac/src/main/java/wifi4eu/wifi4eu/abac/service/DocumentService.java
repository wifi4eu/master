package wifi4eu.wifi4eu.abac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.abac.data.dto.LegalEntityDocumentCSVRow;
import wifi4eu.wifi4eu.abac.data.entity.Document;
import wifi4eu.wifi4eu.abac.data.entity.LegalEntity;
import wifi4eu.wifi4eu.abac.data.repository.DocumentRepository;

@Service
public class DocumentService {

	@Autowired
	private DocumentRepository documentRepository;

	@Autowired LegalEntityService legalEntityService;


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

		LegalEntity legalEntity = legalEntityService.getLegalEntityByMunicipalityPortalId(documentCSVRow.getMunicipalityPortalId());
		document.setLegalEntity(legalEntity);

		return document;
	}
}
