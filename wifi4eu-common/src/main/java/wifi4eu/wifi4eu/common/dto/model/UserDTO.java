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
    private int idRole;

    public UserDTO() {
    }

    public UserDTO(int id, String ecasUsername, String ecasEmail, String treatment, String name, String surname, String address, String addressNum, String postalCode, String email, String password, String lang, long createDate, long accessDate, int type, boolean verified, int idRole) {
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
        this.idRole = idRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getEcasUsername() {
        return ecasUsername;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
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

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }
}