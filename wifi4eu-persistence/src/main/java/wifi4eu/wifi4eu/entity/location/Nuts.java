package wifi4eu.wifi4eu.entity.location;

import javax.persistence.*;


/**
 * Created by rgarcita on 08/02/2017.
 */
@Entity
@Table(name="LOC_NUTS_T")
public class Nuts {

    @Id
    @Column(name="NUTS_ID")
    private Long nutsId;

    @Column(name="CODE")
    private String code;

    @Column(name="NAME")
    private String name;

    @Column(name="LEVEL")
    private Long level;

    @Column(name="CONTRY_CODE")
    private String countryCode;

    @Column(name="_ORDER")
    private Long order;

    @Column(name="SORTING")
    private Long sorting;

    public Nuts() {
    }

    public Nuts(Long nutsId, String code, String name, Long level, String countryCode, Long order, Long sorting) {
        this.nutsId = nutsId;
        this.code = code;
        this.name = name;
        this.level = level;
        this.countryCode = countryCode;
        this.order = order;
        this.sorting = sorting;
    }

    public Long getNutsId() {
        return nutsId;
    }

    public void setNutsId(Long nutsId) {
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

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Long getOrder() {
        return order;
    }

    public void setOrder(Long order) {
        this.order = order;
    }

    public Long getSorting() {
        return sorting;
    }

    public void setSorting(Long sorting) {
        this.sorting = sorting;
    }
}
