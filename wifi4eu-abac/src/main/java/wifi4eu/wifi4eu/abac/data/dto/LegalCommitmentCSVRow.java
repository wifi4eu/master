package wifi4eu.wifi4eu.abac.data.dto;

import java.util.Date;

public class LegalCommitmentCSVRow {
	
	private Long municipalityPortalId;
	private Date countersignatureDate;
	
	public Long getMunicipalityPortalId() {
		return municipalityPortalId;
	}
	public void setMunicipalityPortalId(Long municipalityPortalId) {
		this.municipalityPortalId = municipalityPortalId;
	}
	public Date getCountersignatureDate() {
		return countersignatureDate;
	}
	public void setCountersignatureDate(Date countersignatureDate) {
		this.countersignatureDate = countersignatureDate;
	}
}
