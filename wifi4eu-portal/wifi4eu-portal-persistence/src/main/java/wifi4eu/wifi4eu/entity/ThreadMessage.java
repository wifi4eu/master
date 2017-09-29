package wifi4eu.wifi4eu.entity;

import javax.persistence.*;

@Entity
@Table(name = "thread_messages")
public class ThreadMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;

    @ManyToOne
    @JoinColumn(name = "thread", table = "threads")
    Thread thread;

    @ManyToOne
    @JoinColumn(name = "author", table = "users")
    User author;

    @Column(name = "message")
    String message;

    public ThreadMessage() {
    }

    public ThreadMessage(int id, Thread thread, User author, String message) {
        this.id = id;
        this.thread = thread;
        this.author = author;
        this.message = message;
    }

    public int get() {
        return id;
    }

    public void set(int id) {
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