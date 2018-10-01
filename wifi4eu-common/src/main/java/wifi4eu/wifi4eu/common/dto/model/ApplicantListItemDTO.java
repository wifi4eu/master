package wifi4eu.wifi4eu.common.dto.model;

import java.util.List;

public class ApplicantListItemDTO {
    private Integer lauId;
    private String countryCode;
    private String name;
    private Integer counter;
    private Boolean mediation;
    private Integer status;
    private List<Integer> issueStatus;
    private Long applicationDate;
    private String invalidateReason;
    private Boolean warning1;
    private Boolean warning2;
    private Boolean warning3;
    private Integer supportingDocuments;

    public ApplicantListItemDTO() {
    }
    
    public ApplicantListItemDTO(Integer lauId, String countryCode, String name, Integer counter, Boolean mediation, Integer status, List<Integer> issueStatus, Long applicationDate, String invalidateReason, Boolean warning1, Boolean warning2, Boolean warning3, Integer supportingDocuments) {
      this.lauId = lauId;
      this.countryCode = countryCode;
        this.name = name;
        this.counter = counter;
        this.mediation = mediation;
        this.status = status;
        this.issueStatus = issueStatus;
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
    
    public List<Integer> getIssueStatus() {
      return issueStatus;
    }

    public void setIssueStatus(List<Integer> issueStatus) {
      this.issueStatus = issueStatus;
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