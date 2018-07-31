package wifi4eu.wifi4eu.entity.application;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ApplicationIssueUtil {

    @Id
    @Column(name = "regUserId")
    private Integer regUserId;

    @Column(name = "applicationId")
    private Integer applicationId;

    @Column(name = "registrationId")
    private Integer registrationId;

    @Column(name = "countryCode")
    private String countryCode;

    @Column(name = "userEmail")
    private String userEmail;

    @Column(name = "userEcasEmail")
    private String userEcasEmail;

    @Column(name = "userLang")
    private String userLang;

    @Column(name = "mayorEmail")
    private String mayorEmail;

    @Column(name = "status")
    private Integer status;

    public ApplicationIssueUtil() {
    }

    public ApplicationIssueUtil(Integer regUserId, Integer applicationId, Integer registrationId, String countryCode, String userEmail, String userEcasEmail, String userLang, String mayorEmail, Integer status) {
        this.regUserId = regUserId;
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

    public Integer getRegUserId() {
        return regUserId;
    }

    public void setRegUserId(Integer regUserId) {
        this.regUserId = regUserId;
    }
}