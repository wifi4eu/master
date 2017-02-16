package wifi4eu.wifi4eu.entity.security;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="SEC_USERS_T")
public class User {

    @Id
<<<<<<< HEAD
=======
    @GeneratedValue(strategy = GenerationType.AUTO)
>>>>>>> b91e370681b926aaabd5d02c9cad160ca95ca8e2
    @Column(name="USER_ID")
    private Long userId;

    @Column(name="EMAIL")
    private String email;

    @Column(name="PASSWORD")
<<<<<<< HEAD
    private Long password;
=======
    private String password;
>>>>>>> b91e370681b926aaabd5d02c9cad160ca95ca8e2

    @Column(name="CREATE_DATE")
    private Date createDate;

    @Column(name="ACESS_DATE")
    private Date accessDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "SEC_USER_ROLES_T", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private List<Role> roles;


    public User() {

    }

<<<<<<< HEAD
    public User(long userId, String email, long password, Date createDate, Date accessDate, List<Role> roles) {
=======
    public User(long userId, String email, String password, Date createDate, Date accessDate, List<Role> roles) {
>>>>>>> b91e370681b926aaabd5d02c9cad160ca95ca8e2
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.createDate = createDate;
        this.accessDate = accessDate;
        this.roles = roles;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

<<<<<<< HEAD
    public long getPassword() {
        return password;
    }

    public void setPassword(long password) {
=======
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
>>>>>>> b91e370681b926aaabd5d02c9cad160ca95ca8e2
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getAccessDate() {
        return accessDate;
    }

    public void setAccessDate(Date accessDate) {
        this.accessDate = accessDate;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}