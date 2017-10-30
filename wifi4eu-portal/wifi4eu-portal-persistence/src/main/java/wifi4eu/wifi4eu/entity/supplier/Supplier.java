package wifi4eu.wifi4eu.entity.supplier;

import wifi4eu.wifi4eu.entity.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @SequenceGenerator(name = "supplier_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_seq")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "vat")
    private String vat;

    @Column(name = "bic")
    private String bic;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "website")
    private String website;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "contact_surname")
    private String contactSurname;

    @Column(name = "contact_phone_prefix")
    private String contactPhonePrefix;

    @Column(name = "contact_phone_number")
    private String contactPhoneNumber;

    @Column(name = "contact_email")
    private String contactEmail;

    @Column(name = "logo")
    private String logo;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @OneToMany(mappedBy = "supplier")
    private List<SuppliedRegion> suppliedRegions;

    public Supplier() {
    }

    public Supplier(Integer id, String name, String address, String vat, String bic, String accountNumber, String website, String contactName, String contactSurname, String contactPhonePrefix, String contactPhoneNumber, String contactEmail, String logo, User user, List<SuppliedRegion> suppliedRegions) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.vat = vat;
        this.bic = bic;
        this.accountNumber = accountNumber;
        this.website = website;
        this.contactName = contactName;
        this.contactSurname = contactSurname;
        this.contactPhonePrefix = contactPhonePrefix;
        this.contactPhoneNumber = contactPhoneNumber;
        this.contactEmail = contactEmail;
        this.logo = logo;
        this.user = user;
        this.suppliedRegions = suppliedRegions;
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

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactSurname() {
        return contactSurname;
    }

    public void setContactSurname(String contactSurname) {
        this.contactSurname = contactSurname;
    }

    public String getContactPhonePrefix() {
        return contactPhonePrefix;
    }

    public void setContactPhonePrefix(String contactPhonePrefix) {
        this.contactPhonePrefix = contactPhonePrefix;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<SuppliedRegion> getSuppliedRegions() {
        return suppliedRegions;
    }

    public void setSuppliedRegions(List<SuppliedRegion> suppliedRegions) {
        this.suppliedRegions = suppliedRegions;
    }
}