package wifi4eu.wifi4eu.entity.exportImport;

import wifi4eu.wifi4eu.entity.municipality.Municipality;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "budgetary_commitment")
public class BudgetaryCommitment {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "municipality")
    private Municipality municipality;

    @ManyToOne
    @JoinColumn(name = "global_commitment")
    private GlobalCommitment globalCommitment;

    @Column(name = "position")
    private Integer position;

    @Column(name = "ammount")
    private Integer ammount;

    @Column(name = "abac_bc_key")
    private String abacBcKey;

    @Column(name = "abac_lc_key")
    private String abacLcKey;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }

    public GlobalCommitment getGlobalCommitment() {
        return globalCommitment;
    }

    public void setGlobalCommitment(GlobalCommitment globalCommitment) {
        this.globalCommitment = globalCommitment;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getAmmount() {
        return ammount;
    }

    public void setAmmount(Integer ammount) {
        this.ammount = ammount;
    }

    public String getAbacBcKey() {
        return abacBcKey;
    }

    public void setAbacBcKey(String abacBcKey) {
        this.abacBcKey = abacBcKey;
    }

    public String getAbacLcKey() {
        return abacLcKey;
    }

    public void setAbacLcKey(String abacLcKey) {
        this.abacLcKey = abacLcKey;
    }
}
