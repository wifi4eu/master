package wifi4eu.wifi4eu.abac.data.dto;

import wifi4eu.wifi4eu.abac.data.enums.DocumentType;

import java.util.Date;

public class LegalEntityDocumentCSVRow {

	private Long municipalityPortalId;
	private Long documentPortalId;
	private String documentName;
	private String documentFileName;
	private String documentMimeType;
	private Date documentDate;
	private DocumentType documentType;

	public Long getMunicipalityPortalId() {
		return municipalityPortalId;
	}

	public void setMunicipalityPortalId(Long municipalityPortalId) {
		this.municipalityPortalId = municipalityPortalId;
	}

	public Long getDocumentPortalId() {
		return documentPortalId;
	}

	public void setDocumentPortalId(Long documentPortalId) {
		this.documentPortalId = documentPortalId;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getDocumentFileName() {
		return documentFileName;
	}

	public void setDocumentFileName(String documentFileName) {
		this.documentFileName = documentFileName;
	}

	public String getDocumentMimeType() {
		return documentMimeType;
	}

	public void setDocumentMimeType(String documentMimeType) {
		this.documentMimeType = documentMimeType;
	}

	public Date getDocumentDate() {
		return documentDate;
	}

	public void setDocumentDate(Date documentDate) {
		this.documentDate = documentDate;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}
}
