package wifi4eu.wifi4eu.entity.security;

import wifi4eu.wifi4eu.entity.user.User;

import javax.persistence.*;

@Entity
@Table(name = "rights")
public class Right {


    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "rightdesc")
    private String rightdesc;

    @Column(name = "type")
    private Integer type;

    public Right() {

    }

    public Right(User user, String rightdesc, Integer type) {
        this.user = user;
        this.rightdesc = rightdesc;
        this.type = type;
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

    public String getRightdesc() {
        return rightdesc;
    }

    public void setRightdesc(String rightdesc) {
        this.rightdesc = rightdesc;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}