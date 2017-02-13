package wifi4eu.wifi4eu.common.dto.model;

/**
 * Created by rgarcita on 09/02/2017.
 */
public class MayorDTO {

    private long mayorId;
    private String treatment;
    private String name;
    private String surname;
    private String email;
    private String repeatEmail;

    public MayorDTO(){}

    public MayorDTO(long mayorId, String treatment, String name, String surname, String email, String repeatEmail) {
        this.mayorId = mayorId;
        this.treatment = treatment;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.repeatEmail = repeatEmail;
    }

    public long getMayorId() {
        return mayorId;
    }

    public void setMayorId(long mayorId) {
        this.mayorId = mayorId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRepeatEmail() {
        return repeatEmail;
    }

    public void setRepeatEmail(String repeatEmail) {
        this.repeatEmail = repeatEmail;
    }
}
