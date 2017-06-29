package wifi4eu.wifi4eu.entity.helpdesk;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "HEL_HELPDESK_COMMENTS_T")
public class HelpdeskComment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COMMENT_ID")
    private Long commentId;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "COMMENT")
    private String comment;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "COMMENT_DATE")
    private Date commentDate;

    @Column(name = "ISSUE_ID")
    private Long issueId;

    public HelpdeskComment() {
    }

    public HelpdeskComment(String type, String comment, Date commentDate, Long issueId) {
        this.type = type;
        this.comment = comment;
        this.commentDate = commentDate;
        this.issueId = issueId;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Long getIssueId() {
        return issueId;
    }

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
    }
}
