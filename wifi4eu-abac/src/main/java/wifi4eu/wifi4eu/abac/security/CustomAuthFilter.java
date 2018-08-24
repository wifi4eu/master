package wifi4eu.wifi4eu.abac.security;

import eu.cec.digit.ecas.client.jaas.DetailedUser;
import eu.cec.digit.ecas.client.jaas.SubjectNotFoundException;
import eu.cec.digit.ecas.client.jaas.SubjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class CustomAuthFilter extends GenericFilterBean {

    private final Logger log = LoggerFactory.getLogger(CustomAuthFilter.class);

    AuthenticationManager authenticationManager;

    public CustomAuthFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        if(getCurrentUser() != null) {

            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(getCurrentUser().getUid(), "none");
            Authentication authResult = this.authenticationManager.authenticate(authRequest);
            SecurityContextHolder.getContext().setAuthentication(authResult);

            log.info("Authentication success: " + authResult);
        }

        chain.doFilter(request, response);
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
