package wifi4eu.wifi4eu.abac.data.enums;

public enum LegalEntityImportCSVColumn {

	MUNICIPALITY_PORTAL_ID("mun_id"),
	MUNICIPALITY_NAME("mun_name"),
   	MUNICIPALITY_ADDRESS("mun_address"),
	MUNICIPALITY_POSTAL_CODE("mun_postalCode"),
	MUNICIPALITY_CITY("mun_city"),
	MUNICIPALITY_COUNTRY_CODE("mun_countryCodeISO"),
	MUNICIPALITY_LANGUAGE_CODE("mun_languageCodeISO"),
	MUNICIPALITY_REGISTRATION_NUMBER("mun_registrationNumber"),
	MUNICIPALITY_ABAC_REFERENCE("mun_ABACReference"),
	MUNICIPALITY_ABAC_STATUS("mun_abacStatus");


	private String value;

	private LegalEntityImportCSVColumn(String value) {
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