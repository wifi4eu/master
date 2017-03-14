package wifi4eu.wifi4eu.entity.call;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "CALL_T")
public class Call {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CALL_ID")
    private Long callId;

    @Column(name = "START_DATE")
    private Long startDate;

    @Column(name = "END_DATE")
    private Long endDate;

    @Column(name = "EVENT")
    private String event;

    public Call() {
    }

    public Call(Long callId, Long startDate, Long endDate, String event) {
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
