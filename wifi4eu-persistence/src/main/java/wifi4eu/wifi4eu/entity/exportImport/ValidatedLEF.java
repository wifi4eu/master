package wifi4eu.wifi4eu.entity.exportImport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VALIDATED_LEF")
public class ValidatedLEF {

    @Column(name = "idLef")
    @Id
    private Integer idLef;

    // There is not such column
//    @Column(name = "stat")
//    private String stat;

    public ValidatedLEF() {}

    public ValidatedLEF(Integer idLef) {
        this.idLef = idLef;
    }

    public ValidatedLEF(Long idLef) {
        // TODO: should be Long
        this.idLef = idLef.intValue();
    }

//    public ValidatedLEF(Integer idLef, String stat) {
//        this.idLef = idLef;
//        this.stat = stat;
//    }

//    public ValidatedLEF(Long abacReference, String abacStatus) {
//        this.idLef = abacReference.intValue();
//        this.stat = abacStatus;
//    }

    public Integer getIdLef() {
        return idLef;
    }

    public void setIdLef(Integer idLef) {
        this.idLef = idLef;
    }

//    public String getStat() {
//        return stat;
//    }
//
//    public void setStat(String stat) {
//        this.stat = stat;
//    }
}