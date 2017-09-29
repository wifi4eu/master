package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;

/**
 * Created by rgarcita on 08/02/2017.
 */
public class LauDTO implements Serializable {

    private Long lauId;
    private String countryCode;
    private String nuts3;
    private String lau1;
    private String lau2;
    private String change;
    private String name1;
    private String name2;
    private long pop;
    private long area;
    private String physicalAddress;

    public LauDTO() {
    }

    public LauDTO(Long lauId, String countryCode, String nuts3, String lau1, String lau2, String change, String name1, String name2, long pop, long area, String physicalAddress) {
        this.lauId = lauId;
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
    }

    public Long getLauId() {
        return lauId;
    }

    public void setLauId(Long lauId) {
        this.lauId = lauId;
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

    public long getPop() {
        return pop;
    }

    public void setPop(long pop) {
        this.pop = pop;
    }

    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }
}
