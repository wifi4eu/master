package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;

public class SimpleLauDTO implements Serializable {
    private int id;
    private String countryCode;
    private String nuts3;
    private String lau1;
    private String lau2;
    private String change;
    private String name1;
    private String name2;
    private int pop;
    private int area;
    private String physicalAddress;

    public SimpleLauDTO() {
    }

    public SimpleLauDTO(int id, String countryCode) {
        this.id = id;
        this.countryCode = countryCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return "SimpleLauDTO{" +
                "id=" + id +
                ", countryCode='" + countryCode + '\'';
    }
}