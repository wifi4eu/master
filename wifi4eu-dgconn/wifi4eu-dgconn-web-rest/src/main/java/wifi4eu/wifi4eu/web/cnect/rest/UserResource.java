package wifi4eu.wifi4eu.web.cnect.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.common.session.RecoverHttpSession;
import wifi4eu.wifi4eu.common.utils.RequestIpRetriever;
import wifi4eu.wifi4eu.entity.security.RightConstants;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/user", description = "User object REST API services")
@RequestMapping("user")
public class UserResource {
    @Autowired
    private UserService userService;

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private PermissionChecker permissionChecker;

    Logger _log = LogManager.getLogger(UserResource.class);

/*    @ApiOperation(value = "Get all the users")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<UserDTO> allUsers(HttpServletResponse response) throws IOException {
        _log.info("allUsers");
        try{
            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if(userDTO.getType() != 5){
                throw new AccessDeniedException("");
            }
        }
        catch (AccessDeniedException ade) {
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        }
        List<UserDTO> resUsers = userService.getAllUsers();
        for (UserDTO resUser : resUsers) {
            resUser.setPassword(null);
        }
        return resUsers;
    }*/

    @ApiOperation(value = "Get user by specific id")
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public UserDTO getUserById(@PathVariable("userId") final Integer userId, HttpServletResponse response) {
        UserDTO resUser = userService.getUserById(userId);
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Retrieving user by id " + userId);
        if (userConnected.getType() != 5) {
            permissionChecker.check(RightConstants.USER_TABLE + userId);
        }
        //check permission
        if (resUser != null) {
            resUser.setPassword(null);
        }
        return resUser;
    }

    @ApiOperation(value = "Get main user from registration")
    @RequestMapping(value = "/user/{registrationId}}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public UserDTO getUserByIdFromRegistration(@PathVariable("registrationId") final Integer registrationId, HttpServletResponse response) {
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
    @RequestMapping(value = "/users/{registrationId}}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<UserDTO> getUsersByIdFromRegistration(@PathVariable("registrationId") final Integer registrationId, HttpServletResponse response) {
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

/*    @ApiOperation(value = "Create user")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO createUser(@RequestBody final UserDTO userDTO) {
        try {
            _log.info("createUser");
            UserDTO resUser = userService.createUser(userDTO);
            resUser.setPassword(null);
            return new ResponseDTO(true, resUser, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'createUser' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }*/



    @ApiOperation(value = "Update user details")
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public ResponseDTO updateUserDetails(@RequestBody final UserDTO userDTO,
                                         HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Updating user details by id " + userDTO.getId());
        try {
            int userId = userDTO.getId();
            permissionChecker.check(RightConstants.USER_TABLE + userId);
            if (userDTO.getId() != userConnected.getId()) {
                throw new AccessDeniedException("");
            }
            return new ResponseDTO(true, userService.updateUserDetails(userConnected, userDTO.getName(), userDTO.getSurname()), null);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - You have no permission to update user details", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - The user details cannot been updated", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
    }

    @ApiOperation(value = "Delete user by specific id")
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseDTO deleteUser(@RequestBody final Integer userId,
                                  HttpServletResponse response, HttpServletRequest request) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Removing user by id " + userId);
        try {
            //check permission
            permissionChecker.check(RightConstants.USER_TABLE + userId);
            UserDTO resUser = userService.deleteUser(userId, request);
            resUser.setPassword(null);
            _log.log(Level.getLevel("BUSINESS"), "[ " + RequestIpRetriever.getIp(request) + " ] - ECAS Username: " + userConnected.getEcasUsername() + " - Deleted user information from the database");
            return new ResponseDTO(true, resUser, null);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - You have no permission to remove this user", ade.getMessage());
            response.sendError(HttpStatus.FORBIDDEN.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.getReasonPhrase()));
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - The user cannot been removed", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
    }

/*    @ApiOperation(value = "Get users by specific type number")
    @RequestMapping(value = "/type/{type}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<UserDTO> getUsersByType(@PathVariable("type") final Integer type) {
        _log.info("getUsersByType: " + type);
        List<UserDTO> resUsers = userService.getUsersByType(type);
        for (UserDTO resUser : resUsers) {
            resUser.setPassword(null);
        }
        return resUsers;
    }*/

    @ApiOperation(value = "Service to do Login with a ECAS User")
    @RequestMapping(value = "/ecaslogin", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO ecasLogin(HttpServletResponse response) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Logging in with ECAS User");
        try {
            UserDTO userDTO = userConnected;
            Cookie cookie = userService.getCSRFCookie();
            if (cookie != null) {
                response.addCookie(cookie);
            }
            return new ResponseDTO(true, userDTO, null);
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Cannot be logged in", e);
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
    }

    @ApiOperation(value = "Service to do Login with a ECAS User")
    @RequestMapping(value = "/ecaslogout", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO ecasLogout() {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Logging out from ECAS User");
        try {
            return new ResponseDTO(true, userService.getLogoutEnviroment(), null);
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Cannot be logged out", e);
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
    }

    @ApiOperation(value = "Service to do Login with a ECAS User")
    @RequestMapping(value = "/ecasChangePassword", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO ecasChangePassword() {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Changing ECAS password");
        try {
            return new ResponseDTO(true, userService.getChangePassword(), null); //permissionChecker.check(RightConstants.USER_TABLE+userId);
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Cannot change ECAS password", e);
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
    }

/*    @ApiOperation(value = "Service to do Login with a user email and SHA512 password")
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO login(@RequestBody final UserDTO userDTO) {
        try {
            _log.info("login: " + userDTO.getEcasEmail());
            UserDTO resUser = userService.login(userDTO);
            resUser.setPassword(null);
            if (registrationService.checkIfRegistrationIsKO(resUser.getId())) {
                return new ResponseDTO(false, resUser, null);
            }
            return new ResponseDTO(true, resUser, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'login' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }*/

    /*@ApiOperation(value = "Service to activate an account")
    @RequestMapping(value = "/activateAccount", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO activateAccount(@RequestBody final ActivateAccountDTO activateAccountDTO) {
        try {
            _log.info("activateAccount: " + activateAccountDTO.getEmail());
            userService.activateAccount(activateAccountDTO);
            return new ResponseDTO(true, null, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'activateAccount' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }*/

    @ApiOperation(value = "Service to resend email with a link to activate account")
    @RequestMapping(value = "/resendEmail", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO resendEmail(@RequestBody final String email) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Resending email to activate account to " + email);
        try {
            if (userService.resendEmail(email)) {
                return new ResponseDTO(true, null, null);
            }
            return new ResponseDTO(false, null, null);
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Cannot resend email to activate ECAS account", e);
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
    }


/*    @ApiOperation(value = "Send forgot password mail with a link to reset password")
    @RequestMapping(value = "/forgotPassword", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO forgotPassword(@RequestBody final String email) {
        _log.info("forgot Password: " + email);
        try {
            userService.forgotPassword(email);
            return new ResponseDTO(true, null, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'forgotPassword' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }*/

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