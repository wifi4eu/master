package wifi4eu.wifi4eu.abac.data.enums;

public enum DocumentType {
	GRANT_AGREEMENT("GRANT_AGREEMENT"),
	COUNTERSIGNED_GRANT_AGREEMENT("COUNTERSIGNED_GRANT_AGREEMENT"),
	IDENTIFICATION_FORM("IDENTIFICATION_FORM");

	private String value;

	DocumentType(String value) {
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
