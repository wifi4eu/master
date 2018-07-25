package wifi4eu.wifi4eu.entity.registration;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "conditions_agreement")
public class ConditionsAgreement {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "registration_id")
    private Integer registrationId;

    @Column(name = "status")
    private Integer status;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "change_status_date")
    private Date changeStatusDate;

    public ConditionsAgreement() {
    }

    public ConditionsAgreement(Integer id, Integer registrationId, Integer status, Integer userId, Date changeStatusDate) {
        this.id = id;
        this.registrationId = registrationId;
        this.status = status;
        this.userId = userId;
        this.changeStatusDate = changeStatusDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Integer registrationId) {
        this.registrationId = registrationId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getChangeStatusDate() {
        return changeStatusDate;
    }

    public void setChangeStatusDate(Date changeStatusDate) {
        this.changeStatusDate = changeStatusDate;
    }
}
