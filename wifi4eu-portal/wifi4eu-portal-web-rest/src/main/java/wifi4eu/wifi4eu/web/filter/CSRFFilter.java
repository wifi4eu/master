package wifi4eu.wifi4eu.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.DigestUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CSRFFilter extends OncePerRequestFilter {

    Logger _log = LoggerFactory.getLogger(CSRFFilter.class);

    @Autowired
    private UserService userService;

    @Override
    protected String getAlreadyFilteredAttributeName() {
        return "CSRFFilter";
    }

    @Override
    protected void initFilterBean() throws ServletException {
        super.initFilterBean();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        _log.error("[i] doFilterInternal");
        _log.error("Servlet path: " + request.getServletPath());
        _log.error("doFilterInternal : XSRF : getRequestURL: " + request.getRequestURL().toString());
        _log.error("METHOD: " + request.getMethod());

        if(!request.getMethod().equalsIgnoreCase("GET")
                && !request.getRequestURL().toString().contains("/api/user/ecaslogin")){

            String XSRFTOKEN = request.getHeader("X-XSRF-TOKEN");
            _log.error("[i] X-XSRF-TOKEN: " + XSRFTOKEN);

            if(XSRFTOKEN != null && XSRFTOKEN.length() > 0) {
                UserContext userContext = UserHolder.getUser();

                if (userContext != null) {
                    UserDTO user = userService.getUserByUserContext(userContext);

                    if (user != null) {
                        _log.error("User stored Token: " + user.getCsrfToken());
                        _log.error("Comparision: " + XSRFTOKEN.equalsIgnoreCase(user.getCsrfToken()));

                        if (!XSRFTOKEN.equalsIgnoreCase(user.getCsrfToken())) {
                            response.sendError(HttpStatus.UNAUTHORIZED.value());
                            return;
                        }
                    } else {
                        _log.error("user is NULL");
                        response.sendError(HttpStatus.UNAUTHORIZED.value());
                        return;
                    }
                } else {
                    _log.error("userContext is NULL");
                    response.sendError(HttpStatus.UNAUTHORIZED.value());
                    return;
                }
            } else {
                response.sendError(HttpStatus.UNAUTHORIZED.value());
                return;
            }
        }

        _log.error("[f] doFilterInternal");
        filterChain.doFilter(request, response);
    }
}
