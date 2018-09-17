package wifi4eu.wifi4eu.util.parsing;

/**
 * Headers of the LEF csv as they are expected by ABAC.
 */
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
	MUNICIPALITY_ABAC_REFERENCE("mun_abacReference"),
	MUNICIPALITY_CALL_NUMBER("mun_CallNumber"),
	MUNICIPALITY_ABAC_STATUS("mun_abacStatus"),
	MUNICIPALITY_ABAC_MESSAGE("abac_Message");

	private String value;

	LegalEntityCSVColumn(String value) {
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
