package wifi4eu.wifi4eu.service.security;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.security.UserDTO;
import wifi4eu.wifi4eu.common.security.UserSessionCache;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.user.UserService;

import java.util.Collections;

@Service
public class CacheUserDetailsServiceCustom {

    @Autowired
    UserService userService;

    private final Logger _log = LogManager.getLogger(CacheUserDetailsServiceCustom.class);

    @Autowired
    private UserSessionCache sessionCache;

    protected UserDetails loadUserByHash(String hash) {

        String hashEmail = "";
        try {
            if (hash.contains("Bearer")) {
                String cleanToken = hash.substring(7);

                try{

                    hashEmail = (String) AuthJWTokenizer.decode(cleanToken).get("email");

                } catch (ExpiredJwtException ex) {

                    _log.info("JWT expired: " + ex.getMessage());
                    hashEmail = (String) ex.getClaims().get("email");
                    return new User(hashEmail, "", true, true, false, true, Collections.EMPTY_SET);

                } catch (SignatureException ex) {
                    _log.info(ex.getMessage(), ex);
                    throw ex;
                }

                UserDTO userCache = sessionCache.userSessionCache.get(cleanToken);

                if (userCache != null) { //If token exists -> user has been logged and we update the value to prevent expiration
                    sessionCache.userSessionCache.put(cleanToken, userCache);
                    return  new User(userCache.getEmail(), userCache.getPassword(),
                            true, true, true, true, Collections.EMPTY_SET);
                } else {
                    return new User(hashEmail, "", true, true, false, true, Collections.EMPTY_SET);
                }

            } else {
                throw new BadCredentialsException("Incorrect format header");
            }
        } catch (Exception ex) {
            _log.info(ex.getMessage(), ex);
            return new User(hashEmail, "", true, true, false, true, Collections.EMPTY_SET);
        }

    }

}