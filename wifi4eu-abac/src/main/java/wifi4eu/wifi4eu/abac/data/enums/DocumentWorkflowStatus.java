package wifi4eu.wifi4eu.abac.data.enums;

public enum DocumentWorkflowStatus {

	IMPORTED("IMPORTED", "Imported"),
	COUNTERSIGNATURE_REQUESTED("COUNTERSIGNATURE_REQUESTED", "Counter Signature Requested"),
	COUNTERSIGNED("COUNTERSIGNED", "Counter Signed"),
	ARCHIVED_IN_ARES("ARCHIVED_IN_ARES", "Created and registered in ARES"),
	ARES_ERROR("ARES_ERROR", "Error creating in ARES"),
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
