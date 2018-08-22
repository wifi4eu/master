package wifi4eu.wifi4eu.common.dto.model;

import java.util.Date;

public class ConditionsAgreementDTO {

    private Integer id;
    private Integer registrationId;
    private Integer status;
    private Integer userId;
    private Date changeStatusDate;

    public ConditionsAgreementDTO() {
    }

    public ConditionsAgreementDTO(Integer id, Integer registrationId, Integer status, Integer userId, Date changeStatusDate) {
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
