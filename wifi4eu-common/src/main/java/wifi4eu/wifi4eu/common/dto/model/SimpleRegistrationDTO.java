package wifi4eu.wifi4eu.common.dto.model;

public class SimpleRegistrationDTO {

    private int id;
    private int municipality;

    public SimpleRegistrationDTO() {
    }

    public SimpleRegistrationDTO(int id, int municipality) {
        this.id = id;
        this.municipality = municipality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMunicipalityId() {
        return municipality;
    }

    public void setMunicipalityId(int municipality) {
        this.municipality = municipality;
    }
}
