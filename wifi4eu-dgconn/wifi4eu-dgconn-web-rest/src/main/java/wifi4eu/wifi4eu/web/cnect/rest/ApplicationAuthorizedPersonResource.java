package wifi4eu.wifi4eu.web.cnect.rest;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.ApplicationAuthorizedPersonDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.application.ApplicationAuthorizedPersonService;


@CrossOrigin(origins = "*")
@Controller
@Api(value = "/application_authorizedPerson", description = "Application Authorized Person object REST API services")
@RequestMapping("application_authorizedPerson")
public class ApplicationAuthorizedPersonResource {
    @Autowired
    ApplicationAuthorizedPersonService applicationAuthorizedPersonService;

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

}
