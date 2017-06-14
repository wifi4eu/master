package wifi4eu.wifi4eu.entity.supplier;

import javax.persistence.*;

@Entity
@Table(name = "SUPP_ACCESSPOINT_T")
public class AccessPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ACCESSPOINT_ID")
    private Long accessPointId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SERIAL_NUMBER")
    private String serialNumber;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "MODEL_NUMBER")
    private String modelNumber;

    @Column(name = "INSTALLATION_ID")
    private Long installationId;

    @Column(name = "INDOOR")
    private Boolean indoor;

    public AccessPoint(){

    }

    public AccessPoint(String name, String serialNumber, String productName, String modelNumber, Long installationId, Boolean indoor) {
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