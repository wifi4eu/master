package wifi4eu.wifi4eu.common.dto.model;

public class SimpleRegistrationDTO {

    private int id;
    private int municipalityId;

    public SimpleRegistrationDTO(int id, int municipalityId) {
        this.id = id;
        this.municipalityId = municipalityId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMunicipalityId() {
        return municipalityId;
    }

    public void setMunicipalityId(int municipalityId) {
        this.municipalityId = municipalityId;
    }
}
