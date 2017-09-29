package wifi4eu.wifi4eu.entity;

import javax.persistence.*;

@Entity
@Table(name = "nuts")
public class Nuts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int nutsId;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "level")
    private int level;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "order")
    private int order;

    @Column(name = "sorting")
    private int sorting;

    public Nuts() {
    }

    public Nuts(int nutsId, String code, String name, int level, String countryCode, int order, int sorting) {
        this.nutsId = nutsId;
        this.code = code;
        this.name = name;
        this.level = level;
        this.countryCode = countryCode;
        this.order = order;
        this.sorting = sorting;
    }

    public int getNutsId() {
        return nutsId;
    }

    public void setNutsId(int nutsId) {
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getSorting() {
        return sorting;
    }

    public void setSorting(int sorting) {
        this.sorting = sorting;
    }
}