package wifi4eu.wifi4eu.entity.warnings;

import wifi4eu.wifi4eu.entity.registration.Registration;

import javax.persistence.*;

@Entity
@Table(name = "registration_warnings")
public class RegistrationWarning {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "registration_id")
    private Registration registration;

    @Column(name = "warning")
    private Integer warning;

    public RegistrationWarning() {
    }

    public RegistrationWarning(Registration registration, Integer warning) {
        this.registration = registration;
        this.warning = warning;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    public Integer getWarning() {
        return warning;
    }

    public void setWarning(Integer warning) {
        this.warning = warning;
    }
}