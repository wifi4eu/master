package wifi4eu.wifi4eu.entity.application;

import wifi4eu.wifi4eu.entity.call.Call;
import wifi4eu.wifi4eu.entity.registration.Registration;
import wifi4eu.wifi4eu.entity.supplier.Supplier;

import javax.persistence.*;

@Entity
@Table(name = "applications")
public class Application {
    @Id
    @SequenceGenerator(name = "application_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "application_seq")
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "call_id")
    private Call call;

    @ManyToOne
    @JoinColumn(name = "registration")
    private Registration registration;

    @ManyToOne
    @JoinColumn(name = "supplier")
    private Supplier supplier;

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

    public Application() {
    }

    public Application(Integer id, Call call, Registration registration, Supplier supplier, boolean voucherAwarded, Long date, Long lefExport, Long lefImport, Integer lefStatus, Long bcExport, Long bcImport, Integer bcStatus, Long lcExport, Long lcImport, Integer lcStatus) {
        this.id = id;
        this.call = call;
        this.registration = registration;
        this.supplier = supplier;
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

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
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