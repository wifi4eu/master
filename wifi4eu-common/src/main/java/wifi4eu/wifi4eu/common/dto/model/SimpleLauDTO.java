package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;

public class SimpleLauDTO implements Serializable {
    private int id;
    private String country_code;

    public SimpleLauDTO() {
    }

    public SimpleLauDTO(int id, String country_code) {
        this.id = id;
        this.country_code = country_code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }
}