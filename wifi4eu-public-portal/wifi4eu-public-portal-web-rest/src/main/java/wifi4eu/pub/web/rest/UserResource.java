package wifi4eu.pub.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.session.RecoverHttpSession;

import javax.servlet.http.HttpSession;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/user", description = "User object REST API services")
@RequestMapping("user")
public class UserResource {

    Logger _log = LogManager.getLogger(UserResource.class);

    @ApiOperation(value = "getUser")
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    @ResponseBody
    public UserDTO getUser() {
        return new UserDTO();
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