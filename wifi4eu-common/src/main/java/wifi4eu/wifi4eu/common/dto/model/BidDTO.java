package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;

public class BidDTO implements Serializable {
    private Long bidId;
    private Long nip;
    private Long outdoorNumber;
    private Long indoorNumber;

    public BidDTO() {
    }

    public BidDTO(Long bidId, Long nip, Long outdoorNumber, Long indoorNumber) {
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