package wifi4eu.wifi4eu.common.dto.model;

import wifi4eu.wifi4eu.common.dto.model.BidDTO;
import wifi4eu.wifi4eu.common.dto.model.InvoiceDTO;

public class InstallationDetailDTO {
    private Long installationDetailId;
    private BidDTO bidDTO;
    private InvoiceDTO invoiceDTOs[];

    public InstallationDetailDTO() {
    }

    public InstallationDetailDTO(Long installationDetailId, BidDTO bidDTO, InvoiceDTO[] invoiceDTOs) {
        this.installationDetailId = installationDetailId;
        this.bidDTO = bidDTO;
        this.invoiceDTOs = invoiceDTOs;
    }

    public Long getInstallationDetailId() {
        return installationDetailId;
    }

    public void setInstallationDetailId(Long installationDetailId) {
        this.installationDetailId = installationDetailId;
    }

    public BidDTO getBidDTO() {
        return bidDTO;
    }

    public void setBidDTO(BidDTO bidDTO) {
        this.bidDTO = bidDTO;
    }

    public InvoiceDTO[] getInvoiceDTOs() {
        return invoiceDTOs;
    }

    public void setInvoiceDTOs(InvoiceDTO[] invoiceDTOs) {
        this.invoiceDTOs = invoiceDTOs;
    }
}