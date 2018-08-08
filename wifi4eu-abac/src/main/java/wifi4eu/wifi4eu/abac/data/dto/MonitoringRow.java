package wifi4eu.wifi4eu.abac.data.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import wifi4eu.wifi4eu.abac.data.enums.AbacWorkflowStatusEnum;

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
	
	public MonitoringRow(IMonitoringRowProjection data) {
		if(data != null) {
			this.setId(data.getId());
			this.setCountryCode(data.getCountryCode());
			this.setMunicipality(data.getMunicipality());
			this.setRegistrationNumber(data.getRegistrationNumber());
			this.setSignatureDate(data.getSignatureDate());
			try {
				if(data.getLEFStatus() != null) {
					this.setLefStatus(AbacWorkflowStatusEnum.valueOf(data.getLEFStatus()).getTitle());
				}
			}catch(IllegalArgumentException e) {
				this.setLefStatus(AbacWorkflowStatusEnum.UNMAPPED_STATUS.getTitle());
			}
			try {
				if(data.getBCStatus() != null) {
					this.setBcStatus(AbacWorkflowStatusEnum.valueOf(data.getBCStatus()).getTitle());
				}
			}catch(IllegalArgumentException e) {
				this.setBcStatus(AbacWorkflowStatusEnum.UNMAPPED_STATUS.getTitle());
			}
			try {
				if(data.getLCStatus() != null) {
					this.setLcStatus(AbacWorkflowStatusEnum.valueOf(data.getLCStatus()).getTitle());
				}
			}catch(IllegalArgumentException e) {
				this.setLcStatus(AbacWorkflowStatusEnum.UNMAPPED_STATUS.getTitle());
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
	
	public void setLefStatus(AbacWorkflowStatusEnum lefStatus) {
		this.lefStatus = lefStatus.getTitle();
	}

	public String getBcStatus() {
		return bcStatus;
	}

	public void setBcStatus(String bcStatus) {
		this.bcStatus = bcStatus;
	}
	
	public void setBcStatus(AbacWorkflowStatusEnum bcStatus) {
		this.bcStatus = bcStatus.getTitle();
	}

	public String getLcStatus() {
		return lcStatus;
	}

	public void setLcStatus(String lcStatus) {
		this.lcStatus = lcStatus;
	}
	
	public void setLcStatus(AbacWorkflowStatusEnum lcStatus) {
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
