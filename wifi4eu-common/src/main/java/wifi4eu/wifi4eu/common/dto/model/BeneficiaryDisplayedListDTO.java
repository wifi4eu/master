package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;

public class BeneficiaryDisplayedListDTO implements Serializable {
    private String name;
    private Integer id;

    public BeneficiaryDisplayedListDTO(){

    }

    public BeneficiaryDisplayedListDTO(String name, Integer id){
        this.name = name;
        this.id = id;
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

    @Override
    public String toString(){
        return "BeneficiaryDisplayedListDTO{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

}
