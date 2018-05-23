package wifi4eu.supplier.web.rest.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.dto.security.ActivateAccountDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.entity.installation.InstallationSite;
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

    Logger _log = LoggerFactory.getLogger(UserResource.class);

    @ApiOperation(value = "Service to do Login with a ECAS User")
    @RequestMapping(value = "/ecaslogin", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO ecasLogin() {
        try {
            _log.info("[i] ecasLogin");
            UserContext userContext = UserHolder.getUser();
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


    @ApiOperation(value = "Logout session")
    @RequestMapping(value = "/logout", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String doCompleteSignOut() {
        _log.debug("Logging out");

        final HttpSession session = RecoverHttpSession.session();
        String outMessage = "page.logout";

        if (session == null) {
            _log.info("Session is expired.");
            outMessage = "page.not.session";
        } else {
            _log.info("Expiring session.");
            session.invalidate();
        }

        return outMessage;
    }

    @ApiOperation(value = "Edit user")
    @RequestMapping(value = "/edit", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public ResponseDTO editUser(@RequestBody UserDTO userDTO) {
        ResponseDTO response = new ResponseDTO();
        response.setSuccess(false);
        response.setData("Not Implemented");
        return response;
    }

}