package wifi4eu.wifi4eu.entity.application;

import wifi4eu.wifi4eu.common.dto.model.RegistrationWarningDTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class ApplicantListItem {
    @Id
    private Integer lauId;
    private String countryCode;
    private String name;
    private Integer counter;
    private Boolean mediation;
    private Integer status;
    private Long applicationDate;
    private String invalidateReason;

    public ApplicantListItem() {
    }

    public ApplicantListItem(Integer lauId, String countryCode, String name, Integer counter, Boolean mediation, Integer status, Long applicationDate, String invalidateReason) {
        this.lauId = lauId;
        this.countryCode = countryCode;
        this.name = name;
        this.counter = counter;
        this.mediation = mediation;
        this.status = status;
        this.applicationDate = applicationDate;
        this.invalidateReason = invalidateReason;
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

    public Boolean getMediation() {
        return mediation;
    }

    public void setMediation(Boolean mediation) {
        this.mediation = mediation;
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
}