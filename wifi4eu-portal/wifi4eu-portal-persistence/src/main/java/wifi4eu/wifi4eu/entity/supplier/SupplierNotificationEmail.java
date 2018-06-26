package wifi4eu.wifi4eu.entity.supplier;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SupplierNotificationEmail {

    @Id
    private Integer registrationId;
    
    private String supplierEmail;
    
    private Integer municipalityId;

    private String municipalityName;

    private String municipalityCountry;

    private String userLang;


    public SupplierNotificationEmail() {
    }

    public SupplierNotificationEmail(Integer registrationId, String supplierEmail, Integer municipalityId, String municipalityName, String municipalityCountry, String userLang) {
        this.registrationId = registrationId;
        this.supplierEmail = supplierEmail;
        this.municipalityId = municipalityId;
        this.municipalityName = municipalityName;
        this.municipalityCountry = municipalityCountry;
        this.userLang = userLang;
    }

    public Integer getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Integer registrationId) {
        this.registrationId = registrationId;
    }
    
    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }

    public Integer getMunicipalityId() {
        return municipalityId;
    }

    public void setMunicipalityId(Integer municipalityId) {
        this.municipalityId = municipalityId;
    }

    public String getMunicipalityName() {
        return municipalityName;
    }

    public void setMunicipalityName(String municipalityName) {
        this.municipalityName = municipalityName;
    }

    public String getMunicipalityCountry() {
        return municipalityCountry;
    }

    public void setMunicipalityCountry(String municipalityCountry) {
        this.municipalityCountry = municipalityCountry;
    }

    public String getUserLang() {
        return userLang;
    }

    public void setUserLang(String userLang) {
        this.userLang = userLang;
    }

}