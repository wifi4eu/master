package wifi4eu.wifi4eu.common.dto.model;

public class ApplicationDTO {
    private int id;
    private int callId;
    private int registrationId;
    private Integer supplierId;
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
    private int status;
    private String invalidateReason;
    private String cancelReason;
    private Boolean preSelectedFlag;
    private Boolean rejected;
    private Integer authorizedPerson;
    private boolean sentEmail;

    public ApplicationDTO() {
    }

    public ApplicationDTO(int id, int callId, int registrationId, Integer supplierId, boolean voucherAwarded, long date, long lefExport, long lefImport, int lefStatus, long bcExport, long bcImport, int bcStatus, long lcExport, long lcImport, int lcStatus, int status, String invalidateReason, String cancelReason, Boolean preSelectedFlag, Boolean rejected, Integer authorizedPerson, boolean sentEmail) {
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
        this.status = status;
        this.invalidateReason = invalidateReason;
        this.cancelReason = cancelReason;
        this.preSelectedFlag = preSelectedFlag;
        this.rejected = rejected;
        this.authorizedPerson = authorizedPerson;
        this.sentEmail = sentEmail;
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

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInvalidateReason() {
        return invalidateReason;
    }

    public void setInvalidateReason(String invalidateReason) {
        this.invalidateReason = invalidateReason;
    }

    public Boolean getPreSelectedFlag() {
        return preSelectedFlag;
    }

    public void setPreSelectedFlag(Boolean preSelectedFlag) {
        this.preSelectedFlag = preSelectedFlag;
    }

    public Boolean getRejected() {
        return rejected;
    }

    public void setRejected(Boolean rejected) {
        this.rejected = rejected;
    }

    public Integer getAuthorizedPerson() { return authorizedPerson; }

    public void setAuthorizedPerson(Integer authorizedPerson) { this.authorizedPerson = authorizedPerson; }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public boolean isSentEmail() {
        return sentEmail;
    }

    public void setSentEmail(boolean sentEmail) {
        this.sentEmail = sentEmail;
    }
}