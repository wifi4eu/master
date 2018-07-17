package wifi4eu.wifi4eu.entity.registration;

import wifi4eu.wifi4eu.entity.municipality.Municipality;
import wifi4eu.wifi4eu.entity.user.User;
import wifi4eu.wifi4eu.entity.warnings.RegistrationWarning;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "registrations")
public class Registration {


    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "municipality")
    private Municipality municipality;

    @Column(name = "role")
    private String role;

    @Column(name = "_status")
    private int status;

    @Column(name = "legal_file1_size")
    private Long legalFile1Size;

    @Column(name = "legal_file1_mime")
    private String legalFile1Mime;

    @Column(name = "legal_file2_size")
    private Long legalFile2Size;

    @Column(name = "legal_file2_mime")
    private String legalFile2Mime;

    @Column(name = "legal_file3_size")
    private Long legalFile3Size;

    @Column(name = "legal_file3_mime")
    private String legalFile3Mime;

    @Column(name = "legal_file4_size")
    private Long legalFile4Size;

    @Column(name = "legal_file4_mime")
    private String legalFile4Mime;

    @Column(name = "ip_registration")
    private String ipRegistration;

    @Column(name = "association_name")
    private String associationName;

    @Column(name = "organisation_id")
    private int organisationId;

    @Column(name = "upload_time")
    private Long uploadTime;

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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "registration_users",
            joinColumns = @JoinColumn( name="registration", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn( name="_user", referencedColumnName = "id"))
    private List<User> users;

    public Registration() {
    }

    public Registration(Municipality municipality, String role, int status, long legalFile1Size, String legalFile1Mime, long legalFile2Size, String legalFile2Mime, long legalFile3Size, String legalFile3Mime, long legalFile4Size, String legalFile4Mime, String ipRegistration, String associationName, int organisationId, Long uploadTime, int allFilesFlag, int mailCounter, List<RegistrationWarning> registrationWarningList, int idStatusBeneficiary, int idUserPM, int idUserBPM, boolean compliance, int actionToBeTaken, int actionTaken, Date installationSiteSubmission, Date installationSiteRejection, Date installationSiteConfirmation, boolean conformity, Timestamp firstFalseCheck, Timestamp dateRegistered, List<User> users) {
        this.municipality = municipality;
        this.role = role;
        this.status = status;
        this.legalFile1Size = legalFile1Size;
        this.legalFile1Mime = legalFile1Mime;
        this.legalFile2Size = legalFile2Size;
        this.legalFile2Mime = legalFile2Mime;
        this.legalFile3Size = legalFile3Size;
        this.legalFile3Mime = legalFile3Mime;
        this.legalFile4Size = legalFile4Size;
        this.legalFile4Mime = legalFile4Mime;
        this.ipRegistration = ipRegistration;
        this.associationName = associationName;
        this.organisationId = organisationId;
        this.uploadTime = uploadTime;
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

    public Long getLegalFile1Size() {
        return legalFile1Size;
    }

    public void setLegalFile1Size(Long legalFile1Size) {
        this.legalFile1Size = legalFile1Size;
    }

    public String getLegalFile1Mime() {
        return legalFile1Mime;
    }

    public void setLegalFile1Mime(String legalFile1Mime) {
        this.legalFile1Mime = legalFile1Mime;
    }

    public Long getLegalFile2Size() {
        return legalFile2Size;
    }

    public void setLegalFile2Size(Long legalFile2Size) {
        this.legalFile2Size = legalFile2Size;
    }

    public String getLegalFile2Mime() {
        return legalFile2Mime;
    }

    public void setLegalFile2Mime(String legalFile2Mime) {
        this.legalFile2Mime = legalFile2Mime;
    }

    public Long getLegalFile3Size() {
        return legalFile3Size;
    }

    public void setLegalFile3Size(Long legalFile3Size) {
        this.legalFile3Size = legalFile3Size;
    }

    public String getLegalFile3Mime() {
        return legalFile3Mime;
    }

    public void setLegalFile3Mime(String legalFile3Mime) {
        this.legalFile3Mime = legalFile3Mime;
    }

    public Long getLegalFile4Size() {
        return legalFile4Size;
    }

    public void setLegalFile4Size(Long legalFile4Size) {
        this.legalFile4Size = legalFile4Size;
    }

    public String getLegalFile4Mime() {
        return legalFile4Mime;
    }

    public void setLegalFile4Mime(String legalFile4Mime) {
        this.legalFile4Mime = legalFile4Mime;
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

    public Long getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Long uploadTime) {
        this.uploadTime = uploadTime;
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
}