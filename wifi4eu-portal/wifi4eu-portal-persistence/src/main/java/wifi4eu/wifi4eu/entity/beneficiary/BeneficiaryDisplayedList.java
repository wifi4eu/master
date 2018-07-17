package wifi4eu.wifi4eu.entity.beneficiary;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BeneficiaryDisplayedList {
    private String name;
    @Id
    private Integer id;

    public BeneficiaryDisplayedList(){

    }

    public BeneficiaryDisplayedList(String name, Integer id){
        this.name = name;
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

}
