package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BeneficiaryListDTO implements Serializable {
    private LauDTO lau;
    private Integer numRegistrations;
    private boolean status;
    private Integer issue;
    private boolean mediation;
    private List<RegistrationDTO> registrations = new ArrayList<>();

    public BeneficiaryListDTO(LauDTO lau, Integer numRegistrations, boolean status, Integer issue, boolean mediation, List<RegistrationDTO> registrations) {
        this.lau = lau;
        this.numRegistrations = numRegistrations;
        this.status = status;
        this.issue = issue;
        this.mediation = mediation;
        this.registrations = registrations;
    }

    public BeneficiaryListDTO() {
    }

    public boolean isMediation() {
        return mediation;
    }

    public void setMediation(boolean mediation) {
        this.mediation = mediation;
    }

    public LauDTO getLau() {
        return lau;
    }

    public void setLau(LauDTO lau) {
        this.lau = lau;
    }

    public Integer getNumRegistrations() {
        return numRegistrations;
    }

    public void setNumRegistrations(Integer numRegistrations) {
        this.numRegistrations = numRegistrations;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<RegistrationDTO> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<RegistrationDTO> registrations) {
        this.registrations = registrations;
    }

    public boolean isStatus() {
        return status;
    }

    public Integer getIssue() {
        return issue;
    }

    public void setIssue(Integer issue) {
        this.issue = issue;
    }

}
