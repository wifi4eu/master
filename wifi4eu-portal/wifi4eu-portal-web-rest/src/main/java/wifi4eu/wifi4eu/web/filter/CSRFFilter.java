package wifi4eu.wifi4eu.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CSRFFilter extends OncePerRequestFilter {

    Logger _log = LoggerFactory.getLogger(CSRFFilter.class);

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
        _log.error("Servlet path: " + request.getRequestURL().toString());
        _log.error("METHOD: " + request.getMethod());

        if(!request.getMethod().equalsIgnoreCase("GET") || !request.getRequestURL().toString().contains("ecaslogin")){

            String XSRFTOKEN = request.getHeader("X-XSRF-TOKEN");
            _log.error("[i] X-XSRF-TOKEN: " + XSRFTOKEN);

            if(XSRFTOKEN != null && XSRFTOKEN.length() > 0) {
                UserContext userContext = UserHolder.getUser();

                if (userContext != null) {
                    String value = userContext.getUsername() + userContext.getDomain();
                    String hash = DigestUtils.md5DigestAsHex(value.getBytes());
                    _log.error("HASH: " + hash);
                    _log.error("Comparision: " + XSRFTOKEN.equalsIgnoreCase(hash));

                    if (!XSRFTOKEN.equalsIgnoreCase(hash)) {
                        response.sendRedirect(request.getContextPath() + "/index.jsp");
                        return;
                    }
                } else {
                    _log.error("userContext is NULL");
                    response.sendRedirect(request.getContextPath() + "/index.jsp");
                    return;
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/index.jsp");
                return;
            }
        }

        _log.debug("[f] doFilterInternal");
        filterChain.doFilter(request, response);
    }
}
