package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.web.filter.UserFilterMocked;

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
    private RegistrationService registrationService;

    Logger _log = LoggerFactory.getLogger(UserResource.class);

    @ApiOperation(value = "Get all the users")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<UserDTO> allUsers() {
        _log.info("allUsers");
        List<UserDTO> resUsers = userService.getAllUsers();
        for (UserDTO resUser : resUsers) {
            resUser.setPassword(null);
        }
        return resUsers;
    }

    @ApiOperation(value = "Get user by specific id")
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public UserDTO getUserById(@PathVariable("userId") final Integer userId) {
        _log.info("getUserById: " + userId);
        UserDTO resUser = userService.getUserById(userId);
        resUser.setPassword(null);
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
    public ResponseDTO saveUserChanges(@RequestBody final UserDTO userDTO) {
        try {
            _log.info("saveUserChanges");
            UserDTO resUser = userService.saveUserChanges(userDTO);
            resUser.setPassword(null);
            return new ResponseDTO(true, resUser, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'saveUserChanges' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "Delete user by specific id")
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseDTO deleteUser(@RequestBody final Integer userId) {
        try {
            _log.info("deleteUser: " + userId);
            UserDTO resUser = userService.deleteUser(userId);
            resUser.setPassword(null);
            return new ResponseDTO(true, resUser, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'deleteUser' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
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
            _log.info("[f] ecasLogout");
            return new ResponseDTO(true, null, null);
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
            _log.info("login: " + userDTO.getEmail());
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

    @ApiOperation(value = "Is mocked user")
    @RequestMapping(value = "/isMockedUser", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public boolean isMockedUser()  {
        _log.debug("Getting if it is mocked user: " + UserFilterMocked.randomUser);

        return UserFilterMocked.randomUser != null;
    }

    private void doLogout(HttpSession session) {
        session.invalidate();
        UserFilterMocked.randomUser = null;
    }
}