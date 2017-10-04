package wifi4eu.wifi4eu.entity.helpdesk;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "helpdesk_issues")
public class HelpdeskIssue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "from_email")
    private String fromEmail;

    @Column(name = "assigned_to")
    private String assignedTo;

    @Column(name = "topic")
    private String topic;

    @Column(name = "portal")
    private String portal;

    @Column(name = "member_state")
    private String memberState;

    @Column(name = "summary")
    private String summary;

    @Column(name = "create_date")
    private Long createDate;

    @Column(name = "status")
    private Integer status;

    @OneToMany(mappedBy = "issue")
    private List<HelpdeskComment> comments;

    public HelpdeskIssue() {
    }

    public HelpdeskIssue(Integer id, String fromEmail, String assignedTo, String topic, String portal, String memberState, String summary, Long createDate, Integer status) {
        this.id = id;
        this.fromEmail = fromEmail;
        this.assignedTo = assignedTo;
        this.topic = topic;
        this.portal = portal;
        this.memberState = memberState;
        this.summary = summary;
        this.createDate = createDate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getPortal() {
        return portal;
    }

    public void setPortal(String portal) {
        this.portal = portal;
    }

    public String getMemberState() {
        return memberState;
    }

    public void setMemberState(String memberState) {
        this.memberState = memberState;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<HelpdeskComment> getComments() {
        return comments;
    }

    public void setComments(List<HelpdeskComment> comments) {
        this.comments = comments;
    }
}