package wifi4eu.wifi4eu.entity.supplier;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "SUPP_COMPANY_T")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COMPANY_ID")
    private Long companyId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "VAT")
    private String vat;

    @Column(name = "BIC")
    private String bic;

    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;

    @Column(name = "WEBSITE")
    private String website;

    public Company() {
    }

    public Company(Long companyId, String name, String address, String vat, String bic, String accountNumber, String website) {
        this.companyId = companyId;
        this.name = name;
        this.address = address;
        this.vat = vat;
        this.bic = bic;
        this.accountNumber = accountNumber;
        this.website = website;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
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