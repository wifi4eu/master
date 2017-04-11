package wifi4eu.wifi4eu.entity.supplier;

import javax.persistence.*;

@Entity
@Table(name = "SUPP_BENPUBSUP_T")
public class BenPubSup {

    @Column(name = "BENEFICIARY_ID")
    private Long beneficiaryId;

    @Column(name = "PUBLICATION_ID")
    private Long publicationId;

    @Column(name = "AWARDED")
    private boolean awarded;

    @Column(name = "SUPPLIER_ID")
    private Long supplierId;

    public BenPubSup() {
    }

    public BenPubSup(Long beneficiaryId, Long publicationId, boolean awarded, Long supplierId) {
        this.beneficiaryId = beneficiaryId;
        this.publicationId = publicationId;
        this.awarded = awarded;
        this.supplierId = supplierId;
    }

    public Long getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(Long beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public Long getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(Long publicationId) {
        this.publicationId = publicationId;
    }

    public boolean isAwarded() {
        return awarded;
    }

    public void setAwarded(boolean awarded) {
        this.awarded = awarded;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }
}