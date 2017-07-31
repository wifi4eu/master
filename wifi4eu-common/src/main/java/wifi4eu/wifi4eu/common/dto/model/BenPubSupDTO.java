package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BenPubSupDTO implements Serializable {
    private Long benPubSubId;
    private Long beneficiaryId;
    private Long publicationId;
    private boolean awarded;
    private Long supplierId;
    private boolean budgetCommited;
    private boolean budgetLinked;
    private String lastAbacMessage;
    private Date date;

    public BenPubSupDTO() {
    }

    public BenPubSupDTO(Long benPubSubId, Long beneficiaryId, Long publicationId, boolean awarded, Long supplierId, boolean budgetCommited, boolean budgetLinked, String lastAbacMessage, Date date) {
        this.benPubSubId = benPubSubId;
        this.beneficiaryId = beneficiaryId;
        this.publicationId = publicationId;
        this.awarded = awarded;
        this.supplierId = supplierId;
        this.budgetCommited = budgetCommited;
        this.budgetLinked = budgetLinked;
        this.lastAbacMessage = lastAbacMessage;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}