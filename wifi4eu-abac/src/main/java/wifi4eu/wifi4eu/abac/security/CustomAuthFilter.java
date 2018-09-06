package wifi4eu.wifi4eu.abac.security;

import eu.cec.digit.ecas.client.jaas.DetailedUser;
import eu.cec.digit.ecas.client.jaas.SubjectNotFoundException;
import wifi4eu.wifi4eu.abac.service.ECASUserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class CustomAuthFilter extends GenericFilterBean {

    private final Logger log = LoggerFactory.getLogger(CustomAuthFilter.class);

    AuthenticationManager authenticationManager;
    ECASUserService ecasUserService;

    public CustomAuthFilter(AuthenticationManager authenticationManager, ECASUserService ecasUserService){
        this.authenticationManager = authenticationManager;
        this.ecasUserService = ecasUserService;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	
    	String currentUser = ecasUserService.getCurrentUsername();
    	
    	if(currentUser != null) {
    		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(currentUser, "none");
    		Authentication authResult = this.authenticationManager.authenticate(authRequest);
    		SecurityContextHolder.getContext().setAuthentication(authResult);
    	}
    	chain.doFilter(request, response);
    }
}
