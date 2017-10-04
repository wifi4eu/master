package wifi4eu.wifi4eu.common.dto.model;

public class TimelineDTO {
    int id;
    int callId;
    String description;
    long startDate;
    long endDate;

    public TimelineDTO() {
    }

    public TimelineDTO(int id, int callId, String description, long startDate, long endDate) {
        this.id = id;
        this.callId = callId;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCallId() {
        return callId;
    }

    public void setCallId(int callId) {
        this.callId = callId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }
}