package wifi4eu.wifi4eu.abac.data.enums;

public enum AbacWorkflowStatus {
	
	IMPORTED("IMPORTED", "Imported"),
	READY_FOR_ABAC("READY_FOR_ABAC", "Ready for ABAC"),
	WAITING_FOR_ABAC("WAITING_FOR_ABAC", "Waiting to be sent to ABAC"),
	WAITING_APPROVAL("WAITING_APPROVAL", "Waiting for approval"),
	ABAC_FINISH("ABAC_FINISH", "Sent to ABAC"),
	ABAC_ERROR("ABAC_ERROR", "Error sending to ABAC"),
    ABAC_VALID("ABAC_VALID", "Validated in ABAC"),
    ABAC_REJECTED("ABAC_REJECTED", "Rejected in ABAC"),
	UNMAPPED_STATUS("UNMAPPED_STATUS", "Unknown status");

	private String value;
	private String title;

	private AbacWorkflowStatus(String value, String title) {
		this.value = value;
		this.title = title;
	}

	public String getValue() {
		return value;
	}
	
	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return getValue();
	}
}
