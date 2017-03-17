package wifi4eu.wifi4eu.entity.supplier;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import wifi4eu.wifi4eu.common.dto.model.CallDTO;
import wifi4eu.wifi4eu.common.dto.model.LegalEntityDTO;
import wifi4eu.wifi4eu.common.dto.model.SupplierDTO;

@Entity
@Table(name = "SUPP_BENSUPPLIERPUBLICATION_T")
public class BeneficiarySupplierPublication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BENSUPPLIERPUBLICATION_ID")
    private Long benSupplierPublicationId;

    @Column(name = "LEGAL_ENTITY")
    private LegalEntityDTO legalEntityDTO;

    @Column(name = "SUPPLIER")
    private SupplierDTO supplierDTO;

    @Column(name = "PUBLICATION_CALL")
    private CallDTO publicationCallDTO;

    @Column(name = "CREATE_DATE")
    private Long createDate;

    public BeneficiarySupplierPublication() {
    }

    public BeneficiarySupplierPublication(Long benSupplierPublicationId, LegalEntityDTO legalEntityDTO, SupplierDTO supplierDTO, CallDTO publicationCallDTO, Long createDate) {
        this.benSupplierPublicationId = benSupplierPublicationId;
        this.legalEntityDTO = legalEntityDTO;
        this.supplierDTO = supplierDTO;
        this.publicationCallDTO = publicationCallDTO;
        this.createDate = createDate;
    }

    public Long getBenSupplierPublicationId() {
        return benSupplierPublicationId;
    }

    public void setBenSupplierPublicationId(Long benSupplierPublicationId) {
        this.benSupplierPublicationId = benSupplierPublicationId;
    }

    public LegalEntityDTO getLegalEntityDTO() {
        return legalEntityDTO;
    }

    public void setLegalEntityDTO(LegalEntityDTO legalEntityDTO) {
        this.legalEntityDTO = legalEntityDTO;
    }

    public SupplierDTO getSupplierDTO() {
        return supplierDTO;
    }

    public void setSupplierDTO(SupplierDTO supplierDTO) {
        this.supplierDTO = supplierDTO;
    }

    public CallDTO getPublicationCallDTO() {
        return publicationCallDTO;
    }

    public void setPublicationCallDTO(CallDTO publicationCallDTO) {
        this.publicationCallDTO = publicationCallDTO;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }
}