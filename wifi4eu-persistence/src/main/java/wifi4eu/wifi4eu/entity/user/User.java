package wifi4eu.wifi4eu.entity.user;

import wifi4eu.wifi4eu.entity.registration.Registration;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "treatment")
    private String treatment;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "address")
    private String address;

    @Column(name = "address_num")
    private String addressNum;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "email", updatable = false)
    private String email;

    @Column(name = "lang")
    private String lang;

    @Column(name = "password")
    private String password;

    @Column(name = "create_date")
    private Long createDate;

    @Column(name = "access_date")
    private Long accessDate;

    @Column(name = "type")
    private Integer type;

    @Column(name = "verified")
    private boolean verified;

    @Column(name = "ecas_email")
    private String ecasEmail;

    @Column(name = "ecas_username")
    private String ecasUsername;

    @Column(name = "csrf_token")
    private String csrfToken;

    @Column(name = "contact_phone_prefix")
    private String phone_prefix;

    @Column(name = "contact_phone_number")
    private String phone_number;

    public User() {
    }

    public User(Integer id, String treatment, String name, String surname, String address, String addressNum, String postalCode, String email, String lang, String password, Long createDate, Long accessDate, Integer type, boolean verified, String ecasEmail, String ecasUsername, String csrfToken, String phone_prefix, String phone_number) {
        this.id = id;
        this.treatment = treatment;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.addressNum = addressNum;
        this.postalCode = postalCode;
        this.email = email;
        this.lang = lang;
        this.password = password;
        this.createDate = createDate;
        this.accessDate = accessDate;
        this.type = type;
        this.verified = verified;
        this.ecasEmail = ecasEmail;
        this.ecasUsername = ecasUsername;
        this.csrfToken = csrfToken;
        this.phone_prefix = phone_prefix;
        this.phone_number = phone_number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public Long getAccessDate() {
        return accessDate;
    }

    public void setAccessDate(Long accessDate) {
        this.accessDate = accessDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getEcasEmail() {
        return ecasEmail;
    }

    public void setEcasEmail(String ecasEmail) {
        this.ecasEmail = ecasEmail;
    }

    public String getEcasUsername() {
        return ecasUsername;
    }

    public void setEcasUsername(String ecasUsername) {
        this.ecasUsername = ecasUsername;
    }

    public String getCsrfToken() {
        return csrfToken;
    }

    public void setCsrfToken(String csrfToken) {
        this.csrfToken = csrfToken;
    }

    public String getPhone_prefix() {
        return phone_prefix;
    }

    public void setPhone_prefix(String phone_prefix) {
        this.phone_prefix = phone_prefix;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}