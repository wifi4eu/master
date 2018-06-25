package wifi4eu.wifi4eu.entity.registration;

import javax.persistence.*;

@Entity
@Table(name = "legal_files")
public class LegalFile {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "registration")
    private Registration registration;

    @Column(name = "type")
    private Integer type;

    @Column(name = "data")
    private String data;

    @Column(name = "upload_time")
    private Long uploadTime;

    @Column(name = "request_correction")
    private Boolean requestCorrection;

    @Column(name = "correction_reason")
    private Integer correctionReason;

    public LegalFile() {
    }

    public LegalFile(Integer id, Registration registration, Integer type, String data, Long uploadTime, Boolean requestCorrection, Integer correctionReason) {
        this.id = id;
        this.registration = registration;
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

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
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