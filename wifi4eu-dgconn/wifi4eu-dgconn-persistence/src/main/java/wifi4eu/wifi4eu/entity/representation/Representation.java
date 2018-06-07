package wifi4eu.wifi4eu.entity.representation;

import wifi4eu.wifi4eu.entity.municipality.Municipality;
import wifi4eu.wifi4eu.entity.mayor.Mayor;

import javax.persistence.*;

@Entity
@Table(name = "representations")
public class Representation {


    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "municipality")
    private Municipality municipality;

    @ManyToOne
    @JoinColumn(name = "mayor")
    private Mayor mayor;

    public Representation() {
    }

    public Representation(Integer id, Municipality municipality, Mayor mayor) {
        this.id = id;
        this.municipality = municipality;
        this.mayor = mayor;
    }

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

    public Mayor getMayor() {
        return mayor;
    }

    public void setMayor(Mayor mayor) {
        this.mayor = mayor;
    }
}