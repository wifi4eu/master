package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Date;

public class RegistrationDTO implements Serializable {
    private int id;
    private int municipalityId;
    private String role;
    private int status;
    private String ipRegistration;
    private String associationName;
    private int organisationId;
    private int allFilesFlag;
    private int mailCounter;
    private List<RegistrationWarningDTO> registrationWarningDTOList;
    private int idUserPM;
    private int idUserBPM;
    private int idStatusBeneficiary;
    private boolean compliance;
    private int actionToBeTaken;
    private int actionTaken;
    private boolean conformity;
    private Timestamp firstFalseCheck;
    private Timestamp dateRegistered;
    private Date installationSiteSubmission;
    private Date installationSiteRejection;
    private Date installationSiteConfirmation;
    private List<UserDTO> users;

    public RegistrationDTO() {
    }

    public RegistrationDTO(int id, int municipalityId, String role, int status, String ipRegistration, String associationName, int organisationId, int allFilesFlag, int
            mailCounter, List<RegistrationWarningDTO> registrationWarningDTOList, int idUserPM, int idUserBPM, int idStatusBeneficiary, boolean
                                   compliance, int actionToBeTaken, int actionTaken, boolean conformity, Timestamp firstFalseCheck, Timestamp dateRegistered, Date
                                   installationSiteSubmission, Date installationSiteRejection, Date installationSiteConfirmation, List<UserDTO> users) {
        this.id = id;
        this.municipalityId = municipalityId;
        this.role = role;
        this.status = status;
        this.ipRegistration = ipRegistration;
        this.associationName = associationName;
        this.organisationId = organisationId;
        this.allFilesFlag = allFilesFlag;
        this.mailCounter = mailCounter;
        this.registrationWarningDTOList = registrationWarningDTOList;
        this.idUserPM = idUserPM;
        this.idUserBPM = idUserBPM;
        this.idStatusBeneficiary = idStatusBeneficiary;
        this.compliance = compliance;
        this.actionToBeTaken = actionToBeTaken;
        this.actionTaken = actionTaken;
        this.conformity = conformity;
        this.firstFalseCheck = firstFalseCheck;
        this.dateRegistered = dateRegistered;
        this.installationSiteSubmission = installationSiteSubmission;
        this.installationSiteRejection = installationSiteRejection;
        this.installationSiteConfirmation = installationSiteConfirmation;
        this.users = users;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMunicipalityId() {
        return municipalityId;
    }

    public void setMunicipalityId(int municipalityId) {
        this.municipalityId = municipalityId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
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

    public List<RegistrationWarningDTO> getRegistrationWarningDTOList() {
        return registrationWarningDTOList;
    }

    public void setRegistrationWarningDTOList(List<RegistrationWarningDTO> registrationWarningDTOList) {
        this.registrationWarningDTOList = registrationWarningDTOList;
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

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }
}