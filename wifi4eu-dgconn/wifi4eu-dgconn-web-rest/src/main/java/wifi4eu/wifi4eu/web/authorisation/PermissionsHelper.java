package wifi4eu.wifi4eu.web.authorisation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("permissionsHelper")
public class PermissionsHelper {

    private static final Logger logger = LoggerFactory.getLogger(PermissionsHelper.class);

    @Autowired
    private UserService userService;

    public boolean checkPermissions() throws IOException {
        boolean returnValue = true;
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        if (Validator.isNull(userConnected) || userConnected.getType() != 5) {
            logger.error("No permissions for " + userConnected.getEcasUsername());

            returnValue = false;

            HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
            response.sendError(HttpStatus.NOT_FOUND.value());
        } else {
            logger.debug("User {} has access level 5", userConnected.getEcasUsername());
        }

        return returnValue;
    }

}
