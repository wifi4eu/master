package wifi4eu.wifi4eu.web.cnect.rest;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import wifi4eu.wifi4eu.common.dto.model.ApplicationAuthorizedPersonDTO;
import wifi4eu.wifi4eu.common.dto.model.UserAuthorizedPersonDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.service.application.ApplicationAuthorizedPersonService;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.web.authorisation.DashboardUsersOnly;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@CrossOrigin(origins = "*")
@Controller
@Api(value = "/application_authorizedPerson", description = "Application Authorized Person object REST API services")
@RequestMapping("application_authorizedPerson")
public class ApplicationAuthorizedPersonResource {

    @Autowired
    private ApplicationAuthorizedPersonService applicationAuthorizedPersonService;

    @Autowired
    private UserService userService;

    private static final Logger _log = LoggerFactory.getLogger(ApplicationAuthorizedPersonResource.class);

    @ApiOperation(value = "Authorized")
    @RequestMapping(value = "/Authorized", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public ResponseDTO editUser(@RequestBody ApplicationAuthorizedPersonDTO request) {
        ResponseDTO response = new ResponseDTO();
        response.setSuccess(false);
        response.setData("Not implemented");
        return response;
    }

    @ApiOperation(value = "Authorized")
    @RequestMapping(value = "/Authorized", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ApplicationAuthorizedPersonDTO findByApplicationAndUserId(@RequestParam("applicationId") final Integer applicationId, @RequestParam("userId") final Integer userId) {
        return applicationAuthorizedPersonService.findByApplicationAndAuthorisedPerson(applicationId, userId);
    }

    @ApiOperation(value = "Update Authorization")
    @RequestMapping(value = "/updateAuthorization", method = RequestMethod.POST)
    @ResponseBody
    @DashboardUsersOnly
    public ResponseDTO updateAuthorization(@RequestBody final UserAuthorizedPersonDTO userAuthorizedPersonDTO, HttpServletResponse response) throws IOException {
        try {
            applicationAuthorizedPersonService.updateAuthorization(userAuthorizedPersonDTO);
            return new ResponseDTO(true, userAuthorizedPersonDTO, null);
        } catch (Exception e) {
            UserContext userContext = UserHolder.getUser();
            UserDTO userConnected = userService.getUserByUserContext(userContext);

            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- the user can not be authorized/desauthorized", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, null);
        }
    }

    //ONY FOR SWAGGER
    @ApiOperation(value = "Return Authorization")
    @RequestMapping(value = "/returnAuthorization", method = RequestMethod.GET)
    @ResponseBody
    public UserAuthorizedPersonDTO updateAuthorization(@RequestBody final UserAuthorizedPersonDTO userAuthorizedPersonDTO){
        return userAuthorizedPersonDTO;
    }

    @ApiOperation(value = "Get Authorization")
    @RequestMapping(value = "/getAuthorization", method = RequestMethod.GET)
    @ResponseBody
    @DashboardUsersOnly
    public ResponseDTO getAuthorization(@RequestParam("applicationId") final Integer applicationId, HttpServletResponse response) throws IOException {
        try {
            List<ApplicationAuthorizedPersonDTO> applicationAuthorizedPersonDTOList = applicationAuthorizedPersonService.findByApplication(applicationId);
            return new ResponseDTO(true, applicationAuthorizedPersonDTOList, null);
        } catch (Exception e) {
            UserContext userContext = UserHolder.getUser();
            UserDTO userConnected = userService.getUserByUserContext(userContext);

            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- can not get authorization of the user", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, null);
        }
    }

}
