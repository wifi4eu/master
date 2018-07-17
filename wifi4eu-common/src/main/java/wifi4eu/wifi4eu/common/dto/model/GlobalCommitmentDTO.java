package wifi4eu.wifi4eu.common.dto.model;


import java.io.Serializable;

public class GlobalCommitmentDTO implements Serializable{
    private Integer id;
    private Integer call;
    private String globalCommitment;
    private String ammount;
    private Integer priority;

    public GlobalCommitmentDTO() {}

    public GlobalCommitmentDTO(Integer id, Integer call, String globalCommitment, String ammount, Integer priority) {
        this.id = id;
        this.call = call;
        this.globalCommitment = globalCommitment;
        this.ammount = ammount;
        this.priority = priority;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCall() {
        return call;
    }

    public void setCall(Integer call) {
        this.call = call;
    }

    public String getGlobalCommitment() {
        return globalCommitment;
    }

    public void setGlobalCommitment(String globalCommitment) {
        this.globalCommitment = globalCommitment;
    }

    public String getAmmount() {
        return ammount;
    }

    public void setAmmount(String ammount) {
        this.ammount = ammount;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

}
