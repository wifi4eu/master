package wifi4eu.wifi4eu.common.dto.model;

public class UserDTO {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private long createDate;
    private long accessDate;
    private int type;
    private boolean verified;

    public UserDTO() {
    }

    public UserDTO(int id, String name, String surname, String email, String password, long createDate, long accessDate, boolean verified, int type) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.createDate = createDate;
        this.accessDate = accessDate;
        this.verified = verified;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}