package wifi4eu.wifi4eu.common.dto.model;

/**
 * Created by rgarcita on 09/02/2017.
 */
public class LegalEntityDTO {

    private long legalEntityId;
    private String countryCode;
    private String municipalityCode;
    private String address;
    private String addressNum;
    private String postalCode;

    private boolean legalCheckbox1;
    private boolean legalCheckbox2;
    private boolean legalCheckbox3;

    public LegalEntityDTO(){}

    public LegalEntityDTO(long legalEntityId, String countryCode, String municipalityCode, String address, String addressNum, String postalCode, boolean legalCheckbox1, boolean legalCheckbox2, boolean legalCheckbox3) {
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

    public void setLegalEntityId(long legalEntityId) {
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

    public boolean isLegalCheckbox1() {
        return legalCheckbox1;
    }

    public void setLegalCheckbox1(boolean legalCheckbox1) {
        this.legalCheckbox1 = legalCheckbox1;
    }

    public boolean isLegalCheckbox2() {
        return legalCheckbox2;
    }

    public void setLegalCheckbox2(boolean legalCheckbox2) {
        this.legalCheckbox2 = legalCheckbox2;
    }

    public boolean isLegalCheckbox3() {
        return legalCheckbox3;
    }

    public void setLegalCheckbox3(boolean legalCheckbox3) {
        this.legalCheckbox3 = legalCheckbox3;
    }

    public String toString(){

        StringBuffer result = new StringBuffer();

        result.append("legalEntityId: " + this.getLegalEntityId());
        result.append("address: " + this.getAddress());
        result.append("addressNum:" + this.getAddressNum());
        result.append("countryCode: " + this.getCountryCode());
        result.append("municipalityCode" + this.getMunicipalityCode());
        result.append("postalCode" + this.getPostalCode());

        return result.toString();
    }
}
