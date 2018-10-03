package wifi4eu.wifi4eu.entity.registration;

import wifi4eu.wifi4eu.entity.application.Application;
import wifi4eu.wifi4eu.entity.municipality.Municipality;
import wifi4eu.wifi4eu.entity.user.User;
import wifi4eu.wifi4eu.entity.warnings.RegistrationWarning;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "registrations")
public class Registration {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "municipality")
    private Municipality municipality;

    @OneToMany(mappedBy = "registration")
    private List<Application> applications;

    @Column(name = "role")
    private String role;

    @Column(name = "_status")
    private int status;

    @Column(name = "ip_registration")
    private String ipRegistration;

    @Column(name = "association_name")
    private String associationName;

    @Column(name = "organisation_id")
    private int organisationId;

    @Column(name = "allFiles_flag")
    private int allFilesFlag;

    @Column(name = "mail_counter")
    private int mailCounter;

    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JoinColumn(name = "registration_id")
    private List<RegistrationWarning> registrationWarningList;

    @Column(name = "id_status_beneficiary")
    private int idStatusBeneficiary;

    @Column(name = "id_pm")
    private int idUserPM;

    @Column(name = "id_bpm")
    private int idUserBPM;

    @Column(name = "compliance")
    private boolean compliance;

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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "registration_users",
          joinColumns = @JoinColumn( name="registration", referencedColumnName = "id"),
          inverseJoinColumns = @JoinColumn( name="_user", referencedColumnName = "id"))
    private List<User> users;

    public Registration() {
    }

    public Registration(Municipality municipality, String role, int status, String ipRegistration, String associationName, int organisationId, int allFilesFlag, int mailCounter, List<RegistrationWarning> registrationWarningList, int idStatusBeneficiary, int idUserPM, int idUserBPM, boolean compliance, int actionToBeTaken, int actionTaken, Date installationSiteSubmission, Date installationSiteRejection, Date installationSiteConfirmation, boolean conformity, Timestamp firstFalseCheck, Timestamp dateRegistered, List<User> users) {
        this.municipality = municipality;
        this.role = role;
        this.status = status;
        this.ipRegistration = ipRegistration;
        this.associationName = associationName;
        this.organisationId = organisationId;
        this.allFilesFlag = allFilesFlag;
        this.mailCounter = mailCounter;
        this.registrationWarningList = registrationWarningList;
        this.idStatusBeneficiary = idStatusBeneficiary;
        this.idUserPM = idUserPM;
        this.idUserBPM = idUserBPM;
        this.compliance = compliance;
        this.actionToBeTaken = actionToBeTaken;
        this.actionTaken = actionTaken;
        this.installationSiteSubmission = installationSiteSubmission;
        this.installationSiteRejection = installationSiteRejection;
        this.installationSiteConfirmation = installationSiteConfirmation;
        this.conformity = conformity;
        this.firstFalseCheck = firstFalseCheck;
        this.dateRegistered = dateRegistered;
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
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

    public String getIpRegistration() {
        return ipRegistration;
    }

    public void setIpRegistration(String ipRegistration) {
        this.ipRegistration = ipRegistration;
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

    public int getAllFilesFlag() {
        return allFilesFlag;
    }

    public void setAllFilesFlag(int allFilesFlag) {
        this.allFilesFlag = allFilesFlag;
    }

    public int getMailCounter() {
        return mailCounter;
    }

    public void setMailCounter(int mailCounter) {
        this.mailCounter = mailCounter;
    }

    public List<RegistrationWarning> getRegistrationWarningList() {
        return registrationWarningList;
    }

    public void setRegistrationWarningList(List<RegistrationWarning> registrationWarningList) {
        this.registrationWarningList = registrationWarningList;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Application> getApplications() {
        if (applications == null) {
            applications = new ArrayList<>(0);
        }
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }
}