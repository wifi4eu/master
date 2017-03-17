package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;

public class CompanyDTO implements Serializable {
    private long companyId;
    private String name;
    private String address;
    private String vat;
    private String bic;
    private String accountNumber;
    private String website;

    public CompanyDTO() {
    }

    public CompanyDTO(long companyId, String name, String address, String vat, String bic, String accountNumber, String website) {
        this.companyId = companyId;
        this.name = name;
        this.address = address;
        this.vat = vat;
        this.bic = bic;
        this.accountNumber = accountNumber;
        this.website = website;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
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
}