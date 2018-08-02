package wifi4eu.wifi4eu.abac.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "WIF_ABAC_REQUEST_PROCESS")
public class AbacRequest {

    @Id
    @Column(name = "ID", unique = true, nullable = false, precision = 18, scale = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "abacBatchIDGenerator")
    @SequenceGenerator(name = "abacBatchIDGenerator", sequenceName = "SEQ_WIF_ABAC_STATUS", allocationSize = 1)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LE_ID")
    private LegalEntity legalEntity;

    @Column(name = "L_RUN_ID", nullable = false, precision = 18, scale = 0)
    private Long lRunID;

    @Column(name = "L_LOC_SYS_CD")
    private String lLocSysCd;

    @Column(name = "L_LOC_OBJ_FK")
    private String locObjForeignId;

    @Column(name = "L_QUE_ID", nullable = false, precision = 18, scale = 0)
    private Long lQueID;

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

    public String getLocObjForeignId() {
        return locObjForeignId;
    }

    public void setLocObjForeignId(String locObjForeignId) {
        this.locObjForeignId = locObjForeignId;
    }

    public Long getlQueID() {
        return lQueID;
    }

    public void setlQueID(Long lQueID) {
        this.lQueID = lQueID;
    }

    @Override
    public String toString() {
        return "AbacRequest{" +
                "id=" + id +
                ", legalEntity=" + legalEntity +
                ", lRunID=" + lRunID +
                ", lLocSysCd='" + lLocSysCd + '\'' +
                ", locObjForeignId='" + locObjForeignId + '\'' +
                ", lQueID=" + lQueID + '\'' +
                '}';
    }
}
