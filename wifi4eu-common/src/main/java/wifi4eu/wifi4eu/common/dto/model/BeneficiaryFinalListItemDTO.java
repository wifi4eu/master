package wifi4eu.wifi4eu.common.dto.model;

import java.util.Date;

public class BeneficiaryFinalListItemDTO {

    private Integer id;
    private Integer lauId;
    private String countryCode;
    private Integer registrationId;
    private String name;
    private Integer status;
    private Boolean verifiedToSign;
    private Date dateSignature;
    private Date dateCounterSignature;

    public BeneficiaryFinalListItemDTO() {
    }

    public BeneficiaryFinalListItemDTO(Integer id, Integer lauId, String countryCode, Integer registrationId, String name, Integer status, Boolean verifiedToSign, Date dateSignature, Date dateCounterSignature) {
        this.id = id;
        this.lauId = lauId;
        this.countryCode = countryCode;
        this.registrationId = registrationId;
        this.name = name;
        this.status = status;
        this.verifiedToSign = verifiedToSign;
        this.dateSignature = dateSignature;
        this.dateCounterSignature = dateCounterSignature;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLauId() {
        return lauId;
    }

    public void setLauId(Integer lauId) {
        this.lauId = lauId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Integer getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Integer registrationId) {
        this.registrationId = registrationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getVerifiedToSign() {
        return verifiedToSign;
    }

    public void setVerifiedToSign(Boolean verifiedToSign) {
        this.verifiedToSign = verifiedToSign;
    }

    public Date getDateSignature() {
        return dateSignature;
    }

    public void setDateSignature(Date dateSignature) {
        this.dateSignature = dateSignature;
    }

    public Date getDateCounterSignature() {
        return dateCounterSignature;
    }

    public void setDateCounterSignature(Date dateCounterSignature) {
        this.dateCounterSignature = dateCounterSignature;
    }
}
