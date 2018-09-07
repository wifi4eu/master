package wifi4eu.wifi4eu.entity.supplier;

import wifi4eu.wifi4eu.entity.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "suppliers")
public class Supplier {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "street")
    private String street;

    @Column(name = "street_number")
    private String streetNumber;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "vat")
    private String vat;

    @Column(name = "bic")
    private String bic;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "website")
    private String website;

    @Column(name = "contact_email")
    private String contactEmail;

    @Column(name = "logo")
    private String logo;

    @OneToMany
    @JoinTable(name = "supplier_users",
            joinColumns = @JoinColumn(name = "supplier_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private List<User> users;

    @OneToMany(mappedBy = "supplier")
    private List<SuppliedRegion> suppliedRegions;

    @Column(name = "legal_file1")
    private String legalFile1;

    @Column(name = "legal_file2")
    private String legalFile2;

    @Column(name = "_status")
    private int status;

    public Supplier() {
    }

    public Supplier(Integer id, String name, String address, String vat, String bic, String accountNumber, String website, String contactEmail, String logo, List<User> users, List<SuppliedRegion> suppliedRegions, String legalFile1, String legalFile2, int status) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.vat = vat;
        this.bic = bic;
        this.accountNumber = accountNumber;
        this.website = website;
        this.contactEmail = contactEmail;
        this.logo = logo;
        this.users = users;
        this.suppliedRegions = suppliedRegions;
        this.legalFile1 = legalFile1;
        this.legalFile2 = legalFile2;
        this.status = status;
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

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<SuppliedRegion> getSuppliedRegions() {
        return suppliedRegions;
    }

    public void setSuppliedRegions(List<SuppliedRegion> suppliedRegions) {
        this.suppliedRegions = suppliedRegions;
    }

    public String getLegalFile1() {
        return legalFile1;
    }

    public void setLegalFile1(String legalFile1) {
        this.legalFile1 = legalFile1;
    }

    public String getLegalFile2() {
        return legalFile2;
    }

    public void setLegalFile2(String legalFile2) {
        this.legalFile2 = legalFile2;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}