package wifi4eu.wifi4eu.common.dto.model;

import java.util.List;

public class ThreadDTO {
    private int id;
    private String title;
    private String reason;
    private int type;
    private List<ThreadMessageDTO> messages;

    public ThreadDTO() {
    }

    public ThreadDTO(int id, String title, String reason, int type, List<ThreadMessageDTO> messages) {
        this.id = id;
        this.title = title;
        this.reason = reason;
        this.type = type;
        this.messages = messages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<ThreadMessageDTO> getMessages() {
        return messages;
    }

    public void setMessages(List<ThreadMessageDTO> messages) {
        this.messages = messages;
    }
}