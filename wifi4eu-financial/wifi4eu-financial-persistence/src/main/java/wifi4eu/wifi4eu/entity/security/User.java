package wifi4eu.wifi4eu.entity.security;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "SEC_USERS_T")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ACCESS_DATE")
    private Date accessDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "SEC_USER_ROLES_T", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private List<Role> roles;

    @Column(name = "USER_TYPE")
    private long userType;

    @Column(name = "USER_TYPE_ID")
    private long userTypeId;

    public User() {

    }

    public User(Long userId, String email, String password, Date createDate, Date accessDate, List<Role> roles, long userType, long userTypeId) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.createDate = createDate;
        this.accessDate = accessDate;
        this.roles = roles;
        this.userType = userType;
        this.userTypeId = userTypeId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
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

    public long getUserType() {
        return userType;
    }

    public void setUserType(long userType) {
        this.userType = userType;
    }

    public long getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(long userTypeId) {
        this.userTypeId = userTypeId;
    }
}