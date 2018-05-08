package wifi4eu.wifi4eu.common.dto.model;

import java.util.List;

public class MunicipalityDetailsDTO {
    private MunicipalityDTO municipality;
    private MayorDTO mayor;
    private LauDTO lau;
    private RegistrationDTO registration;
    private List<ApplicationDTO> applications;

    public MunicipalityDetailsDTO() {
    }

    public MunicipalityDetailsDTO(MunicipalityDTO municipality, MayorDTO mayor, LauDTO lau, RegistrationDTO registration, List<ApplicationDTO> applications) {
        this.municipality = municipality;
        this.mayor = mayor;
        this.lau = lau;
        this.registration = registration;
        this.applications = applications;
    }

    public MunicipalityDTO getMunicipality() {
        return municipality;
    }

    public void setMunicipality(MunicipalityDTO municipality) {
        this.municipality = municipality;
    }

    public MayorDTO getMayor() {
        return mayor;
    }

    public void setMayor(MayorDTO mayor) {
        this.mayor = mayor;
    }

    public LauDTO getLau() {
        return lau;
    }

    public void setLau(LauDTO lau) {
        this.lau = lau;
    }

    public RegistrationDTO getRegistration() {
        return registration;
    }

    public void setRegistration(RegistrationDTO registration) {
        this.registration = registration;
    }

    public List<ApplicationDTO> getApplications() {
        return applications;
    }

    public void setApplications(List<ApplicationDTO> applications) {
        this.applications = applications;
    }
}