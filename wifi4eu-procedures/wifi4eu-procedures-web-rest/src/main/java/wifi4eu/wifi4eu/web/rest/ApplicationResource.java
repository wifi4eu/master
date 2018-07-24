package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import wifi4eu.wifi4eu.service.application.ApplicationService;

import java.io.IOException;

@CrossOrigin(origins = "http://localhost:8080")
@Controller
@Api(value = "/application", description = "Application object REST API services")
@RequestMapping("application")
public class ApplicationResource {

    @Autowired
    ApplicationService applicationService;

    Logger _log = LogManager.getLogger(ApplicationResource.class);

    @ApiOperation(value = "Get application by call and registration id")
    @RequestMapping(value = "/sendApplicationEmails", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public void sendApplicationEmails () throws IOException {
        applicationService.sendEmailApplications();
    }


}