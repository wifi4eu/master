package wifi4eu.wifi4eu.entity.exportImport;

import wifi4eu.wifi4eu.entity.municipality.Municipality;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "municipalities_abac")
public class ExportImportRegistrationData {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "euRank")
    private Integer euRank;

    @Column(name = "countryRank")
    private Integer countryRank;

    @Column(name = "countryName")
    private String countryName;

    @Column(name = "municipalityName")
    private String municipalityName;

    @Column(name = "issue")
    private String issue;

    @Column(name = "numberOfRegistrations")
    private Integer numberOfRegistrations;

    @Column(name = "abacReference")
    private String abacReference;

    @Column(name = "abacStandarName")
    private String abacStandarName;

    @ManyToOne
    @JoinColumn(name = "municipality")
    private Municipality municipality;

    public ExportImportRegistrationData() {
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

    public void setCountryRank(Integer countryRank) {
        this.countryRank = countryRank;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getMunicipalityName() {
        return municipalityName;
    }

    public void setMunicipalityName(String municipalityName) {
        this.municipalityName = municipalityName;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public Integer getNumberOfRegistrations() {
        return numberOfRegistrations;
    }

    public void setNumberOfRegistrations(Integer numberOfRegistrations) {
        this.numberOfRegistrations = numberOfRegistrations;
    }

    public String getAbacReference() {
        return abacReference;
    }

    public void setAbacReference(String abacReference) {
        this.abacReference = abacReference;
    }

    public String getAbacStandarName() {
        return abacStandarName;
    }

    public void setAbacStandarName(String abacStandarName) {
        this.abacStandarName = abacStandarName;
    }

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }

}
