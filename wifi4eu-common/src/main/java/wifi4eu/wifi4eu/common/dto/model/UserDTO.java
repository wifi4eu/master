package wifi4eu.wifi4eu.common.dto.model;

public class UserDTO {
    private int id;

    private String ecasUsername;
    private String ecasEmail;
    private String treatment;
    private String name;
    private String surname;
    private String address;
    private String addressNum;
    private String postalCode;
    private String email;
    private String password;
    private String lang;
    private long createDate;
    private long accessDate;
    private int type;
    private boolean verified;
    private String csrfToken;
    private String phonePrefix;
    private String phoneNumber;
    private boolean isUserInvited = false;
    private int userInvitedFor = 0;
    private String country;
    private String city;

    public UserDTO() {
    }

    public UserDTO(int id, String ecasUsername, String ecasEmail, String treatment, String name, String surname, String address, String addressNum, String postalCode, String email, String password, String lang, long createDate, long accessDate, int type, boolean verified, String csrfToken, String phonePrefix, String phoneNumber, String country, String city) {
        this.id = id;
        this.ecasUsername = ecasUsername;
        this.ecasEmail = ecasEmail;
        this.treatment = treatment;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.addressNum = addressNum;
        this.postalCode = postalCode;
        this.email = email;
        this.password = password;
        this.lang = lang;
        this.createDate = createDate;
        this.accessDate = accessDate;
        this.type = type;
        this.verified = verified;
        this.csrfToken = csrfToken;
        this.phonePrefix = phonePrefix;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEcasUsername() {
        return ecasUsername;
    }

    public void setEcasUsername(String ecasUsername) {
        this.ecasUsername = ecasUsername;
    }

    public String getEcasEmail() {
        return ecasEmail;
    }

    public void setEcasEmail(String ecasEmail) {
        this.ecasEmail = ecasEmail;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public long getAccessDate() {
        return accessDate;
    }

    public void setAccessDate(long accessDate) {
        this.accessDate = accessDate;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getCsrfToken() {
        return csrfToken;
    }

    public void setCsrfToken(String csrfToken) {
        this.csrfToken = csrfToken;
    }

    public String getPhonePrefix() {
        return phonePrefix;
    }

    public void setPhonePrefix(String phonePrefix) {
        this.phonePrefix = phonePrefix;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isUserInvited() {
        return isUserInvited;
    }

    public void setUserInvited(boolean isUserInvited) {
        this.isUserInvited = isUserInvited;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getUserInvitedFor() {
        return userInvitedFor;
    }

    public void setUserInvitedFor(int userInvitedFor) {
        this.userInvitedFor = userInvitedFor;
    }
}