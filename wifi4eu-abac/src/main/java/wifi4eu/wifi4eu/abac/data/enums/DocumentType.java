package wifi4eu.wifi4eu.abac.data.enums;

public enum DocumentType {
	GRANT_AGREEMENT("GRANT_AGREEMENT", "Grant Agreement"),
	COUNTERSIGNED_GRANT_AGREEMENT("COUNTERSIGNED_GRANT_AGREEMENT", "Countersigned Grant Agreement"),
	IDENTIFICATION_FORM("IDENTIFICATION_FORM", "Identification Form");

	private String value;
	private String userInterfaceTitle;

	DocumentType(String value, String userInterfaceTitle) {
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
