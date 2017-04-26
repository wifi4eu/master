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

    @Column(name = "OUTDOOR_PRICE")
    private Double outdoorPrice;

    @Column(name = "INDOOR_PRICE")
    private Double indoorPrice;

    public Installation() {
    }

    public Installation(Long installationId, String nip, Double outdoorPrice, Double indoorPrice) {
        this.installationId = installationId;
        this.nip = nip;
        this.outdoorPrice = outdoorPrice;
        this.indoorPrice = indoorPrice;
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
}