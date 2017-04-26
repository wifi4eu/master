package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;
import java.util.List;

public class InstallationDTO implements Serializable {
    private Long installationId;
    private String nip;
    private Double outdoorPrice;
    private Double indoorPrice;
    private List<AccessPointDTO> accessPoints;

    public InstallationDTO() {
    }

    public InstallationDTO(Long installationId, String nip, Double outdoorPrice, Double indoorPrice, List<AccessPointDTO> accessPoints) {
        this.installationId = installationId;
        this.nip = nip;
        this.outdoorPrice = outdoorPrice;
        this.indoorPrice = indoorPrice;
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

    public Double getOutdoorPrice() {
        return outdoorPrice;
    }

    public void setOutdoorPrice(Double outdoorPrice) {
        this.outdoorPrice = outdoorPrice;
    }

    public Double getIndoorPrice() {
        return indoorPrice;
    }

    public void setIndoorPrice(Double indoorPrice) {
        this.indoorPrice = indoorPrice;
    }

    public List<AccessPointDTO> getAccessPoints() {
        return accessPoints;
    }

    public void setAccessPoints(List<AccessPointDTO> accessPoints) {
        this.accessPoints = accessPoints;
    }
}