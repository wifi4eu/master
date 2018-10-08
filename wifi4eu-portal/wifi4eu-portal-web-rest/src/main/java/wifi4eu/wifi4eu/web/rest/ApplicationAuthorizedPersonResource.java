package wifi4eu.wifi4eu.web.rest;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.ApplicationAuthorizedPersonDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.service.application.ApplicationAuthorizedPersonService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.user.UserService;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/application_authorizedPerson", description = "Application Authorized Person object REST API services")
@RequestMapping("application_authorizedPerson")
public class ApplicationAuthorizedPersonResource {
    @Autowired
    ApplicationAuthorizedPersonService applicationAuthorizedPersonService;

    @Autowired
    UserService userService;

    @Autowired
    PermissionChecker permissionChecker;

    @ApiOperation(value = "Authorized")
    @RequestMapping(value = "/Authorized", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public ResponseDTO editUser(@RequestBody ApplicationAuthorizedPersonDTO request) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        if (userConnected == null || userConnected.getType() == 1) {
            throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
        }
        ResponseDTO response = new ResponseDTO();
        response.setSuccess(false);
        response.setData("Not implemented");
        return response;

    }

    @ApiOperation(value = "Authorized")
    @RequestMapping(value = "/Authorized", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO findByApplication(@RequestParam("applicationId") final Integer applicationId) {
        return new ResponseDTO(true, permissionChecker.checkIfAuthorizedGrantAgreement(applicationId), null);
    }

}
