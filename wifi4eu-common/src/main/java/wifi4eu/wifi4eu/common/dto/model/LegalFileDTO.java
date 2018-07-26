package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;
import java.util.Date;

public class LegalFileDTO implements Serializable {
	private int id;
	private int registration;
	private String fileData;
	private int fileType;
	private Date uploadTime;
	private Integer userId;
	private int fileSize;
	private String fileMime;
	private String fileName;

	public LegalFileDTO() {
    this.uploadTime = new Date();
	}

	public LegalFileDTO(int registration, String fileData, int fileType, Date uploadTime, Integer userId, int fileSize, String fileMime, String
			fileName) {
		this.registration = registration;
		this.fileData = fileData;
		this.fileType = fileType;
		this.uploadTime = uploadTime;
		this.userId = userId;
		this.fileSize = fileSize;
		this.fileMime = fileMime;
		this.fileName = fileName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRegistration() {
		return registration;
	}

	public void setRegistration(int registration) {
		this.registration = registration;
	}

	public String getFileData() {
		return fileData;
	}

	public void setFileData(String fileData) {
		this.fileData = fileData;
	}

	public int getFileType() {
		return fileType;
	}

	public void setFileType(int fileType) {
		this.fileType = fileType;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileMime() {
		return fileMime;
	}

	public void setFileMime(String fileMime) {
		this.fileMime = fileMime;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
