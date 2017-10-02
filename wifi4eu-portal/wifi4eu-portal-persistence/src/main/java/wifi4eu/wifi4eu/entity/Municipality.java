package wifi4eu.wifi4eu.entity;

import javax.persistence.*;

@Entity
@Table(name = "municipalities")
public class Municipality {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id;

    @Column(name = "name")
    String name;

    @Column(name = "address")
    String address;

    @OneToOne
    @JoinColumn(name = "lau")
    Lau lau;

    public Municipality() {
    }

    public Municipality(Integer id, String name, String address, Lau lau) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.lau = lau;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Lau getLau() {
        return lau;
    }

    public void setLau(Lau lau) {
        this.lau = lau;
    }
}
