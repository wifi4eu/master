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
import wifi4eu.wifi4eu.common.dto.model.GroupedRegistrationDTO;
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
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'createRegistration' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
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
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'deleteRegistration' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "Get registrations by specific user id")
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<RegistrationDTO> getRegistrationsByUserId(@PathVariable("userId") final Integer userId) {
        _log.info("getRegistrationsByUserId: " + userId);
        return registrationService.getRegistrationsByUserId(userId);
    }

    @ApiOperation(value = "Get registrations by specific municipality id")
    @RequestMapping(value = "/municipality/{municipalityId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<RegistrationDTO> getRegistrationsByMunicipalityId(@PathVariable("municipalityId") final Integer municipalityId) {
        _log.info("getRegistrationsByMunicipalityId: " + municipalityId);
        return registrationService.getRegistrationsByMunicipalityId(municipalityId);
    }

    @ApiOperation(value = "Check if a certain user id registration is KO (deleted or suspended).")
    @RequestMapping(value = "/registrationKO/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseDTO checkIfRegistrationIsKO(@PathVariable("userId") final Integer userId) {
        try {
            _log.info("checkIfRegistrationIsKO: " + userId);
            return new ResponseDTO(true, registrationService.checkIfRegistrationIsKO(userId), null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'checkIfRegistrationIsKO' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "Get registration by specific user and municipality id's")
    @RequestMapping(value = "/user/{userId}/municipality/{municipalityId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public RegistrationDTO getRegistrationByUserAndMunicipality(@PathVariable("userId") final Integer userId, @PathVariable("municipalityId") final Integer municipalityId) {
        _log.info("getRegistrationByUser: " + userId + " | AndMunicipality: " + municipalityId);
        return registrationService.getRegistrationByUserAndMunicipality(userId, municipalityId);
    }

    @ApiOperation(value = "Get registrations grouped by municipality")
    @RequestMapping(value = "/grouped", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<GroupedRegistrationDTO> getAllGroupedRegistrations() {
        _log.info("getAllGroupedRegistrations");
        return registrationService.getAllGroupedRegistrations();
    }

    @ApiOperation(value = "Get registrations grouped by municipality")
    @RequestMapping(value = "/grouped", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public GroupedRegistrationDTO test() {
        return new GroupedRegistrationDTO();
    }
}