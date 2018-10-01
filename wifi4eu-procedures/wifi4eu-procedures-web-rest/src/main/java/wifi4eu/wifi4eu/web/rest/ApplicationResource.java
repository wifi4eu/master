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

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "127.0.0.1")
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
    public ResponseDTO sendApplicationEmails(HttpServletRequest http, @PathVariable("callId") final Integer callId) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.info("IP ADDRESS => "+http.getRemoteAddr());
        try {
                if (userConnected.getType() != 5) {
                    throw new AccessDeniedException("This user is not authorized to use this functionality.");
                }
                Integer[] sentEmails = applicationService.sendEmailApplications(callId);
                if (sentEmails != null) {
                    Map<String, Long> response = new HashMap<>();
                    response.put("sentEmailsUsers", sentEmails[0].longValue());
                    response.put("sentEmailsMunicipalities", sentEmails[1].longValue());
                    return new ResponseDTO(true, response, null);
                } else {
                    throw new Exception("ERROR - Could not create application emails");
                }
        } catch (AccessDeniedException ade) {
            return new ResponseDTO(false, null, new ErrorDTO(403, ade.getMessage()));
        } catch (Exception e) {
            return new ResponseDTO(false, null, new ErrorDTO(500, e.getMessage()));
        }
    }

}