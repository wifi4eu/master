package wifi4eu.wifi4eu.web.filter;


import org.springframework.web.filter.OncePerRequestFilter;
import wifi4eu.wifi4eu.common.dto.security.RoleDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.exception.AppException;
import wifi4eu.wifi4eu.common.security.UserContext;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;
import java.util.Random;
import java.util.UUID;

public class UserFilterMocked extends OncePerRequestFilter {

    public static String randomUser = null;

    @Override
    protected String getAlreadyFilteredAttributeName() {
        return "UserFilter";
    }

    @Override
    protected void initFilterBean() throws ServletException {
        super.initFilterBean();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {

        try {
            if (randomUser == null) {
                randomUser = randomString();
            }
            final UserContext user = initUserContext();

            UserHolder.setUser(user);
            filterChain.doFilter(request, response);

        } catch (Exception e) {
            throw new AppException(e);
        } finally {
            UserHolder.clearUser();
        }
    }

    private UserContext initUserContext() {
        final UserContext user = new UserContext(randomUser);

        user.setEmail( randomUser +
                UserFilterConstants.AT +
                UserFilterConstants.DOMAIN +
                UserFilterConstants.EXTENSION);
        user.setDomain( UserFilterConstants.DOMAIN );
        user.setPerId( randomInt() );
        user.setDetailedUser( null );
        user.setFirstName(UserFilterConstants.NAME);
        user.setLastName(UserFilterConstants.LAST_NAME);
        user.setRoleList(new LinkedList<RoleDTO>());

        return user;
    }

    private String randomString(){
        final UUID idOne = UUID.randomUUID();
        final String uuid = idOne.toString();
        final String[] uuidArray = uuid.split("-");

        return uuidArray[uuidArray.length-1]+uuidArray[0];
    }

    private Long randomInt(){
        final Random randomGenerator = new Random();
        Long randomInt = 0L;
        
        for (int idx = 1; idx <= 10; ++idx){
            randomInt += randomGenerator.nextInt(UserFilterConstants.RANDOM_VALUE);
        }
        
        return randomInt;
    }
}