package wifi4eu.wifi4eu.common.dto.model;

public class ThreadDTO {
    int id;
    String title;

    public ThreadDTO() {
    }

    public ThreadDTO(int id, String title) {
        this.id = id;
        this.title = title;
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
}