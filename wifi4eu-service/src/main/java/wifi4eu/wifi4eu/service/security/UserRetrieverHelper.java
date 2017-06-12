package wifi4eu.wifi4eu.service.security;


import io.jsonwebtoken.ExpiredJwtException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wifi4eu.wifi4eu.common.dto.security.UserDTO;
import wifi4eu.wifi4eu.common.security.UserSessionCache;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutionException;

@Component
public class UserRetrieverHelper {

    private static final Logger logger = Logger.getLogger(UserRetrieverHelper.class);

    @Autowired
    private UserSessionCache sessionCache;

    public Long getUserId(String token) {
        Long id = null;
        String hashEmail = "";
        try{

            hashEmail = (String) AuthJWTokenizer.decode(token).get("email");

        } catch (ExpiredJwtException ex){

            logger.info("JWT expired: " + ex.getMessage());
            hashEmail = (String) ex.getClaims().get("email");

        } catch (UnsupportedEncodingException ex){
            logger.warn(ex.getMessage(), ex);
        }

        try {

            UserDTO user = sessionCache.userSessionCache.get(token);
            id = user.getUserId();

        }catch (ExecutionException ex){
            logger.info(ex.getMessage());
        }

        return id;

    }

    public Boolean checkUserIdWithToken(String token, Long userId){
        return getUserId(token).equals(userId);
    }
}
