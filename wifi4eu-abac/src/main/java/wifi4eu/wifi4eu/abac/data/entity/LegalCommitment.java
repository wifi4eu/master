package wifi4eu.wifi4eu.abac.data.entity;

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
import javax.persistence.ManyToOne;
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

	@Column(name = "wf_status")
	@Enumerated(EnumType.STRING)
	private AbacWorkflowStatus wfStatus;

	@Column(name = "date_created", length = 20)
	private Date dateCreated;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_LE")
	private LegalEntity legalEntity;
	
	public LegalCommitment() {
	}

	public LegalCommitment(Integer id, AbacWorkflowStatus wfStatus, Date dateCreated) {
		super();
		this.id = id;
		this.wfStatus = wfStatus;
		this.dateCreated = dateCreated;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AbacWorkflowStatus getWfStatus() {
		return wfStatus;
	}

	public void setWfStatus(AbacWorkflowStatus wfStatus) {
		this.wfStatus = wfStatus;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public LegalEntity getLegalEntity() {
		return legalEntity;
	}

	public void setLegalEntity(LegalEntity legalEntity) {
		this.legalEntity = legalEntity;
	}

	@Override
	public String toString() {
		return "LegalCommitment [id=" + id + ", wfStatus=" + wfStatus + ", dateCreated=" + dateCreated + "]";
	}

}