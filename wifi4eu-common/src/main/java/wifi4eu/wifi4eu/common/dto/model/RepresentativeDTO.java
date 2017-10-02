package wifi4eu.wifi4eu.common.dto.model;

/**
 * Created by rgarcita on 09/02/2017.
 */
public class RepresentativeDTO {


    private long representativeId;
    private String treatment;
    private String name;
    private String surname;
    private String municipalityRole;
    private String email;
    private String mayorRepeatEmail;
    private long mayorId;
    private String status;

    public RepresentativeDTO() {
    }

    public RepresentativeDTO(long representativeId, String treatment, String name, String surname, String municipalityRole, String email, String mayorRepeatEmail, long mayorId, String status) {
        this.representativeId = representativeId;
        this.treatment = treatment;
        this.name = name;
        this.surname = surname;
        this.municipalityRole = municipalityRole;
        this.email = email;
        this.mayorRepeatEmail = mayorRepeatEmail;
        this.mayorId = mayorId;
        this.status = status;
    }

    public long getRepresentativeId() {
        return representativeId;
    }

    public void setRepresentativeId(long representativeId) {
        this.representativeId = representativeId;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMunicipalityRole() {
        return municipalityRole;
    }

    public void setMunicipalityRole(String municipalityRole) {
        this.municipalityRole = municipalityRole;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMayorRepeatEmail() {
        return mayorRepeatEmail;
    }

    public void setMayorRepeatEmail(String mayorRepeatEmail) {
        this.mayorRepeatEmail = mayorRepeatEmail;
    }

    public Long getMayorId() {
        return mayorId;
    }

    public void setMayorId(Long mayorId) {
        this.mayorId = mayorId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
