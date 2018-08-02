package wifi4eu.wifi4eu.abac.data.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import wifi4eu.wifi4eu.abac.data.enums.AbacWorkflowStatusEnum;

public class MonitoringRow {
	
	private Long id;
	private String countryCode;
	private String municipality;
	private Long registrationNumber; 
	private AbacWorkflowStatusEnum lefStatus;
	private AbacWorkflowStatusEnum bcStatus;
	private AbacWorkflowStatusEnum lcStatus;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date signatureDate;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date counterSignatureDate;
	
	public MonitoringRow() {
	}
	
	public MonitoringRow(Long id, String countryCode, String municipality, Long registrationNumber, AbacWorkflowStatusEnum lefStatus, Date signatureDate) {
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

	public AbacWorkflowStatusEnum getLefStatus() {
		return lefStatus;
	}

	public void setLefStatus(AbacWorkflowStatusEnum lefStatus) {
		this.lefStatus = lefStatus;
	}

	public AbacWorkflowStatusEnum getBcStatus() {
		return bcStatus;
	}

	public void setBcStatus(AbacWorkflowStatusEnum bcStatus) {
		this.bcStatus = bcStatus;
	}

	public AbacWorkflowStatusEnum getLcStatus() {
		return lcStatus;
	}

	public void setLcStatus(AbacWorkflowStatusEnum lcStatus) {
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
