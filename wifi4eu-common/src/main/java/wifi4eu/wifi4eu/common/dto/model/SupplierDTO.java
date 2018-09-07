package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;
import java.util.List;

public class SupplierDTO implements Serializable {
    private int id;
    private String name;
    private String address;
    private String street;
    private String streetNumber;
    private String postalCode;
    private String city;
    private String country;
    private String vat;
    private String bic;
    private String accountNumber;
    private String website;
    private String contactEmail;
    private String logo;
    private List<UserDTO> users;
    private List<SuppliedRegionDTO> suppliedRegions;
    private boolean legalCheck1;
    private boolean legalCheck2;
    private String legalFile1;
    private String legalFile2;
    private int status;
    private String lang;
    private String contactPrefix;
    private String contactNumber;

    public SupplierDTO() {
    }

    public SupplierDTO(int id, String name, String address, String vat, String bic, String accountNumber, String website, String contactEmail, String logo, List<UserDTO> users, List<SuppliedRegionDTO> suppliedRegions, boolean legalCheck1, boolean legalCheck2, String legalFile1, String legalFile2, int status, String lang, String contactPrefix, String contactNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.vat = vat;
        this.bic = bic;
        this.accountNumber = accountNumber;
        this.website = website;
        this.contactEmail = contactEmail;
        this.logo = logo;
        this.users = users;
        this.suppliedRegions = suppliedRegions;
        this.legalCheck1 = legalCheck1;
        this.legalCheck2 = legalCheck2;
        this.legalFile1 = legalFile1;
        this.legalFile2 = legalFile2;
        this.status = status;
        this.lang = lang;
        this.contactPrefix = contactPrefix;
        this.contactNumber = contactNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }

    public List<SuppliedRegionDTO> getSuppliedRegions() {
        return suppliedRegions;
    }

    public void setSuppliedRegions(List<SuppliedRegionDTO> suppliedRegions) {
        this.suppliedRegions = suppliedRegions;
    }

    public boolean isLegalCheck1() {
        return legalCheck1;
    }

    public void setLegalCheck1(boolean legalCheck1) {
        this.legalCheck1 = legalCheck1;
    }

    public boolean isLegalCheck2() {
        return legalCheck2;
    }

    public void setLegalCheck2(boolean legalCheck2) {
        this.legalCheck2 = legalCheck2;
    }

    public String getLegalFile1() {
        return legalFile1;
    }

    public void setLegalFile1(String legalFile1) {
        this.legalFile1 = legalFile1;
    }

    public String getLegalFile2() {
        return legalFile2;
    }

    public void setLegalFile2(String legalFile2) {
        this.legalFile2 = legalFile2;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getContactPrefix() {
        return contactPrefix;
    }

    public void setContactPrefix(String contactPrefix) {
        this.contactPrefix = contactPrefix;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    @Override
    public String toString() {
        return "SupplierDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", street='" + street+ '\'' +
                ", number='" + streetNumber + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", vat='" + vat + '\'' +
                ", bic='" + bic + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", website='" + website + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", logo='" + logo + '\'' +
                ", suppliedRegions=" + suppliedRegions +
                ", legalCheck1=" + legalCheck1 +
                ", legalCheck2=" + legalCheck2 +
                ", legalFile1='" + legalFile1 + '\'' +
                ", legalFile2='" + legalFile2 + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}