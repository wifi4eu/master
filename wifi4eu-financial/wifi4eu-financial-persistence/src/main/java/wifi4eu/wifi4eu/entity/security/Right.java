package wifi4eu.wifi4eu.entity.security;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="SEC_RIGHTS_T")
public class Right {

    /* ORACLE USAGE
    @SequenceGenerator(name="SEC_RIGHTS_SEQ", sequenceName="SEC_RIGHTS_SEQ", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEC_RIGHTS_SEQ")
    */


    @Id
    @Column(name="RIGHT_ID")
    private Long rightId;

    @Column(name="NAME")
    private String name;

    @ManyToMany(mappedBy = "rights")
    private List<Role> roles;

    public Right() {
    }

    public Right(Long rightId, String name) {
        this.rightId = rightId;
        this.name = name;
    }

    public Long getRightId() {
        return rightId;
    }

    public void setRightId(Long rightId) {
        this.rightId = rightId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}