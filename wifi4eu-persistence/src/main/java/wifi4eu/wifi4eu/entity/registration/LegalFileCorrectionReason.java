package wifi4eu.wifi4eu.entity.registration;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "legal_files_correction_reason")
public class LegalFileCorrectionReason {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "registration")
    private Registration registration;

    @Column(name = "id_legal_file")
    private Integer legalFile;

    @Column(name = "type")
    private Integer type;

    @Column(name = "request_correction")
    private Boolean requestCorrection;

    @Column(name = "correction_reason")
    private Integer correctionReason;

    @Column(name = "request_correction_date")
    private Long requestCorrectionDate;

    public LegalFileCorrectionReason() {
    }

    public LegalFileCorrectionReason(Integer id, Registration registration, Integer legalFile, Integer type, Boolean requestCorrection, Integer correctionReason, Long requestCorrectionDate) {
        this.id = id;
        this.registration = registration;
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

    public Long getRequestCorrectionDate() {
        return requestCorrectionDate;
    }

    public void setRequestCorrectionDate(Long requestCorrectionDate) {
        this.requestCorrectionDate = requestCorrectionDate;
    }

    public Integer getLegalFile() {
        return legalFile;
    }

    public void setLegalFile(Integer legalFile) {
        this.legalFile = legalFile;
    }
}