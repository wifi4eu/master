package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;

public class BeneficiaryListDTO implements Serializable {
    LauDTO lau;
    Integer numRegistrations;

    public BeneficiaryListDTO(LauDTO lau, Integer numRegistrations) {
        this.lau = lau;
        this.numRegistrations = numRegistrations;
    }

    public BeneficiaryListDTO() {
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
}
