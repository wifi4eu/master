package wifi4eu.wifi4eu.entity.exportImport;

import javax.persistence.*;

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

    @Column(name = "municipality")
    private Integer municipality;

    public ExportImportRegistrationData() {}

    public ExportImportRegistrationData(Integer id, Integer euRank, Integer countryRank, String countryName, String municipalityName, String issue, Integer numberOfRegistrations, String abacReference, String abacStandarName, Integer municipality) {
        this.id = id;
        this.euRank = euRank;
        this.countryRank = countryRank;
        this.countryName = countryName;
        this.municipalityName = municipalityName;
        this.issue = issue;
        this.numberOfRegistrations = numberOfRegistrations;
        this.abacReference = abacReference;
        this.abacStandarName = abacStandarName;
        this.municipality = municipality;
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

    public Integer getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Integer municipality) {
        this.municipality = municipality;
    }
}
