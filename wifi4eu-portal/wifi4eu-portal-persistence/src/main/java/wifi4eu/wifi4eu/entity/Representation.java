package wifi4eu.wifi4eu.entity;

import javax.persistence.*;

@Entity
@Table(name = "representations")
public class Representation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;

    @ManyToOne
    @JoinColumn(name = "municipality", table = "municipalities")
    Municipality municipality;

    @ManyToOne
    @JoinColumn(name = "mayor", table = "mayors")
    Mayor mayor;

    public Representation() {
    }

    public Representation(int id, Municipality municipality, Mayor mayor) {
        this.id = id;
        this.municipality = municipality;
        this.mayor = mayor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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