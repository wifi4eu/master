package wifi4eu.wifi4eu.common.dto.model;

public class VoucherSimulationDTO {

    private int id;
    private int euRank;
    private int countryRank;
    private String country;
    private MunicipalityDTO municipality;
    private int issues;
    private int numApplications;
    private int rejected;
    private int voucherAssignment;

    public VoucherSimulationDTO() {
    }

    public VoucherSimulationDTO(int id, int euRank, int countryRank, String country, MunicipalityDTO municipality, int issues, int numApplications, int rejected, int voucherAssignment) {
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

    public VoucherSimulationDTO(int euRank, int countryRank, String country, MunicipalityDTO municipality, int issues, int numApplications, int rejected, int voucherAssignment) {
        this.euRank = euRank;
        this.countryRank = countryRank;
        this.country = country;
        this.municipality = municipality;
        this.issues = issues;
        this.numApplications = numApplications;
        this.rejected = rejected;
        this.voucherAssignment = voucherAssignment;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public MunicipalityDTO getMunicipality() {
        return municipality;
    }

    public void setMunicipality(MunicipalityDTO municipality) {
        this.municipality = municipality;
    }

    public int getIssues() {
        return issues;
    }

    public void setIssues(int issues) {
        this.issues = issues;
    }

    public int getNumApplications() {
        return numApplications;
    }

    public void setNumApplications(int numApplications) {
        this.numApplications = numApplications;
    }

    public int getRejected() {
        return rejected;
    }

    public void setRejected(int rejected) {
        this.rejected = rejected;
    }

    public int getVoucherAssignment() {
        return voucherAssignment;
    }

    public void setVoucherAssignment(int voucherAssignment) {
        this.voucherAssignment = voucherAssignment;
    }
}
