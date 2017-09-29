package wifi4eu.wifi4eu.common.dto.model;

public class UserDTO {
    int id;
    String name;
    String surname;
    String email;
    String password;
    long createDate;
    long accessDate;
    boolean verified;

    public UserDTO() {
    }

    public UserDTO(int id, String name, String surname, String email, String password, long createDate, long accessDate, boolean verified) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.createDate = createDate;
        this.accessDate = accessDate;
        this.verified = verified;
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
}