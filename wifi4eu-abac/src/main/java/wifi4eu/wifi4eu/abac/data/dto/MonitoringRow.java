package wifi4eu.wifi4eu.abac.data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import wifi4eu.wifi4eu.abac.data.entity.Country;
import wifi4eu.wifi4eu.abac.data.enums.AbacWorkflowStatus;
import wifi4eu.wifi4eu.abac.data.enums.LegalCommitmentWorkflowStatus;

import java.util.Date;

public class MonitoringRow {
	
	private Long id;
	private String countryCode;
	private String municipality;
	private Long registrationNumber;
	private String lefStatus;
	private String lefAbacRef;
	private String bcStatus;
	private String bcAbacRef;
	private String lcStatus;
	private String lcAbacRef;
	private String lefDocAresRef;
	private String lcDocAresRef;
	private Boolean readyToBeCounterSigned;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date signatureDate;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date counterSignatureDate;
	
	public MonitoringRow() {
	}
	
	public MonitoringRow(
		Long id, Country country, String municipality, Long registrationNumber,
		AbacWorkflowStatus lefStatus, String lefAbacRef,
		AbacWorkflowStatus bcStatus, String bcAbacRef,
		LegalCommitmentWorkflowStatus lcStatus, String lcAbacRef,
		Date signatureDate, Date counterSignatureDate,
		String lefDocAresRef, String lcDocAresRef
	) {
		super();
		this.setId(id);
		if(country != null){
			this.setCountryCode(country.getIso2Code());
		}
		this.setMunicipality(municipality);
		this.setRegistrationNumber(registrationNumber);
		this.setLefStatus(lefStatus);
		this.setLefAbacRef(lefAbacRef);
		this.setBcStatus(bcStatus);
		this.setBcAbacRef(bcAbacRef);
		this.setLcStatus(lcStatus);
		this.setLcAbacRef(lcAbacRef);
		this.setLefDocAresRef(lefDocAresRef);
		this.setLcDocAresRef(lcDocAresRef);
		this.setSignatureDate(signatureDate);
		this.setCounterSignatureDate(counterSignatureDate);
		calculateReadyToBeCounterSigned();
	}

	private void calculateReadyToBeCounterSigned() {
		readyToBeCounterSigned = this.lcStatus != null && this.lcStatus.equals(LegalCommitmentWorkflowStatus.READY_TO_BE_COUNTERSIGNED.getUserInterfaceTitle());
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
		if(lefStatus != null) {
			this.lefStatus = lefStatus.getUserInterfaceTitle();
		}
	}

	public String getBcStatus() {
		return bcStatus;
	}

	public void setBcStatus(String bcStatus) {
		this.bcStatus = bcStatus;
	}
	
	public void setBcStatus(AbacWorkflowStatus bcStatus) {
		if(bcStatus != null) {
			this.bcStatus = bcStatus.getUserInterfaceTitle();
		}
	}

	public String getLcStatus() {
		return lcStatus;
	}

	public void setLcStatus(String lcStatus) {
		this.lcStatus = lcStatus;
	}
	
	public void setLcStatus(LegalCommitmentWorkflowStatus lcStatus) {
		if(lcStatus != null) {
			this.lcStatus = lcStatus.getUserInterfaceTitle();
		}
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

	public Boolean getReadyToBeCounterSigned() {
		return readyToBeCounterSigned;
	}

	public void setReadyToBeCounterSigned(Boolean readyToBeCounterSigned) {
		this.readyToBeCounterSigned = readyToBeCounterSigned;
	}

	public String getLefAbacRef() {
		return lefAbacRef;
	}

	public void setLefAbacRef(String lefAbacRef) {
		this.lefAbacRef = lefAbacRef;
	}

	public String getBcAbacRef() {
		return bcAbacRef;
	}

	public void setBcAbacRef(String bcAbacRef) {
		this.bcAbacRef = bcAbacRef;
	}

	public String getLcAbacRef() {
		return lcAbacRef;
	}

	public void setLcAbacRef(String lcAbacRef) {
		this.lcAbacRef = lcAbacRef;
	}

	public String getLefDocAresRef() {
		return lefDocAresRef;
	}

	public void setLefDocAresRef(String lefDocAresRef) {
		this.lefDocAresRef = lefDocAresRef;
	}

	public String getLcDocAresRef() {
		return lcDocAresRef;
	}

	public void setLcDocAresRef(String lcDocAresRef) {
		this.lcDocAresRef = lcDocAresRef;
	}
	
}
