package wifi4eu.wifi4eu.entity.beneficiary;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class BeneficiaryDisplayedList {
    private String name;
    @Id
    private Integer id;

    private Date installationSiteSubmission;
    private Date installationSiteRejection;
    private Date installationSiteConfirmation;

    public BeneficiaryDisplayedList(){

    }

    public BeneficiaryDisplayedList(String name, Integer id, Date installationSiteSubmission, Date installationSiteRejection, Date installationSiteConfirmation) {
        this.name = name;
        this.id = id;
        this.installationSiteSubmission = installationSiteSubmission;
        this.installationSiteRejection = installationSiteRejection;
        this.installationSiteConfirmation = installationSiteConfirmation;
    }

    public Date getInstallationSiteSubmission() {
        return installationSiteSubmission;
    }

    public void setInstallationSiteSubmission(Date installationSiteSubmission) {
        this.installationSiteSubmission = installationSiteSubmission;
    }

    public Date getInstallationSiteRejection() {
        return installationSiteRejection;
    }

    public void setInstallationSiteRejection(Date installationSiteRejection) {
        this.installationSiteRejection = installationSiteRejection;
    }

    public Date getInstallationSiteConfirmation() {
        return installationSiteConfirmation;
    }

    public void setInstallationSiteConfirmation(Date installationSiteConfirmation) {
        this.installationSiteConfirmation = installationSiteConfirmation;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

}
