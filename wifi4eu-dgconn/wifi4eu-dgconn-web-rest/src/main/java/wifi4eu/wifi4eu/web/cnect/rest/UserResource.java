package wifi4eu.wifi4eu.web.cnect.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.common.session.RecoverHttpSession;
import wifi4eu.wifi4eu.entity.security.RightConstants;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/user", description = "User object REST API services")
@RequestMapping("user")
public class UserResource {

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionChecker permissionChecker;

    private static final Logger _log = LogManager.getLogger(UserResource.class);

    @ApiOperation(value = "Get main user from registration")
    @RequestMapping(value = "/user/{registrationId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public UserDTO getUserByIdFromRegistration(@PathVariable("registrationId") final Integer registrationId) {
        UserDTO resUser = userService.getMainUserByIdFromRegistration(registrationId);
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Retrieving main user for registration id " + registrationId);
        if (userConnected.getType() != 5) {
            permissionChecker.check(RightConstants.USER_TABLE + resUser.getId());
        }

        if (resUser != null) {
            resUser.setPassword(null);
        }
        return resUser;
    }

    @ApiOperation(value = "Get users from registration")
    @RequestMapping(value = "/users/{registrationId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<UserDTO> getUsersByIdFromRegistration(@PathVariable("registrationId") final Integer registrationId) {
        List<UserDTO> resUsers = userService.getUsersByIdFromRegistration(registrationId);
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Retrieving main user for registration id " + registrationId);
        for (UserDTO userDTO : resUsers) {
            if (userConnected.getType() != 5) {
                permissionChecker.check(RightConstants.USER_TABLE + userDTO.getId());
            }
            if (userDTO != null) {
                userDTO.setPassword(null);
            }
        }
        return resUsers;
    }

    @ApiOperation(value = "Service to do Login with a ECAS User")
    @RequestMapping(value = "/ecaslogin", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO ecasLogin(HttpServletResponse response) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Logging in with ECAS User");
        try {
            Cookie cookie = userService.getCSRFCookie();
            if (cookie != null) {
                response.addCookie(cookie);
            }
            return new ResponseDTO(true, userConnected, null);
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Cannot be logged in", e);
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
    }

    @ApiOperation(value = "Logout session")
    @RequestMapping(value = "/logout", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String doCompleteSignOut() {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Logging out session");
        final HttpSession session = RecoverHttpSession.session();
        String outMessage = "page.logout";

        if (session == null) {
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - Session has expired");
            outMessage = "page.not.session";
        } else {
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - Session is expiring");
            doLogout(session);
        }
        return outMessage;
    }

    private void doLogout(HttpSession session) {
        session.invalidate();
    }
}