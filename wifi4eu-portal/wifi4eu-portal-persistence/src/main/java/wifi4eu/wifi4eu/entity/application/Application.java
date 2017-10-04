package wifi4eu.wifi4eu.entity.application;

import wifi4eu.wifi4eu.entity.call.Call;
import wifi4eu.wifi4eu.entity.registration.Registration;

import javax.persistence.*;

@Entity
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id;

    @ManyToOne
    @JoinColumn(name = "call")
    Call call;

    @ManyToOne
    @JoinColumn(name = "registration")
    Registration registration;

    @Column(name = "supplier")
    Integer supplierId;

    @Column(name = "voucher_awarded")
    boolean voucherAwarded;

    @Column(name = "date")
    Long date;

    @Column(name = "lef_export")
    Long lefExport;

    @Column(name = "lef_import")
    Long lefImport;

    @Column(name = "lef_status")
    Integer lefStatus;

    @Column(name = "bc_export")
    Long bcExport;

    @Column(name = "bc_import")
    Long bcImport;

    @Column(name = "bc_status")
    Integer bcStatus;

    @Column(name = "lc_export")
    Long lcExport;

    @Column(name = "lc_import")
    Long lcImport;

    @Column(name = "lc_status")
    Integer lcStatus;

    public Application() {
    }

    public Application(Integer id, Call call, Registration registration, Integer supplierId, boolean voucherAwarded, Long date, Long lefExport, Long lefImport, Integer lefStatus, Long bcExport, Long bcImport, Integer bcStatus, Long lcExport, Long lcImport, Integer lcStatus) {
        this.id = id;
        this.call = call;
        this.registration = registration;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Call getCall() {
        return call;
    }

    public void setCall(Call call) {
        this.call = call;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
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
}