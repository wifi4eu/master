package eu.europa.ec.jagate.financiallegalentity.model;

import eu.europa.ec.rdg.jagate.ws.domain.legalentity.v6.PublicBodyAccountGroupType;
import eu.europa.ec.research.fp.model.code_ref.v3.CodeRefType;

import java.util.Date;

public class LegalEntityJagate {
    String officialName;

    String street;
    String postalCode;
    String city;

    String registrationAuthority;

    Date legistrationDate;
    String legalRegNumber;

    CodeRefType country;
    CodeRefType officialLanguage;
    CodeRefType abacLegalForm;
    PublicBodyAccountGroupType accountGroupType = PublicBodyAccountGroupType.OTHER_PUBLIC_BODIES;

    public String getOfficialName() {
        return officialName;
    }

    public void setOfficialName(String officialName) {
        this.officialName = officialName;
    }

    public CodeRefType getCountry() {
        return country;
    }

    public CodeRefType getOfficialLanguage() {
        return officialLanguage;
    }

    public CodeRefType getAbacLegalForm() {
        return abacLegalForm;
    }

    public void setCountry(CodeRefType country) {
        this.country = country;
    }

    public void setOfficialLanguage(CodeRefType officialLanguage) {
        this.officialLanguage = officialLanguage;
    }

    public void setAbacLegalForm(CodeRefType abacLegalForm) {
        this.abacLegalForm = abacLegalForm;
    }

    public PublicBodyAccountGroupType getAccountGroupType() {
        return accountGroupType;
    }

    public void setAccountGroupType(PublicBodyAccountGroupType accountGroupType) {
        this.accountGroupType = accountGroupType;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegistrationAuthority() {
        return registrationAuthority;
    }

    public void setRegistrationAuthority(String registrationAuthority) {
        this.registrationAuthority = registrationAuthority;
    }

    public Date getLegistrationDate() {
        return legistrationDate;
    }

    public void setLegistrationDate(Date legistrationDate) {
        this.legistrationDate = legistrationDate;
    }

    public String getLegalRegNumber() {
        return legalRegNumber;
    }

    public void setLegalRegNumber(String legalRegNumber) {
        this.legalRegNumber = legalRegNumber;
    }


    public static LegalEntityJagate generateDummyLE(){
        LegalEntityJagate legalEntityJagate = new LegalEntityJagate();
        legalEntityJagate.setOfficialName("TEST WIFI4EU CZ 2");
        legalEntityJagate.setCity("BXL");
        legalEntityJagate.setStreet("G-1");
        legalEntityJagate.setPostalCode("1000");
        legalEntityJagate.setRegistrationAuthority("LANSKROUN");
        legalEntityJagate.setLegistrationDate(new Date());
        legalEntityJagate.setLegalRegNumber("00279102");

        CodeRefType beCountry = new CodeRefType();
        beCountry.setAbbreviation("CZ");
        beCountry.setDescription("Czech Republic");
        beCountry.setId("20000872");

        CodeRefType abacLegalForm = new CodeRefType();
        abacLegalForm.setId("31044341");
        abacLegalForm.setAbbreviation("CZ_UNK");
        abacLegalForm.setDescription("UNKNOWN");

        CodeRefType languageFr = new CodeRefType();
        languageFr.setId("20001134");
        languageFr.setAbbreviation("cs");
        languageFr.setDescription("Czech");


        legalEntityJagate.setOfficialLanguage(languageFr);
        legalEntityJagate.setCountry(beCountry);
        legalEntityJagate.setAbacLegalForm(abacLegalForm);
        legalEntityJagate.setAccountGroupType(PublicBodyAccountGroupType.OTHER_PUBLIC_BODIES);

        return legalEntityJagate;
    }
}
