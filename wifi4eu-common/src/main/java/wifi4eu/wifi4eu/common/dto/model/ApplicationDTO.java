package wifi4eu.wifi4eu.common.dto.model;

public class ApplicationDTO {
    private int id;
    private int callId;
    private int registrationId;
    private int supplierId;
    private boolean voucherAwarded;
    private long date;
    private long lefExport;
    private long lefImport;
    private int lefStatus;
    private long bcExport;
    private long bcImport;
    private int bcStatus;
    private long lcExport;
    private long lcImport;
    private int lcStatus;

    public ApplicationDTO() {
    }

    public ApplicationDTO(int id, int callId, int registrationId, int supplierId, boolean voucherAwarded, long date, long lefExport, long lefImport, int lefStatus, long bcExport, long bcImport, int bcStatus, long lcExport, long lcImport, int lcStatus) {
        this.id = id;
        this.callId = callId;
        this.registrationId = registrationId;
        this.supplierId = supplierId;
        this.voucherAwarded = voucherAwarded;
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
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCallId() {
        return callId;
    }

    public void setCallId(int callId) {
        this.callId = callId;
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public boolean isVoucherAwarded() {
        return voucherAwarded;
    }

    public void setVoucherAwarded(boolean voucherAwarded) {
        this.voucherAwarded = voucherAwarded;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getLefExport() {
        return lefExport;
    }

    public void setLefExport(long lefExport) {
        this.lefExport = lefExport;
    }

    public long getLefImport() {
        return lefImport;
    }

    public void setLefImport(long lefImport) {
        this.lefImport = lefImport;
    }

    public int getLefStatus() {
        return lefStatus;
    }

    public void setLefStatus(int lefStatus) {
        this.lefStatus = lefStatus;
    }

    public long getBcExport() {
        return bcExport;
    }

    public void setBcExport(long bcExport) {
        this.bcExport = bcExport;
    }

    public long getBcImport() {
        return bcImport;
    }

    public void setBcImport(long bcImport) {
        this.bcImport = bcImport;
    }

    public int getBcStatus() {
        return bcStatus;
    }

    public void setBcStatus(int bcStatus) {
        this.bcStatus = bcStatus;
    }

    public long getLcExport() {
        return lcExport;
    }

    public void setLcExport(long lcExport) {
        this.lcExport = lcExport;
    }

    public long getLcImport() {
        return lcImport;
    }

    public void setLcImport(long lcImport) {
        this.lcImport = lcImport;
    }

    public int getLcStatus() {
        return lcStatus;
    }

    public void setLcStatus(int lcStatus) {
        this.lcStatus = lcStatus;
    }
}