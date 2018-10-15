package wifi4eu.wifi4eu.entity.warnings;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WarningsNumber {

    @Id
    @Column(name = "registration_id")
    private Integer registrationId;

    @Column(name = "warning1")
    private Integer warning1;

    @Column(name = "warning2")
    private Integer warning2;

    @Column(name = "warning3")
    private Integer warning3;

    public WarningsNumber() {

    }

    public WarningsNumber(Integer registrationId, Integer warning1, Integer warning2, Integer warning3) {
        this.registrationId = registrationId;
        this.warning1 = warning1;
        this.warning2 = warning2;
        this.warning3 = warning3;
    }

    public Integer getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Integer registrationId) {
        this.registrationId = registrationId;
    }

    public Integer getWarning1() {
        return warning1;
    }

    public void setWarning1(Integer warning1) {
        this.warning1 = warning1;
    }

    public Integer getWarning2() {
        return warning2;
    }

    public void setWarning2(Integer warning2) {
        this.warning2 = warning2;
    }

    public Integer getWarning3() {
        return warning3;
    }

    public void setWarning3(Integer warning3) {
        this.warning3 = warning3;
    }
}
