package wifi4eu.wifi4eu.entity.municipality;

import wifi4eu.wifi4eu.entity.location.Lau;
import wifi4eu.wifi4eu.entity.registration.Registration;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "municipalities")
public class Municipality {
    @Id
    @SequenceGenerator(name = "municipality_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "municipality_seq")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "address_num")
    private Integer addressNum;

    @Column(name = "country")
    private String country;

    @OneToOne
    @JoinColumn(name = "lau")
    private Lau lau;

    @OneToMany(mappedBy = "municipality")
    private List<Registration> registrations;

    public Municipality() {
    }

    public Municipality(Integer id, String name, String address, Lau lau, String postalCode, Integer addressNum, String country, List<Registration> registrations) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.lau = lau;
        this.registrations = registrations;
        this.country = country;
        this.addressNum = addressNum;
        this.postalCode = postalCode;
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

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getAddressNum() {
        return addressNum;
    }

    public void setAddressNum(Integer addressNum) {
        this.addressNum = addressNum;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
