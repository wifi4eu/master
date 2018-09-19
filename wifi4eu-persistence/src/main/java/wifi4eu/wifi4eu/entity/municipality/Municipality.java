package wifi4eu.wifi4eu.entity.municipality;

import wifi4eu.wifi4eu.entity.exportImport.BudgetaryCommitment;
import wifi4eu.wifi4eu.entity.location.Lau;
import wifi4eu.wifi4eu.entity.registration.Registration;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "municipalities")
public class Municipality {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "address_num")
    private String addressNum;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "country", updatable = false)
    private String country;

    @ManyToOne
    @JoinColumn(name = "lau", updatable = false)
    private Lau lau;

    @OneToMany(mappedBy = "municipality")
    private List<Registration> registrations;

    @OneToMany(mappedBy = "municipality")
    private List<BudgetaryCommitment> budgetaryCommitments;

    public Municipality() {
    }

    public Municipality(Integer id, String name, String address, String addressNum, String postalCode, String country, Lau lau, List<Registration> registrations) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.addressNum = addressNum;
        this.postalCode = postalCode;
        this.country = country;
        this.lau = lau;
        this.registrations = registrations;
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

    public String getAddressNum() {
        return addressNum;
    }

    public void setAddressNum(String addressNum) {
        this.addressNum = addressNum;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }

    public List<BudgetaryCommitment> getBudgetaryCommitments() {
        if (budgetaryCommitments == null) {
            budgetaryCommitments = new ArrayList<>(0);
        }
        return budgetaryCommitments;
    }

    public void setBudgetaryCommitments(List<BudgetaryCommitment> budgetaryCommitments) {
        this.budgetaryCommitments = budgetaryCommitments;
    }
}
