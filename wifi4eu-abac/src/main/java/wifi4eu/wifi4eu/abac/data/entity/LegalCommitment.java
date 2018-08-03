package wifi4eu.wifi4eu.abac.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WIF_LEGAL_COMMITMENT")
public class LegalCommitment {

	@Id
	private Integer id;

	@Column(name = "wf_status", length = 20)
	private String wfStatus;

	@Column(name = "date_created", length = 20)
	private String dateCreated;

	public LegalCommitment() {
	}

	public LegalCommitment(Integer id, String wfStatus, String dateCreated) {
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

	public String getWfStatus() {
		return wfStatus;
	}

	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return "LegalCommitment [id=" + id + ", wfStatus=" + wfStatus + ", dateCreated=" + dateCreated + "]";
	}

}