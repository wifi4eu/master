package wifi4eu.wifi4eu.entity.mayor;

import wifi4eu.wifi4eu.entity.municipality.Municipality;

import javax.persistence.*;

@Entity
@Table(name = "mayors")
public class Mayor {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "municipality")
    private Municipality municipality;

    public Mayor() {
    }

    public Mayor(Integer id, String name, String surname, String email, Municipality municipality) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.municipality = municipality;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }
}