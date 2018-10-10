package wifi4eu.wifi4eu.web.cnect.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.warning.RegistrationWarningService;
import wifi4eu.wifi4eu.web.authorisation.DashboardUsersOnly;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/registrationWarning", description = "RegistrationWarning object REST API services")
@RequestMapping("registrationWarning")
@DashboardUsersOnly
public class RegistrationWarningResource {

    @Autowired
    private RegistrationWarningService registrationWarningService;

    @ApiOperation(value = "Upload warnings in old registrations")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO uploadOldRegistrations() {
        return registrationWarningService.uploadRegistrationWarnings();
    }
}
