package wifi4eu.wifi4eu.entity.exportImport;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExportFile {

	@Id
	private Integer id;

	private String filename;

	private byte[] data;

	public ExportFile() {

	}

	public ExportFile(String filename, byte[] data) {
		super();
		this.filename = filename;
		this.data = data;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
