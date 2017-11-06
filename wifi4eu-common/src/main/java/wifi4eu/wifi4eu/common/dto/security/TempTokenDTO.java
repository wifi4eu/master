package wifi4eu.wifi4eu.common.dto.security;

public class TempTokenDTO {
    private long id;
    private String token;
    private String email;
    private long createDate;
    private long expiryDate;
    private int userId;

    public TempTokenDTO() {
    }

    public TempTokenDTO(long id, String token, String email, long createDate, long expiryDate, int userId) {
        this.id = id;
        this.token = token;
        this.email = email;
        this.createDate = createDate;
        this.expiryDate = expiryDate;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public long getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(long expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}