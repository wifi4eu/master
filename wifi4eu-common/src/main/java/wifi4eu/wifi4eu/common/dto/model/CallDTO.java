package wifi4eu.wifi4eu.common.dto.model;

public class CallDTO {
    private int id;
    private String event;
    private long startDate;
    private long endDate;

    public CallDTO() {
    }

    public CallDTO(int id, String event, long startDate, long endDate) {
        this.id = id;
        this.event = event;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
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