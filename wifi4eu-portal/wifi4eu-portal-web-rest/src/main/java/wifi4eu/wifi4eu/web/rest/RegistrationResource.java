package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.RegistrationDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.registration.RegistrationService;

import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/registration", description = "Registration object REST API services")
@RequestMapping("registration")
public class RegistrationResource {
    @Autowired
    private RegistrationService registrationService;

    Logger _log = LoggerFactory.getLogger(RegistrationResource.class);

    @ApiOperation(value = "Get all the registrations")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<RegistrationDTO> allRegistrations() {
        _log.info("allRegistrations");
        return registrationService.getAllRegistrations();
    }

    @ApiOperation(value = "Get registration by specific id")
    @RequestMapping(value = "/{registrationId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public RegistrationDTO getRegistrationById(@PathVariable("registrationId") final Integer registrationId) {
        _log.info("getRegistrationById: " + registrationId);
        return registrationService.getRegistrationById(registrationId);
    }

    @ApiOperation(value = "Create registration")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO createRegistration(@RequestBody final RegistrationDTO registrationDTO) {
        try {
            _log.info("createRegistration");
            RegistrationDTO resRegistration = registrationService.createRegistration(registrationDTO);
            return new ResponseDTO(true, resRegistration, null);
        } catch (Exception e) {
            ErrorDTO errorDTO = new ErrorDTO(0, e.getMessage());
            return new ResponseDTO(false, null, errorDTO);
        }
    }

    @ApiOperation(value = "Delete registration by specific id")
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseDTO deleteRegistration(@RequestBody final Integer registrationId) {
        try {
            _log.info("deleteRegistration: " + registrationId);
            RegistrationDTO resRegistration = registrationService.deleteRegistration(registrationId);
            return new ResponseDTO(true, resRegistration, null);
        } catch (Exception e) {
            ErrorDTO errorDTO = new ErrorDTO(0, e.getMessage());
            return new ResponseDTO(false, null, errorDTO);
        }
    }

    @ApiOperation(value = "Get registrations by specific user id")
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<RegistrationDTO> getRegistrationsByUserId(@PathVariable("userId") final Integer userId) {
        _log.info("getRegistrationsByUserId" + userId);
        return registrationService.getRegistrationsByUserId(userId);
    }
}