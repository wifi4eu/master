package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;
import java.util.Date;

public class BenPubSupDTO implements Serializable {
    private Long benPubSubId;
    private Long beneficiaryId;
    private Long publicationId;
    private Long supplierId;
    private boolean awarded;
    private Date date;
    private Long lefExport;
    private Long lefImport;
    private int lefStatus;
    private Long bcExport;
    private Long bcImport;
    private int bcStatus;
    private Long lcExport;
    private Long lcImport;
    private int lcStatus;
    private String lastAbacMessage;

    public BenPubSupDTO() {
    }

    public BenPubSupDTO(Long benPubSubId, Long beneficiaryId, Long publicationId, Long supplierId, boolean awarded, Date date, Long lefExport, Long lefImport, int lefStatus, Long bcExport, Long bcImport, int bcStatus, Long lcExport, Long lcImport, int lcStatus, String lastAbacMessage) {
        this.benPubSubId = benPubSubId;
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

    public static BenPubSupDTO createNewApplication() {
        BenPubSupDTO benPubSupDTO = new BenPubSupDTO();
        benPubSupDTO.lefExport = Long.valueOf(0);
        benPubSupDTO.lefImport = Long.valueOf(0);
        benPubSupDTO.lefStatus = 0;
        benPubSupDTO.bcExport = Long.valueOf(0);
        benPubSupDTO.bcImport = Long.valueOf(0);
        benPubSupDTO.bcStatus = 0;
        benPubSupDTO.lcExport = Long.valueOf(0);
        benPubSupDTO.lcImport = Long.valueOf(0);
        benPubSupDTO.lcStatus = 0;
        return benPubSupDTO;
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