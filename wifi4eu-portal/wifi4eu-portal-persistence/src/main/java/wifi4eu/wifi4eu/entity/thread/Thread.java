package wifi4eu.wifi4eu.entity.thread;

import wifi4eu.wifi4eu.entity.location.Lau;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "threads")
public class Thread {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @OneToOne
    @JoinColumn(name = "lau")
    private Lau lau;

    @OneToMany(mappedBy = "thread")
    private List<ThreadMessage> messages;

    public Thread() {
    }

    public Thread(Integer id, String title, Lau lau, List<ThreadMessage> messages) {
        this.id = id;
        this.title = title;
        this.lau = lau;
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

    public Lau getLau() {
        return lau;
    }

    public void setLau(Lau lau) {
        this.lau = lau;
    }

    public List<ThreadMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ThreadMessage> messages) {
        this.messages = messages;
    }
}