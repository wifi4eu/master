package wifi4eu.wifi4eu.entity.location;

import javax.persistence.*;

@Entity
@Table(name = "nuts")
public class Nuts {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "label")
    private String label;

    @Column(name = "level")
    private Integer level;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "_order")
    private Integer order;

    @Column(name = "sorting")
    private Integer sorting;

    public Nuts() {
    }

    public Nuts(Integer id, String code, String label, Integer level, String countryCode, Integer order, Integer sorting) {
        this.id = id;
        this.code = code;
        this.label = label;
        this.level = level;
        this.countryCode = countryCode;
        this.order = order;
        this.sorting = sorting;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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