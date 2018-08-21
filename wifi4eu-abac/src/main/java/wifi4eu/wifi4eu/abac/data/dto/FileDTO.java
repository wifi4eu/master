package wifi4eu.wifi4eu.abac.data.dto;

public class FileDTO {

	private String fileName;
	private FileType fileType;
	private Long size;
	byte[] content;

	public FileDTO() {

	}

	public FileDTO(String fileName, Long size, byte[] content) {
		this.fileName = fileName;
		this.size = size;
		this.content = content;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public FileType getFileType() {
		return fileType;
	}

	public void setFileType(FileType fileType) {
		this.fileType = fileType;
	}

	public enum FileType{
		LEGAL_ENTITY_INFORMATION_CSV,
		LEGAL_ENTITY_DOCUMENTS_CSV
	}
}
