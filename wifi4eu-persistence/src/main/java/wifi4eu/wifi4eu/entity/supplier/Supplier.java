package wifi4eu.wifi4eu.entity.supplier;

import wifi4eu.wifi4eu.entity.location.Nuts;

import javax.persistence.*;
import java.util.List;
import java.sql.Blob;

@Entity
@Table(name = "SUPP_SUPPLIER_T")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SUPPLIER_ID")
    private Long supplierId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "VAT")
    private String vat;

    @Column(name = "BIC")
    private String bic;

    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;

    @Column(name = "WEBSITE")
    private String website;

    @Column(name = "CONTACT_NAME")
    private String contactName;

    @Column(name = "CONTACT_SURNAME")
    private String contactSurname;

    @Column(name = "CONTACT_PHONE_PREFIX")
    private String contactPhonePrefix;

    @Column(name = "CONTACT_PHONE_NUMBER")
    private String contactPhoneNumber;

    @Column(name = "CONTACT_EMAIL")
    private String contactEmail;

    @Column(name = "LEGAL_CHECK1")
    private boolean legalCheck1;

    @Column(name = "LEGAL_CHECK2")
    private boolean legalCheck2;

    @Column(name = "CREATE_DATE")
    private Long createDate;

    @Column(name = "NUTS_IDS")
    private String nutsIds;

    //@Column(name = "LOGO")
    //private Blob logo;

    /*
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "SUPP_SUPP_NUTS_T", joinColumns = @JoinColumn(name = "supplier_id", referencedColumnName = "supplier_id"), inverseJoinColumns = @JoinColumn(name = "nuts_id", referencedColumnName = "nuts_id"))
    private List<Nuts> nuts;
    */

    public Supplier() {
    }

    public Supplier(Long supplierId, String name, String address, String vat, String bic, String accountNumber, String website, String contactName, String contactSurname, String contactPhonePrefix, String contactPhoneNumber, String contactEmail, boolean legalCheck1, boolean legalCheck2, Long createDate, String nutsIds) {
        this.supplierId = supplierId;
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
        this.legalCheck1 = legalCheck1;
        this.legalCheck2 = legalCheck2;
        this.createDate = createDate;
        this.nutsIds = nutsIds;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
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

    public boolean isLegalCheck1() {
        return legalCheck1;
    }

    public void setLegalCheck1(boolean legalCheck1) {
        this.legalCheck1 = legalCheck1;
    }

    public boolean isLegalCheck2() {
        return legalCheck2;
    }

    public void setLegalCheck2(boolean legalCheck2) {
        this.legalCheck2 = legalCheck2;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public String getNutsIds() {
        return nutsIds;
    }

    public void setNutsIds(String nutsIds) {
        this.nutsIds = nutsIds;
    }

    /*public Blob getLogo() {
        return logo;
    }*/

    /*public void setLogo(Blob logo) {
        this.logo = logo;
    }*/
}