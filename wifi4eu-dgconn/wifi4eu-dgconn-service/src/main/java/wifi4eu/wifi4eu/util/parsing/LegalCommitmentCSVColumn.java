package wifi4eu.wifi4eu.util.parsing;

public enum LegalCommitmentCSVColumn {

    MUNICIPALITY_ID("mun_id"),

    ABAC_STATUS("lc_abacStatus"),

    SIGNATURE_DATE("ga_signatureDate"),

    COUNTERSIGNATURE_DATE("ga_counterSignatureDate"),

    ABAC_KEY("abac_key");

    private String value;

    LegalCommitmentCSVColumn(String value) {
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
