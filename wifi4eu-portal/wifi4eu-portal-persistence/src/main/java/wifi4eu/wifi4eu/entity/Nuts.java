package wifi4eu.wifi4eu.entity;

import javax.persistence.*;

@Entity
@Table(name = "nuts")
public class Nuts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer nutsId;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "level")
    private Integer level;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "order")
    private Integer order;

    @Column(name = "sorting")
    private Integer sorting;

    public Nuts() {
    }

    public Nuts(Integer nutsId, String code, String name, Integer level, String countryCode, Integer order, Integer sorting) {
        this.nutsId = nutsId;
        this.code = code;
        this.name = name;
        this.level = level;
        this.countryCode = countryCode;
        this.order = order;
        this.sorting = sorting;
    }

    public Integer getNutsId() {
        return nutsId;
    }

    public void setNutsId(Integer nutsId) {
        this.nutsId = nutsId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getSorting() {
        return sorting;
    }

    public void setSorting(Integer sorting) {
        this.sorting = sorting;
    }
}