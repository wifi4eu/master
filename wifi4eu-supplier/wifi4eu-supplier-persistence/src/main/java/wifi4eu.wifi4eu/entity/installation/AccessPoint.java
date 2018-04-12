package wifi4eu.wifi4eu.entity.installation;

import wifi4eu.wifi4eu.entity.installation.InstallationSite;

import javax.persistence.*;

@Entity
@Table(name = "access_points")
public class AccessPoint {

    @Id
    @SequenceGenerator(name = "access_points_seq", allocationSize = 1, initialValue = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "access_points_seq")
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_installation_site")
    private InstallationSite installationSite;

    @Column(name = "model_number")
    private String modelNumber;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "isIndoor")
    private boolean isIndoor;

    @Column(name = "device_brand")
    private String deviceBrand;

    @Column(name = "location")
    private String location;

    @Column(name = "location_type")
    private String locationType;

    @Column(name = "latitude", precision=8, scale=6)
    private double latitude;

    @Column(name = "longitude", precision=8, scale=6)
    private double longitude;

    @Column(name = "mac_address", length = 17)
    private String macAddress;

    public AccessPoint(InstallationSite installationSite, String modelNumber, String serialNumber, boolean isIndoor, String deviceBrand, String location, String locationType, double latitude, double longitude, String macAddress) {
        this.installationSite = installationSite;
        this.modelNumber = modelNumber;
        this.serialNumber = serialNumber;
        this.isIndoor = isIndoor;
        this.deviceBrand = deviceBrand;
        this.location = location;
        this.locationType = locationType;
        this.latitude = latitude;
        this.longitude = longitude;
        this.macAddress = macAddress;
    }

    public InstallationSite getInstallationSite() {
        return installationSite;
    }

    public void setInstallationSite(InstallationSite installationSite) {
        this.installationSite = installationSite;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public boolean isIndoor() {
        return isIndoor;
    }

    public void setIndoor(boolean indoor) {
        isIndoor = indoor;
    }

    public String getDeviceBrand() {
        return deviceBrand;
    }

    public void setDeviceBrand(String deviceBrand) {
        this.deviceBrand = deviceBrand;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }
}