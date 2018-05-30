package wifi4eu.wifi4eu.entity.voucher;


import wifi4eu.wifi4eu.entity.location.Lau;

import javax.persistence.*;

@Entity
public class SimpleMunicipality {

    @Id
    private Integer id;

    private String country;

    private Integer lau;

    public SimpleMunicipality(){}

    public SimpleMunicipality(Integer id, String country, Integer lau) {
        this.id = id;
        this.country = country;
        this.lau = lau;
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
}
