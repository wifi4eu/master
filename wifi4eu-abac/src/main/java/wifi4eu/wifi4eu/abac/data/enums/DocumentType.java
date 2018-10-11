package wifi4eu.wifi4eu.abac.data.enums;

public enum DocumentType {
	GRANT_AGREEMENT("GRANT_AGREEMENT", "Grant agreement n° %s/Wifi4EU/Call n° %d - 2018/identifying n° %d/%s/%s"),
	COUNTERSIGNED_GRANT_AGREEMENT("COUNTERSIGNED_GRANT_AGREEMENT", "Grant agreement n° %s/Wifi4EU/Call n° %d - 2018/identifying n° %d/%s/%s"),
	IDENTIFICATION_FORM("IDENTIFICATION_FORM", "LEF supporting document for Wifi4EU grant agreement n° %s/Wifi4EU/Call n° %d - 2018/identifying n° %d/%s/%s"),
	BANK_ACCOUNT_IDENTIFICATION_FORM("BANK_ACCOUNT_IDENTIFICATION_FORM", "BAF Identification Form");

	private String value;
	private String userInterfacePattern;

	DocumentType(String value, String userInterfacePattern) {
		this.value = value;
		this.userInterfacePattern = userInterfacePattern;
	}

	public String getValue() {
		return value;
	}

	public String getUserInterfacePattern() {
		return userInterfacePattern;
	}

	@Override
	public String toString() {
		return getValue();
	}
}
