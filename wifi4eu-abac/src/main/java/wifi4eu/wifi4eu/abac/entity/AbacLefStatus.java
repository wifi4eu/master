package wifi4eu.wifi4eu.abac.entity;

import org.hibernate.annotations.Immutable;
import wifi4eu.wifi4eu.abac.service.AbacWorkflowStatusEnum;

import javax.persistence.*;

@Immutable
@Entity
@Table(name="WIF_ABAC_LEF_STATUS_VIEW")
public class AbacLefStatus {

	@Id
	@Column(name = "LOC_OBJ_FOREIGN_ID")
	private String locObjForeignId;

	@Column(name = "STATUS")
	@Enumerated(EnumType.STRING)
	private AbacWorkflowStatusEnum status;

	@Column(name = "LE_KEY")
	private String legalEntityKey;

	@Column(name = "ERROR_MESSAGE")
	private String errorMessage;

	public String getLocObjForeignId() {
		return locObjForeignId;
	}

	public void setLocObjForeignId(String locObjForeignId) {
		this.locObjForeignId = locObjForeignId;
	}

	public AbacWorkflowStatusEnum getStatus() {
		return status;
	}

	public void setStatus(AbacWorkflowStatusEnum status) {
		this.status = status;
	}

	public String getLegalEntityKey() {
		return legalEntityKey;
	}

	public void setLegalEntityKey(String legalEntityKey) {
		this.legalEntityKey = legalEntityKey;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
