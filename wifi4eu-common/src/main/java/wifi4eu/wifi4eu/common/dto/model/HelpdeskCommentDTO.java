package wifi4eu.wifi4eu.common.dto.model;

public class HelpdeskCommentDTO {
    private int id;
    private int issueId;
    private String fromEmail;
    private String comment;
    private long createDate;

    public HelpdeskCommentDTO() {
    }

    public HelpdeskCommentDTO(int id, int issueId, String fromEmail, String comment, long createDate) {
        this.id = id;
        this.issueId = issueId;
        this.fromEmail = fromEmail;
        this.comment = comment;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
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

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }
}