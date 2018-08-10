package wifi4eu.wifi4eu.abac.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import wifi4eu.wifi4eu.abac.data.enums.AbacWorkflowStatus;

@Entity
@Table(name = "WIF_LEGAL_COMMITMENT")
public class LegalCommitment {

	@Id
	private Integer id;

	@Column(name = "wf_status")
	@Enumerated(EnumType.STRING)
	private AbacWorkflowStatus wfStatus;

	@Column(name = "date_created", length = 20)
	private Date dateCreated;

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

	@Override
	public String toString() {
		return "LegalCommitment [id=" + id + ", wfStatus=" + wfStatus + ", dateCreated=" + dateCreated + "]";
	}

}