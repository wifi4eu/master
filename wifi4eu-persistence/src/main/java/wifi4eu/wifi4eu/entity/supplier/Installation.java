package wifi4eu.wifi4eu.entity.supplier;

import javax.persistence.*;
import java.util.List;
import javax.validation.constraints.NotNull;

import wifi4eu.wifi4eu.entity.supplier.InstallationDetail;
import wifi4eu.wifi4eu.common.dto.model.NutsDTO;

@Entity
@Table(name = "SUPP_INSTALLATION_T")
public class Installation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "INSTALLATION_ID")
    private Long installationId;

    @Column(name = "NUTS")
    private NutsDTO nutsDTO;

    @OneToMany
    @JoinColumn(name = "INSTALLATIONDETAIL_ID", referencedColumnName = "INSTALLATION_ID")
    private List<InstallationDetail> installationDetails;

    public Installation() {
    }

    public Installation(Long installationId, NutsDTO nutsDTO, List<InstallationDetail> installationDetails) {
        this.installationId = installationId;
        this.nutsDTO = nutsDTO;
        this.installationDetails = installationDetails;
    }

    public Long getInstallationId() {
        return installationId;
    }

    public void setInstallationId(Long installationId) {
        this.installationId = installationId;
    }

    public NutsDTO getNutsDTO() {
        return nutsDTO;
    }

    public void setNutsDTO(NutsDTO nutsDTO) {
        this.nutsDTO = nutsDTO;
    }

    public List<InstallationDetail> getInstallationDetails() {
        return installationDetails;
    }

    public void setInstallationDetails(List<InstallationDetail> installationDetails) {
        this.installationDetails = installationDetails;
    }
}