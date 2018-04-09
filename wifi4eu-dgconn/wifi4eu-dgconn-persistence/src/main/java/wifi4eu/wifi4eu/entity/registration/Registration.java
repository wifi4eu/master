package wifi4eu.wifi4eu.entity.registration;

import wifi4eu.wifi4eu.entity.status.BeneficiaryStatus;
import wifi4eu.wifi4eu.entity.user.User;
import wifi4eu.wifi4eu.entity.municipality.Municipality;

import javax.persistence.*;
import java.util.Date;

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

    @Column(name = "ip_registration")
    private String ipRegistration;

    @ManyToOne
    @JoinColumn(name = "id_status_beneficiary")
    private BeneficiaryStatus idStatusBeneficiary;

    @Column(name = "compliance")
    private int compliance;

    @Column(name = "short_member_state")
    private String shortMemberState;

    @Column(name = "member_state")
    private String memberState;

    @Column(name = "call_number")
    private String call;

    @Column(name = "action_to_be_taken")
    private int actionToBeTaken;

    @Column(name = "action_taken")
    private int actionTaken;

    @Column(name = "beneficiary_indicator")
    private int beneficiaryIndicator;

    @Column(name = "wifi_indicator")
    private int wifiIndicator;

    @Column(name = "conformity")
    private int conformity;

    @Column(name = "first_false_check")
    private Date firstFalseCheck;

    @Column(name = "date_registered")
    private Date dateRegistered;

    public Registration() {
    }

    public Registration(User user, Municipality municipality, String role, int status, String legalFile1, String legalFile2, String legalFile3, String legalFile4, String ipRegistration, BeneficiaryStatus idStatusBeneficiary) {
        this.user = user;
        this.municipality = municipality;
        this.role = role;
        this.status = status;
        this.legalFile1 = legalFile1;
        this.legalFile2 = legalFile2;
        this.legalFile3 = legalFile3;
        this.legalFile4 = legalFile4;
        this.ipRegistration = ipRegistration;
        this.idStatusBeneficiary = idStatusBeneficiary;
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

    public String getIpRegistration() {
        return ipRegistration;
    }

    public void setIpRegistration(String ipRegistration) {
        this.ipRegistration = ipRegistration;
    }

    public BeneficiaryStatus getIdStatusBeneficiary() {
        return idStatusBeneficiary;
    }

    public void setIdStatusBeneficiary(BeneficiaryStatus idStatusBeneficiary) {
        this.idStatusBeneficiary = idStatusBeneficiary;
    }
}