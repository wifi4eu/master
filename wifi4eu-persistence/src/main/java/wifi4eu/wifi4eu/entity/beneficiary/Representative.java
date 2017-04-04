package wifi4eu.wifi4eu.entity.beneficiary;

import javax.persistence.*;

/**
 * Created by rgarcita on 09/02/2017.
 */
@Entity
@Table(name = "BEN_REP_T")
public class Representative {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "REPRESENTATIVE_ID")
    private Long representativeId;

    @Column(name = "TREATMENT")
    private String treatment;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "MUNICIPALITY_ROLE")
    private String municipalityRole;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "MAYOR_ID")
    private Long mayorId;

    public Representative() {
    }

    public Representative(long representativeId, String treatment, String name, String surname, String municipalityRole, String email, long mayorId) {
        this.representativeId = representativeId;
        this.treatment = treatment;
        this.name = name;
        this.surname = surname;
        this.municipalityRole = municipalityRole;
        this.email = email;
        this.mayorId = mayorId;
    }

    public long getRepresentativeId() {
        return representativeId;
    }

    public void setRepresentativeId(long representativeId) {
        this.representativeId = representativeId;
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

    public String getMunicipalityRole() {
        return municipalityRole;
    }

    public void setMunicipalityRole(String municipalityRole) {
        this.municipalityRole = municipalityRole;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMayorId() {
        return mayorId;
    }

    public void setMayorId(long mayorId) {
        this.mayorId = mayorId;
    }
}
