package wifi4eu.wifi4eu.common.dto.model;

public class RegistrationDTO {
    private int id;
    private int userId;
    private int municipalityId;
    private String role;
    private int status;

    public RegistrationDTO() {
    }

    public RegistrationDTO(int id, int userId, int municipalityId, String role) {
        this.id = id;
        this.userId = userId;
        this.municipalityId = municipalityId;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMunicipalityId() {
        return municipalityId;
    }

    public int getStatus() {
        return status;
    }

    public void setMunicipalityId(int municipalityId) {
        this.municipalityId = municipalityId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}