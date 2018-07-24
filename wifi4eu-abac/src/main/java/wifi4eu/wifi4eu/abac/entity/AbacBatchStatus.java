package wifi4eu.wifi4eu.abac.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "WIF_ABAC_BATCH_STATUS")
public class AbacBatchStatus {

    @Id
    @Column(name = "ID", unique = true, nullable = false, precision = 18, scale = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "abacBatchIDGenerator")
    @SequenceGenerator(name = "abacBatchIDGenerator", sequenceName = "SEQ_WIF_ABAC_STATUS", allocationSize = 1)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LE_ID")
    private LegalEntity legalEntity;

    @Column(name = "L_RUN_ID", nullable = false, precision = 18, scale = 0)
    private Long lRunID;

    @Column(name = "L_LOC_SYS_CD")
    private String lLocSysCd;

    @Column(name = "L_LOC_OBJ_FK")
    private String lLocObjFk;

    @Column(name = "L_QUE_ID", nullable = false, precision = 18, scale = 0)
    private Long lQueID;

    @Column(name = "LEF_ABAC_STATUS")
    private String lefAbacStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LegalEntity getLegalEntity() {
        return legalEntity;
    }

    public void setLegalEntity(LegalEntity legalEntity) {
        this.legalEntity = legalEntity;
    }

    public Long getlRunID() {
        return lRunID;
    }

    public void setlRunID(Long lRunID) {
        this.lRunID = lRunID;
    }

    public String getlLocSysCd() {
        return lLocSysCd;
    }

    public void setlLocSysCd(String lLocSysCd) {
        this.lLocSysCd = lLocSysCd;
    }

    public String getlLocObjFk() {
        return lLocObjFk;
    }

    public void setlLocObjFk(String lLocObjFk) {
        this.lLocObjFk = lLocObjFk;
    }

    public Long getlQueID() {
        return lQueID;
    }

    public void setlQueID(Long lQueID) {
        this.lQueID = lQueID;
    }

    public String getLefAbacStatus() {
        return lefAbacStatus;
    }

    public void setLefAbacStatus(String lefAbacStatus) {
        this.lefAbacStatus = lefAbacStatus;
    }

    @Override
    public String toString() {
        return "AbacBatchStatus{" +
                "id=" + id +
                ", legalEntity=" + legalEntity +
                ", lRunID=" + lRunID +
                ", lLocSysCd='" + lLocSysCd + '\'' +
                ", lLocObjFk='" + lLocObjFk + '\'' +
                ", lQueID=" + lQueID +
                ", lefAbacStatus='" + lefAbacStatus + '\'' +
                '}';
    }
}
