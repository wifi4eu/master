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
	private Long fileSize;

	@Column(name = "file_mime")
	private Long fileMime;

	@Column(name = "file_name")
	private Long fileName;


	public LegalFile() {
	}

    public LegalFile(int registration, String fileData, int fileType, Date uploadTime, Integer userId, Long fileSize, Long fileMime, Long fileName) {
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

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public Long getFileMime() {
        return fileMime;
    }

    public void setFileMime(Long fileMime) {
        this.fileMime = fileMime;
    }

    public Long getFileName() {
        return fileName;
    }

    public void setFileName(Long fileName) {
        this.fileName = fileName;
    }
}
