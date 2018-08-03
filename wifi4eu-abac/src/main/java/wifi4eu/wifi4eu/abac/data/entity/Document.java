package wifi4eu.wifi4eu.abac.data.entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import wifi4eu.wifi4eu.abac.data.enums.AbacWorkflowStatusEnum;

@Entity
@Table(name = "WIF_DOCUMENTS")
public class Document {
	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 18, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "docIDGenerator")
	@SequenceGenerator(name = "docIDGenerator", sequenceName = "SEQ_DOCUMENTS", allocationSize = 1)
	private Long id;

	@Column(name = "name", length = 400)
	private String name;

	@Lob
	@Column(name = "data")
	private byte[] data;

	@Column(name = "ares_reference", length = 50)
	private String aresReference;

	@Column(name = "ares_date")
	private Date aresDate;

	@Column(name = "size")
	private Long size;

	@Column(name = "mimetypecity", length = 50)
	private String mimetype;

	@Column(name = "wf_status", length = 20)
	@Enumerated(EnumType.STRING)
	private AbacWorkflowStatusEnum wfStatus;

	@Column(name = "date_created", length = 20)
	private Date dateCreated;

	@Column(name = "date_updated", length = 20)
	private Date dateUpdated;

	public Document() {

	}

	public Document(Long id, String name, byte[] data, String aresReference, Date aresDate, Long size, String mimetype,
			AbacWorkflowStatusEnum wfStatus, Date dateCreated, Date dateUpdated) {
		super();
		this.id = id;
		this.name = name;
		this.data = data;
		this.aresReference = aresReference;
		this.aresDate = aresDate;
		this.size = size;
		this.mimetype = mimetype;
		this.wfStatus = wfStatus;
		this.dateCreated = dateCreated;
		this.dateUpdated = dateUpdated;
	}

	@PrePersist
	protected void onCreate() {
		this.dateCreated = Calendar.getInstance().getTime();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getAresReference() {
		return aresReference;
	}

	public void setAresReference(String aresReference) {
		this.aresReference = aresReference;
	}

	public Date getAresDate() {
		return aresDate;
	}

	public void setAresDate(Date aresDate) {
		this.aresDate = aresDate;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getMimetype() {
		return mimetype;
	}

	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}

	public AbacWorkflowStatusEnum getWfStatus() {
		return wfStatus;
	}

	public void setWfStatus(AbacWorkflowStatusEnum wfStatus) {
		this.wfStatus = wfStatus;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

}