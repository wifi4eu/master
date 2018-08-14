package wifi4eu.wifi4eu.abac.data.enums;

public enum DocumentWorkflowStatus {

	IMPORTED("IMPORTED", "Imported"),
	WAITING_COUNTERSIGNATURE("WAITING_COUNTERSIGNATURE", "Waiting for Counter Signature"),
	COUNTERSIGNED("COUNTERSIGNED", "Counter Signed"),
	ARCHIVED_IN_ARES("ARCHIVED_IN_ARES", "Created and registered in ARES"),
	UNMAPPED_STATUS("UNMAPPED_STATUS", "Unknown status");

	private String value;
	private String title;

	private DocumentWorkflowStatus(String value, String title) {
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
