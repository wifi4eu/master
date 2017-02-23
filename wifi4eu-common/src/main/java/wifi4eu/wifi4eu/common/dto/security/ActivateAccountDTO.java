package wifi4eu.wifi4eu.common.dto.security;

/**
 * Created by rgarcita on 21/02/2017.
 */
public class ActivateAccountDTO {

    private String token;

    private String email;

    private String password;

    public ActivateAccountDTO(){}

    public ActivateAccountDTO(String token, String email, String password) {
        this.token = token;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
