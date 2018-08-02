package wifi4eu.wifi4eu.abac.entity;

public class ExportFile {
	private String mimetype;
	private String filename;
	private byte[] data;

	public ExportFile() {

	}

	public String getMimetype() {
		return mimetype;
	}

	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

}
