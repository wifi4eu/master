package wifi4eu.wifi4eu.common.dto.model;

public class ApplicationInvalidateReasonDTO {

    int id;
    int applicationId;
    int reason;

    public ApplicationInvalidateReasonDTO() {
    }

    public ApplicationInvalidateReasonDTO(int applicationId, int reason) {
        this.applicationId = applicationId;
        this.reason = reason;
    }

    public ApplicationInvalidateReasonDTO(int id, int applicationId, int reason) {
        this.id = id;
        this.applicationId = applicationId;
        this.reason = reason;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public int getReason() {
        return reason;
    }

    public void setReason(int reason) {
        this.reason = reason;
    }
}
