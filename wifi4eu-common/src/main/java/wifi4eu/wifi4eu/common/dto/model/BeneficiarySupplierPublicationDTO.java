package wifi4eu.wifi4eu.common.dto.model;

import wifi4eu.wifi4eu.common.dto.model.CallDTO;
import wifi4eu.wifi4eu.common.dto.model.LegalEntityDTO;
import wifi4eu.wifi4eu.common.dto.model.SupplierDTO;

public class BeneficiarySupplierPublicationDTO {
    private Long benSupplierPublicationId;
    private LegalEntityDTO legalEntityDTO;
    private SupplierDTO supplierDTO;
    private CallDTO publicationCallDTO;
    private Long createDate;

    public BeneficiarySupplierPublicationDTO() {
    }

    public BeneficiarySupplierPublicationDTO(Long benSupplierPublicationId, LegalEntityDTO legalEntityDTO, SupplierDTO supplierDTO, CallDTO publicationCallDTO, Long createDate) {
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