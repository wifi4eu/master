package wifi4eu.wifi4eu.entity.exportImport;

import java.util.List;

public class ExportImportLegalCommitmentInformation {
	private Long municipalityId;
	private Long documentId; 
	private String documentName; 
	private String zipFileDocumentName; 
	private String documentMimeType;
	private String documentSignatureDate;
	private String documentType;
	private String aresReference;
	private List<ExportFile> files;

	public Long getMunicipalityId() {
		return municipalityId;
	}
	public void setMunicipalityId(Long municipalityId) {
		this.municipalityId = municipalityId;
	}
	public Long getDocumentId() {
		return documentId;
	}
	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public String getZipFileDocumentName() {
		return zipFileDocumentName;
	}
	public void setZipFileDocumentName(String zipFileDocumentName) {
		this.zipFileDocumentName = zipFileDocumentName;
	}
	public String getDocumentMimeType() {
		return documentMimeType;
	}
	public void setDocumentMimeType(String documentMimeType) {
		this.documentMimeType = documentMimeType;
	}
	public String getDocumentSignatureDate() {
		return documentSignatureDate;
	}
	public void setDocumentSignatureDate(String documentSignatureDate) {
		this.documentSignatureDate = documentSignatureDate;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public String getAresReference() {
		return aresReference;
	}
	public void setAresReference(String aresReference) {
		this.aresReference = aresReference;
	}
	public List<ExportFile> getFiles() {
		return files;
	}
	public void setFiles(List<ExportFile> files) {
		this.files = files;
	}
}