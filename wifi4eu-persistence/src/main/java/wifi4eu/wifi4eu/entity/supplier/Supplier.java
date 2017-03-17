package wifi4eu.wifi4eu.entity.supplier;

import javax.persistence.*;
import java.util.List;
import javax.validation.constraints.NotNull;

import wifi4eu.wifi4eu.common.dto.model.CompanyDTO;
import wifi4eu.wifi4eu.common.dto.model.ContactPersonDTO;
//import wifi4eu.wifi4eu.common.dto.model.InstallationDTO;
import wifi4eu.wifi4eu.entity.supplier.Installation;
//import wifi4eu.wifi4eu.common.dto.model.NutsDTO;
import wifi4eu.wifi4eu.entity.location.Nuts;

@Entity
@Table(name = "SUPP_SUPPLIER_T")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SUPPLIER_ID")
    private Long supplierId;

    @Column(name = "COMPANY")
    private CompanyDTO companyDTO;

    @OneToMany
    @JoinColumn(name = "NUTS_ID", referencedColumnName = "SUPPLIER_ID")
    private List<Nuts> supportedRegions;

    @Column(name = "CONTACT_PERSON")
    private ContactPersonDTO contactPersonDTO;

    @OneToMany
    @JoinColumn(name = "INSTALLATION_ID", referencedColumnName = "SUPPLIER_ID")
    private List<Installation> installations;

    @Column(name = "LEGAL_CHECK1")
    private boolean legalCheck1;

    @Column(name = "LEGAL_CHECK2")
    private boolean legalCheck2;

    @Column(name = "CREATE_DATE")
    private Long createDate;

    public Supplier() {
    }

    public Supplier(Long supplierId, CompanyDTO companyDTO, List<Nuts> supportedRegions, ContactPersonDTO contactPersonDTO, List<Installation> installations, boolean legalCheck1, boolean legalCheck2, Long createDate) {
        this.supplierId = supplierId;
        this.companyDTO = companyDTO;
        this.supportedRegions = supportedRegions;
        this.contactPersonDTO = contactPersonDTO;
        this.installations = installations;
        this.legalCheck1 = legalCheck1;
        this.legalCheck2 = legalCheck2;
        this.createDate = createDate;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public CompanyDTO getCompanyDTO() {
        return companyDTO;
    }

    public void setCompanyDTO(CompanyDTO companyDTO) {
        this.companyDTO = companyDTO;
    }

    public List<Nuts> getSupportedRegions() {
        return supportedRegions;
    }

    public void setSupportedRegions(List<Nuts> supportedRegions) {
        this.supportedRegions = supportedRegions;
    }

    public ContactPersonDTO getContactPersonDTO() {
        return contactPersonDTO;
    }

    public void setContactPersonDTO(ContactPersonDTO contactPersonDTO) {
        this.contactPersonDTO = contactPersonDTO;
    }

    public List<Installation> getInstallations() {
        return installations;
    }

    public void setInstallations(List<Installation> installations) {
        this.installations = installations;
    }

    public boolean isLegalCheck1() {
        return legalCheck1;
    }

    public void setLegalCheck1(boolean legalCheck1) {
        this.legalCheck1 = legalCheck1;
    }

    public boolean isLegalCheck2() {
        return legalCheck2;
    }

    public void setLegalCheck2(boolean legalCheck2) {
        this.legalCheck2 = legalCheck2;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }
}