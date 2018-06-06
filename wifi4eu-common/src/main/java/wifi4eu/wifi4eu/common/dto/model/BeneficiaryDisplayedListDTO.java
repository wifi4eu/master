package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;
import java.util.Date;

public class BeneficiaryDisplayedListDTO implements Serializable {
    private String name;
    private Integer id;

    private Date installationSiteSubmission;
    private Date installationSiteRejection;
    private Date installationSiteConfirmation;


    public BeneficiaryDisplayedListDTO(){

    }

    public BeneficiaryDisplayedListDTO(String name, Integer id, Date installationSiteSubmission, Date installationSiteRejection, Date installationSiteConfirmation) {
        this.name = name;
        this.id = id;
        this.installationSiteSubmission = installationSiteSubmission;
        this.installationSiteRejection = installationSiteRejection;
        this.installationSiteConfirmation = installationSiteConfirmation;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
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
}
