package wifi4eu.wifi4eu.abac.security;

import eu.cec.digit.ecas.client.jaas.DetailedUser;
import eu.cec.digit.ecas.client.jaas.SubjectNotFoundException;
import eu.cec.digit.ecas.client.jaas.SubjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final Logger log = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(getCurrentUser().getUid());


        return new UsernamePasswordAuthenticationToken(
                userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals( UsernamePasswordAuthenticationToken.class);
    }

    private DetailedUser getCurrentUser() {
        DetailedUser currentEcasUser = null;
        try {
            currentEcasUser = SubjectUtil.getCurrentEcasUser();
        } catch (SubjectNotFoundException e) {
            log.error("ERROR while trying to retrieve the current user", e);
        }
        return currentEcasUser;
    }
}
