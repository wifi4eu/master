package wifi4eu.wifi4eu.entity.security;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="SEC_USERS_T")
public class User {

    @Id
    @Column(name="PER_ID")
    private Long perId;

    @Column(name="USERID")
    private String userId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "SEC_USER_ROLES_T", joinColumns = @JoinColumn(name = "per_id", referencedColumnName = "per_id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private List<Role> roles;


    public User() {

    }

    public User(Long perId, String userId, List<Role> roles) {
        this.perId = perId;
        this.userId = userId;
        this.roles = roles;
    }


    public Long getPerId() {
        return perId;
    }

    public void setPerId(Long perId) {
        this.perId = perId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

}