package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;
import java.util.List;

public class SimpleMunicipalityDTO implements Serializable {
    private int id;
    private String country;
    private int lau;
    private String name;

    public SimpleMunicipalityDTO() {
    }

    public SimpleMunicipalityDTO(int id, String country, int lau, String name) {
        this.id = id;
        this.country = country;
        this.lau = lau;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getLau() {
        return lau;
    }

    public void setLau(int lau) {
        this.lau = lau;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MunicipalityDTO{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", lau=" + lau +
                ", name=" + lau +
                '}';
    }
}
