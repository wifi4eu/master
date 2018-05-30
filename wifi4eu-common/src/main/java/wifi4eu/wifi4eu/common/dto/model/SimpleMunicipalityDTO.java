package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;
import java.util.List;

public class SimpleMunicipalityDTO implements Serializable {
    private int id;
    private String country;
    private int lau;


    public SimpleMunicipalityDTO() {
    }

    public SimpleMunicipalityDTO(int id, String country, int lauId ) {
        this.id = id;
        this.country = country;
        this.lau = lauId;
    }

    public int getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getLauId() {
        return lau;
    }

    public void setLauId(int lauId) {
        this.lau= lauId;
    }

    @Override
    public String toString() {
        return "MunicipalityDTO{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", lau=" + lau +
                '}';
    }
}
