package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;
import java.util.List;

public class SupplierDTO implements Serializable {
    private Long supplierId;
    private String name;
    private String address;
    private String vat;
    private String bic;
    private String accountNumber;
    private String website;
    private String contactName;
    private String contactSurname;
    private String contactPhone;
    private String contactEmail;
    private List<InstallationDTO> installations;
    private boolean legalCheck1;
    private boolean legalCheck2;
    private Long createDate;
    private List<NutsDTO> nuts;

    public SupplierDTO() {
    }

    public SupplierDTO(Long supplierId, String name, String address, String vat, String bic, String accountNumber, String website, String contactName, String contactSurname, String contactPhone, String contactEmail, List<InstallationDTO> installations, boolean legalCheck1, boolean legalCheck2, Long createDate, List<NutsDTO> nuts) {
        this.supplierId = supplierId;
        this.name = name;
        this.address = address;
        this.vat = vat;
        this.bic = bic;
        this.accountNumber = accountNumber;
        this.website = website;
        this.contactName = contactName;
        this.contactSurname = contactSurname;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
        this.installations = installations;
        this.legalCheck1 = legalCheck1;
        this.legalCheck2 = legalCheck2;
        this.createDate = createDate;
        this.nuts = nuts;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
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

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public List<InstallationDTO> getInstallations() {
        return installations;
    }

    public void setInstallations(List<InstallationDTO> installations) {
        this.installations = installations;
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

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public List<NutsDTO> getNuts() {
        return nuts;
    }

    public void setNuts(List<NutsDTO> nuts) {
        this.nuts = nuts;
    }
}