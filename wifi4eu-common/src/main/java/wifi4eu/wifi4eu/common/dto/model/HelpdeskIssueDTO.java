package wifi4eu.wifi4eu.common.dto.model;

import java.util.List;

public class HelpdeskIssueDTO {
    private int id;
    private String fromEmail;
    private String assignedTo;
    private String topic;
    private String portal;
    private String memberState;
    private String summary;
    //TODO: Modificar los Date a objetos tipo Date
    private long createDate;
    private int status;
    private List<HelpdeskCommentDTO> comments;

    public HelpdeskIssueDTO() {
    }

    public HelpdeskIssueDTO(int id, String fromEmail, String assignedTo, String topic, String portal, String memberState, String summary, long createDate, int status, List<HelpdeskCommentDTO> comments) {
        this.id = id;
        this.fromEmail = fromEmail;
        this.assignedTo = assignedTo;
        this.topic = topic;
        this.portal = portal;
        this.memberState = memberState;
        this.summary = summary;
        this.createDate = createDate;
        this.status = status;
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<HelpdeskCommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<HelpdeskCommentDTO> comments) {
        this.comments = comments;
    }
}