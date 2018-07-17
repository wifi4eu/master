package wifi4eu.wifi4eu.entity.exportImport;

import javax.persistence.*;

@Entity
public class ExportImportBeneficiaryInformation {

    @Id
    private Integer id;

    private String mun_OfficialName;

    private String mun_OfficialAddress;

    private String org_Name;

    private String org_TypeCode;

    private String sup_Name;

    private String sup_BankAccount;

    private Integer reg_RegistartionNumber;

    public ExportImportBeneficiaryInformation() {}

    public ExportImportBeneficiaryInformation(Integer id, String mun_OfficialName, String mun_OfficialAddress, String org_Name, String org_TypeCode, String sup_Name, String sup_BankAccount, Integer reg_RegistartionNumber) {
        this.id = id;
        this.mun_OfficialName = mun_OfficialName;
        this.mun_OfficialAddress = mun_OfficialAddress;
        this.org_Name = org_Name;
        this.org_TypeCode = org_TypeCode;
        this.sup_Name = sup_Name;
        this.sup_BankAccount = sup_BankAccount;
        this.reg_RegistartionNumber = reg_RegistartionNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMun_OfficialName() {
        return mun_OfficialName;
    }

    public void setMun_OfficialName(String mun_OfficialName) {
        this.mun_OfficialName = mun_OfficialName;
    }

    public String getMun_OfficialAddress() {
        return mun_OfficialAddress;
    }

    public void setMun_OfficialAddress(String mun_OfficialAddress) {
        this.mun_OfficialAddress = mun_OfficialAddress;
    }

    public String getOrg_Name() {
        return org_Name;
    }

    public void setOrg_Name(String org_Name) {
        this.org_Name = org_Name;
    }

    public String getOrg_TypeCode() {
        return org_TypeCode;
    }

    public void setOrg_TypeCode(String org_TypeCode) {
        this.org_TypeCode = org_TypeCode;
    }

    public String getSup_Name() {
        return sup_Name;
    }

    public void setSup_Name(String sup_Name) {
        this.sup_Name = sup_Name;
    }

    public String getSup_BankAccount() {
        return sup_BankAccount;
    }

    public void setSup_BankAccount(String sup_BankAccount) {
        this.sup_BankAccount = sup_BankAccount;
    }

    public Integer getReg_RegistartionNumber() {
        return reg_RegistartionNumber;
    }

    public void setReg_RegistartionNumber(Integer reg_RegistartionNumber) {
        this.reg_RegistartionNumber = reg_RegistartionNumber;
    }
}
