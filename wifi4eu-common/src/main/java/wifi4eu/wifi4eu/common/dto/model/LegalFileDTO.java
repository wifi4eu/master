package wifi4eu.wifi4eu.common.dto.model;

public class LegalFileDTO {
    private Integer id;
    private Integer registrationId;
    private Integer type;
    private String data;
    private Long uploadTime;
    private Boolean requestCorrection;
    private Integer correctionReason;

    public LegalFileDTO() {
    }

    public LegalFileDTO(Integer id, Integer registrationId, Integer type, String data, Long uploadTime, Boolean requestCorrection, Integer correctionReason) {
        this.id = id;
        this.registrationId = registrationId;
        this.type = type;
        this.data = data;
        this.uploadTime = uploadTime;
        this.requestCorrection = requestCorrection;
        this.correctionReason = correctionReason;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Long uploadTime) {
        this.uploadTime = uploadTime;
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
}