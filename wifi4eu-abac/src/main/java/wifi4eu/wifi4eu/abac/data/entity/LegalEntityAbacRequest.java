package wifi4eu.wifi4eu.abac.data.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value = "LEGAL_ENTITY")
public class LegalEntityAbacRequest extends AbacRequest {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LE_ID")
    private LegalEntity legalEntity;

    @Column(name = "REJECTION_MSG")
    private String rejectionReason;


    public LegalEntity getLegalEntity() {
        return legalEntity;
    }

    public void setLegalEntity(LegalEntity legalEntity) {
        this.legalEntity = legalEntity;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }
}
