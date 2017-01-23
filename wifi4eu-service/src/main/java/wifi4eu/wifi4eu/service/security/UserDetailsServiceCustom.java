package wifi4eu.wifi4eu.service.security;

import java.security.Principal;
import java.util.LinkedList;
import java.util.Set;

import javax.security.auth.Subject;

import eu.cec.digit.ecas.client.jaas.DetailedUser;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.common.dto.security.RoleDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceCustom implements UserDetailsService {

    private final static Logger logger = LoggerFactory.getLogger(UserDetailsServiceCustom.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {

        try {

            DetailedUser detailedUser = UserHolder.getDetailedUser();
            Long perId = UserHolder.extractEcasEmployeeNumber(detailedUser);

            UserContext userContext = new UserContext(username);
            userContext.setEmail(detailedUser.getEmail());
            userContext.setDomain(detailedUser.getDomain());
            userContext.setPerId(perId);
            userContext.setDetailedUser(detailedUser);
            userContext.setFirstName(detailedUser.getFirstName());
            userContext.setLastName(detailedUser.getLastName());

            userContext.setRoleList(new LinkedList<RoleDTO>());

            if (existsClass("weblogic.security.Security")) {
                Subject subject = (Subject) Class.forName("weblogic.security.Security").getMethod("getCurrentSubject", null).invoke(null, null);
                Set<Principal> principals = subject.getPrincipals();
                for (Principal principal : principals) {
                    if (Class.forName("weblogic.security.spi.WLSGroup").isInstance(principal)) {
                        RoleDTO role = new RoleDTO();
                        role.setName(principal.getName());
                        userContext.getRoleList().add(role);
                        logger.info("---------------------------------------REGISTERED ROLE : " + principal.getName());
                    }
                }
            }

            UserHolder.setUser(userContext);

            return userContext;

        } catch (Exception ex) {
            if (ex instanceof UsernameNotFoundException) {
                throw (UsernameNotFoundException) ex;
            } else
                throw new UsernameNotFoundException("Cannot retrieve the userDetails", ex);
        }
    }

    public boolean existsClass(String claszzName) {
        boolean exists = true;
        try {
            Class.forName(claszzName, false, getClass().getClassLoader());
        } catch (ClassNotFoundException e) {
            exists = false;
        }
        return exists;
    }


    public UserDetails getUserContext() {
        return UserHolder.getUser();
    }


}
