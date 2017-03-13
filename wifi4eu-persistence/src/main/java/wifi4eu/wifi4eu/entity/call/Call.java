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

    @Temporal(TemporalType.DATE)
    @Column(name = "START_DATE")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "EVENT")
    private String event;

    public Call() {
    }

    public Call(Long callId, Date startDate, Date endDate, String event) {
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
