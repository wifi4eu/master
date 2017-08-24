package wifi4eu.wifi4eu.entity.supplier;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SUPP_INSTALLATION_T")
public class Installation {

    @Id
    @Column(name = "INSTALLATION_ID")
    private Long installationId;

    @Column(name = "NIP")
    private String nip;

    public Installation() {
    }

    public Installation(Long installationId, String nip) {
        this.installationId = installationId;
        this.nip = nip;
    }

    public Long getInstallationId() {
        return installationId;
    }

    public void setInstallationId(Long installationId) {
        this.installationId = installationId;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }
}