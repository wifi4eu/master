package wifi4eu.wifi4eu.web.filter;

import eu.cec.digit.ecas.client.jaas.DetailedUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.filter.OncePerRequestFilter;
import wifi4eu.wifi4eu.common.Constant;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.exception.AppException;
import wifi4eu.wifi4eu.common.security.UserContext;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserFilter extends OncePerRequestFilter {

    Logger _log = LogManager.getLogger(UserFilter.class);

    @Override
    protected String getAlreadyFilteredAttributeName() {
        return "UserFilter";
    }

    @Override
    protected void initFilterBean() throws ServletException {
        super.initFilterBean();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String requestUri = "Unknown resource";
        try {
            requestUri = request.getRequestURI();
            HttpSession session = request.getSession();

            UserContext user = null;
            DetailedUser ecasPrincipal = (DetailedUser) request.getUserPrincipal();
            if (ecasPrincipal != null) {
                user = new UserContext(ecasPrincipal.getDomainUsername());
                user.setEmail(ecasPrincipal.getEmail());
                user.setDomain(ecasPrincipal.getDomain());
                if (ecasPrincipal.getEmployeeNumber() != null) {
                    user.setPerId(new Long(ecasPrincipal.getEmployeeNumber()));
                }
                user.setDetailedUser(ecasPrincipal);
                user.setFirstName(ecasPrincipal.getFirstName());
                user.setLastName(ecasPrincipal.getLastName());

                session.setAttribute(Constant.USER, user);
            } else if (_log.isDebugEnabled()) {
                _log.info("Unauthenticated request: " + requestUri);
            }

            user = (UserContext) session.getAttribute(Constant.USER);
            UserHolder.setUser(user);

            if (user == null && requestUri.equalsIgnoreCase("/wifi4eu/")) {
                response.sendRedirect(request.getContextPath() + "/index.jsp");
                return;
            } else {
                try {
                    filterChain.doFilter(request, response);
                } catch (Exception ex) {
                    _log.error("Error processing request: " + requestUri, ex);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new AppException(ex);
        } finally {
            UserHolder.clearUser();
        }
    }
}