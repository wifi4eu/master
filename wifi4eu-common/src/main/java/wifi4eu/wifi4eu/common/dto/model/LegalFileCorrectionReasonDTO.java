package wifi4eu.wifi4eu.common.dto.model;

import java.util.Date;

public class LegalFileCorrectionReasonDTO {
    private Integer id;
    private Integer registrationId;
    private Integer legalFile;
    private Integer type;
    private Boolean requestCorrection;
    private Integer correctionReason;
    private Date requestCorrectionDate;

    public LegalFileCorrectionReasonDTO() {
    }

    public LegalFileCorrectionReasonDTO(Integer id, Integer registrationId, Integer legalFile, Integer type, Boolean requestCorrection, Integer correctionReason, Date requestCorrectionDate) {
        this.id = id;
        this.registrationId = registrationId;
        this.legalFile = legalFile;
        this.type = type;
        this.requestCorrection = requestCorrection;
        this.correctionReason = correctionReason;
        this.requestCorrectionDate = requestCorrectionDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Integer registrationId) {
        this.registrationId = registrationId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Boolean getRequestCorrection() {
        return requestCorrection;
    }

    public void setRequestCorrection(Boolean requestCorrection) {
        this.requestCorrection = requestCorrection;
    }

    public Integer getCorrectionReason() {
        return correctionReason;
    }

    public void setCorrectionReason(Integer correctionReason) {
        this.correctionReason = correctionReason;
    }

    public Date getRequestCorrectionDate() {
        return requestCorrectionDate;
    }

    public void setRequestCorrectionDate(Date requestCorrectionDate) {
        this.requestCorrectionDate = requestCorrectionDate;
    }

    public Integer getLegalFile() {
        return legalFile;
    }

    public void setLegalFile(Integer legalFile) {
        this.legalFile = legalFile;
    }
}