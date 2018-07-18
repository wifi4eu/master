package wifi4eu.wifi4eu.entity.application;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ApplyVoucher {

    @Column(name = "reg_id", length = 20)
    @Id
    private Long idRegistration;

    @Column(name = "mun_id", length = 20)
    private Long idMunicipality;

    @Column(name = "files_uploaded", length = 20)
    private int filesUploaded;

    @Column(name = "upload_time", length = 100)
    private long uploadTime;

    public ApplyVoucher(){

    }

    public ApplyVoucher(Long idRegistration, Long idMunicipality, int filesUploaded, long uploadTime) {
        this.idRegistration = idRegistration;
        this.idMunicipality = idMunicipality;
        this.filesUploaded = filesUploaded;
        this.uploadTime = uploadTime;
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

    public int getFilesUploaded() {
        return filesUploaded;
    }

    public void setFilesUploaded(int filesUploaded) {
        this.filesUploaded = filesUploaded;
    }

    public long getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(long uploadTime) {
        this.uploadTime = uploadTime;
    }
}