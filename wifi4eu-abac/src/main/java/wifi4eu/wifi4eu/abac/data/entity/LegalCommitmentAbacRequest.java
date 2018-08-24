package wifi4eu.wifi4eu.abac.data.entity;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "LEGAL_COMMITMENT")
public class LegalCommitmentAbacRequest extends AbacRequest {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LC_ID")
    private LegalCommitment legalCommitment;

    public LegalCommitment getLegalCommitment() {
        return legalCommitment;
    }

    public void setLegalCommitment(LegalCommitment legalCommitment) {
        this.legalCommitment = legalCommitment;
    }
}
