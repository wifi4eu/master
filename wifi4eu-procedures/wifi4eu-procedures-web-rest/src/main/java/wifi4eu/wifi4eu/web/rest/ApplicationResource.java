package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.user.UserService;

import java.io.IOException;

@CrossOrigin(origins = "http://localhost:8080")
@Controller
@Api(value = "/application", description = "Application object REST API services")
@RequestMapping("application")
public class ApplicationResource {

    @Autowired
    ApplicationService applicationService;

    @Autowired
    UserService userService;

    Logger _log = LogManager.getLogger(ApplicationResource.class);

    @ApiOperation(value = "Send email to notify the applicandts for a given call id")
    @RequestMapping(value = "/sendApplicationEmails/{callId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO sendApplicationEmails (@PathVariable("callId") final Integer callId) throws IOException {
        //what happens if callId is null
        //security?
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        try {
            if (userConnected.getType() != 5)
                throw new AccessDeniedException("This user is not authorized to use this functionality.");
            Integer sentEmails = applicationService.sendEmailApplications(callId);
            if (sentEmails != null)
                return new ResponseDTO(true, "SUCCESS - Create Application Emails", sentEmails.longValue(), null);
            else
                throw new Exception("ERROR - Could not create application emails");
        } catch (AccessDeniedException ade) {
            return new ResponseDTO(false, null, new ErrorDTO(403, ade.getMessage()));
        } catch (Exception e) {
            return new ResponseDTO(false, null, new ErrorDTO(500, e.getMessage()));
        }
    }


}