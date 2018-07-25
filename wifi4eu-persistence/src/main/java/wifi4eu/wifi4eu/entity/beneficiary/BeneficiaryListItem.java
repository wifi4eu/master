package wifi4eu.wifi4eu.entity.beneficiary;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BeneficiaryListItem {
    private String name;
    @Id
    private Integer lauId;
    private String countryCode;
    private Integer counter;
    private Boolean status;
    private Boolean mediation;
    private Integer issueStatus;

    public BeneficiaryListItem() {
    }

    public BeneficiaryListItem(String name, Integer lauId, String countryCode, Integer counter, Boolean status, Boolean mediation) {
        this.name = name;
        this.lauId = lauId;
        this.countryCode = countryCode;
        this.counter = counter;
        this.status = status;
        this.mediation = mediation;
    }

    public BeneficiaryListItem(String name, Integer lauId, String countryCode, Integer counter, Boolean status, Boolean mediation, Integer issueStatus) {
        this.name = name;
        this.lauId = lauId;
        this.countryCode = countryCode;
        this.counter = counter;
        this.status = status;
        this.mediation = mediation;
        this.issueStatus = issueStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getMediation() {
        return mediation;
    }

    public void setMediation(Boolean mediation) {
        this.mediation = mediation;
    }

    public Integer getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(Integer issueStatus) {
        this.issueStatus = issueStatus;
    }
}