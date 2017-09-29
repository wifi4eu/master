package wifi4eu.wifi4eu.common.dto.model;

public class RegistrationDTO {
    int id;
    int userId;
    int municipalityId;
    String role;
    int threadId;

    public RegistrationDTO() {
    }

    public RegistrationDTO(int id, int userId, int municipalityId, String role, int threadId) {
        this.id = id;
        this.userId = userId;
        this.municipalityId = municipalityId;
        this.role = role;
        this.threadId = threadId;
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

    public void setMunicipalityId(int municipalityId) {
        this.municipalityId = municipalityId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getThreadId() {
        return threadId;
    }

    public void setThreadId(int threadId) {
        this.threadId = threadId;
    }
}