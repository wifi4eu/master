package wifi4eu.wifi4eu.abac.data.dto;

import wifi4eu.wifi4eu.abac.data.entity.Country;
import wifi4eu.wifi4eu.abac.data.enums.AbacWorkflowStatus;

public class BAFMonitoringRow {

	private Long id;
    private String countryCode;
    private String accountName;
    private String bafStatus;
    
	public BAFMonitoringRow(Long id, Country country, String bafAccountName, AbacWorkflowStatus bafStatus) {
		super();
		this.setId(id);
		if(country!=null) {
			this.setCountryCode(country.getIso2Code());
		}
		this.setAccountName(bafAccountName);
		this.setBafStatus(bafStatus);
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
	
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getBafStatus() {
		return bafStatus;
	}
	
	public void setBafStatus(String bafStatus) {
		this.bafStatus = bafStatus;
	}
	
	public void setBafStatus(AbacWorkflowStatus bafStatus) {
		if(bafStatus != null) {
			this.bafStatus = bafStatus.getUserInterfaceTitle();
		}
	}
}
