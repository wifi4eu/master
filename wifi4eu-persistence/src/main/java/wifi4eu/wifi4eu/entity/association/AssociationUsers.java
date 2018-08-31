package wifi4eu.wifi4eu.entity.association;

import javax.persistence.*;

@Entity
@Table(name = "association_users")
public class AssociationUsers {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_Association")
    private Integer idAssociation;

    @Column(name = "id_user")
    private Integer idUser;

    public AssociationUsers() {

    }

    public AssociationUsers(Integer id, Integer idAssociation, Integer idUser) {
        this.id = id;
        this.idAssociation = idAssociation;
        this.idUser = idUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdAssociation() {
        return idAssociation;
    }

    public void setIdAssociation(Integer idAssociation) {
        this.idAssociation = idAssociation;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
}
