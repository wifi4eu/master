package wifi4eu.wifi4eu.entity.application;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ApplicationIssueUtil {

    @Id
    private Integer applicationId;

    private Integer registrationId;

    private String countryCode;

    private String userEmail;

    private String userEcasEmail;

    private String userLang;

    private String mayorEmail;

    private Integer status;

    public ApplicationIssueUtil() {
    }

    public ApplicationIssueUtil(Integer applicationId, Integer registrationId, String countryCode, String userEmail, String userEcasEmail, String userLang, String mayorEmail, Integer status) {
        this.applicationId = applicationId;
        this.registrationId = registrationId;
        this.countryCode = countryCode;
        this.userEmail = userEmail;
        this.userEcasEmail = userEcasEmail;
        this.userLang = userLang;
        this.mayorEmail = mayorEmail;
        this.status = status;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Integer registrationId) {
        this.registrationId = registrationId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserEcasEmail() {
        return userEcasEmail;
    }

    public void setUserEcasEmail(String userEcasEmail) {
        this.userEcasEmail = userEcasEmail;
    }

    public String getUserLang() {
        return userLang;
    }

    public void setUserLang(String userLang) {
        this.userLang = userLang;
    }

    public String getMayorEmail() {
        return mayorEmail;
    }

    public void setMayorEmail(String mayorEmail) {
        this.mayorEmail = mayorEmail;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}