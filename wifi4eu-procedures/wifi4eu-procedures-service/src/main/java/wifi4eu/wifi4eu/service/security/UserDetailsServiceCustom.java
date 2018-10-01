package wifi4eu.wifi4eu.service.security;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.ecas.UserHolder;

@Service
public class UserDetailsServiceCustom implements UserDetailsService {

    private final static Logger logger = LogManager.getLogger(UserDetailsServiceCustom.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {

        try {

            return UserHolder.getUser();

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
