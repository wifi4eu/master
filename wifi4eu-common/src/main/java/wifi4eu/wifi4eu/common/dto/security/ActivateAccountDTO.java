package wifi4eu.wifi4eu.common.dto.security;

public class ActivateAccountDTO {
    private String token;
    private String email;
    private String password;
    private String confirmPassword;

    public ActivateAccountDTO() {
    }

    public ActivateAccountDTO(String token, String email, String password, String confirmPassword) {
        this.token = token;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
