package wifi4eu.wifi4eu.entity.registration;

import wifi4eu.wifi4eu.entity.status.BeneficiaryStatus;
import wifi4eu.wifi4eu.entity.user.User;
import wifi4eu.wifi4eu.entity.municipality.Municipality;

import javax.persistence.*;
import java.sql.Timestamp;
@Entity
@Table(name = "registrations")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "association_name")
    private String associationName;

    @Column(name = "organisation_id")
    private int organisationId;

    @ManyToOne
    @JoinColumn(name = "id_status_beneficiary")
    private BeneficiaryStatus idStatusBeneficiary;

    @Column(name = "compliance")
    private boolean compliance;

    @Column(name = "short_member_state", length = 75)
    private String shortMemberState;

    @Column(name = "member_state", length = 75)
    private String memberState;

    @Column(name = "call_number" , length = 75)
    private String call;

    @Column(name = "action_to_be_taken")
    private int actionToBeTaken;

    @Column(name = "action_taken")
    private int actionTaken;

    @Column(name = "beneficiary_indicator")
    private boolean beneficiaryIndicator;

    @Column(name = "wifi_indicator")
    private boolean wifiIndicator;

    @Column(name = "conformity")
    private boolean conformity;

    @Column(name = "first_false_check")
    private Timestamp firstFalseCheck;

    @Column(name = "date_registered")
    private Timestamp dateRegistered;

    public Registration() {
    }

    public Registration(User user, Municipality municipality, String role, int status, String legalFile1, String legalFile2, String legalFile3, String legalFile4, String associationName, int organisationId, BeneficiaryStatus idStatusBeneficiary, boolean compliance, String shortMemberState, String memberState, String call, int actionToBeTaken, int actionTaken, boolean beneficiaryIndicator, boolean wifiIndicator, boolean conformity, Timestamp firstFalseCheck, Timestamp dateRegistered) {
        this.user = user;
        this.municipality = municipality;
        this.role = role;
        this.status = status;
        this.legalFile1 = legalFile1;
        this.legalFile2 = legalFile2;
        this.legalFile3 = legalFile3;
        this.legalFile4 = legalFile4;
        this.associationName = associationName;
        this.organisationId = organisationId;
        this.idStatusBeneficiary = idStatusBeneficiary;
        this.compliance = compliance;
        this.shortMemberState = shortMemberState;
        this.memberState = memberState;
        this.call = call;
        this.actionToBeTaken = actionToBeTaken;
        this.actionTaken = actionTaken;
        this.beneficiaryIndicator = beneficiaryIndicator;
        this.wifiIndicator = wifiIndicator;
        this.conformity = conformity;
        this.firstFalseCheck = firstFalseCheck;
        this.dateRegistered = dateRegistered;
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

    public String getAssociationName() {
        return associationName;
    }

    public void setAssociationName(String associationName) {
        this.associationName = associationName;
    }

    public int getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(int organisationId) {
        this.organisationId = organisationId;
    }

    public BeneficiaryStatus getIdStatusBeneficiary() {
        return idStatusBeneficiary;
    }

    public void setIdStatusBeneficiary(BeneficiaryStatus idStatusBeneficiary) {
        this.idStatusBeneficiary = idStatusBeneficiary;
    }

    public boolean isCompliance() {
        return compliance;
    }

    public void setCompliance(boolean compliance) {
        this.compliance = compliance;
    }

    public String getShortMemberState() {
        return shortMemberState;
    }

    public void setShortMemberState(String shortMemberState) {
        this.shortMemberState = shortMemberState;
    }

    public String getMemberState() {
        return memberState;
    }

    public void setMemberState(String memberState) {
        this.memberState = memberState;
    }

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public int getActionToBeTaken() {
        return actionToBeTaken;
    }

    public void setActionToBeTaken(int actionToBeTaken) {
        this.actionToBeTaken = actionToBeTaken;
    }

    public int getActionTaken() {
        return actionTaken;
    }

    public void setActionTaken(int actionTaken) {
        this.actionTaken = actionTaken;
    }

    public boolean isBeneficiaryIndicator() {
        return beneficiaryIndicator;
    }

    public void setBeneficiaryIndicator(boolean beneficiaryIndicator) {
        this.beneficiaryIndicator = beneficiaryIndicator;
    }

    public boolean isWifiIndicator() {
        return wifiIndicator;
    }

    public void setWifiIndicator(boolean wifiIndicator) {
        this.wifiIndicator = wifiIndicator;
    }

    public boolean isConformity() {
        return conformity;
    }

    public void setConformity(boolean conformity) {
        this.conformity = conformity;
    }

    public Timestamp getFirstFalseCheck() {
        return firstFalseCheck;
    }

    public void setFirstFalseCheck(Timestamp firstFalseCheck) {
        this.firstFalseCheck = firstFalseCheck;
    }

    public Timestamp getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Timestamp dateRegistered) {
        this.dateRegistered = dateRegistered;
    }
}