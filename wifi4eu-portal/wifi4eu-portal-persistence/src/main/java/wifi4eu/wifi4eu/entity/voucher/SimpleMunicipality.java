package wifi4eu.wifi4eu.entity.voucher;


import wifi4eu.wifi4eu.entity.location.Lau;

import javax.persistence.*;

@Entity
public class SimpleMunicipality {

    @Id
    private Integer id;

    private String country;

    private Integer lau;

    private String name;

    public SimpleMunicipality(){}

    public SimpleMunicipality(Integer id, String country, Integer lau, String name) {
        this.id = id;
        this.country = country;
        this.lau = lau;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getLau() {
        return lau;
    }

    public void setLau(Integer lau) {
        this.lau = lau;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
