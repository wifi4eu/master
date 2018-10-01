package wifi4eu.wifi4eu.entity.location;

import javax.persistence.*;

@Entity
@Table(name = "laus")
public class Lau {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "nuts3")
    private String nuts3;

    @Column(name = "lau1")
    private String lau1;

    @Column(name = "lau2")
    private String lau2;

    @Column(name = "_change")
    private String change;

    @Column(name = "name_national", updatable = false, insertable = false)
    private String name1;

    @Column(name = "display_name", updatable = false, insertable = false)
    private String name2;

    @Column(name = "pop")
    private Integer pop;

    @Column(name = "area")
    private Integer area;

    @Column(name = "physical_address")
    private String physicalAddress;

    @Column(name = "name_national")
    private String nationalName;

    @Column(name = "name_latin")
    private String latinName;

    @Column(name = "abac_name")
    private String abacName;

    @Column(name = "display_name")
    private String displayName;

    public Lau() {
    }

    public Lau(Integer id, String countryCode, String nuts3, String lau1, String lau2, String change, String name1, String name2, Integer pop,
               Integer area, String physicalAddress, String nationalName, String latinName, String abacName, String displayName) {
        this.id = id;
        this.countryCode = countryCode;
        this.nuts3 = nuts3;
        this.lau1 = lau1;
        this.lau2 = lau2;
        this.change = change;
        this.name1 = name1;
        this.name2 = name2;
        this.pop = pop;
        this.area = area;
        this.physicalAddress = physicalAddress;
        this.nationalName = nationalName;
        this.latinName = latinName;
        this.abacName = abacName;
        this.displayName = displayName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getNuts3() {
        return nuts3;
    }

    public void setNuts3(String nuts3) {
        this.nuts3 = nuts3;
    }

    public String getLau1() {
        return lau1;
    }

    public void setLau1(String lau1) {
        this.lau1 = lau1;
    }

    public String getLau2() {
        return lau2;
    }

    public void setLau2(String lau2) {
        this.lau2 = lau2;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public Integer getPop() {
        return pop;
    }

    public void setPop(Integer pop) {
        this.pop = pop;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public String getNationalName() {
        return nationalName;
    }

    public void setNationalName(String nationalName) {
        this.nationalName = nationalName;
    }

    public String getLatinName() {
        return latinName;
    }

    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }

    public String getAbacName() {
        return abacName;
    }

    public void setAbacName(String abacName) {
        this.abacName = abacName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
