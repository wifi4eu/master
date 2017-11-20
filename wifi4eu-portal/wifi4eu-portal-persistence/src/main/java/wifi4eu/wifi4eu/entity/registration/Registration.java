package wifi4eu.wifi4eu.entity.registration;

import wifi4eu.wifi4eu.entity.user.User;
import wifi4eu.wifi4eu.entity.municipality.Municipality;

import javax.persistence.*;

@Entity
@Table(name = "registrations")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "municipality")
    private Municipality municipality;

    @Column(name = "role")
    private String role;

    @Column(name = "status")
    private int status;

    public Registration() {
    }

    public Registration(User user, Municipality municipality, String role, int status) {
        this.user = user;
        this.municipality = municipality;
        this.role = role;
        this.status = status;
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

    public int getStatus() {
        return status;
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

    public void setStatus(int status) {
        this.status = status;
    }
}