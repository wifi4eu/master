package wifi4eu.wifi4eu.common.dto.model;

public class SupplierListItemDTO {
    private int id;
    private String name;
    private String website;
    private String vat;
    private String accountNumber;
    private int status;
    private int numberRegistrations;

    public SupplierListItemDTO() {
    }

    public SupplierListItemDTO(int id, String name, String website, String vat, String accountNumber, int status) {
        this.id = id;
        this.name = name;
        this.website = website;
        this.vat = vat;
        this.accountNumber = accountNumber;
        this.status = status;
    }

    public SupplierListItemDTO(int id, String name, String website, String vat, String accountNumber, int status, int numberRegistrations) {
        this.id = id;
        this.name = name;
        this.website = website;
        this.vat = vat;
        this.accountNumber = accountNumber;
        this.status = status;
        this.numberRegistrations = numberRegistrations;
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getNumberRegistrations() {
        return numberRegistrations;
    }

    public void setNumberRegistrations(int numberRegistrations) {
        this.numberRegistrations = numberRegistrations;
    }
}