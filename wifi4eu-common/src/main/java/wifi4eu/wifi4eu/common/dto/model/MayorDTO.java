package wifi4eu.wifi4eu.common.dto.model;

public class MayorDTO {
    private int id;
    private String name;
    private String surname;
    private String email;
    private int municipalityId;

    public MayorDTO() {
    }

    public MayorDTO(int id, String name, String surname, String email, int municipalityId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.municipalityId = municipalityId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getMunicipalityId() {
        return municipalityId;
    }

    public void setMunicipalityId(int municipalityId) {
        this.municipalityId = municipalityId;
    }
}