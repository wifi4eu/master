package wifi4eu.wifi4eu.common.dto.model;

import wifi4eu.wifi4eu.common.dto.model.InstallationDetailDTO;
import wifi4eu.wifi4eu.common.dto.model.NutsDTO;

public class InstallationDTO {
    private Long installationId;
    private NutsDTO nutsDTO;
    private InstallationDetailDTO installationDetailDTOs[];

    public InstallationDTO() {
    }

    public InstallationDTO(Long installationId, NutsDTO nutsDTO, InstallationDetailDTO[] installationDetailDTOs) {
        this.installationId = installationId;
        this.nutsDTO = nutsDTO;
        this.installationDetailDTOs = installationDetailDTOs;
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

    public InstallationDetailDTO[] getInstallationDetailDTOs() {
        return installationDetailDTOs;
    }

    public void setInstallationDetailDTOs(InstallationDetailDTO[] installationDetailDTOs) {
        this.installationDetailDTOs = installationDetailDTOs;
    }
}