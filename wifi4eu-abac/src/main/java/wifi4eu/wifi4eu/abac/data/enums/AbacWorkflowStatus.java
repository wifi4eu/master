package wifi4eu.wifi4eu.abac.data.enums;

public enum AbacWorkflowStatus {
	
	IMPORTED("IMPORTED", "Imported"),
	WAITING_FOR_ARES("WAITING_FOR_ARES", "Waiting for ARES reference"),
	READY_FOR_ABAC("READY_FOR_ABAC", "Imported"),
	WAITING_FOR_ABAC("WAITING_FOR_ABAC", "Imported"),
	WAITING_APPROVAL("WAITING_APPROVAL", "Wating ABAC Validation"),
	ABAC_ERROR("ABAC_ERROR", "Error sending to ABAC"),
    ABAC_VALID("ABAC_VALID", "Validated in ABAC"),
    ABAC_REJECTED("ABAC_REJECTED", "Rejected in ABAC"),
	UNMAPPED_STATUS("UNMAPPED_STATUS", "Unknown status");

	private String value;
	private String userInterfaceTitle;

	private AbacWorkflowStatus(String value, String userInterfaceTitle) {
		this.value = value;
		this.userInterfaceTitle = userInterfaceTitle;
	}

	public String getValue() {
		return value;
	}
	
	public String getUserInterfaceTitle() {
		return userInterfaceTitle;
	}

	@Override
	public String toString() {
		return getValue();
	}
}
