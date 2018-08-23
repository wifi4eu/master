package wifi4eu.wifi4eu.abac.data.enums;

public enum LegalCommitmentImportCSVColumn {

	MUNICIPALITY_PORTAL_ID("mun_id"),
	GRANT_AGREEMENT_SIGNATURE_DATE("ga_signatureDate"),
	GRANT_AGREEMENT_COUNTERSIGNATURE_DATE("ga_counterSignatureDate"),
	ABAC_STATUS("lc_abacStatus"),
	ABAC_MESSAGE("abac_message"),
	ABAC_KEY("abac_key");
	
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
