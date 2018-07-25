package wifi4eu.wifi4eu.abac.service;

public enum AbacWorkflowStatusEnum {
	IMPORTED("IMPORTED"),
	READY_FOR_ABAC("READY_FOR_ABAC"),
	WAITING_FOR_ABAC("WAITING_FOR_ABAC"),
	ABAC_PROCESSED_WAITING_APPROVAL("ABAC_PROCESSED_WAITING_APPROVAL"),
	ABAC_FINISH("ABAC_FINISH"),
	ABAC_ERROR("ABAC_ERROR");

	private String value;

	private AbacWorkflowStatusEnum(String value) {
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
