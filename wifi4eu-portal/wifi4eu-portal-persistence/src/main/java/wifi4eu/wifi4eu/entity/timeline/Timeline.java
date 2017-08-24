package wifi4eu.wifi4eu.entity.timeline;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "TIM_TIMELINE_T")
public class Timeline {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TIMELINE_ID")
    private Long timelineId;

    @Column(name = "START_DATE")
    private Long startDate;

    @Column(name = "END_DATE")
    private Long endDate;

    @Column(name = "EVENT")
    private String event;

    public Timeline() {
    }

    public Timeline(Long startDate, Long endDate, String event) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.event = event;
    }

    public Long getTimelineId() {
        return timelineId;
    }

    public void setTimelineId(Long timelineId) {
        this.timelineId = timelineId;
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
