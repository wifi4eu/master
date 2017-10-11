package wifi4eu.wifi4eu.common.dto.model;

public class AccessPointDTO {
    private int accessPointId;
    private String name;
    private String serialNumber;
    private String productName;
    private String modelNumber;
    private int installationId;
    private boolean indoor;

    public AccessPointDTO() {
    }

    public AccessPointDTO(int accessPointId, String name, String serialNumber, String productName, String modelNumber, int installationId, boolean indoor) {
        this.accessPointId = accessPointId;
        this.name = name;
        this.serialNumber = serialNumber;
        this.productName = productName;
        this.modelNumber = modelNumber;
        this.installationId = installationId;
        this.indoor = indoor;
    }

    public int getAccessPointId() {
        return accessPointId;
    }

    public void setAccessPointId(int accessPointId) {
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

    public int getInstallationId() {
        return installationId;
    }

    public void setInstallationId(int installationId) {
        this.installationId = installationId;
    }

    public boolean isIndoor() {
        return indoor;
    }

    public void setIndoor(boolean indoor) {
        this.indoor = indoor;
    }
}