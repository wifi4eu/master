package wifi4eu.wifi4eu.entity.beneficiary;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BeneficiaryMyInstallation {

    @Id
    private Integer id;
    private String name;
    private String country;
    private Long selectSupplierDate;
    private Integer bankAccountId;

    public BeneficiaryMyInstallation() {
    }

    public BeneficiaryMyInstallation(Integer id, String name, String country, Long selectSupplierDate, Integer bankAccountId) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.selectSupplierDate = selectSupplierDate;
        this.bankAccountId = bankAccountId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getSelectSupplierDate() {
        return selectSupplierDate;
    }

    public void setSelectSupplierDate(Long selectSupplierDate) {
        this.selectSupplierDate = selectSupplierDate;
    }

    public Integer getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(Integer bankAccountId) {
        this.bankAccountId = bankAccountId;
    }
}
