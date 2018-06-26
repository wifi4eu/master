package wifi4eu.wifi4eu.common.dto.model;

import java.io.*;

public class LegalFilesDTO implements Serializable {
	private int id;
	private int registration;
	private String fileData;
	private int fileType;

	public LegalFilesDTO() {
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
}
