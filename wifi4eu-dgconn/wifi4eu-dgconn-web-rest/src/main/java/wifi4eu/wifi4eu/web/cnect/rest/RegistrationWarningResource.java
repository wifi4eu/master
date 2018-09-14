package wifi4eu.wifi4eu.web.cnect.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.service.warning.RegistrationWarningService;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/registrationWarning", description = "RegistrationWarning object REST API services")
@RequestMapping("registrationWarning")
public class RegistrationWarningResource {
    Logger _log = LoggerFactory.getLogger(CallResource.class);

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private RegistrationWarningService warningService;

    @Autowired
    RegistrationWarningService registrationWarningService;

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Upload warnings in old registrations")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO uploadOldRegistrations() {
        UserContext userContext = UserHolder.getUser();
        if (userService.getUserByUserContext(userContext).getType() == 5) {
            return registrationWarningService.uploadRegistrationWarnings();
        }
        throw new AccessDeniedException("");
    }
}
