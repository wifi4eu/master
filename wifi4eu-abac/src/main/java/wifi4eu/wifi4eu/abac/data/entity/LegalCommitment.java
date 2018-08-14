package wifi4eu.wifi4eu.abac.data.entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import wifi4eu.wifi4eu.abac.data.enums.AbacWorkflowStatus;

@Entity
@Table(name = "WIF_LEGAL_COMMITMENT")
public class LegalCommitment {

	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 18, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lcIDGenerator")
	@SequenceGenerator(name = "lcIDGenerator", sequenceName = "SEQ_LEGAL_COMMITMENT", allocationSize = 1)
	private Integer id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LEGAL_ENTITY_ID")
	private LegalEntity legalEntity;
	
	@Column(name = "abac_id")
	private Long abacId;
	
	@Column(name = "wf_status")
	@Enumerated(EnumType.STRING)
	private AbacWorkflowStatus wfStatus;

	@Column(name = "user_imported")
	private String userImported;
	
	@Column(name = "date_created", length = 20)
	private Date dateCreated;
	
	@Column(name = "date_updated", length = 20)
	private Date dateUpdated;
	
	@Column(name = "countersignature_date", length = 20)
	private Date countersignatureDate;

	@Column(name = "id_countersignature_file")
	private Long idCountersignatureFile;
	
	@Column(name = "user_countersignatured")
	private String userCountersignatured;
	
	public LegalCommitment() {
	}

	public LegalCommitment(Integer id, LegalEntity legalEntity, Long abacId, AbacWorkflowStatus wfStatus,
			String userImported, Date dateCreated, Date dateUpdated, Date countersignatureDate,
			Long idCountersignatureFile, String userCountersignatured) {
		super();
		this.id = id;
		this.legalEntity = legalEntity;
		this.abacId = abacId;
		this.wfStatus = wfStatus;
		this.userImported = userImported;
		this.dateCreated = dateCreated;
		this.dateUpdated = dateUpdated;
		this.countersignatureDate = countersignatureDate;
		this.idCountersignatureFile = idCountersignatureFile;
		this.userCountersignatured = userCountersignatured;
	}

	@PrePersist
	protected void onCreate() {
		this.dateCreated = Calendar.getInstance().getTime();
		this.wfStatus = AbacWorkflowStatus.READY_FOR_ABAC;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LegalEntity getLegalEntity() {
		return legalEntity;
	}

	public void setLegalEntity(LegalEntity legalEntity) {
		this.legalEntity = legalEntity;
	}

	public Long getAbacId() {
		return abacId;
	}

	public void setAbacId(Long abacId) {
		this.abacId = abacId;
	}

	public AbacWorkflowStatus getWfStatus() {
		return wfStatus;
	}

	public void setWfStatus(AbacWorkflowStatus wfStatus) {
		this.wfStatus = wfStatus;
	}

	public String getUserImported() {
		return userImported;
	}

	public void setUserImported(String userImported) {
		this.userImported = userImported;
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

	public Date getCountersignatureDate() {
		return countersignatureDate;
	}

	public void setCountersignatureDate(Date countersignatureDate) {
		this.countersignatureDate = countersignatureDate;
	}

	public Long getIdCountersignatureFile() {
		return idCountersignatureFile;
	}

	public void setIdCountersignatureFile(Long idCountersignatureFile) {
		this.idCountersignatureFile = idCountersignatureFile;
	}

	public String getUserCountersignatured() {
		return userCountersignatured;
	}

	public void setUserCountersignatured(String userCountersignatured) {
		this.userCountersignatured = userCountersignatured;
	}

	@Override
	public String toString() {
		return "LegalCommitment [id=" + id + ", legalEntity=" + legalEntity + ", abacId=" + abacId + ", wfStatus="
				+ wfStatus + ", userImported=" + userImported + ", dateCreated=" + dateCreated + ", dateUpdated="
				+ dateUpdated + ", countersignatureDate=" + countersignatureDate + ", idCountersignatureFile="
				+ idCountersignatureFile + ", userCountersignatured=" + userCountersignatured + "]";
	}
}