package wifi4eu.wifi4eu.entity.invitationContacts;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "invitation_contacts")
public class InvitationContact {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type")
    private Integer type;

    @Column(name = "id_registration")
    private Integer idRegistration;

    @Column(name = "id_supplier")
    private Integer idSupplier;

    @Column(name = "id_user_request")
    private Integer idUserRequest;

    @Column(name = "email_invited")
    private String emailInvited;

    @Column(name = "status")
    private Integer status;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "last_modified")
    private Date lastModified;

    @Column(name = "id_organization")
    private Integer idAssociation;

    public InvitationContact(){

    }

    public InvitationContact(Integer type, Integer idRegistration, Integer idSupplier, Integer idUserRequest, String emailInvited, Integer status, Date createDate, Date lastModified, Integer idAssociation) {
        this.type = type;
        this.idRegistration = idRegistration;
        this.idSupplier = idSupplier;
        this.idUserRequest = idUserRequest;
        this.emailInvited = emailInvited;
        this.status = status;
        this.createDate = createDate;
        this.lastModified = lastModified;
        this.idAssociation = idAssociation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIdRegistration() {
        return idRegistration;
    }

    public void setIdRegistration(Integer idRegistration) {
        this.idRegistration = idRegistration;
    }

    public Integer getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(Integer idSupplier) {
        this.idSupplier = idSupplier;
    }

    public Integer getIdUserRequest() {
        return idUserRequest;
    }

    public void setIdUserRequest(Integer idUserRequest) {
        this.idUserRequest = idUserRequest;
    }

    public String getEmailInvited() {
        return emailInvited;
    }

    public void setEmailInvited(String emailInvited) {
        this.emailInvited = emailInvited;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Integer getIdAssociation() {
        return idAssociation;
    }

    public void setIdAssociation(Integer idAssociation) {
        this.idAssociation = idAssociation;
    }
}
