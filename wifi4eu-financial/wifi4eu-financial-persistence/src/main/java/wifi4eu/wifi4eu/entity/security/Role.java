package wifi4eu.wifi4eu.entity.security;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="SEC_ROLES_T")
public class Role {

    /* ORACLE USAGE
    @SequenceGenerator(name="SEC_ROLES_SEQ", sequenceName="SEC_ROLES_SEQ", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEC_ROLES_SEQ")
    */

    @Id
    @Column(name="ROLE_ID")
    private Long roleId;

    @Column(name="NAME")
    private String name;

    @ManyToMany(cascade ={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "SEC_ROLE_RIGHTS_T", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"), inverseJoinColumns = @JoinColumn(name = "right_id", referencedColumnName = "right_id"))
    private List<Right> rights;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public Role() {
    }

    public Role(Long roleId, String name, List<Right> rights) {
        this.roleId = roleId;
        this.name = name;
        this.rights = rights;
    }


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Right> getRights() {
        return rights;
    }

    public void setRights(List<Right> rights) {
        this.rights = rights;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}