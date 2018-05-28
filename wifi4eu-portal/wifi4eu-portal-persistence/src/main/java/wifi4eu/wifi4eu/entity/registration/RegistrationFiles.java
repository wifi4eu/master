package wifi4eu.wifi4eu.entity.registration;

import wifi4eu.wifi4eu.entity.user.*;

import javax.persistence.*;

@Entity
@Table(name = "legal_files")
public class RegistrationFiles {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "registrationId")
	private Registration registration;

	@Column(name = "file_data")
	private String file_data;

	@Column(name = "file_index")
	private int file_index;

	public RegistrationFiles() {
	}

	public RegistrationFiles(Registration registration, String file_data, int file_index) {
		this.registration = registration;
		this.file_data = file_data;
		this.file_index = file_index;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
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
