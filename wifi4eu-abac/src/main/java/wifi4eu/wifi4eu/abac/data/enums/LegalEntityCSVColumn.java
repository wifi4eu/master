package wifi4eu.wifi4eu.abac.data.enums;

public enum LegalEntityCSVColumn {

	MUNICIPALITY_PORTAL_ID("mun_id"),
	MUNICIPALITY_NAME("mun_name"),
	MUNICIPALITY_ABAC_LATIN_NAME("mun_abac_name"),
   	MUNICIPALITY_ADDRESS("mun_address"),
	MUNICIPALITY_POSTAL_CODE("mun_postalCode"),
	MUNICIPALITY_CITY("mun_city"),
	MUNICIPALITY_COUNTRY_CODE("mun_countryCodeISO"),
	MUNICIPALITY_LANGUAGE_CODE("mun_languageCodeISO"),
	MUNICIPALITY_REGISTRATION_NUMBER("mun_registrationNumber"),
	MUNICIPALITY_ABAC_REFERENCE("mun_ABACReference"),
	MUNICIPALITY_ABAC_STATUS("mun_abacStatus"),
	MUNICIPALITY_CALL_NUMBER("mun_CallNumber"),
	MUNICIPALITY_ABAC_MESSAGE("abac_Message"),
	MUNICIPALITY_DATE_EXPORTED("mun_lastDateExported"),
	MUNICIPALITY_USER_EXPORTED("mun_lastUserExported");

	private String value;

	private LegalEntityCSVColumn(String value) {
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
