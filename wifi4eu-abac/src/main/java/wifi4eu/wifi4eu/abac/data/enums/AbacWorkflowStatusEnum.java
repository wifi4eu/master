package wifi4eu.wifi4eu.abac.data.enums;

public enum AbacWorkflowStatusEnum {
	
	IMPORTED("IMPORTED", "Imported"),
	READY_FOR_ABAC("READY_FOR_ABAC", "Ready for ABAC"),
	WAITING_FOR_ABAC("WAITING_FOR_ABAC", "Waiting for ABAC"),
	WAITING_APPROVAL("WAITING_APPROVAL", "Waiting approval"),
	ABAC_FINISH("ABAC_FINISH", "Validated in ABAC"),
	ABAC_ERROR("ABAC_ERROR", "Error in ABAC"),
	UNMAPPED_STATUS("UNMAPPED_STATUS", "Unknown");

	private String value;
	private String title;

	private AbacWorkflowStatusEnum(String value, String title) {
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
