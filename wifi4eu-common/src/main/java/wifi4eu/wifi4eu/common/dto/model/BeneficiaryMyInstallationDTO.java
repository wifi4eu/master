package wifi4eu.wifi4eu.common.dto.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

public class BeneficiaryMyInstallationDTO implements Serializable {
    //application id
    private Integer id;
    //municipality Name
    private String name;
    //municipalityCountry
    private String country;
    private Long selectSupplierDate;
    private Integer bankAccountId;

    public BeneficiaryMyInstallationDTO() {
    }

    public BeneficiaryMyInstallationDTO(Integer id, String name, String country, Long selectSupplierDate, Integer bankAccountId) {
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

