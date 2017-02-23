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

    @Temporal(TemporalType.DATE)
    @Column(name="CREATE_DATE")
    private Date createDate;

    @Temporal(TemporalType.DATE)
    @Column(name="EXPIRY_DATE")
    private Date expiryDate;

    public TempToken(){}

    public TempToken(Long id, String token, String email, Date createDate, Date expiryDate) {
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
}
