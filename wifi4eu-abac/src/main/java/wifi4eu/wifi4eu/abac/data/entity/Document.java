package wifi4eu.wifi4eu.abac.data.entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;

import wifi4eu.wifi4eu.abac.data.enums.AbacWorkflowStatus;
import wifi4eu.wifi4eu.abac.data.enums.DocWorkflowStatus;
import wifi4eu.wifi4eu.abac.data.enums.DocumentType;

@Entity
@Table(name = "WIF_DOCUMENTS")
public class Document {
	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 18, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "docIDGenerator")
	@SequenceGenerator(name = "docIDGenerator", sequenceName = "SEQ_DOCUMENT", allocationSize = 1)
	private Long id;

	@Column(name = "portal_id")
	private Long portalId;

	@Column(name="file_name")
	private String fileName;

	@Column(name="portal_date")
	private Date portalDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="LEGAL_ENTITY_ID")
	private LegalEntity legalEntity;

	@Column(name = "name", length = 400)
	private String name;

	@Lob
	@Column(name = "data")
	private byte[] data;

	@Column(name = "ares_reference", length = 50)
	private String aresReference;

	@Column(name = "ares_date")
	private Date aresDate;

	@Column(name = "file_size")
	private Long size;

	@Column(name = "mimetype", length = 50)
	private String mimetype;

	@Column(name = "wf_status", length = 20)
	@Enumerated(EnumType.STRING)
	private DocWorkflowStatus wfStatus;

	@Column(name = "date_created", length = 20)
	private Date dateCreated;

	@Column(name = "date_updated", length = 20)
	private Date dateUpdated;

	@Column(name = "document_type")
	@Enumerated
	private DocumentType type;

	@PrePersist
	protected void onCreate() {
		this.dateCreated = Calendar.getInstance().getTime();
		this.wfStatus = DocWorkflowStatus.IMPORTED;
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

	public DocWorkflowStatus getWfStatus() {
		return wfStatus;
	}

	public void setWfStatus(DocWorkflowStatus wfStatus) {
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

	public DocumentType getType() {
		return type;
	}

	public void setType(DocumentType type) {
		this.type = type;
	}

	public Long getPortalId() {
		return portalId;
	}

	public void setPortalId(Long portalId) {
		this.portalId = portalId;
	}

	public LegalEntity getLegalEntity() {
		return legalEntity;
	}

	public void setLegalEntity(LegalEntity legalEntity) {
		this.legalEntity = legalEntity;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getPortalDate() {
		return portalDate;
	}

	public void setPortalDate(Date portalDate) {
		this.portalDate = portalDate;
	}
}