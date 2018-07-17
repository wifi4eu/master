package wifi4eu.wifi4eu.entity.exportImport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "global_commitment")
public class GlobalCommitment {
    @Column(name = "id")
    @Id
    private Integer id;

    @Column(name = "call")

    private Integer call;

    @Column(name = "globalCommitment")
    private String globalCommitment;

    @Column(name = "ammount")
    private String ammount;

    @Column(name = "priority")
    private Integer priority;

    public GlobalCommitment() {}

    public GlobalCommitment(Integer id, Integer call, String globalCommitment, String ammount, Integer priority) {
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
