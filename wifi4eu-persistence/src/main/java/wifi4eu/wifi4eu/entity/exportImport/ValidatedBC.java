package wifi4eu.wifi4eu.entity.exportImport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VALIDATED_BC")
public class ValidatedBC {
    @Column(name = "idBc")
    @Id
    private Integer idBc;

    public ValidatedBC() {
    }

    public ValidatedBC(Integer idBc) {
        this.idBc = idBc;
    }

    public Integer getIdBc() {
        return idBc;
    }

    public void setId(Integer idBc) {
        this.idBc = idBc;
    }

}
