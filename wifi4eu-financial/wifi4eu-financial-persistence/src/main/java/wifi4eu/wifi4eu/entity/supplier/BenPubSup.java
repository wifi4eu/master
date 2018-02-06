package wifi4eu.wifi4eu.entity.supplier;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SUPP_BENPUBSUP_T")
public class BenPubSup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BENPUBSUP_ID")
    private Long benPubSubId;

    @Column(name = "BENEFICIARY_ID")
    private Long beneficiaryId;

    @Column(name = "PUBLICATION_ID")
    private Long publicationId;

    @Column(name = "SUPPLIER_ID")
    private Long supplierId;

    @Column(name = "AWARDED")
    private boolean awarded;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "LEF_EXPORT")
    private Long lefExport;

    @Column(name = "LEF_IMPORT")
    private Long lefImport;

    @Column(name = "LEF_STATUS")
    private int lefStatus;

    @Column(name = "BC_EXPORT")
    private Long bcExport;

    @Column(name = "BC_IMPORT")
    private Long bcImport;

    @Column(name = "BC_STATUS")
    private int bcStatus;

    @Column(name = "LC_EXPORT")
    private Long lcExport;

    @Column(name = "LC_IMPORT")
    private Long lcImport;

    @Column(name = "LC_STATUS")
    private int lcStatus;

    @Column(name = "LAST_ABAC_MESSAGE")
    private String lastAbacMessage;

    public BenPubSup() {
    }

    public BenPubSup(Long beneficiaryId, Long publicationId, Long supplierId, boolean awarded, Date date, Long lefExport, Long lefImport, int lefStatus, Long bcExport, Long bcImport, int bcStatus, Long lcExport, Long lcImport, int lcStatus, String lastAbacMessage) {
        this.beneficiaryId = beneficiaryId;
        this.publicationId = publicationId;
        this.supplierId = supplierId;
        this.awarded = awarded;
        this.date = date;
        this.lefExport = lefExport;
        this.lefImport = lefImport;
        this.lefStatus = lefStatus;
        this.bcExport = bcExport;
        this.bcImport = bcImport;
        this.bcStatus = bcStatus;
        this.lcExport = lcExport;
        this.lcImport = lcImport;
        this.lcStatus = lcStatus;
        this.lastAbacMessage = lastAbacMessage;
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

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public boolean isAwarded() {
        return awarded;
    }

    public void setAwarded(boolean awarded) {
        this.awarded = awarded;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getLefExport() {
        return lefExport;
    }

    public void setLefExport(Long lefExport) {
        this.lefExport = lefExport;
    }

    public Long getLefImport() {
        return lefImport;
    }

    public void setLefImport(Long lefImport) {
        this.lefImport = lefImport;
    }

    public int getLefStatus() {
        return lefStatus;
    }

    public void setLefStatus(int lefStatus) {
        this.lefStatus = lefStatus;
    }

    public Long getBcExport() {
        return bcExport;
    }

    public void setBcExport(Long bcExport) {
        this.bcExport = bcExport;
    }

    public Long getBcImport() {
        return bcImport;
    }

    public void setBcImport(Long bcImport) {
        this.bcImport = bcImport;
    }

    public int getBcStatus() {
        return bcStatus;
    }

    public void setBcStatus(int bcStatus) {
        this.bcStatus = bcStatus;
    }

    public Long getLcExport() {
        return lcExport;
    }

    public void setLcExport(Long lcExport) {
        this.lcExport = lcExport;
    }

    public Long getLcImport() {
        return lcImport;
    }

    public void setLcImport(Long lcImport) {
        this.lcImport = lcImport;
    }

    public int getLcStatus() {
        return lcStatus;
    }

    public void setLcStatus(int lcStatus) {
        this.lcStatus = lcStatus;
    }

    public String getLastAbacMessage() {
        return lastAbacMessage;
    }

    public void setLastAbacMessage(String lastAbacMessage) {
        this.lastAbacMessage = lastAbacMessage;
    }
}