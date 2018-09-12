package wifi4eu.wifi4eu.abac.data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import wifi4eu.wifi4eu.abac.data.entity.BudgetaryCommitment;
import wifi4eu.wifi4eu.abac.data.entity.Document;
import wifi4eu.wifi4eu.abac.data.entity.LegalCommitment;
import wifi4eu.wifi4eu.abac.data.entity.LegalEntity;
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
	private String docAresRef;
	private Boolean readyToBeCounterSigned;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date signatureDate;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date counterSignatureDate;
	
	public MonitoringRow() {
	}
	
	public MonitoringRow(LegalEntity legalEntity, BudgetaryCommitment budgetaryCommitment, LegalCommitment legalCommitment, Document doc) {

		//Legal Entity data
		if(legalEntity != null) {
			this.setId(legalEntity.getId());
			if (legalEntity.getCountry() != null) {
				this.setCountryCode(legalEntity.getCountry().getIso2Code());
			}
			this.setMunicipality(legalEntity.getOfficialName());
			this.setRegistrationNumber(legalEntity.getRegistrationNumber());
			this.setSignatureDate(legalEntity.getSignatureDate());
			this.setLefStatus(legalEntity.getWfStatus());
			this.setLefAbacRef(legalEntity.getAbacFelId());
		}

		//Budgetary Commitment Data
		if(budgetaryCommitment != null) {
			this.setBcStatus(budgetaryCommitment.getWfStatus());
			this.setBcAbacRef(budgetaryCommitment.getCommitmentLevel2Key());
		}

		//Legal Commitment Data
		if(legalCommitment != null) {
			this.setLcStatus(legalCommitment.getWfStatus());
			this.setSignatureDate(legalCommitment.getGrantAgreementSignatureDate());
			this.setCounterSignatureDate(legalCommitment.getGrantAgreementCounterSignatureDate());
			this.setLcAbacRef(legalCommitment.getAbacKey());
		}
		
		if(doc != null) {
			this.setDocAresRef(doc.getAresReference());
		}

		readyToBeCounterSigned = legalCommitment != null && legalCommitment.getWfStatus().equals(LegalCommitmentWorkflowStatus.READY_TO_BE_COUNTERSIGNED);
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
		this.lefStatus = lefStatus.getUserInterfaceTitle();
	}

	public String getBcStatus() {
		return bcStatus;
	}

	public void setBcStatus(String bcStatus) {
		this.bcStatus = bcStatus;
	}
	
	public void setBcStatus(AbacWorkflowStatus bcStatus) {
		this.bcStatus = bcStatus.getUserInterfaceTitle();
	}

	public String getLcStatus() {
		return lcStatus;
	}

	public void setLcStatus(String lcStatus) {
		this.lcStatus = lcStatus;
	}
	
	public void setLcStatus(LegalCommitmentWorkflowStatus lcStatus) {
		this.lcStatus = lcStatus.getUserInterfaceTitle();
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

	public String getDocAresRef() {
		return docAresRef;
	}

	public void setDocAresRef(String docAresRef) {
		this.docAresRef = docAresRef;
	}
	
}
