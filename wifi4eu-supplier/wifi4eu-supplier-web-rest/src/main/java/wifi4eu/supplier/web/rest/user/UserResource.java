package wifi4eu.supplier.web.rest.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpSession;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/user", description = "User object REST API services")
@RequestMapping("user")
public class UserResource {
    @Autowired
    private UserService userService;

    Logger _log = LogManager.getLogger(UserResource.class);

    @ApiOperation(value = "Service to do Login with a ECAS User")
    @RequestMapping(value = "/ecaslogin", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO ecasLogin() {
        try {
            UserContext userContext = UserHolder.getUser();
            UserDTO userDTO = userService.getUserByUserContext(userContext);
            return new ResponseDTO(true, userDTO, null);
        } catch (Exception e) {
            _log.error(" - Cannot login with ECAS User", e);
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "Logout session")
    @RequestMapping(value = "/logout", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String doCompleteSignOut() {
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