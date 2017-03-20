package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class CallDTO implements Serializable {

    private Long callId;
    @NotNull
    private Long startDate;
    private Long endDate;
    private String event;

    public CallDTO() {
    }

    public CallDTO(Long callId, Long startDate, Long endDate, String event) {

        this.callId = callId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.event = event;
    }

    public Long getCallId() {
        return callId;
    }

    public void setCallId(Long callId) {
        this.callId = callId;
    }

    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public Long getEndDate() {
        return endDate;
    }

    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
