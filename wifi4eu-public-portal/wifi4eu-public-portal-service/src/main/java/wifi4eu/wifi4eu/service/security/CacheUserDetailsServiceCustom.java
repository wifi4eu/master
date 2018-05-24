package wifi4eu.wifi4eu.service.security;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import wifi4eu.wifi4eu.common.dto.security.UserDTO;
import wifi4eu.wifi4eu.common.security.UserSessionCache;

import java.util.*;

@Service
public class CacheUserDetailsServiceCustom {

    private final static Logger logger = Logger.getLogger(CacheUserDetailsServiceCustom.class);

    @Autowired
    private UserSessionCache sessionCache;

    protected UserDetails loadUserByHash(String hash) {

        String hashEmail = "";
        try {
            if (hash.contains("Bearer")) {
                String cleanToken = hash.substring(7);

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
            logger.info(ex.getMessage(), ex);
            return new User(hashEmail, "", true, true, false, true, Collections.EMPTY_SET);
        }

    }

}