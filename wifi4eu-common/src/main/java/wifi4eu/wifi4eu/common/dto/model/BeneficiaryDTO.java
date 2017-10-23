package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;
import java.util.List;

public class BeneficiaryDTO implements Serializable {
    private List<UserDTO> users;
    private List<MunicipalityDTO> municipalities;
    private boolean representing;

    public BeneficiaryDTO() {
    }

    public BeneficiaryDTO(List<UserDTO> users, List<MunicipalityDTO> municipalities, boolean representing) {
        this.users = users;
        this.municipalities = municipalities;
        this.representing = representing;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }

    public List<MunicipalityDTO> getMunicipalities() {
        return municipalities;
    }

    public void setMunicipalities(List<MunicipalityDTO> municipalities) {
        this.municipalities = municipalities;
    }

    public boolean isRepresenting() {
        return representing;
    }

    public void setRepresenting(boolean representing) {
        this.representing = representing;
    }
}