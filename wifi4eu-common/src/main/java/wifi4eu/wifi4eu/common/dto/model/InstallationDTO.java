package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;
import java.util.List;

public class InstallationDTO implements Serializable {
    private Long installationId;
    private String nip;
    private Long outdoorPrice;
    private Long indoorPrice;
    private String accessPointName;
    private String serialNumber;
    private String productName;
    private String modelNumber;

    public InstallationDTO() {
    }

    public InstallationDTO(Long installationId, String nip, Long outdoorPrice, Long indoorPrice, String accessPointName, String serialNumber, String productName, String modelNumber) {
        this.installationId = installationId;
        this.nip = nip;
        this.outdoorPrice = outdoorPrice;
        this.indoorPrice = indoorPrice;
        this.accessPointName = accessPointName;
        this.serialNumber = serialNumber;
        this.productName = productName;
        this.modelNumber = modelNumber;
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

    public Long getOutdoorPrice() {
        return outdoorPrice;
    }

    public void setOutdoorPrice(Long outdoorPrice) {
        this.outdoorPrice = outdoorPrice;
    }

    public Long getIndoorPrice() {
        return indoorPrice;
    }

    public void setIndoorPrice(Long indoorPrice) {
        this.indoorPrice = indoorPrice;
    }

    public String getAccessPointName() {
        return accessPointName;
    }

    public void setAccessPointName(String accessPointName) {
        this.accessPointName = accessPointName;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }
}