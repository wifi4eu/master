package wifi4eu.wifi4eu.entity.registration;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "legal_files")
public class LegalFile {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "registration")
	private int registration;

	@Column(name = "data")
	private String fileData;

	@Column(name = "type")
	private int fileType;

	@Column(name = "upload_time")
	private Date uploadTime;

	@Column(name = "id_user")
	private Integer userId;

	@Column(name = "file_size")
	private int fileSize;

	@Column(name = "file_mime")
	private String fileMime;

	@Column(name = "file_name")
	private String fileName;


	public LegalFile() {
	}

    public LegalFile(int registration, String fileData, int fileType, Date uploadTime, Integer userId, int fileSize, String fileMime, String fileName) {
        this.registration = registration;
        this.fileData = fileData;
        this.fileType = fileType;
        this.uploadTime = uploadTime;
        this.userId = userId;
        this.fileSize = fileSize;
        this.fileMime = fileMime;
        this.fileName = fileName;
    }

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
