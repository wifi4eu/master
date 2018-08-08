package wifi4eu.wifi4eu.abac.data.dto;

import java.util.Date;

public interface IMonitoringRowProjection {
	
	Long getId();
	String getCountryCode();
	String getMunicipality();
	Long getRegistrationNumber();
	Date getSignatureDate();
	String getLEFStatus();
	String getBCStatus();
	String getLCStatus();
}
