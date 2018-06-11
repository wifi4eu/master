package wifi4eu.wifi4eu.entity.application;

import wifi4eu.wifi4eu.entity.call.Call;
import wifi4eu.wifi4eu.entity.registration.Registration;
import wifi4eu.wifi4eu.entity.supplier.Supplier;

import javax.persistence.*;

@Entity
@Table(name = "applications")
public class Application {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "call_id")
    private Integer callId;

    @Column(name = "registration")
    private Integer registrationId;

    @Column(name = "supplier")
    private Integer supplierId;

    @Column(name = "voucher_awarded")
    private boolean voucherAwarded;

    @Column(name = "date")
    private Long date;

    @Column(name = "lef_export")
    private Long lefExport;

    @Column(name = "lef_import")
    private Long lefImport;

    @Column(name = "lef_status")
    private Integer lefStatus;

    @Column(name = "bc_export")
    private Long bcExport;

    @Column(name = "bc_import")
    private Long bcImport;

    @Column(name = "bc_status")
    private Integer bcStatus;

    @Column(name = "lc_export")
    private Long lcExport;

    @Column(name = "lc_import")
    private Long lcImport;

    @Column(name = "lc_status")
    private Integer lcStatus;

    @Column(name = "_status")
    private int status;

    @Column(name = "invalidate_reason")
    private String invalidateReason;

    public Application() {
    }

    public Application(Integer id, Integer call, Integer registration, Integer supplier, boolean voucherAwarded, Long date, Long lefExport, Long lefImport, Integer lefStatus, Long bcExport, Long bcImport, Integer bcStatus, Long lcExport, Long lcImport, Integer lcStatus, Integer status, String invalidateReason) {
        this.id = id;
        this.callId = call;
        this.registrationId = registration;
        this.supplierId = supplier;
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
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCallId() {
        return callId;
    }

    public void setCallId(Integer callId) {
        this.callId = callId;
    }

    public Integer getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Integer registrationId) {
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

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
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

    public Integer getLefStatus() {
        return lefStatus;
    }

    public void setLefStatus(Integer lefStatus) {
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

    public Integer getBcStatus() {
        return bcStatus;
    }

    public void setBcStatus(Integer bcStatus) {
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

    public Integer getLcStatus() {
        return lcStatus;
    }

    public void setLcStatus(Integer lcStatus) {
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
}