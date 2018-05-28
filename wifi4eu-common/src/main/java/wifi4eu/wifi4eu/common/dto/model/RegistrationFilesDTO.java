package wifi4eu.wifi4eu.common.dto.model;

import java.io.*;

public class RegistrationFilesDTO implements Serializable {
	private int id;
	private int registrationId;
	private String file_data;
	private int file_index;

	public RegistrationFilesDTO() {
	}

	public RegistrationFilesDTO(int registrationId, String file_data, int file_index) {
		this.id = id;
		this.registrationId = registrationId;
		this.file_data = file_data;
		this.file_index = file_index;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}

	public String getFile_data() {
		return file_data;
	}

	public void setFile_data(String file_data) {
		this.file_data = file_data;
	}

	public int getFile_index() {
		return file_index;
	}

	public void setFile_index(int file_index) {
		this.file_index = file_index;
	}
}
