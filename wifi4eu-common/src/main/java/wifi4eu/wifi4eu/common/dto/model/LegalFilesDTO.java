package wifi4eu.wifi4eu.common.dto.model;

import java.io.*;
import java.util.Date;

public class LegalFilesDTO implements Serializable {
	private int id;
	private int registration;
	private String fileData;
  private int fileType;
  private Date uploadTime;

	public LegalFilesDTO() {
    this.uploadTime = new Date();
	}

	public LegalFilesDTO(int registration, String fileData, int fileType) {
		this.id = id;
		this.registration = registration;
		this.fileData = fileData;
		this.fileType = fileType;
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
  
  public void setUploadTime(Date uploadTime){
    this.uploadTime = uploadTime;
  }

  public Date getUploadTime(){
    return this.uploadTime;
  }

}
