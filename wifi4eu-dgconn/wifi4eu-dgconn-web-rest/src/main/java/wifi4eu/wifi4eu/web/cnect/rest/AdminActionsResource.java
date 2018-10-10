package wifi4eu.wifi4eu.web.cnect.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import wifi4eu.wifi4eu.common.dto.model.AdminActionsDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.service.admin.AdminActionsService;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.web.authorisation.DashboardUsersOnly;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/admin-actions", description = "Admin actions")
@RequestMapping("admin-actions")
public class AdminActionsResource {

    @Autowired
    private AdminActionsService adminActionsService;

    @Autowired
    private UserService userService;

    private static final Logger _log = LoggerFactory.getLogger(AdminActionsResource.class);

    @ApiOperation(value = "Get admin actions by action name")
    @RequestMapping(value = "/by-name/{name}", method = RequestMethod.GET)
    @ResponseBody
    @DashboardUsersOnly
    public ResponseDTO getByActionName(@PathVariable("name") String name, HttpServletResponse response) throws IOException {
        try {
            return new ResponseDTO(true, adminActionsService.getByActionName(name), new ErrorDTO());
        } catch (Exception e) {
            UserContext userContext = UserHolder.getUser();
            UserDTO userConnected = userService.getUserByUserContext(userContext);

            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Admin action with name " + name + " cannot been retrieved", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, null);
        }
    }

    // TODO: not used. Remove.
    @ApiOperation(value = "Disabled")
    @RequestMapping(value = "/disabled", method = RequestMethod.GET)
    @ResponseBody
    public AdminActionsDTO disabledMethod() {
        return new AdminActionsDTO();
    }

}
