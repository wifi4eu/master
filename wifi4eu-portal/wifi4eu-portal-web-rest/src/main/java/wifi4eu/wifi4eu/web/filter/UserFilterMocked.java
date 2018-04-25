package wifi4eu.wifi4eu.web.filter;


import org.springframework.web.filter.OncePerRequestFilter;
import wifi4eu.wifi4eu.common.dto.security.RoleDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.exception.AppException;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.service.user.UserConstants;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

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
            HttpSession session = request.getSession();
            long activeSession = session.getLastAccessedTime() - session.getCreationTime();
            long timestampSeconds = TimeUnit.MILLISECONDS.toSeconds(activeSession);

            if (timestampSeconds < session.getMaxInactiveInterval()) {
                UserContext user = new UserContext(UserConstants.MOCKED_USER_NAME);
                user.setEmail(UserConstants.MOCKED_MAIL);
                user.setDomain(UserConstants.MOCKED_DOMAIN);
                user.setPerId(UserConstants.MOCKED_PER_ID);
                user.setDetailedUser(UserConstants.MOCKED_DETAILED_USER);
                user.setFirstName(UserConstants.MOCKED_FIRST_NAME);
                user.setLastName(UserConstants.MOCKED_LAST_NAME);

                user.setRoleList(new LinkedList<RoleDTO>());

                UserHolder.setUser(user);

                filterChain.doFilter(request, response);
            } else  {
                String requestUri = request.getRequestURI();
                logger.info("Unauthenticated request: " + requestUri);
            }
        } catch (Exception e) {
            throw new AppException(e);
        } finally {
        UserHolder.clearUser();
    }
    }
}