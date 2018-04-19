package wifi4eu.wifi4eu.entity.voucher;

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

    @ManyToOne
    @JoinColumn(name = "municipality")
    private Municipality municipality;

    @Column(name = "issues")
    private Integer issues;

    @Column(name = "num_applications")
    private String numApplications;

    @Column(name = "rejected")
    private Integer rejected;

    @ManyToOne
    @JoinColumn(name = "voucher_assignment")
    private VoucherAssignment voucherAssignment;

    public VoucherSimulation() {
    }

    public VoucherSimulation(Integer id, Integer euRank, Integer countryRank, String country, Municipality municipality, Integer issues, String numApplications, Integer rejected, VoucherAssignment voucherAssignment) {
        this.id = id;
        this.euRank = euRank;
        this.countryRank = countryRank;
        this.country = country;
        this.municipality = municipality;
        this.issues = issues;
        this.numApplications = numApplications;
        this.rejected = rejected;
        this.voucherAssignment = voucherAssignment;
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

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }

    public Integer getIssues() {
        return issues;
    }

    public void setIssues(Integer issues) {
        this.issues = issues;
    }

    public String getNumApplications() {
        return numApplications;
    }

    public void setNumApplications(String numApplications) {
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
}
