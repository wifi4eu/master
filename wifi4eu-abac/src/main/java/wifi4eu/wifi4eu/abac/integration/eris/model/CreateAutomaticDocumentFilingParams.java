package wifi4eu.wifi4eu.abac.integration.eris.model;
import eu.europa.ec.research.fp.model.document_ref.v3.DocumentRefType;

/**
 * Local class for all the parameters needed for document filing in ERIS
 * @author bulancr
 *
 */
public class CreateAutomaticDocumentFilingParams {
	
	private String filePlan;
	private String fileType;
	private String fileSpecificCode;
	private String subfileType;
	private DocumentRefType documentId;
	
	public String getFilePlan() {
		return filePlan;
	}
	public void setFilePlan(String filePlan) {
		this.filePlan = filePlan;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFileSpecificCode() {
		return fileSpecificCode;
	}
	public void setFileSpecificCode(String fileSpecificCode) {
		this.fileSpecificCode = fileSpecificCode;
	}
	public String getSubfileType() {
		return subfileType;
	}
	public void setSubfileType(String subfileType) {
		this.subfileType = subfileType;
	}
	public DocumentRefType getDocumentId() {
		return documentId;
	}
	public void setDocumentId(DocumentRefType documentId) {
		this.documentId = documentId;
	}
	

}
