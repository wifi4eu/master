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

    @Column(name = "STATUS")
    private String status;

    public ValidatedLEF() {}

    public ValidatedLEF(Integer idLef, String status) {
        this.idLef = idLef;
        this.status = status;
    }

    public Integer getIdLef() {
        return idLef;
    }

    public void setIdLef(Integer idLef) {
        this.idLef = idLef;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
