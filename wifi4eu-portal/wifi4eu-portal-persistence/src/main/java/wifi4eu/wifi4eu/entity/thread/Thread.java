package wifi4eu.wifi4eu.entity.thread;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "threads")
public class Thread {
    @Id
    @SequenceGenerator(name = "thread_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "thread_seq")
    @Column(name = "id")
    Integer id;

    @Column(name = "title")
    String title;

    @OneToMany(mappedBy = "thread")
    private List<ThreadMessage> messages;

    public Thread() {
    }



    public Thread(Integer id, String title, List<ThreadMessage> messages) {
        this.id = id;
        this.title = title;
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

    public List<ThreadMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ThreadMessage> messages) {
        this.messages = messages;
    }
}