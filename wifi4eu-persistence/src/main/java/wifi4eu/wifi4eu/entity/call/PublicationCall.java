package wifi4eu.wifi4eu.entity.call;

import javax.persistence.*;

@Entity
@Table(name = "CAL_PUBCALL_T")
public class PublicationCall {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CALL_ID")
    private Long callId;

    @Column(name = "URL")
    private String url;

    @Column(name = "START_DATE")
    private String startDate;

    @Column(name = "START_TIME")
    private String startTime;

    @Column(name = "END_DATE")
    private String endDate;

    @Column(name = "END_TIME")
    private String endTime;

    public PublicationCall() {
    }

    public PublicationCall(Long callId, String url, String startDate, String startTime, String endDate, String endTime) {
        this.callId = callId;
        this.url = url;
        this.startDate = startDate;
        this.startTime = startTime;
        this.endDate = endDate;
        this.endTime = endTime;
    }

    public Long getCallId() {
        return callId;
    }

    public void setCallId(Long callId) {
        this.callId = callId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
