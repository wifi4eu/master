package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;
import java.util.List;

import wifi4eu.wifi4eu.common.dto.model.CompanyDTO;
import wifi4eu.wifi4eu.common.dto.model.ContactPersonDTO;
import wifi4eu.wifi4eu.common.dto.model.InstallationDTO;
import wifi4eu.wifi4eu.common.dto.model.NutsDTO;

public class SupplierDTO implements Serializable {
    private Long supplierId;
    private CompanyDTO companyDTO;
    private List<NutsDTO> supportedRegions;
    private ContactPersonDTO contactPersonDTO;
    private List<InstallationDTO> installationDTOs;
    private boolean legalCheck1;
    private boolean legalCheck2;
    private Long createDate;

    public SupplierDTO() {
    }

    public SupplierDTO(Long supplierId, CompanyDTO companyDTO, List<NutsDTO> supportedRegions, ContactPersonDTO contactPersonDTO, List<InstallationDTO> installationDTOs, boolean legalCheck1, boolean legalCheck2, Long createDate) {
        this.supplierId = supplierId;
        this.companyDTO = companyDTO;
        this.supportedRegions = supportedRegions;
        this.contactPersonDTO = contactPersonDTO;
        this.installationDTOs = installationDTOs;
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

    public List<NutsDTO> getSupportedRegions() {
        return supportedRegions;
    }

    public void setSupportedRegions(List<NutsDTO> supportedRegions) {
        this.supportedRegions = supportedRegions;
    }

    public ContactPersonDTO getContactPersonDTO() {
        return contactPersonDTO;
    }

    public void setContactPersonDTO(ContactPersonDTO contactPersonDTO) {
        this.contactPersonDTO = contactPersonDTO;
    }

    public List<InstallationDTO> getInstallationDTOs() {
        return installationDTOs;
    }

    public void setInstallationDTOs(List<InstallationDTO> installationDTOs) {
        this.installationDTOs = installationDTOs;
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