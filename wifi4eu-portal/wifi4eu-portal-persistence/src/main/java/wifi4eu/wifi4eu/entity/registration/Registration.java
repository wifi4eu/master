package wifi4eu.wifi4eu.entity.registration;

import wifi4eu.wifi4eu.entity.user.User;
import wifi4eu.wifi4eu.entity.municipality.Municipality;

import javax.persistence.*;

@Entity
@Table(name = "registrations")
public class Registration {
    @Id
    @SequenceGenerator(name = "registratrion_seq", allocationSize = 1, initialValue = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "registration_seq")
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "municipality")
    private Municipality municipality;

    @Column(name = "role")
    private String role;

    @Column(name = "_status")
    private int status;

    @Column(name = "legal_file1")
    private String legalFile1;

    @Column(name = "legal_file2")
    private String legalFile2;

    @Column(name = "legal_file3")
    private String legalFile3;

    @Column(name = "legal_file4")
    private String legalFile4;

    public Registration() {
    }

    public Registration(User user, Municipality municipality, String role, int status, String legalFile1, String legalFile2, String legalFile3, String legalFile4) {
        this.user = user;
        this.municipality = municipality;
        this.role = role;
        this.status = status;
        this.legalFile1 = legalFile1;
        this.legalFile2 = legalFile2;
        this.legalFile3 = legalFile3;
        this.legalFile4 = legalFile4;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public int getStatus() {
        return status;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLegalFile1() {
        return legalFile1;
    }

    public void setLegalFile1(String legalFile1) {
        this.legalFile1 = legalFile1;
    }

    public String getLegalFile2() {
        return legalFile2;
    }

    public void setLegalFile2(String legalFile2) {
        this.legalFile2 = legalFile2;
    }

    public String getLegalFile3() {
        return legalFile3;
    }

    public void setLegalFile3(String legalFile3) {
        this.legalFile3 = legalFile3;
    }

    public String getLegalFile4() {
        return legalFile4;
    }

    public void setLegalFile4(String legalFile4) {
        this.legalFile4 = legalFile4;
    }
}