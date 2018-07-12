package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;
import java.util.List;

public class SupplierDTO implements Serializable {
    private int id;
    private String name;
    private String address;
    private String vat;
    private String bic;
    private String accountNumber;
    private String website;
    private String contactName;
    private String contactSurname;
    private String contactPhonePrefix;
    private String contactPhoneNumber;
    private String contactEmail;
    private String logo;
    private List<SupplierUserDTO> supplierUsers;
    private List<SuppliedRegionDTO> suppliedRegions;
    private boolean legalCheck1;
    private boolean legalCheck2;
    private String legalFile1;
    private String legalFile2;
    private int status;
    private String lang;

    public SupplierDTO() {
    }

    public SupplierDTO(int id, String name, String address, String vat, String bic, String accountNumber, String website, String contactName, String contactSurname, String contactPhonePrefix, String contactPhoneNumber, String contactEmail, String logo, List<SupplierUserDTO> supplierUsers, List<SuppliedRegionDTO> suppliedRegions, boolean legalCheck1, boolean legalCheck2, String legalFile1, String legalFile2, int status, String lang) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.vat = vat;
        this.bic = bic;
        this.accountNumber = accountNumber;
        this.website = website;
        this.contactName = contactName;
        this.contactSurname = contactSurname;
        this.contactPhonePrefix = contactPhonePrefix;
        this.contactPhoneNumber = contactPhoneNumber;
        this.contactEmail = contactEmail;
        this.logo = logo;
        this.supplierUsers = supplierUsers;
        this.suppliedRegions = suppliedRegions;
        this.legalCheck1 = legalCheck1;
        this.legalCheck2 = legalCheck2;
        this.legalFile1 = legalFile1;
        this.legalFile2 = legalFile2;
        this.status = status;
        this.lang = lang;
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

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactSurname() {
        return contactSurname;
    }

    public void setContactSurname(String contactSurname) {
        this.contactSurname = contactSurname;
    }

    public String getContactPhonePrefix() {
        return contactPhonePrefix;
    }

    public void setContactPhonePrefix(String contactPhonePrefix) {
        this.contactPhonePrefix = contactPhonePrefix;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
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

    public List<SupplierUserDTO> getSupplierUsers() {
        return supplierUsers;
    }

    public void setSupplierUsers(List<SupplierUserDTO> supplierUsers) {
        this.supplierUsers = supplierUsers;
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

    @Override
    public String toString() {
        return "SupplierDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", vat='" + vat + '\'' +
                ", bic='" + bic + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", website='" + website + '\'' +
                ", contactName='" + contactName + '\'' +
                ", contactSurname='" + contactSurname + '\'' +
                ", contactPhonePrefix='" + contactPhonePrefix + '\'' +
                ", contactPhoneNumber='" + contactPhoneNumber + '\'' +
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

    public Integer getUserId() {
        for(SupplierUserDTO supplierUserDTO: supplierUsers){

            if (supplierUserDTO.getMain() == 1){
                return supplierUserDTO.getUserDTO().getId();
            }
        }

        return null;
    }

}