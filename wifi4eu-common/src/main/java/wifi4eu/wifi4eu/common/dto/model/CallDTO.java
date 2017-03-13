package wifi4eu.wifi4eu.common.dto.model;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class CallDTO {

    private Long callId;
    @NotNull
    private Date startDate;
    private Date endDate;
    private String event;

    public CallDTO() {
    }

    public CallDTO(Long callId, Date startDate, Date endDate, String event) {

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
