package wifi4eu.wifi4eu.common.dto.model;

public class UserRegistrationDTO {
    private String email;
    private int municipalityId;

    public UserRegistrationDTO() {
    }

    public UserRegistrationDTO(String email, int municipalityId) {
        this.email = email;
        this.municipalityId = municipalityId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMunicipalityId() {
        return municipalityId;
    }

    public void setMunicipalityId(int municipalityId) {
        this.municipalityId = municipalityId;
    }
}