package wifi4eu.wifi4eu.entity.supplier;

import javax.persistence.*;

@Entity
@Table(name = "bank_accounts")
public class BankAccount {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "iban")
    private String iban;

    @Column(name = "supplier_id")
    private Integer supplierId;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "bank_street")
    private String bankStreet;

    @Column(name = "bank_number")
    private String bankNumber;

    @Column(name = "bank_city")
    private String bankCity;

    @Column(name = "bank_country")
    private String bankCountry;

    @Column(name = "account_holder_street")
    private String accountHolderStreet;

    @Column(name = "account_holder_number")
    private String accountHolderNumber;

    @Column(name = "account_holder_city")
    private String accountHolderCity;

    @Column(name = "account_holder_country")
    private String accountHolderCountry;

    @Column(name = "status")
    private Integer status;

    @Column(name = "rejection_cause")
    private String rejectionCause;

    public BankAccount() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankStreet() {
        return bankStreet;
    }

    public void setBankStreet(String bankStreet) {
        this.bankStreet = bankStreet;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getBankCity() {
        return bankCity;
    }

    public void setBankCity(String bankCity) {
        this.bankCity = bankCity;
    }

    public String getBankCountry() {
        return bankCountry;
    }

    public void setBankCountry(String bankCountry) {
        this.bankCountry = bankCountry;
    }

    public String getAccountHolderStreet() {
        return accountHolderStreet;
    }

    public void setAccountHolderStreet(String accountHolderStreet) {
        this.accountHolderStreet = accountHolderStreet;
    }

    public String getAccountHolderNumber() {
        return accountHolderNumber;
    }

    public void setAccountHolderNumber(String accountHolderNumber) {
        this.accountHolderNumber = accountHolderNumber;
    }

    public String getAccountHolderCity() {
        return accountHolderCity;
    }

    public void setAccountHolderCity(String accountHolderCity) {
        this.accountHolderCity = accountHolderCity;
    }

    public String getAccountHolderCountry() {
        return accountHolderCountry;
    }

    public void setAccountHolderCountry(String accountHolderCountry) {
        this.accountHolderCountry = accountHolderCountry;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRejectionCause() {
        return rejectionCause;
    }

    public void setRejectionCause(String rejectionCause) {
        this.rejectionCause = rejectionCause;
    }
}
