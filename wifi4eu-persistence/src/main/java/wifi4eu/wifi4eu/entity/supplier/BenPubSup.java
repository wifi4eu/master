package wifi4eu.wifi4eu.entity.supplier;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "SUPP_BENPUBSUP_T")
public class BenPubSup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BENPUBSUP_ID")
    private Long benPubSubId;

    @Column(name = "BENEFICIARY_ID")
    private Long beneficiaryId;

    @Column(name = "PUBLICATION_ID")
    private Long publicationId;

    @Column(name = "AWARDED")
    private boolean awarded;

    @Column(name = "SUPPLIER_ID")
    private Long supplierId;

    @Column(name = "DATE")
    private Date date;

    public BenPubSup() {
    }

    public BenPubSup(Long beneficiaryId, Long publicationId, boolean awarded, Long supplierId, Date date) {
        this.beneficiaryId = beneficiaryId;
        this.publicationId = publicationId;
        this.awarded = awarded;
        this.supplierId = supplierId;
        this.date = date;
    }

    public Long getBenPubSubId() {
        return benPubSubId;
    }

    public Long getBeneficiaryId() {
        return beneficiaryId;
    }

    public Long getPublicationId() {
        return publicationId;
    }

    public boolean isAwarded() {
        return awarded;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public Date getDate() {
        return date;
    }

    public void setBenPubSubId(Long benPubSubId) {
        this.benPubSubId = benPubSubId;
    }

    public void setBeneficiaryId(Long beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public void setPublicationId(Long publicationId) {
        this.publicationId = publicationId;
    }

    public void setAwarded(boolean awarded) {
        this.awarded = awarded;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}