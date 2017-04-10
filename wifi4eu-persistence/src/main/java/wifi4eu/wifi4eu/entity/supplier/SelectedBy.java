package wifi4eu.wifi4eu.entity.supplier;

import wifi4eu.wifi4eu.entity.location.Nuts;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SUPP_SELECTEDBY_T")
public class SelectedBy {

    @Id
    @Column(name = "SUPPLIER_ID")
    private Long supplierId;

    @Id
    @Column(name = "BENEFICIARY_ID")
    private Long beneficiaryId;

    @Column(name = "PUBLICATION_ID")
    private Long publicationId;

    /*
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "SUPP_SUPP_NUTS_T", joinColumns = @JoinColumn(name = "supplier_id", referencedColumnName = "supplier_id"), inverseJoinColumns = @JoinColumn(name = "nuts_id", referencedColumnName = "nuts_id"))
    private List<Nuts> nuts;
    */

    public SelectedBy() {
    }

    public SelectedBy(Long supplierId, Long beneficiaryId, Long publicationId) {
        this.supplierId = supplierId;
        this.beneficiaryId = beneficiaryId;
        this.publicationId = publicationId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
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
}