package wifi4eu.wifi4eu.abac.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import wifi4eu.wifi4eu.abac.service.AbacWorkflowStatusEnum;

public class MonitoringRow {
	
	private Long id;
	private String countryCode;
	private String municipality;
	private Long registrationNumber; 
	private AbacWorkflowStatusEnum wfStatus;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date signatureDate;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date counterSignatureDate;
	
	public MonitoringRow() {
	}
	
	public MonitoringRow(Long id, String countryCode, String municipality, Long registrationNumber, AbacWorkflowStatusEnum wfStatus, Date signatureDate) {
		super();
		this.id = id;
		this.countryCode = countryCode;
		this.municipality = municipality;
		this.registrationNumber = registrationNumber;
		this.wfStatus = wfStatus;
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

	public AbacWorkflowStatusEnum getWfStatus() {
		return wfStatus;
	}

	public void setWfStatus(AbacWorkflowStatusEnum wfStatus) {
		this.wfStatus = wfStatus;
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
