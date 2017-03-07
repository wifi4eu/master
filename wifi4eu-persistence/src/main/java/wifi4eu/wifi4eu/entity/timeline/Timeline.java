package wifi4eu.wifi4eu.entity.timeline;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by rgarcita on 02/03/2017.
 */
@Entity
@Table(name="TIM_TIMELINE_T")
public class Timeline {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="TIMELINE_ID")
    private Long timelineId;

    @Column(name="EVENT_TITLE")
    private String eventTitle;

    @Temporal(TemporalType.DATE)
    @Column(name="START_DATE")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name="END_DATE")
    private Date endDate;

    public Timeline(){}

    public Timeline(Long timelineId, String eventTitle, Date startDate, Date endDate) {
        this.timelineId = timelineId;
        this.eventTitle = eventTitle;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getTimelineId() {
        return timelineId;
    }

    public void setTimelineId(Long timelineId) {
        this.timelineId = timelineId;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
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
}
