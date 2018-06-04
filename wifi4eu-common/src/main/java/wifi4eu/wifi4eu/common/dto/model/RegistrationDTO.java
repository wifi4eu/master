package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;

public class RegistrationDTO implements Serializable {
    private int id;
    private int userId;
    private int municipalityId;
    private String role;
    private int status;
    private long legalFile1Size;
    private String legalFile1Mime;
    private long legalFile2Size;
    private String legalFile2Mime;
    private long legalFile3Size;
    private String legalFile3Mime;
    private long legalFile4Size;
    private String legalFile4Mime;
    private String ipRegistration;
    private String associationName;
    private int organisationId;
    private long uploadTime;
    private int allFilesFlag;
    private int mailCounter;

    public RegistrationDTO() {
    }

    public RegistrationDTO(int id, int userId, int municipalityId, String role, int status, long legalFile1Size, String legalFile1Mime, long legalFile2Size, String legalFile2Mime, long legalFile3Size, String legalFile3Mime, long legalFile4Size, String legalFile4Mime, String ipRegistration, String associationName, int organisationId, long uploadTime, int allFilesFlag, int mailCounter) {
        this.id = id;
        this.userId = userId;
        this.municipalityId = municipalityId;
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

    public long getLegalFile1Size() {
        return legalFile1Size;
    }

    public void setLegalFile1Size(long legalFile1Size) {
        this.legalFile1Size = legalFile1Size;
    }

    public String getLegalFile1Mime() {
        return legalFile1Mime;
    }

    public void setLegalFile1Mime(String legalFile1Mime) {
        this.legalFile1Mime = legalFile1Mime;
    }

    public long getLegalFile2Size() {
        return legalFile2Size;
    }

    public void setLegalFile2Size(long legalFile2Size) {
        this.legalFile2Size = legalFile2Size;
    }

    public String getLegalFile2Mime() {
        return legalFile2Mime;
    }

    public void setLegalFile2Mime(String legalFile2Mime) {
        this.legalFile2Mime = legalFile2Mime;
    }

    public long getLegalFile3Size() {
        return legalFile3Size;
    }

    public void setLegalFile3Size(long legalFile3Size) {
        this.legalFile3Size = legalFile3Size;
    }

    public String getLegalFile3Mime() {
        return legalFile3Mime;
    }

    public void setLegalFile3Mime(String legalFile3Mime) {
        this.legalFile3Mime = legalFile3Mime;
    }

    public long getLegalFile4Size() {
        return legalFile4Size;
    }

    public void setLegalFile4Size(long legalFile4Size) {
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

    public long getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(long uploadTime) {
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

    @Override
    public String toString() {
        return "RegistrationDTO{" +
                "id=" + id +
                ", userId=" + userId +
                ", municipalityId=" + municipalityId +
                ", role='" + role + '\'' +
                ", status=" + status +
                ", upload_time='" + uploadTime + '\'' +
                ", allFiles_flag='" + allFilesFlag + '\'' +
                ", mail_counter='" + mailCounter + '\'' +
                '}';
    }
}