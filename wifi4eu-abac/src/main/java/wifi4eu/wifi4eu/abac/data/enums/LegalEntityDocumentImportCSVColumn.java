package wifi4eu.wifi4eu.abac.data.enums;

public enum LegalEntityDocumentImportCSVColumn {

	MUNICIPALITY_PORTAL_ID("mun_id"),
	DOCUMENT_PORTAL_ID("doc_portalId"),
	DOCUMENT_NAME("doc_Name"),
   	DOCUMENT_FILENAME("doc_fileName"),
	DOCUMENT_MIMETYPE("doc_mimeType"),
	DOCUMENT_DATE("doc_date"),
	DOCUMENT_TYPE("doc_type");

	private String value;

	private LegalEntityDocumentImportCSVColumn(String value) {
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
