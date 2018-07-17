package wifi4eu.wifi4eu.entity.helpdesk;

import javax.persistence.*;

@Entity
@Table(name = "helpdesk_comments")
public class HelpdeskComment {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "issue")
    private HelpdeskIssue issue;

    @Column(name = "from_email")
    private String fromEmail;

    @Column(name = "comment")
    private String comment;

    @Column(name = "create_date")
    private Long createDate;

    public HelpdeskComment() {
    }

    public HelpdeskComment(Integer id, HelpdeskIssue issue, String fromEmail, String comment, Long createDate) {
        this.id = id;
        this.issue = issue;
        this.fromEmail = fromEmail;
        this.comment = comment;
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public HelpdeskIssue getIssue() {
        return issue;
    }

    public void setIssue(HelpdeskIssue issue) {
        this.issue = issue;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }
}