package wifi4eu.wifi4eu.common.dto.model;

public class BankAccountDTO {

    private int id;
    private int supplierId;

    private String accountName;

    private String bankName;
    private String bankStreet;
    private String bankNumber;
    private String bankCity;
    private String bankCountry;

    private String accountHolderStreet;
    private String accountHolderNumber;
    private String accountHolderCity;
    private String accountHolderCountry;

    public BankAccountDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
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
}
