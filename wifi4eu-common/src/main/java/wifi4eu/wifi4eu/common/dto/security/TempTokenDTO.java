package wifi4eu.wifi4eu.common.dto.security;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by rgarcita on 21/02/2017.
 */
public class TempTokenDTO implements Serializable{

    private Long id;

    private String token;

    private String email;

    private Date createDate;

    private Date expiryDate;

    private Long userId;


    public TempTokenDTO() {}

    public TempTokenDTO(Long id, String token, String email, Date createDate, Date expiryDate) {
        this.id = id;
        this.token = token;
        this.email = email;
        this.createDate = createDate;
        this.expiryDate = expiryDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
