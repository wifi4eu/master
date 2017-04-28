package wifi4eu.wifi4eu.common.dto.model;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class HelpdeskCommentDTO {

    private Long commentId;
    private String type;
    private String comment;
    private Date commentDate;
    private Long issueId;

    public HelpdeskCommentDTO() {
    }

    public HelpdeskCommentDTO(Long commentId, String type, String comment, Date commentDate, Long issueId) {
        this.commentId = commentId;
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
