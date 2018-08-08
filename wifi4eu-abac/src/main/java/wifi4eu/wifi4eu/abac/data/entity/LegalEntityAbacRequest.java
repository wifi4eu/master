package wifi4eu.wifi4eu.abac.data.entity;

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


    public LegalEntity getLegalEntity() {
        return legalEntity;
    }

    public void setLegalEntity(LegalEntity legalEntity) {
        this.legalEntity = legalEntity;
    }
}
