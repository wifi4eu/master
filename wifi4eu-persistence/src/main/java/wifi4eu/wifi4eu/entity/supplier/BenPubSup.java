package wifi4eu.wifi4eu.entity.supplier;

import javax.persistence.*;

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

    @Column(name = "BUDGED_COMMITED")
    private boolean budgetCommited;

    @Column(name = "BUDGED_LINKED")
    private boolean budgetLinked;

    @Column(name = "LAST_ABAC_MESSAGE")
    private String lastAbacMessage;

    public BenPubSup() {
    }

    public BenPubSup(Long benPubSubId, Long beneficiaryId, Long publicationId, boolean awarded, Long supplierId, boolean budgetCommited, boolean budgetLinked, String lastAbacMessage) {
        this.benPubSubId = benPubSubId;
        this.beneficiaryId = beneficiaryId;
        this.publicationId = publicationId;
        this.awarded = awarded;
        this.supplierId = supplierId;
        this.budgetCommited = budgetCommited;
        this.budgetLinked = budgetLinked;
        this.lastAbacMessage = lastAbacMessage;
    }

    public Long getBenPubSubId() {
        return benPubSubId;
    }

    public void setBenPubSubId(Long benPubSubId) {
        this.benPubSubId = benPubSubId;
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

    public boolean isBudgetCommited() { return budgetCommited; }

    public boolean isBudgetLinked() { return budgetLinked; }

    public String getLastAbacMessage() { return lastAbacMessage; }

    public void setBudgetCommited(boolean budgetCommited) { this.budgetCommited = budgetCommited; }

    public void setBudgetLinked(boolean budgetCommited) { this.budgetCommited = budgetCommited; }

    public void setLastAbacMessage(String lastAbacMessage) { this.lastAbacMessage = lastAbacMessage; }

}