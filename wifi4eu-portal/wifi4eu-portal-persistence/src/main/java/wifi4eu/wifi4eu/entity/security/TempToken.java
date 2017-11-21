package wifi4eu.wifi4eu.entity.security;

import wifi4eu.wifi4eu.entity.user.User;

import javax.persistence.*;

@Entity
@Table(name = "temp_tokens")
public class TempToken {
    @Id
    @SequenceGenerator(name = "temptoken_seq", allocationSize = 1, initialValue = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "temptoken_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "token")
    private String token;

    @Column(name = "email")
    private String email;

    @Column(name = "create_date")
    private Long createDate;

    @Column(name = "expiry_date")
    private Long expiryDate;

    @ManyToOne
    @JoinColumn(name = "_user")
    private User user;

    public TempToken() {
    }

    public TempToken(Long id, String token, String email, Long createDate, Long expiryDate, User user) {
        this.id = id;
        this.token = token;
        this.email = email;
        this.createDate = createDate;
        this.expiryDate = expiryDate;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
