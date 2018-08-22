package wifi4eu.wifi4eu.entity.voucher;

import javax.persistence.*;

@Entity
public class SimpleLau {

    @Id
    private Integer id;

    private String country_code;

    public SimpleLau(){}

    public SimpleLau(Integer id, String country_code) {
        this.id = id;
        this.country_code = country_code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }
}
