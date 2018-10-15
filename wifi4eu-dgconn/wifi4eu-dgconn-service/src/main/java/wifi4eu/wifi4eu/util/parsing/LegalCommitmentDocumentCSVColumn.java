package wifi4eu.wifi4eu.util.parsing;

public enum LegalCommitmentDocumentCSVColumn {

    MUNICIPALITY_ID("mun_id"),

    DOC_NAME("doc_name"),

    DOC_FILE_NAME("doc_fileName");

    private String value;

    LegalCommitmentDocumentCSVColumn(String value) {
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
