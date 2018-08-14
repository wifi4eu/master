package wifi4eu.wifi4eu.abac.data.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import wifi4eu.wifi4eu.abac.data.entity.LegalEntity;
import wifi4eu.wifi4eu.abac.data.enums.AbacWorkflowStatus;

public class MonitoringRow {
	
	private Long id;
	private String countryCode;
	private String municipality;
	private Long registrationNumber;
	private String lefStatus;
	private String bcStatus;
	private String lcStatus;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date signatureDate;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date counterSignatureDate;
	
	public MonitoringRow() {
	}
	
	public MonitoringRow(LegalEntity le) {
		if(le != null) {
			this.setId(le.getId());
			if(le.getCountry() != null) {
				this.setCountryCode(le.getCountry().getIso2Code());
			}
			this.setMunicipality(le.getOfficialName());
			this.setRegistrationNumber(le.getRegistrationNumber());
			this.setSignatureDate(le.getSignatureDate());
			this.setLefStatus(le.getWfStatus());
			if(le.getBudgetaryCommitment() != null) {
				this.setBcStatus(le.getBudgetaryCommitment().getWfStatus());
			}
			if(le.getLegalCommitment() != null) {
				this.setLcStatus(le.getLegalCommitment().getWfStatus());
			}
		}
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getMunicipality() {
		return municipality;
	}

	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

	public Long getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(Long registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getLefStatus() {
		return lefStatus;
	}

	public void setLefStatus(String lefStatus) {
		this.lefStatus = lefStatus;
	}
	
	public void setLefStatus(AbacWorkflowStatus lefStatus) {
		this.lefStatus = lefStatus.getTitle();
	}

	public String getBcStatus() {
		return bcStatus;
	}

	public void setBcStatus(String bcStatus) {
		this.bcStatus = bcStatus;
	}
	
	public void setBcStatus(AbacWorkflowStatus bcStatus) {
		this.bcStatus = bcStatus.getTitle();
	}

	public String getLcStatus() {
		return lcStatus;
	}

	public void setLcStatus(String lcStatus) {
		this.lcStatus = lcStatus;
	}
	
	public void setLcStatus(AbacWorkflowStatus lcStatus) {
		this.lcStatus = lcStatus.getTitle();
	}

	public Date getSignatureDate() {
		return signatureDate;
	}

	public void setSignatureDate(Date signatureDate) {
		this.signatureDate = signatureDate;
	}

	public Date getCounterSignatureDate() {
		return counterSignatureDate;
	}

	public void setCounterSignatureDate(Date counterSignatureDate) {
		this.counterSignatureDate = counterSignatureDate;
	}

}
