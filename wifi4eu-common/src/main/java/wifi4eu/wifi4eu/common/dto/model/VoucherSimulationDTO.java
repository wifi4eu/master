package wifi4eu.wifi4eu.common.dto.model;

import java.util.List;

public class VoucherSimulationDTO {

    private int id;
    private int euRank;
    private int countryRank;
    private String country;
    private int municipality;
    private int numApplications;
    private int rejected;
    private int voucherAssignment;
    private int selectionStatus;
    private ApplicationDTO application;
    private int lau;
    private String municipalityName;
    private List<RegistrationWarningDTO> registrationWarningDTO;
    private Integer issues;

    public VoucherSimulationDTO() {
    }

    public VoucherSimulationDTO(List<RegistrationWarningDTO> registrationWarningDTO, int id, int euRank, int countryRank, String country, int municipality, int numApplications, int rejected, int voucherAssignment, int selectionStatus, ApplicationDTO application, int lau, String municipalityName, Integer issues) {
        this.id = id;
        this.euRank = euRank;
        this.countryRank = countryRank;
        this.country = country;
        this.municipality = municipality;
        this.numApplications = numApplications;
        this.rejected = rejected;
        this.voucherAssignment = voucherAssignment;
        this.selectionStatus = selectionStatus;
        this.application = application;
        this.lau = lau;
        this.municipalityName = municipalityName;
        this.registrationWarningDTO = registrationWarningDTO;
        this.issues = issues;
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

    public int getMunicipality() {
        return municipality;
    }

    public void setMunicipality(int municipality) {
        this.municipality = municipality;
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

    public int getSelectionStatus() {
        return selectionStatus;
    }

    public void setSelectionStatus(int selectionStatus) {
        this.selectionStatus = selectionStatus;
    }

    public ApplicationDTO getApplication() {
        return application;
    }

    public void setApplication(ApplicationDTO application) {
        this.application = application;
    }

    public int getLau() {
        return lau;
    }

    public void setLau(int lau) {
        this.lau = lau;
    }

    public String getMunicipalityName() {
        return municipalityName;
    }

    public void setMunicipalityName(String municipalityName) {
        this.municipalityName = municipalityName;
    }

    public List<RegistrationWarningDTO> getRegistrationWarningDTO() {
        return registrationWarningDTO;
    }

    public void setRegistrationWarningDTO(List<RegistrationWarningDTO> registrationWarningDTO) {
        this.registrationWarningDTO = registrationWarningDTO;
    }

    public Integer getIssues() {
        return issues;
    }

    public void setIssues(Integer issues) {
        this.issues = issues;
    }
}
