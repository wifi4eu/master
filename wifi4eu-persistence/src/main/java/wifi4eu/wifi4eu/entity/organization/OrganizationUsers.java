package wifi4eu.wifi4eu.entity.organization;

import javax.persistence.*;

@Entity
@Table(name = "organization_users")
public class OrganizationUsers {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_organization")
    private Integer idOrganization;

    @Column(name = "id_user")
    private Integer idUser;

    public OrganizationUsers() {

    }

    public OrganizationUsers(Integer id, Integer idOrganization, Integer idUser) {
        this.id = id;
        this.idOrganization = idOrganization;
        this.idUser = idUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(Integer idOrganization) {
        this.idOrganization = idOrganization;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
}
