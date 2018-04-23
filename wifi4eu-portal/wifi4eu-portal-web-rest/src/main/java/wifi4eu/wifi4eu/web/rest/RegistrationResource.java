package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.RegistrationDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.entity.security.RightConstants;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/registration", description = "Registration object REST API services")
@RequestMapping("registration")
public class RegistrationResource {
    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private PermissionChecker permissionChecker;

    @Autowired
    private UserService userService;

    Logger _log = LoggerFactory.getLogger(RegistrationResource.class);

    @ApiOperation(value = "Get all the registrations")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<RegistrationDTO> allRegistrations(HttpServletResponse response) throws IOException {
        _log.info("allRegistrations");
        try {
            if (userService.getUserByUserContext(UserHolder.getUser()).getType() != 5) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
        } catch (AccessDeniedException ade) {
            response.sendError(HttpStatus.NOT_FOUND.value());
        } catch (Exception e) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return registrationService.getAllRegistrations();
    }

    @ApiOperation(value = "Get registration by specific id")
    @RequestMapping(value = "/{registrationId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public RegistrationDTO getRegistrationById(@PathVariable("registrationId") final Integer registrationId, HttpServletResponse response) throws IOException {
        _log.info("getRegistrationById: " + registrationId);

        try {
            permissionChecker.check(RightConstants.REGISTRATIONS_TABLE + registrationId);
        } catch (AccessDeniedException ade) {
            if (_log.isErrorEnabled()) {
                _log.error("Error with permission on 'getRegistrationById' operation.", ade);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'getRegistrationById' operation.", e);
            }
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }

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
    public ResponseDTO deleteRegistration(@RequestBody final Integer registrationId, HttpServletResponse response) throws IOException {
        try {
            RegistrationDTO registrationDTO = registrationService.getRegistrationById(registrationId);
            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if (userDTO.getId() != registrationDTO.getUserId()) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            _log.info("deleteRegistration: " + registrationId);
            RegistrationDTO resRegistration = registrationService.deleteRegistration(registrationId);
            return new ResponseDTO(true, resRegistration, null);
        } catch (AccessDeniedException ade) {
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), ade.getMessage()));
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
        permissionChecker.check(RightConstants.USER_TABLE + userId);
        return registrationService.getRegistrationsByUserId(userId);
    }

    @ApiOperation(value = "Get registrations by specific municipality id")
    @RequestMapping(value = "/municipality/{municipalityId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public RegistrationDTO getRegistrationByMunicipalityId(@PathVariable("municipalityId") final Integer municipalityId, HttpServletResponse httpServletResponse) {
        _log.info("getRegistrationsByMunicipalityId: " + municipalityId);
        httpServletResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        httpServletResponse.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        httpServletResponse.setDateHeader("Expires", 0); // Proxies.
        return registrationService.getRegistrationByMunicipalityId(municipalityId);
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
    public RegistrationDTO getRegistrationByUserAndMunicipality(@PathVariable("userId") final Integer userId, @PathVariable("municipalityId") final Integer municipalityId, HttpServletResponse response) throws IOException {
        _log.info("getRegistrationByUser: " + userId + " | AndMunicipality: " + municipalityId);

        try {
            permissionChecker.check(RightConstants.USER_TABLE + userId);
            permissionChecker.check(RightConstants.MUNICIPALITIES_TABLE + municipalityId);
        } catch (AccessDeniedException ade) {
            response.sendError(HttpStatus.NOT_FOUND.value());
        } catch (Exception e) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }

        return registrationService.getRegistrationByUserAndMunicipality(userId, municipalityId);
    }

    @ApiOperation(value = "Request legal documents")
    @RequestMapping(value = "/requestLegalDocuments/{registrationId}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO requestLegalDocuments(@PathVariable("registrationId") final Integer registrationId) {
        try {
            if (_log.isInfoEnabled()) {
                _log.info("requestLegalDocuments for registration: " + registrationId);
            }
            return new ResponseDTO(registrationService.requestLegalDocuments(registrationId), null, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'requestLegalDocuments' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "Assign legal entity")
    @RequestMapping(value = "/assignLegalEntity/{registrationId}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO assignLegalEntity(@PathVariable("registrationId") final Integer registrationId) {
        try {
            if (_log.isInfoEnabled()) {
                _log.info("assignLegalEntity for registration: " + registrationId);
            }
            return new ResponseDTO(registrationService.assignLegalEntity(registrationId), null, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'assignLegalEntity' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "Get registration by specific userThread id")
    @RequestMapping(value = "/userThread/{userThreadId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public RegistrationDTO getRegistrationByUserThreadId(@PathVariable("userThreadId") final Integer userThreadId) {
        _log.info("getRegistrationByUserThreadId: " + userThreadId);
        return registrationService.getRegistrationByUserThreadId(userThreadId);
    }
}