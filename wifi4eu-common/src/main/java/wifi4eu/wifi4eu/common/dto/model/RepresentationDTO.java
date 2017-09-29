package wifi4eu.wifi4eu.common.dto.model;

public class RepresentationDTO {
    int id;
    int municipalityId;
    int mayorId;

    public RepresentationDTO() {
    }

    public RepresentationDTO(int id, int municipalityId, int mayorId) {
        this.id = id;
        this.municipalityId = municipalityId;
        this.mayorId = mayorId;
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

    public int getMayorId() {
        return mayorId;
    }

    public void setMayorId(int mayorId) {
        this.mayorId = mayorId;
    }
}