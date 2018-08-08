package wifi4eu.wifi4eu.abac.data.enums;

public enum DocWorkflowStatus {

	IMPORTED("IMPORTED", "Imported"),
	SIGNED("SIGNED", "Signed"),
	ARCHIVED_IN_ARES("ARCHIVED_IN_ARES", "Created and registered in ARES"),
	UNMAPPED_STATUS("UNMAPPED_STATUS", "Unknown status");

	private String value;
	private String title;

	private DocWorkflowStatus(String value, String title) {
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
