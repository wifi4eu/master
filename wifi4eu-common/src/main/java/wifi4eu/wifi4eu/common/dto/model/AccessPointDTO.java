package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;

public class AccessPointDTO implements Serializable {
    private Long accessPointId;
    private String name;
    private String serialNumber;
    private String productName;
    private String modelNumber;
    private Long installationId;
    private Boolean indoor;

    public AccessPointDTO() {
    }

    public AccessPointDTO(Long accessPointId, String name, String serialNumber, String productName, String modelNumber, Long installationId, Boolean indoor) {

        this.accessPointId = accessPointId;
        this.name = name;
        this.serialNumber = serialNumber;
        this.productName = productName;
        this.modelNumber = modelNumber;
        this.installationId = installationId;
        this.indoor = indoor;
    }

    public Long getAccessPointId() {
        return accessPointId;
    }

    public void setAccessPointId(Long accessPointId) {
        this.accessPointId = accessPointId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Long getInstallationId() {
        return installationId;
    }

    public void setInstallationId(Long installationId) {
        this.installationId = installationId;
    }

    public Boolean getIndoor() {
        return indoor;
    }

    public void setIndoor(Boolean indoor) {
        this.indoor = indoor;
    }


}