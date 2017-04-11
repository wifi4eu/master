package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;
import java.util.List;

public class BenPubSupDTO implements Serializable {
    private Long benPubSubId;
    private Long beneficiaryId;
    private Long publicationId;
    private boolean awarded;
    private Long supplierId;

    public BenPubSupDTO() {
    }

    public BenPubSupDTO(Long benPubSubId, Long beneficiaryId, Long publicationId, boolean awarded, Long supplierId) {
        this.benPubSubId = benPubSubId;
        this.beneficiaryId = beneficiaryId;
        this.publicationId = publicationId;
        this.awarded = awarded;
        this.supplierId = supplierId;
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
}