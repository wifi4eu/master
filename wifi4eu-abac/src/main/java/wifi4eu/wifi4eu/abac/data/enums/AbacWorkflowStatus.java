package wifi4eu.wifi4eu.abac.data.enums;

public enum AbacWorkflowStatus {
	IMPORTED("IMPORTED"),
	READY_FOR_ABAC("READY_FOR_ABAC"),
	WAITING_FOR_ABAC("WAITING_FOR_ABAC"),
	WAITING_APPROVAL("WAITING_APPROVAL"),
	ABAC_FINISH("ABAC_FINISH"),
	ABAC_ERROR("ABAC_ERROR"),
	UNMAPPED_STATUS("UNMAPPED_STATUS");

	private String value;

	private AbacWorkflowStatus(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return getValue();
	}
}
