package wifi4eu.wifi4eu.abac.data.dto;

public class FileDTO {

	private String fileName;
	private Long size;
	byte[] content;

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
}
