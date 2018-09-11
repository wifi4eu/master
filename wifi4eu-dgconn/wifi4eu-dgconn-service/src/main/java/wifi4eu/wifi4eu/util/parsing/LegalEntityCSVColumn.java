package wifi4eu.wifi4eu.util.parsing;

/**
 * Headers of the LEF csv as they are expected by ABAC.
 */
public enum LegalEntityCSVColumn {

	MUNICIPALITY_PORTAL_ID("mun_id", 0),
	MUNICIPALITY_NAME("mun_name", 1),
	MUNICIPALITY_ABAC_LATIN_NAME("mun_abac_name", null),
   	MUNICIPALITY_ADDRESS("mun_address", 2),
	MUNICIPALITY_POSTAL_CODE("mun_postalCode", 3),
	MUNICIPALITY_CITY("mun_city", 4),
	MUNICIPALITY_COUNTRY_CODE("mun_countryCodeISO", 5),
	MUNICIPALITY_LANGUAGE_CODE("mun_languageCodeISO", 6),
	MUNICIPALITY_REGISTRATION_NUMBER("mun_registrationNumber", 7),
	MUNICIPALITY_ABAC_REFERENCE("mun_ABACReference", 8),
	MUNICIPALITY_CALL_NUMBER("mun_CallNumber", null),
	MUNICIPALITY_ABAC_STATUS("mun_abacStatus", 9),
	MUNICIPALITY_ABAC_MESSAGE("abac_Message", 10);


	private Integer airGapColumnIndex;

	private String value;

	LegalEntityCSVColumn(String value, Integer airGapColumnIndex) {
		this.value = value;
		this.airGapColumnIndex = airGapColumnIndex;
	}

	public String getValue() {
		return value;
	}

	public Integer getAirGapColumnIndex() {
		return airGapColumnIndex;
	}

	@Override
	public String toString() {
		return getValue();
	}
}
