package wifi4eu.wifi4eu.entity.registration;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "registration_users")
public class RegistrationUsers {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "_user")
    private Integer userId;

    @Column(name = "registration")
    private Integer registrationId;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "status")
    private Integer status;

    @Column(name = "main")
    private Integer main;

    @Column(name = "contact_email")
    private String contactEmail;

    public RegistrationUsers() {

    }

    public RegistrationUsers(Integer userId, Integer registrationId, Date creationDate, Integer status, Integer main, String contactEmail) {
        this.userId = userId;
        this.registrationId = registrationId;
        this.creationDate = creationDate;
        this.status = status;
        this.main = main;
        this.contactEmail = contactEmail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Integer registrationId) {
        this.registrationId = registrationId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getMain() {
        return main;
    }

    public void setMain(Integer main) {
        this.main = main;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
}
