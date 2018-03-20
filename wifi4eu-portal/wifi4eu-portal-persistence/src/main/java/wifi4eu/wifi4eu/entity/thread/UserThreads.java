package wifi4eu.wifi4eu.entity.thread;

import wifi4eu.wifi4eu.entity.location.Nuts;
import wifi4eu.wifi4eu.entity.supplier.Supplier;
import wifi4eu.wifi4eu.entity.user.User;

import javax.persistence.*;

@Entity
@Table(name = "user_threads")
public class UserThreads {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "thread")
    private Thread thread;

    public UserThreads() {
    }

    public UserThreads(Integer id, User user, Thread thread) {
        this.id = id;
        this.user = user;
        this.thread = thread;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }
}