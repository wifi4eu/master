package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.dto.security.ActivateAccountDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.entity.security.RightConstants;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.user.UserService;

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

    Logger _log = LoggerFactory.getLogger(UserResource.class);

    @ApiOperation(value = "Get all the users")
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
    }

    @ApiOperation(value = "Get user by specific id")
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public UserDTO getUserById(@PathVariable("userId") final Integer userId, HttpServletResponse response) {
        UserDTO resUser = userService.getUserById(userId);

        _log.info("getUserById: " + userId);
        UserDTO userConnected = userService.getUserByUserContext(UserHolder.getUser());
        if(userConnected.getType() != 5){
            permissionChecker.check(RightConstants.USER_TABLE+userId);
        }
        //check permission
        if (resUser != null) {
            resUser.setPassword(null);
        }
        return resUser;
    }

    @ApiOperation(value = "Create user")
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
    }

    @ApiOperation(value = "Save user changes")
    @RequestMapping(value = "/saveChanges", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO saveUserChanges(@RequestBody final UserDTO userDTO,
                                       HttpServletResponse response) throws IOException {
        try {
            _log.info("saveUserChanges");

            //TODO: create saveMayorsChanges
            //TODO: https://webgate.ec.europa.eu/CITnet/jira/browse/WIFIFOREU-1548
            //check permission
            int userId = userDTO.getId();
            permissionChecker.check(RightConstants.USER_TABLE+userId);

            UserDTO user = userService.getUserById(userDTO.getId());

            UserDTO resUser = userService.saveUserChanges(userDTO);
            resUser.setEmail(user.getEmail());
            resUser.setPassword(null);
            return new ResponseDTO(true, resUser, null);
        } catch (AccessDeniedException ade) {
            if (_log.isErrorEnabled()) {
                _log.error("Error with permission on 'saveUserChanges' operation.", ade);
            }
            response.sendError(HttpStatus.FORBIDDEN.value());
            return new ResponseDTO(false, null, new ErrorDTO(403, ade.getMessage()));
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'saveUserChanges' operation.", e);
            }
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseDTO(false, null, new ErrorDTO(500, e.getMessage()));
        }
    }

    @ApiOperation(value = "Delete user by specific id")
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseDTO deleteUser(@RequestBody final Integer userId,
                                  HttpServletResponse response) throws IOException {
        try {
            _log.info("deleteUser: " + userId);

            //check permission
            permissionChecker.check(RightConstants.USER_TABLE+userId);
            UserDTO resUser = userService.deleteUser(userId);
            resUser.setPassword(null);
            return new ResponseDTO(true, resUser, null);
        } catch (AccessDeniedException ade) {
            if (_log.isErrorEnabled()) {
                _log.error("Error with permission on 'deleteUser' operation.", ade);
            }
            response.sendError(HttpStatus.FORBIDDEN.value());
            return new ResponseDTO(false, null, new ErrorDTO(403, ade.getMessage()));
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'deleteUser' operation.", e);
            }
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseDTO(false, null, new ErrorDTO(500, e.getMessage()));
        }
    }

    @ApiOperation(value = "Get users by specific type number")
    @RequestMapping(value = "/type/{type}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<UserDTO> getUsersByType(@PathVariable("type") final Integer type) {
        _log.info("getUsersByType: " + type);
        List<UserDTO> resUsers = userService.getUsersByType(type);
        for (UserDTO resUser : resUsers) {
            resUser.setPassword(null);
        }
        return resUsers;
    }

    @ApiOperation(value = "Service to do Login with a ECAS User")
    @RequestMapping(value = "/ecaslogin", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO ecasLogin() {
        try {
            _log.info("[i] ecasLogin");
            UserContext userContext = UserHolder.getUser();
            _log.debug("user Email: " + userContext.getEmail());
            _log.debug("user PerId: " + userContext.getPerId());
            UserDTO userDTO = userService.getUserByUserContext(userContext);
            _log.info("[f] ecasLogin");
            return new ResponseDTO(true, userDTO, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'login' with ECAS operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "Service to do Login with a ECAS User")
    @RequestMapping(value = "/ecaslogout", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO ecasLogout() {
        try {
            _log.info("[i] ecasLogout");
            return new ResponseDTO(true, userService.getLogoutEnviroment(), null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'login' with ECAS operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "Service to do Login with a ECAS User")
    @RequestMapping(value = "/ecasChangePassword", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO ecasChangePassword() {
        try {
            _log.info("[i] ecasChangePassword");
            return new ResponseDTO(true, userService.getChangePassword(), null); //permissionChecker.check(RightConstants.USER_TABLE+userId);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'login' with ECAS operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "Service to do Login with a user email and SHA512 password")
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
    }

    @ApiOperation(value = "Service to activate an account")
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
    }

    @ApiOperation(value = "Service to resend email with a link to activate account")
    @RequestMapping(value = "/resendEmail", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO resendEmail(@RequestBody final String email) {
        try {
            _log.info("Resend email to '" + email + "'...");
            if (userService.resendEmail(email)) {
                return new ResponseDTO(true, null, null);
            }
            return new ResponseDTO(false, null, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'resendEmail' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }


    @ApiOperation(value = "Send forgot password mail with a link to reset password")
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
    }

    @ApiOperation(value = "Set the user language")
    @RequestMapping(value = "/lang/{lang}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String setUserLang(@PathVariable("lang") final String userLang) {
        _log.info("setUserLang: " + userLang);
        userService.setLang(userLang);

        return userService.getLang();
    }

    @ApiOperation(value = "Logout session")
    @RequestMapping(value = "/logout", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String doCompleteSignOut()  {
        _log.debug("Logging out");

        final HttpSession session = RecoverHttpSession.session();
        String outMessage = "page.logout";

        if (session == null) {
            _log.info("Session is expired.");
            outMessage = "page.not.session";
        } else {
            _log.info("Expiring session.");
            doLogout(session);
        }

        return outMessage;
    }

    private void doLogout(HttpSession session) {
        session.invalidate();
    }
}