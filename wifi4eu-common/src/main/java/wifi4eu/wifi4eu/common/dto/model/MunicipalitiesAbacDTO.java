package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;

public class MunicipalitiesAbacDTO implements Serializable {

    private Integer id;
    private String abacReference;
    private String abacStandarName;
    private String countryName;
    private Integer countryRank;
    private Integer euRank;
    private Integer municipality;
    private String municipalityName;
    private String numberOfRegistrations;
    private String issue;

    public MunicipalitiesAbacDTO() {
    }

    public MunicipalitiesAbacDTO(Integer id, String abacReference, String abacStandarName, String countryName, Integer countryRank, Integer euRank, Integer municipality, String municipalityName, String numberOfRegistrations, String issue) {
        this.id = id;
        this.abacReference = abacReference;
        this.abacStandarName = abacStandarName;
        this.countryName = countryName;
        this.countryRank = countryRank;
        this.euRank = euRank;
        this.municipality = municipality;
        this.municipalityName = municipalityName;
        this.numberOfRegistrations = numberOfRegistrations;
        this.issue = issue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Integer getCountryRank() {
        return countryRank;
    }

    public void setCountryRank(Integer countryRank) {
        this.countryRank = countryRank;
    }

    public Integer getEuRank() {
        return euRank;
    }

    public void setEuRank(Integer euRank) {
        this.euRank = euRank;
    }

    public Integer getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Integer municipality) {
        this.municipality = municipality;
    }

    public String getMunicipalityName() {
        return municipalityName;
    }

    public void setMunicipalityName(String municipalityName) {
        this.municipalityName = municipalityName;
    }

    public String getNumberOfRegistrations() {
        return numberOfRegistrations;
    }

    public void setNumberOfRegistrations(String numberOfRegistrations) {
        this.numberOfRegistrations = numberOfRegistrations;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }
}
