package wifi4eu.wifi4eu.entity;

import javax.persistence.*;

@Entity
@Table(name = "thread_messages")
public class ThreadMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id;

    @ManyToOne
    @JoinColumn(name = "thread")
    Thread thread;

    @ManyToOne
    @JoinColumn(name = "author")
    User author;

    @Column(name = "message")
    String message;

    public ThreadMessage() {
    }

    public ThreadMessage(Integer id, Thread thread, User author, String message) {
        this.id = id;
        this.thread = thread;
        this.author = author;
        this.message = message;
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
}