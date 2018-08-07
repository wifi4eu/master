package wifi4eu.wifi4eu.abac.data.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import wifi4eu.wifi4eu.abac.data.enums.AbacWorkflowStatus;

public class MonitoringRow {
	
	private Long id;
	private String countryCode;
	private String municipality;
	private Long registrationNumber; 
	private AbacWorkflowStatus lefStatus;
	private AbacWorkflowStatus bcStatus;
	private AbacWorkflowStatus lcStatus;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date signatureDate;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date counterSignatureDate;
	
	public MonitoringRow() {
	}
	
	public MonitoringRow(Long id, String countryCode, String municipality, Long registrationNumber, AbacWorkflowStatus lefStatus, Date signatureDate) {
		super();
		this.id = id;
		this.countryCode = countryCode;
		this.municipality = municipality;
		this.registrationNumber = registrationNumber;
		this.lefStatus = lefStatus;
		this.bcStatus = null;
		this.lcStatus = null;
		this.signatureDate = signatureDate;
		this.counterSignatureDate = null;
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

	public AbacWorkflowStatus getLefStatus() {
		return lefStatus;
	}

	public void setLefStatus(AbacWorkflowStatus lefStatus) {
		this.lefStatus = lefStatus;
	}

	public AbacWorkflowStatus getBcStatus() {
		return bcStatus;
	}

	public void setBcStatus(AbacWorkflowStatus bcStatus) {
		this.bcStatus = bcStatus;
	}

	public AbacWorkflowStatus getLcStatus() {
		return lcStatus;
	}

	public void setLcStatus(AbacWorkflowStatus lcStatus) {
		this.lcStatus = lcStatus;
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
