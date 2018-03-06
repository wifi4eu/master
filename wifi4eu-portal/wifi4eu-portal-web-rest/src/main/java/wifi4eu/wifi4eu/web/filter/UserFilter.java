package wifi4eu.wifi4eu.web.filter;


import eu.cec.digit.ecas.client.jaas.DetailedUser;
import wifi4eu.wifi4eu.common.dto.security.RoleDTO;
import wifi4eu.wifi4eu.common.security.UserContext;
import org.springframework.web.filter.OncePerRequestFilter;

import wifi4eu.wifi4eu.common.Constant;
import wifi4eu.wifi4eu.common.ecas.UserHolder;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;

public class UserFilter extends OncePerRequestFilter {

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

        try {
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
                user.setRoleList(new LinkedList<RoleDTO>());

                /*
                String userId = (String) request.getSession(true).getAttribute(Constant.USER);
                UserContext user = new UserContext(userId);
                */

                /*if (user == null) {
                    user = UserHolder.getUser();
                }*/

                HttpSession session = request.getSession();
                session.invalidate();

                session = request.getSession(true);
                session.setAttribute(Constant.USER, user);
            }

            user = (UserContext) request.getSession().getAttribute(Constant.USER);
            UserHolder.setUser(user);

            if (user == null && request.getRequestURI().equalsIgnoreCase("/wifi4eu/")) {
                response.sendRedirect(request.getContextPath() + "/index.jsp");
                //response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
                //response.setHeader("Location", request.getContextPath() + "/index.jsp");
                return;
            } else {
                filterChain.doFilter(request, response);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendError(401);
        } finally {
            UserHolder.clearUser();
        }
    }
}