package wifi4eu.wifi4eu.entity.registration;

import wifi4eu.wifi4eu.entity.user.User;
import wifi4eu.wifi4eu.entity.municipality.Municipality;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "registrations")
public class Registration {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "organisation_id")
    private int organisation_id;

    @Column(name = "association_name")
    private String association_name;

    @Column(name = "id_status_beneficiary")
    private int idStatusBeneficiary;

    @Column(name = "id_pm")
    private int idUserPM;

    @Column(name = "id_bpm")
    private int idUserBPM;

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

    @Column(name = "is_submission")
    private Date installationSiteSubmission;

    @Column(name = "is_rejection")
    private Date installationSiteRejection;

    @Column(name = "is_confirmation")
    private Date installationSiteConfirmation;

    @Column(name = "conformity")
    private boolean conformity;

    @Column(name = "first_false_check")
    private Timestamp firstFalseCheck;

    @Column(name = "date_registered")
    private Timestamp dateRegistered;

    public Registration() {
    }


    public Registration(User user, Municipality municipality, String role, int status, String legalFile1, String legalFile2, String legalFile3, String legalFile4, String ipRegistration, int organisation_id, String association_name, int idStatusBeneficiary, int idUserPM, int idUserBPM, boolean compliance, String shortMemberState, String memberState, String call, int actionToBeTaken, int actionTaken, Date installationSiteSubmission, Date installationSiteRejection, Date installationSiteConfirmation, boolean conformity, Timestamp firstFalseCheck, Timestamp dateRegistered) {
        this.user = user;
        this.municipality = municipality;
        this.role = role;
        this.status = status;
        this.legalFile1 = legalFile1;
        this.legalFile2 = legalFile2;
        this.legalFile3 = legalFile3;
        this.legalFile4 = legalFile4;
        this.ipRegistration = ipRegistration;
        this.organisation_id = organisation_id;
        this.association_name = association_name;
        this.idStatusBeneficiary = idStatusBeneficiary;
        this.idUserPM = idUserPM;
        this.idUserBPM = idUserBPM;
        this.compliance = compliance;
        this.shortMemberState = shortMemberState;
        this.memberState = memberState;
        this.call = call;
        this.actionToBeTaken = actionToBeTaken;
        this.actionTaken = actionTaken;
        this.installationSiteSubmission = installationSiteSubmission;
        this.installationSiteRejection = installationSiteRejection;
        this.installationSiteConfirmation = installationSiteConfirmation;
        this.conformity = conformity;
        this.firstFalseCheck = firstFalseCheck;
        this.dateRegistered = dateRegistered;
    }

    public Date getInstallationSiteSubmission() {
        return installationSiteSubmission;
    }

    public void setInstallationSiteSubmission(Date installationSiteSubmission) {
        this.installationSiteSubmission = installationSiteSubmission;
    }

    public Date getInstallationSiteRejection() {
        return installationSiteRejection;
    }

    public void setInstallationSiteRejection(Date installationSiteRejection) {
        this.installationSiteRejection = installationSiteRejection;
    }

    public Date getInstallationSiteConfirmation() {
        return installationSiteConfirmation;
    }

    public void setInstallationSiteConfirmation(Date installationSiteConfirmation) {
        this.installationSiteConfirmation = installationSiteConfirmation;
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

    public int getOrganisation_id() {
        return organisation_id;
    }

    public void setOrganisation_id(int organisation_id) {
        this.organisation_id = organisation_id;
    }

    public String getAssociation_name() {
        return association_name;
    }

    public void setAssociation_name(String association_name) {
        this.association_name = association_name;
    }

    public int getIdStatusBeneficiary() {
        return idStatusBeneficiary;
    }

    public void setIdStatusBeneficiary(int idStatusBeneficiary) {
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

    public int getIdUserPM() {
        return idUserPM;
    }

    public void setIdUserPM(int idUserPM) {
        this.idUserPM = idUserPM;
    }

    public int getIdUserBPM() {
        return idUserBPM;
    }

    public void setIdUserBPM(int idUserBPM) {
        this.idUserBPM = idUserBPM;
    }
}