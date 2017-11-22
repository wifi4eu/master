package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;
import java.util.List;

public class BeneficiaryDTO implements Serializable {
    private UserDTO user;
    private List<MayorDTO> mayors;
    private List<MunicipalityDTO> municipalities;
    private boolean representsMultipleMunicipalities;

    public BeneficiaryDTO() {
    }

    public BeneficiaryDTO(UserDTO user, List<MayorDTO> mayors, List<MunicipalityDTO> municipalities, boolean representsMultipleMunicipalities) {
        this.user = user;
        this.mayors = mayors;
        this.municipalities = municipalities;
        this.representsMultipleMunicipalities = representsMultipleMunicipalities;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public List<MayorDTO> getMayors() {
        return mayors;
    }

    public void setMayors(List<MayorDTO> mayors) {
        this.mayors = mayors;
    }

    public List<MunicipalityDTO> getMunicipalities() {
        return municipalities;
    }

    public void setMunicipalities(List<MunicipalityDTO> municipalities) {
        this.municipalities = municipalities;
    }

    public boolean isRepresentsMultipleMunicipalities() {
        return representsMultipleMunicipalities;
    }

    public void setRepresentsMultipleMunicipalities(boolean representsMultipleMunicipalities) {
        this.representsMultipleMunicipalities = representsMultipleMunicipalities;
    }
}