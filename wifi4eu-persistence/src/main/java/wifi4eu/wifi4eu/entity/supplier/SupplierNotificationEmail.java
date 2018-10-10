package wifi4eu.wifi4eu.entity.supplier;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SupplierNotificationEmail {

    @Id
    private String supplierEmail;

    private String municipalityName;

    private String municipalityCountry;

    private String supplierLang;

    public SupplierNotificationEmail() {
    }

    public SupplierNotificationEmail(String supplierEmail, String municipalityName, String municipalityCountry, String supplierLang) {
        this.supplierEmail = supplierEmail;
        this.municipalityName = municipalityName;
        this.municipalityCountry = municipalityCountry;
        this.supplierLang = supplierLang;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
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
        return supplierLang;
    }

    public void setUserLang(String supplierLang) {
        this.supplierLang = supplierLang;
    }

}