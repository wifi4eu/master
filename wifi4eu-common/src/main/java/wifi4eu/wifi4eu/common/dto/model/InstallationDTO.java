package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;
import java.util.List;

public class InstallationDTO implements Serializable {
    private Long installationId;
    private String nip;
    private List<AccessPointDTO> accessPoints;

    public InstallationDTO() {
    }

    public InstallationDTO(Long installationId, String nip, List<AccessPointDTO> accessPoints) {
        this.installationId = installationId;
        this.nip = nip;
        this.accessPoints = accessPoints;
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

    public List<AccessPointDTO> getAccessPoints() {
        return accessPoints;
    }

    public void setAccessPoints(List<AccessPointDTO> accessPoints) {
        this.accessPoints = accessPoints;
    }
}