package wifi4eu.wifi4eu.entity.application;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ApplicantListItem {
    @Id
    private Integer lauId;
    private String countryCode;
    private String name;
    private Integer counter;
    private Integer status;
    private Long applicationDate;
    private String invalidateReason;
    private Boolean warning1;
    private Boolean warning2;
    private Boolean warning3;
    private Integer supportingDocuments;

    public ApplicantListItem() {
    }

    public ApplicantListItem(Integer lauId, String countryCode, String name, Integer counter, Integer status, Long applicationDate, String invalidateReason, Boolean warning1, Boolean warning2, Boolean warning3, Integer supportingDocuments) {
        this.lauId = lauId;
        this.countryCode = countryCode;
        this.name = name;
        this.counter = counter;
        this.status = status;
        this.applicationDate = applicationDate;
        this.invalidateReason = invalidateReason;
        this.warning1 = warning1;
        this.warning2 = warning2;
        this.warning3 = warning3;
        this.supportingDocuments = supportingDocuments;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Long applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getInvalidateReason() {
        return invalidateReason;
    }

    public void setInvalidateReason(String invalidateReason) {
        this.invalidateReason = invalidateReason;
    }

    public Boolean getWarning1() {
        return warning1;
    }

    public void setWarning1(Boolean warning1) {
        this.warning1 = warning1;
    }

    public Boolean getWarning2() {
        return warning2;
    }

    public void setWarning2(Boolean warning2) {
        this.warning2 = warning2;
    }

    public Boolean getWarning3() {
        return warning3;
    }

    public void setWarning3(Boolean warning3) {
        this.warning3 = warning3;
    }

    public Integer getSupportingDocuments() {
        return supportingDocuments;
    }

    public void setSupportingDocuments(Integer supportingDocuments) {
        this.supportingDocuments = supportingDocuments;
    }
}