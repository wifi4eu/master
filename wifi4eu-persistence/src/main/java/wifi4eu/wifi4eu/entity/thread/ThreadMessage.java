package wifi4eu.wifi4eu.entity.thread;

import wifi4eu.wifi4eu.entity.user.User;

import javax.persistence.*;

@Entity
@Table(name = "thread_messages")
public class ThreadMessage {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "thread")
    private Thread thread;

    @ManyToOne
    @JoinColumn(name = "author")
    private User author;

    @Column(name = "message")
    private String message;

    @Column(name = "create_date")
    private Long createDate;

    @Column (name = "registration")
    private Integer registration;

    public ThreadMessage() {
    }

    public ThreadMessage(Integer id, Thread thread, User author, String message, Long createDate, Integer registration) {
        this.id = id;
        this.thread = thread;
        this.author = author;
        this.message = message;
        this.createDate = createDate;
        this.registration = registration;
    }

    public Integer get() {
        return id;
    }

    public void set(Integer id) {
        this.id = id;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public Integer getRegistration() { return registration; }

    public void setRegistration(Integer registration) { this.registration = registration; }
}