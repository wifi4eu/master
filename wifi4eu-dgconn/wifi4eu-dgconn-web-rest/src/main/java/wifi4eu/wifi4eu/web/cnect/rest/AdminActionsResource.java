package wifi4eu.wifi4eu.web.cnect.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.AdminActionsDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.service.admin.AdminActionsService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.persistence.Access;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/admin-actions", description = "Admin actions")
@RequestMapping("admin-actions")
public class AdminActionsResource {

    @Autowired
    AdminActionsService adminActionsService;

    @Autowired
    PermissionChecker permissionChecker;

    @Autowired
    UserService userService;

    Logger _log = LogManager.getLogger(VoucherResource.class);

    @ApiOperation(value = "Get admin actions by action name")
    @RequestMapping(value = "/by-name/{name}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseDTO getByActionName(@PathVariable("name") String name, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        try{
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("Access denied: getByActionName");
            }
            return new ResponseDTO(true, adminActionsService.getByActionName(name), new ErrorDTO());
        }
        catch (AccessDeniedException ade){
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - You have no permissions to see admin actions", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, null);
        }
        catch (Exception e){
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Admin action with name " + name + " cannot been retrieved", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, null);
        }
    }

    @ApiOperation(value = "Get export excel action by user id")
    @RequestMapping(value = "/by-name/{name}/user/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseDTO getByActionNameAndUserId(@PathVariable("name") String name, @PathVariable("userId") Integer userId, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        try{
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("Access denied: getByActionName");
            }
            return new ResponseDTO(true, adminActionsService.getByActionNameAndUser(name, userId), new ErrorDTO());
        }
        catch (AccessDeniedException ade){
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - You have no permissions to see admin actions", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, null);
        }
        catch (Exception e){
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Admin action with name " + name + " cannot been retrieved", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, null);
        }
    }

    @ApiOperation(value = "Disabled")
    @RequestMapping(value = "/disabled", method = RequestMethod.GET)
    @ResponseBody
    public AdminActionsDTO disabledMethod(){
        return new AdminActionsDTO();
    }

}
