package wifi4eu.wifi4eu.common.dto.model;

import java.util.List;

public class ThreadDTO {
    private int id;
    private String title;
    private int municipalityId;
    private List<ThreadMessageDTO> messages;

    public ThreadDTO() {
    }

    public ThreadDTO(int id, String title, int municipalityId, List<ThreadMessageDTO> messages) {
        this.id = id;
        this.title = title;
        this.municipalityId = municipalityId;
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

    public int getMunicipalityId() {
        return municipalityId;
    }

    public void setMunicipalityId(int municipalityId) {
        this.municipalityId = municipalityId;
    }

    public List<ThreadMessageDTO> getMessages() {
        return messages;
    }

    public void setMessages(List<ThreadMessageDTO> messages) {
        this.messages = messages;
    }
}