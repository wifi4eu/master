package wifi4eu.wifi4eu.common.dto.model;


import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by rgarcita on 21/02/2017.
 */
public class PublicationCallDTO {

    private Long callId;
    @NotNull
    private String url;
    private String name;
    @NotNull
    private Date callDate;
    @NotNull
    private Date competitionDate;
    @NotNull
    private Date closingDate;

    public PublicationCallDTO(){}

    public PublicationCallDTO(Long callId, String url, String name, Date callDate, Date competitionDate, Date closingDate) {
        this.callId = callId;
        this.url = url;
        this.name = name;
        this.callDate = callDate;
        this.competitionDate = competitionDate;
        this.closingDate = closingDate;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCallDate() {
        return callDate;
    }

    public void setCallDate(Date callDate) {
        this.callDate = callDate;
    }

    public Date getCompetitionDate() {
        return competitionDate;
    }

    public void setCompetitionDate(Date competitionDate) {
        this.competitionDate = competitionDate;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }
}
