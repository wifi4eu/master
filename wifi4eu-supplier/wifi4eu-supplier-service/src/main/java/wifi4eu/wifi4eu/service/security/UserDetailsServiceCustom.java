package wifi4eu.wifi4eu.service.security;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.service.beneficiary.BeneficiaryDisplayedListService;
import wifi4eu.wifi4eu.service.user.UserService;

@Service
public class UserDetailsServiceCustom implements UserDetailsService {

    @Autowired
    UserService userService;

    private final Logger _log = LogManager.getLogger(UserDetailsServiceCustom.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {

        try{

            return UserHolder.getUser();

        } catch (Exception ex) {
            UserContext userContext = UserHolder.getUser();
            UserDTO userConnected = userService.getUserByUserContext(userContext);
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Loading user by username: "+ username+ " ERROR: "+ ex.getMessage());
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
            UserContext userContext = UserHolder.getUser();
            UserDTO userConnected = userService.getUserByUserContext(userContext);
            _log.warn("ECAS Username: " + userConnected.getEcasUsername() + " - class "+ claszzName +" doesn't exist. ERROR: "+ e.getMessage());

        }
        return exists;
    }


    public UserDetails getUserContext() {
        return UserHolder.getUser();
    }


}
