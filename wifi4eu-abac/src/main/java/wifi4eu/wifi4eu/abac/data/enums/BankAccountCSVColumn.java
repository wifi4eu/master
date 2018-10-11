package wifi4eu.wifi4eu.abac.data.enums;

public enum BankAccountCSVColumn {

	BANK_ACCOUNT_PORTAL_ID("baf_id"),
	BANK_ACCOUNT_NAME("baf_account_name"),
	BANK_ACCOUNT_ADDRESS("baf_address"),
	BANK_ACCOUNT_CITY("baf_city"),
	BANK_ACCOUNT_COUNTRY_CODE("baf_countryCodeISO"),
	BANK_ACCOUNT_POSTAL_CODE("mun_postalCode"),
	BANK_ACCOUNT_BANK_NAME("baf_bank_name"),
	BANK_ACCOUNT_IBAN("baf_iban"),
	BANK_ACCOUNT_ABAC_REFERENCE("mun_abacReference"),
	BANK_ACCOUNT_ABAC_STATUS("mun_abacStatus"),
	BANK_ACCOUNT_DATE_EXPORTED("mun_lastDateExported"),
	BANK_ACCOUNT_USER_EXPORTED("mun_lastUserExported"),
	BANK_ACCOUNT_BATCH_REFERENCE("mun_importBatchReference");
	
	private String value;

	private BankAccountCSVColumn(String value) {
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
