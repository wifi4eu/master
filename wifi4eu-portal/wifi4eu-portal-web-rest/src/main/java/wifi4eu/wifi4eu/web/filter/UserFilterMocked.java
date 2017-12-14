package wifi4eu.wifi4eu.web.filter;


import org.springframework.web.filter.OncePerRequestFilter;
import wifi4eu.wifi4eu.common.Constant;
import wifi4eu.wifi4eu.common.dto.security.RoleDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.exception.AppException;
import wifi4eu.wifi4eu.common.security.UserContext;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

public class UserFilterMocked extends OncePerRequestFilter {

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
            UserContext user = new UserContext("Mr. Tester");
            user.setEmail("tester@test.com");
            user.setDomain("TemporalDom");
            user.setPerId(1L);
            user.setDetailedUser( UserHolder.getDetailedUser() );
            user.setFirstName("Tester Name");
            user.setLastName("Test LastName");

            user.setRoleList(new LinkedList<RoleDTO>());

            /*
            String userId = (String) request.getSession(true).getAttribute(Constant.USER);;
            UserContext user = new UserContext(userId);
            */

            if (user == null) {
                user = UserHolder.getUser();
                request.getSession().setAttribute(Constant.USER, user);
            }

            UserHolder.setUser(user);
            filterChain.doFilter(request, response);

        } catch (Exception e) {
            throw new AppException(e);
        } finally {
            UserHolder.clearUser();
        }
    }
}