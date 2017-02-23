package wifi4eu.wifi4eu.entity.call;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by rgarcita on 21/02/2017.
 */
@Entity
@Table(name="CAL_PUBCALL_T")
public class PublicationCall {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="CALL_ID")
    private Long callId;

    @Column(name="URL")
    private String url;

    @Column(name="NAME")
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name="CALL_DATE")
    private Date callDate;

    @Temporal(TemporalType.DATE)
    @Column(name="COMPETITION_DATE")
    private Date competitionDate;

    @Temporal(TemporalType.DATE)
    @Column(name="CLOSING_DATE")
    private Date closingDate;

    public PublicationCall(){}

    public PublicationCall(Long callId, String url, String name, Date callDate, Date competitionDate, Date closingDate) {
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
