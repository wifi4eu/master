package wifi4eu.wifi4eu.common.dto.model;

import javax.persistence.Column;
import java.io.Serializable;
import java.sql.Timestamp;

public class RegistrationDTO implements Serializable {
    private int id;
    private int userId;
    private int municipalityId;
    private String role;
    private int status;
    private String legalFile1;
    private String legalFile2;
    private String legalFile3;
    private String legalFile4;
    private String ipRegistration;
    private String associationName;
    private int organisationId;
    private boolean wifiIndicator;
    private boolean beneficiaryIndicator;
    private int idUserPM;
    private int idUserBPM;
    private int idStatusBeneficiary;
    private boolean compliance;
    private String shortMemberState;
    private String memberState;
    private String call;
    private int actionToBeTaken;
    private int actionTaken;
    private boolean conformity;
    private Timestamp firstFalseCheck;
    private Timestamp dateRegistered;


    public RegistrationDTO() {
    }

    public RegistrationDTO(int id, int userId, int municipalityId, String role, int status, String legalFile1, String
            legalFile2, String legalFile3, String legalFile4, String ipRegistration, String associationName, int
            organisationId, boolean wifiIndicator, boolean beneficiaryIndicator, int idStatusBeneficiary, boolean
            compliance, String shortMemberState, String memberState, String call, int actionToBeTaken, int
            actionTaken, boolean conformity, Timestamp firstFalseCheck, Timestamp dateRegistered, int idUserPM, int idUserBPM) {
        this.id = id;
        this.userId = userId;
        this.municipalityId = municipalityId;
        this.role = role;
        this.status = status;
        this.legalFile1 = legalFile1;
        this.legalFile2 = legalFile2;
        this.legalFile3 = legalFile3;
        this.legalFile4 = legalFile4;
        this.ipRegistration = ipRegistration;
        this.associationName = associationName;
        this.organisationId = organisationId;
        this.wifiIndicator = wifiIndicator;
        this.beneficiaryIndicator = beneficiaryIndicator;
        this.idUserPM  = idUserPM;
        this.idUserBPM = idUserBPM;
        this.idStatusBeneficiary = idStatusBeneficiary;
        this.compliance = compliance;
        this.shortMemberState = shortMemberState;
        this.memberState = memberState;
        this.call = call;
        this.actionToBeTaken = actionToBeTaken;
        this.actionTaken = actionTaken;
        this.conformity = conformity;
        this.firstFalseCheck = firstFalseCheck;
        this.dateRegistered = dateRegistered;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMunicipalityId() {
        return municipalityId;
    }

    public int getStatus() {
        return status;
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

    @Override
    public String toString() {
        return "RegistrationDTO{" +
                "id=" + id +
                ", userId=" + userId +
                ", municipalityId=" + municipalityId +
                ", role='" + role + '\'' +
                ", status=" + status +
                ", legalFile1='" + legalFile1 + '\'' +
                ", legalFile2='" + legalFile2 + '\'' +
                ", legalFile3='" + legalFile3 + '\'' +
                ", legalFile4='" + legalFile4 + '\'' +
                ", ipRegistration='" + ipRegistration + '\'' +
                ", associationName='" + associationName + '\'' +
                ", organisationId=" + organisationId +
                ", wifiIndicator=" + wifiIndicator +
                ", beneficiaryIndicator=" + beneficiaryIndicator +
                '}';
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

    public boolean isWifiIndicator() {
        return wifiIndicator;
    }

    public void setWifiIndicator(boolean wifiIndicator) {
        this.wifiIndicator = wifiIndicator;
    }

    public boolean isBeneficiaryIndicator() {
        return beneficiaryIndicator;
    }

    public void setBeneficiaryIndicator(boolean beneficiaryIndicator) {
        this.beneficiaryIndicator = beneficiaryIndicator;
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
