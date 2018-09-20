package wifi4eu.wifi4eu.entity.exportImport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    // TODO: BigDecimal
    private Integer ammount;

    @Column(name = "priority")
    private Integer priority;

    public GlobalCommitment() {}

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

    public Integer getAmmount() {
        return ammount;
    }

    public void setAmmount(Integer ammount) {
        this.ammount = ammount;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

}
