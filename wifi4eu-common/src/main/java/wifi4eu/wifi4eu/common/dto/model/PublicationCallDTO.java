package wifi4eu.wifi4eu.common.dto.model;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class PublicationCallDTO {

    private Long callId;
    @NotNull
    private String url;
    @NotNull
    private Date startDate;
    @NotNull
    private Date endDate;

    public PublicationCallDTO(){}

    public PublicationCallDTO(Long callId, String url, Date startDate, Date endDate) {
        this.callId = callId;
        this.url = url;
        this.startDate = startDate;
        this.endDate = endDate;
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
