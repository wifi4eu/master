package wifi4eu.wifi4eu.entity.application;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ApplyVoucher {

    @Column(name = "reg_id")
    @Id
    private Long idRegistration;

    @Column(name = "mun_id")
    private Long idMunicipality;

    @Column(name = "municipality")
    private String municipality;

    @Column(name = "files_uploaded")
    private int filesUploaded;

    @Column(name = "upload_time")
    private long uploadTime;

    @Column(name = "apply_time")
    private long applyTime;

    @Column(name = "numberApplicant")
    private int numberApplicant;

    @Column(name = "conditionAgreement")
    private int conditionAgreement;

    public ApplyVoucher(){

    }

    public ApplyVoucher(Long idRegistration, Long idMunicipality, String municipality, int filesUploaded, long uploadTime, long applyTime, int numberApplicant, int conditionAgreement) {
        this.idRegistration = idRegistration;
        this.idMunicipality = idMunicipality;
        this.municipality = municipality;
        this.filesUploaded = filesUploaded;
        this.uploadTime = uploadTime;
        this.numberApplicant = numberApplicant;
        this.conditionAgreement = conditionAgreement;
        this.applyTime = applyTime;
    }

    public Long getIdRegistration() {
        return idRegistration;
    }

    public void setIdRegistration(Long idRegistration) {
        this.idRegistration = idRegistration;
    }

    public Long getIdMunicipality() {
        return idMunicipality;
    }

    public void setIdMunicipality(Long idMunicipality) {
        this.idMunicipality = idMunicipality;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public int getFilesUploaded() {
        return filesUploaded;
    }

    public void setFilesUploaded(int filesUploaded) {
        this.filesUploaded = filesUploaded;
    }

    public long getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(long applyTime) {
        this.applyTime = applyTime;
    }

    public long getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(long uploadTime) {
        this.uploadTime = uploadTime;
    }

    public int getNumberApplicant() {
        return numberApplicant;
    }

    public void setNumberApplicant(int numberApplicant) {
        this.numberApplicant = numberApplicant;
    }

    public int getConditionAgreement() {
        return conditionAgreement;
    }

    public void setConditionAgreement(int conditionAgreement) {
        this.conditionAgreement = conditionAgreement;
    }
}