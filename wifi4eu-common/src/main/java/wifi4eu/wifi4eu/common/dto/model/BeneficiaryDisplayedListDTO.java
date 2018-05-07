package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;

public class BeneficiaryDisplayedListDTO implements Serializable {
    private String name;
    private Integer id;
    private Boolean wifiIndicator;

    public BeneficiaryDisplayedListDTO(){

    }

    public BeneficiaryDisplayedListDTO(String name, Integer id, boolean wifiIndicator){
        this.name = name;
        this.id = id;
        this.wifiIndicator = wifiIndicator;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Boolean isWifiIndicator() {
        return wifiIndicator;
    }

    public void setWifiIndicator(Boolean wifiIndicator) {
        this.wifiIndicator = wifiIndicator;
    }

    @Override
    public String toString() {
        return "BeneficiaryDisplayedListDTO{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", wifiIndicator=" + wifiIndicator +
                '}';
    }
}
