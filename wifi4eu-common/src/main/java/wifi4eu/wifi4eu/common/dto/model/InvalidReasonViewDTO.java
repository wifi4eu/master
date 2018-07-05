package wifi4eu.wifi4eu.common.dto.model;

import java.util.List;

public class InvalidReasonViewDTO {

    int applicationId;
    List<Integer> reasons;

    public InvalidReasonViewDTO() {
    }

    public InvalidReasonViewDTO(int applicationId, List<Integer> reasons) {
        this.applicationId = applicationId;
        this.reasons = reasons;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public List<Integer> getReasons() {
        return reasons;
    }

    public void setReasons(List<Integer> reasons) {
        this.reasons = reasons;
    }
}
