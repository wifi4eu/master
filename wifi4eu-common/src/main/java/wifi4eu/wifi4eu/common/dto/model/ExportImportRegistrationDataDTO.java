package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;


public class ExportImportRegistrationDataDTO implements Serializable {

    private int id;
    private int euRank;
    private int countryRank;
    private String countryName;
    private String municipalityName;
    private String issue;
    private int numberOfRegistrations;
    private String abacReference;
    private String abacStandarName;
    private int municipality;

    public ExportImportRegistrationDataDTO() {}

    public ExportImportRegistrationDataDTO(int id, int euRank, int countryRank, String countryName, String municipalityName, String issue, int numberOfRegistrations, String abacReference, String abacStandarName, int municipality) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEuRank() {
        return euRank;
    }

    public void setEuRank(int euRank) {
        this.euRank = euRank;
    }

    public int getCountryRank() {
        return countryRank;
    }

    public void setCountryRank(int countryRank) {
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

    public int getNumberOfRegistrations() {
        return numberOfRegistrations;
    }

    public void setNumberOfRegistrations(int numberOfRegistrations) {
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

    public int getMunicipality() {
        return municipality;
    }

    public void setMunicipality(int municipality) {
        this.municipality = municipality;
    }

    @Override
    public String toString() {
        return "ExportImportRegistrationDataDTO{" +
                "id=" + id + '\'' +
                ", euRank=" + euRank + '\'' +
                ", countryRank=" + countryRank + '\'' +
                ", countryName=" + countryName + '\'' +
                ", municipalityName=" + municipalityName + '\'' +
                ", issue=" + issue + '\'' +
                ", numberOfRegistrations=" + numberOfRegistrations + '\'' +
                ", abacReference='" + abacReference + '\'' +
                ", abacStandarName='" + abacStandarName + '\'' +
                ", municipality='" + municipality +
                '}';
    }

}

