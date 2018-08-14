package wifi4eu.wifi4eu.abac.data.enums;

public enum LegalCommitmentImportCSVColumn {

	MUNICIPALITY_PORTAL_ID("mun_id");
	
	private String value;

	private LegalCommitmentImportCSVColumn(String value) {
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
