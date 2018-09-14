package wifi4eu.wifi4eu.entity.logEmails;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "log_emails")
public class LogEmail {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "municipalityId")
    private Integer municipalityId;

    @Column(name = "sent_date")
    private Long sentDate;

    @Column(name = "action")
    private String action;

    @Column(name = "fromAddress")
    private String from;

    @Column(name = "toAddress")
    private String to;

    @Column(name = "subject")
    private String subject;

    @Column(name = "body")
    private String body;

    public LogEmail() {}

    public LogEmail(String to, String from, String subject, String body, Integer municipalityId, String action) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.body = body;
        this.sentDate = new Date().getTime();
        this.municipalityId = municipalityId;
        this.action = action;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMunicipalityId() {
        return municipalityId;
    }

    public void setMunicipalityId(Integer municipalityId) {
        this.municipalityId = municipalityId;
    }

    public Long getSentDate() {
        return sentDate;
    }

    public void setSentDate(Long sentDate) {
        this.sentDate = sentDate;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
