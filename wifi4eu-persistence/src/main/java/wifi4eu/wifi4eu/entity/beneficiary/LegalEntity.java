package wifi4eu.wifi4eu.entity.beneficiary;

import javax.persistence.*;

/**
 * Created by rgarcita on 09/02/2017.
 */
@Entity
@Table(name="BEN_LGE_T")
public class LegalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="LEGAL_ENTITY_ID")
    private Long legalEntityId;

    @Column(name="COUNTRY_CODE")
    private String countryCode;

    @Column(name="MUNICIPALITY_CODE")
    private String municipalityCode;

    @Column(name="ADDRESS")
    private String address;

    @Column(name="ADDRESS_NUM")
    private String addressNum;

    @Column(name="POSTAL_CODE")
    private String postalCode;

    @Column(name="LEGAL_CHECKBOX_1")
    private Boolean legalCheckbox1;

    @Column(name="LEGAL_CHECKBOX_2")
    private Boolean legalCheckbox2;

    @Column(name="LEGAL_CHECKBOX_3")
    private Boolean legalCheckbox3;

    public LegalEntity(){}

    public LegalEntity(Long legalEntityId, String countryCode, String municipalityCode, String address, String addressNum, String postalCode, Boolean legalCheckbox1, Boolean legalCheckbox2, Boolean legalCheckbox3) {
        this.legalEntityId = legalEntityId;
        this.countryCode = countryCode;
        this.municipalityCode = municipalityCode;
        this.address = address;
        this.addressNum = addressNum;
        this.postalCode = postalCode;
        this.legalCheckbox1 = legalCheckbox1;
        this.legalCheckbox2 = legalCheckbox2;
        this.legalCheckbox3 = legalCheckbox3;
    }

    public long getLegalEntityId() {
        return legalEntityId;
    }

    public void setLegalEntityId(Long legalEntityId) {
        this.legalEntityId = legalEntityId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getMunicipalityCode() {
        return municipalityCode;
    }

    public void setMunicipalityCode(String municipalityCode) {
        this.municipalityCode = municipalityCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressNum() {
        return addressNum;
    }

    public void setAddressNum(String addressNum) {
        this.addressNum = addressNum;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Boolean isLegalCheckbox1() {
        return legalCheckbox1;
    }

    public void setLegalCheckbox1(Boolean legalCheckbox1) {
        this.legalCheckbox1 = legalCheckbox1;
    }

    public Boolean isLegalCheckbox2() {
        return legalCheckbox2;
    }

    public void setLegalCheckbox2(Boolean legalCheckbox2) {
        this.legalCheckbox2 = legalCheckbox2;
    }

    public Boolean isLegalCheckbox3() {
        return legalCheckbox3;
    }

    public void setLegalCheckbox3(Boolean legalCheckbox3) {
        this.legalCheckbox3 = legalCheckbox3;
    }
}
