package wifi4eu.wifi4eu.entity.beneficiary;

import javax.persistence.*;

/**
 * Created by rgarcita on 09/02/2017.
 */
@Entity
@Table(name = "BEN_MAY_T")
public class Mayor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MAYOR_ID")
    private Long mayorId;

    @Column(name = "TREATMENT")
    private String treatment;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "LEGAL_ENTITY_ID")
    private Long legalEntityId;

    public Mayor() {
    }

    public Mayor(Long mayorId, String treatment, String name, String surname, String email, Long legalEntityId) {
        this.mayorId = mayorId;
        this.treatment = treatment;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.legalEntityId = legalEntityId;
    }

    public Long getMayorId() {
        return mayorId;
    }

    public void setMayorId(Long mayorId) {
        this.mayorId = mayorId;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getLegalEntityId() {
        return legalEntityId;
    }

    public void setLegalEntityId(Long legalEntityId) {
        this.legalEntityId = legalEntityId;
    }
}
