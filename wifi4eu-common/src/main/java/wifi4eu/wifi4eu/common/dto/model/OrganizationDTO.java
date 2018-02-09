package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;

public class OrganizationDTO implements Serializable {
    private int id;
    private String name;
    private String type;
    private String country;

    public OrganizationDTO() {
    }

    public OrganizationDTO(int id, String name, String type, String country) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.country = country;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "OrganizationDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}