package wifi4eu.wifi4eu.entity.voucher;

import wifi4eu.wifi4eu.entity.application.Application;
import wifi4eu.wifi4eu.entity.municipality.Municipality;

import javax.persistence.*;

@Entity
@Table(name = "voucher_simulations")
public class VoucherSimulation {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "eu_rank")
    private Integer euRank;

    @Column(name = "country_rank")
    private Integer countryRank;

    @Column(name = "country")
    private String country;

    @Column(name = "municipality")
    private Integer municipality;

    @Column(name = "num_applications")
    private Integer numApplications;

    @Column(name = "rejected")
    private Integer rejected;

    @Column(name = "selection_status")
    private Integer selectionStatus;

    @OneToOne
    @JoinColumn(name = "application")
    private Application application;

    @ManyToOne
    @JoinColumn(name = "voucher_assignment")
    private VoucherAssignment voucherAssignment;

    @Column(name = "issues")
    private Integer issues;

    public VoucherSimulation() {
    }

    public VoucherSimulation(Integer id, Integer euRank, Integer countryRank, String country, Integer municipality, Integer numApplications, Integer rejected, Integer selectionStatus, Application application, VoucherAssignment voucherAssignment, Integer issues) {
        this.id = id;
        this.euRank = euRank;
        this.countryRank = countryRank;
        this.country = country;
        this.municipality = municipality;
        this.numApplications = numApplications;
        this.rejected = rejected;
        this.selectionStatus = selectionStatus;
        this.application = application;
        this.voucherAssignment = voucherAssignment;
        this.issues = issues;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEuRank() {
        return euRank;
    }

    public void setEuRank(Integer euRank) {
        this.euRank = euRank;
    }

    public Integer getCountryRank() {
        return countryRank;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCountryRank(Integer countryRank) {
        this.countryRank = countryRank;
    }

    public Integer getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Integer municipality) {
        this.municipality = municipality;
    }

    public Integer getNumApplications() {
        return numApplications;
    }

    public void setNumApplications(Integer numApplications) {
        this.numApplications = numApplications;
    }

    public Integer getRejected() {
        return rejected;
    }

    public void setRejected(Integer rejected) {
        this.rejected = rejected;
    }

    public VoucherAssignment getVoucherAssignment() {
        return voucherAssignment;
    }

    public void setVoucherAssignment(VoucherAssignment voucherAssignment) {
        this.voucherAssignment = voucherAssignment;
    }

    public Integer getSelectionStatus() {
        return selectionStatus;
    }

    public void setSelectionStatus(Integer selectionStatus) {
        this.selectionStatus = selectionStatus;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public Integer getIssues() {
        return issues;
    }

    public void setIssues(Integer issues) {
        this.issues = issues;
    }
}
