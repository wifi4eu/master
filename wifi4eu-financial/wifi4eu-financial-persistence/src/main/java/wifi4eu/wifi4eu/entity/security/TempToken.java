package wifi4eu.wifi4eu.entity.security;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by rgarcita on 21/02/2017.
 */

@Entity
@Table(name="SEC_TEMPTOKEN_T")
public class TempToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @Column(name="TOKEN")
    private String token;

    @Column(name="EMAIL")
    private String email;

    @Column(name="USER_ID")
    private Long userId;

    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name="CREATE_DATE")
    private Long createDate;

    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name="EXPIRY_DATE")
    private Long expiryDate;

    public TempToken(){}

    public TempToken(Long id, String token, String email, Long createDate, Long expiryDate) {
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public Long getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Long expiryDate) {
        this.expiryDate = expiryDate;
    }
}
