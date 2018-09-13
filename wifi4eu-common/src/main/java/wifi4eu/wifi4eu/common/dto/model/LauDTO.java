package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;

public class LauDTO implements Serializable {
    private int id;
    private String countryCode;
    private String nuts3;
    private String lau1;
    private String lau2;
    private String change;
    private String name1;
    private String name2;
    private int pop;
    private int area;
    private String physicalAddress;
    private String nationalName;
    private String latinName;
    private String abacName;
    private String displayName;

    public LauDTO() {
    }

    public LauDTO(int id, String countryCode, String nuts3, String lau1, String lau2, String change, String name1, String name2, int pop, int area,
                  String physicalAddress, String nationalName, String latinName, String abacName, String displayName) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getPop() {
        return pop;
    }

    public void setPop(int pop) {
        this.pop = pop;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
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

    @Override
    public String toString() {
        return "LauDTO{" +
                "id=" + id +
                ", countryCode='" + countryCode + '\'' +
                ", nuts3='" + nuts3 + '\'' +
                ", lau1='" + lau1 + '\'' +
                ", lau2='" + lau2 + '\'' +
                ", change='" + change + '\'' +
                ", name1='" + name1 + '\'' +
                ", name2='" + name2 + '\'' +
                ", pop=" + pop +
                ", area=" + area +
                ", physicalAddress='" + physicalAddress + '\'' +
                '}';
    }
}