package wifi4eu.wifi4eu.abac.data.enums;

public enum DocumentType {
	GRANT_AGREEMENT_SIGNATURE("GRANT_AGREEMENT_SIGNATURE");

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
