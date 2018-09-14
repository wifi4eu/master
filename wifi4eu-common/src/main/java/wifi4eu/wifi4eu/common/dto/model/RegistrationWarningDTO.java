package wifi4eu.wifi4eu.common.dto.model;

public class RegistrationWarningDTO {
    private int id;
    private int registrationId;
    private int warning;

    public RegistrationWarningDTO() {
    }

    public RegistrationWarningDTO(int id, int registrationId, int warning) {
        this.id = id;
        this.registrationId = registrationId;
        this.warning = warning;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    public int getWarning() {
        return warning;
    }

    public void setWarning(int warning) {
        this.warning = warning;
    }
}