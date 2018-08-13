package wifi4eu.wifi4eu.abac.integration.eris.model;

/**
 * Local class for all the parameters needed for creating a file in ERIS
 * @author bulancr
 *
 */
public class CreateAutomaticFileParams {
	
	private String filePlan;
	private String fileType;
	private String fileTitle;
	private String specificCode;
	private String chefDeFile;
	
	
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
	public String getFileTitle() {
		return fileTitle;
	}
	public void setFileTitle(String fileTitle) {
		this.fileTitle = fileTitle;
	}
	public String getSpecificCode() {
		return specificCode;
	}
	public void setSpecificCode(String specificCode) {
		this.specificCode = specificCode;
	}
	public String getChefDeFile() {
		return chefDeFile;
	}
	public void setChefDeFile(String chefDeFile) {
		this.chefDeFile = chefDeFile;
	}
	

}
