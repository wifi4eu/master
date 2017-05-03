package wifi4eu.wifi4eu.common.dto.model;

import javax.validation.constraints.NotNull;

public class TimelineDTO {

    private Long timelineId;
    @NotNull
    private Long startDate;
    private Long endDate;
    private String event;

    public TimelineDTO() {
    }

    public TimelineDTO(Long timelineId, Long startDate, Long endDate, String event) {
        this.timelineId = timelineId;
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
