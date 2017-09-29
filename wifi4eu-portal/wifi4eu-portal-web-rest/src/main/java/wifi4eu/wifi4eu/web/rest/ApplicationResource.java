package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import wifi4eu.wifi4eu.common.dto.model.ApplicationDTO;
import wifi4eu.wifi4eu.service.ApplicationService;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/application", description = "Application object REST API services")
@RequestMapping("application")
public class ApplicationResource {
    @Autowired
    ApplicationService applicationService;

    @ApiOperation(value = "Test API operation.")
    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ApplicationDTO test() {
        return new ApplicationDTO();
    }
}