package wifi4eu.wifi4eu.entity.supplier;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "SUPP_BID_T")
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BID_ID")
    private Long bidId;

    @Column(name = "NIP")
    private Long nip;

    @Column(name = "OUTDOOR_NUMBER")
    private Long outdoorNumber;

    @Column(name = "INDOOR_NUMBER")
    private Long indoorNumber;

    public Bid() {
    }

    public Bid(Long bidId, Long nip, Long outdoorNumber, Long indoorNumber) {
        this.bidId = bidId;
        this.nip = nip;
        this.outdoorNumber = outdoorNumber;
        this.indoorNumber = indoorNumber;
    }

    public Long getBidId() {
        return bidId;
    }

    public void setBidId(Long bidId) {
        this.bidId = bidId;
    }

    public Long getNip() {
        return nip;
    }

    public void setNip(Long nip) {
        this.nip = nip;
    }

    public Long getOutdoorNumber() {
        return outdoorNumber;
    }

    public void setOutdoorNumber(Long outdoorNumber) {
        this.outdoorNumber = outdoorNumber;
    }

    public Long getIndoorNumber() {
        return indoorNumber;
    }

    public void setIndoorNumber(Long indoorNumber) {
        this.indoorNumber = indoorNumber;
    }
}