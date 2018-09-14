package wifi4eu.wifi4eu.web.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CSRFFilter extends OncePerRequestFilter {

    Logger _log = LogManager.getLogger(CSRFFilter.class);

    //@Autowired
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
        _log.debug("[i] doFilterInternal");
        _log.debug("Servlet path: " + request.getServletPath());
        _log.debug("doFilterInternal : XSRF : getRequestURL: " + request.getRequestURL().toString());
        _log.debug("METHOD: " + request.getMethod());

        if(userService == null){
            ServletContext servletContext = getServletContext();
            WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
            userService = webApplicationContext.getBean(UserService.class);
        }

        if(!request.getMethod().equalsIgnoreCase("GET")
                && !request.getRequestURL().toString().contains("/api/user/ecaslogin")){

            String XSRFTOKEN = request.getHeader("X-XSRF-TOKEN");
            _log.debug("[i] X-XSRF-TOKEN: " + XSRFTOKEN);

            if(XSRFTOKEN != null && XSRFTOKEN.length() > 0) {
                UserContext userContext = UserHolder.getUser();

                if (userContext != null) {
                    UserDTO user = userService.getUserByUserContext(userContext);

                    if (user != null) {
                        _log.debug("User stored Token: " + user.getCsrfToken());
                        _log.debug("Comparision: " + XSRFTOKEN.equalsIgnoreCase(user.getCsrfToken()));

                        if (!XSRFTOKEN.equalsIgnoreCase(user.getCsrfToken())) {
                            response.sendError(HttpStatus.UNAUTHORIZED.value());
                            return;
                        }
                    } else {
                        _log.debug("user is NULL");
                        response.sendError(HttpStatus.UNAUTHORIZED.value());
                        return;
                    }
                } else {
                    _log.debug("userContext is NULL");
                    response.sendError(HttpStatus.UNAUTHORIZED.value());
                    return;
                }
            } else {
                response.sendError(HttpStatus.UNAUTHORIZED.value());
                return;
            }
        }

        _log.debug("[f] doFilterInternal");
        filterChain.doFilter(request, response);
    }
}
