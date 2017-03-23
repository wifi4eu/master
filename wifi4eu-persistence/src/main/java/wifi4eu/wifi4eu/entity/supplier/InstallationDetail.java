package wifi4eu.wifi4eu.entity.supplier;

import javax.persistence.*;
import java.util.List;
import javax.validation.constraints.NotNull;

import wifi4eu.wifi4eu.common.dto.model.BidDTO;
import wifi4eu.wifi4eu.entity.supplier.Invoice;

@Entity
@Table(name = "SUPP_INSTALLATIONDETAIL_T")
public class InstallationDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "INSTALLATIONDETAIL_ID")
    private Long installationDetailId;

    @Column(name = "BID")
    private BidDTO bidDTO;

    @OneToMany
    @JoinColumn(name = "INVOICE_ID", referencedColumnName = "INSTALLATIONDETAIL_ID")
    private List<Invoice> invoices;

    public InstallationDetail() {
    }

    public InstallationDetail(Long installationDetailId, BidDTO bidDTO, List<Invoice> invoices) {
        this.installationDetailId = installationDetailId;
        this.bidDTO = bidDTO;
        this.invoices = invoices;
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

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }
}