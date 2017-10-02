package wifi4eu.wifi4eu.entity;

import javax.persistence.*;

@Entity
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;

    @ManyToOne
    @JoinColumn(name = "call")
    Call call;

    @ManyToOne
    @JoinColumn(name = "registration")
    Registration registration;

    @Column(name = "supplier")
    int supplierId;

    @Column(name = "voucher_awarded")
    boolean voucherAwarded;

    @Column(name = "date")
    long date;

    @Column(name = "lef_export")
    long lefExport;

    @Column(name = "lef_import")
    long lefImport;

    @Column(name = "lef_status")
    int lefStatus;

    @Column(name = "bc_export")
    long bcExport;

    @Column(name = "bc_import")
    long bcImport;

    @Column(name = "bc_status")
    int bcStatus;

    @Column(name = "lc_export")
    long lcExport;

    @Column(name = "lc_import")
    long lcImport;

    @Column(name = "lc_status")
    int lcStatus;

    public Application() {
    }

    public Application(int id, Call call, Registration registration, int supplierId, boolean voucherAwarded, long date, long lefExport, long lefImport, int lefStatus, long bcExport, long bcImport, int bcStatus, long lcExport, long lcImport, int lcStatus) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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