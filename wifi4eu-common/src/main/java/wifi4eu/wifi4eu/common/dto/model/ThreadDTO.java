package wifi4eu.wifi4eu.common.dto.model;

import java.util.List;

public class ThreadDTO {
    private int id;
    private String title;
    private int lauId;
    private List<ThreadMessageDTO> messages;

    public ThreadDTO() {
    }

    public ThreadDTO(int id, String title, int lauId, List<ThreadMessageDTO> messages) {
        this.id = id;
        this.title = title;
        this.lauId = lauId;
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

    public int getLauId() {
        return lauId;
    }

    public void setLauId(int lauId) {
        this.lauId = lauId;
    }

    public List<ThreadMessageDTO> getMessages() {
        return messages;
    }

    public void setMessages(List<ThreadMessageDTO> messages) {
        this.messages = messages;
    }
}