package wifi4eu.wifi4eu.entity.thread;

import wifi4eu.wifi4eu.entity.location.Lau;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "threads")
public class Thread {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "reason")
    private String reason;

    @Column(name = "type")
    private Integer type;

    @Column(name = "mediation")
    private boolean mediation;

//    @OneToOne
//    @JoinColumn(name = "reason")
//    private Lau lau;

    @OneToMany(mappedBy = "thread")
    private List<ThreadMessage> messages;

    public Thread() {
    }

    public Thread(Integer id, String title, Integer type, String reason, List<ThreadMessage> messages) {
        this.id = id;
        this.title = title;
        this.reason = reason;
        this.type = type;
        this.messages = messages;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<ThreadMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ThreadMessage> messages) {
        this.messages = messages;
    }

    public boolean isMediation() {
        return mediation;
    }

    public void setMediation(boolean mediation) {
        this.mediation = mediation;
    }
}