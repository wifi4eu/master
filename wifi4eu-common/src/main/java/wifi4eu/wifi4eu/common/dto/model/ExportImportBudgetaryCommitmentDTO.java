package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;


public class ExportImportBudgetaryCommitmentDTO implements Serializable {

    private Integer id;

    private String mun_OfficialName;

    private String mun_OfficialAddress;

    private String org_Name;

    private String org_TypeCode;

    private String sup_Name;

    private String sup_BankAccount;

    private Integer reg_RegistartionNumber;

    private Integer app_VoucherAwarded;

    private Integer app_BcStatus;

    private Integer app_BcExport;

    private Integer app_BcImport;

    private Integer app_LefStatus;

    private Integer app_LefExport;

    private Integer app_LefImport;


    public ExportImportBudgetaryCommitmentDTO() {}

    public ExportImportBudgetaryCommitmentDTO(Integer id, String mun_OfficialName, String mun_OfficialAddress, String org_Name, String org_TypeCode, String sup_Name, String sup_BankAccount, Integer reg_RegistartionNumber, Integer app_VoucherAwarded, Integer app_BcStatus, Integer app_BcExport, Integer app_BcImport, Integer app_LefStatus, Integer app_LefExport, Integer app_LefImport) {
        this.id = id;
        this.mun_OfficialName = mun_OfficialName;
        this.mun_OfficialAddress = mun_OfficialAddress;
        this.org_Name = org_Name;
        this.org_TypeCode = org_TypeCode;
        this.sup_Name = sup_Name;
        this.sup_BankAccount = sup_BankAccount;
        this.reg_RegistartionNumber = reg_RegistartionNumber;
        this.app_VoucherAwarded = app_VoucherAwarded;
        this.app_BcStatus = app_BcStatus;
        this.app_BcExport = app_BcExport;
        this.app_BcImport = app_BcImport;
        this.app_LefStatus = app_LefStatus;
        this.app_LefExport = app_LefExport;
        this.app_LefImport = app_LefImport;
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

    public Integer getApp_VoucherAwarded() {
        return app_VoucherAwarded;
    }

    public void setApp_VoucherAwarded(Integer app_VoucherAwarded) {
        this.app_VoucherAwarded = app_VoucherAwarded;
    }

    public Integer getApp_BcStatus() {
        return app_BcStatus;
    }

    public void setApp_BcStatus(Integer app_BcStatus) {
        this.app_BcStatus = app_BcStatus;
    }

    public Integer getApp_BcExport() {
        return app_BcExport;
    }

    public void setApp_BcExport(Integer app_BcExport) {
        this.app_BcExport = app_BcExport;
    }

    public Integer getApp_BcImport() {
        return app_BcImport;
    }

    public void setApp_BcImport(Integer app_BcImport) {
        this.app_BcImport = app_BcImport;
    }

    public Integer getApp_LefStatus() {
        return app_LefStatus;
    }

    public void setApp_LefStatus(Integer app_LefStatus) {
        this.app_LefStatus = app_LefStatus;
    }

    public Integer getApp_LefExport() {
        return app_LefExport;
    }

    public void setApp_LefExport(Integer app_LefExport) {
        this.app_LefExport = app_LefExport;
    }

    public Integer getApp_LefImport() {
        return app_LefImport;
    }

    public void setApp_LefImport(Integer app_LefImport) {
        this.app_LefImport = app_LefImport;
    }
}

