package wifi4eu.wifi4eu.entity.voucher;

import javax.persistence.*;

@Entity
public class SimpleRegistration {

    @Id
    private Integer id;

    private Integer municipality;

    public SimpleRegistration() {}


    public SimpleRegistration(Integer id, Integer municipalityId) {
        this.id = id;
        this.municipality = municipalityId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMunicipalityId() {
        return municipality;
    }

    public void setMunicipalityId(Integer municipalityId) {
        this.municipality = municipalityId;
    }
}
