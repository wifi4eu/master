package wifi4eu.wifi4eu.common.security;

import java.io.Serializable;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import eu.cec.digit.ecas.client.jaas.DetailedUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;


public class UserContext implements Serializable, UserDetails, Principal {


    private static final long serialVersionUID = 1L;
    private final String username;
    private String firstName;
    private String lastName;
    private String login;

    private Long perId;
    private String domain;
    private String email;
    private String mainLanguage;
    private String administrativePosition;
    private String institution;

    private DetailedUser detailedUser;

    public UserContext(String username) {
        this.username = username;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> grantedAuthorities = null;

        grantedAuthorities = new ArrayList<GrantedAuthority>();

        if (grantedAuthorities.isEmpty()) {
            grantedAuthorities.add(new GrantedAuthorityImpl("anonymousUser"));
        }
        return grantedAuthorities;
    }

    public String getFullName() {
        return (getFirstName() + " " + getLastName());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }


    public Long getPerId() {
        return perId;
    }

    public void setPerId(Long perId) {
        this.perId = perId;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMainLanguage() {
        return mainLanguage;
    }

    public void setMainLanguage(String mainLanguage) {
        this.mainLanguage = mainLanguage;
    }

    public String getAdministrativePosition() {
        return administrativePosition;
    }

    public void setAdministrativePosition(String administrativePosition) {
        this.administrativePosition = administrativePosition;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public DetailedUser getDetailedUser() {
        return detailedUser;
    }

    public void setDetailedUser(DetailedUser detailedUser) {
        this.detailedUser = detailedUser;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }
}
