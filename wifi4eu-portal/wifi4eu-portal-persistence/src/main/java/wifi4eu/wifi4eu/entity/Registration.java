package wifi4eu.wifi4eu.entity;

import javax.persistence.*;

@Entity
@Table(name = "registrations")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;

    @ManyToOne
    @JoinColumn(name = "user", table = "users")
    User user;

    @ManyToOne
    @JoinColumn(name = "municipality", table = "municipalities")
    Municipality municipality;

    @Column(name = "role")
    String role;

    @ManyToOne
    @JoinColumn(name = "thread", table = "threads")
    Thread thread;

    public Registration() {
    }

    public Registration(User user, Municipality municipality, String role, Thread thread) {
        this.user = user;
        this.municipality = municipality;
        this.role = role;
        this.thread = thread;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }
}