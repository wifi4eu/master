package wifi4eu.wifi4eu.common.dto.model;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by rgarcita on 02/03/2017.
 */
public class TimelineDTO {

    private Long timelineId;
    @NotNull
    private String eventTitle;
    private Date startDate;
    private Date endDate;

    public TimelineDTO(){}

    public TimelineDTO(Long timelineId, String eventTitle, Date startDate, Date endDate) {
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
