package wifi4eu.wifi4eu.service.security;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.Assert;
import wifi4eu.wifi4eu.service.beneficiary.BeneficiaryDisplayedListService;
import wifi4eu.wifi4eu.service.user.UserService;

public class UsersDetailsByTokenCustom <T extends Authentication> implements AuthenticationUserDetailsService<T>, InitializingBean {

    private CacheUserDetailsServiceCustom userDetailsServiceCustom = null;

    public UsersDetailsByTokenCustom(CacheUserDetailsServiceCustom userDetailsServiceCustom) {
        Assert.notNull(userDetailsServiceCustom, "userDetailsServiceCustom cannot be null.");
        this.userDetailsServiceCustom = userDetailsServiceCustom;
    }

    public void afterPropertiesSet() throws Exception {
        Assert.notNull(this.userDetailsServiceCustom, "UserDetailsService must be set");
    }

    public UserDetails loadUserDetails(T authentication) throws UsernameNotFoundException {
        return userDetailsServiceCustom.loadUserByHash((String) authentication.getPrincipal());
    }

    public void setUserDetailsService(CacheUserDetailsServiceCustom aUserDetailsService) {
        this.userDetailsServiceCustom = aUserDetailsService;
    }
}
