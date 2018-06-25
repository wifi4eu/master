package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.entity.security.RightConstants;
import wifi4eu.wifi4eu.service.location.LauService;
import wifi4eu.wifi4eu.service.location.NutsService;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.thread.ThreadService;
import wifi4eu.wifi4eu.service.thread.UserThreadsService;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/municipality", description = "Municipality object REST API services")
@RequestMapping("municipality")
public class MunicipalityResource {
    @Autowired
    private MunicipalityService municipalityService;

    @Autowired
    private PermissionChecker permissionChecker;

    @Autowired
    private UserService userService;

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private LauService lauService;

    @Autowired
    private NutsService nutsService;

    @Autowired
    private ThreadService threadService;

    @Autowired
    private UserThreadsService userThreadsService;

    Logger _log = LogManager.getLogger(MunicipalityResource.class);

    @ApiOperation(value = "Get municipality by specific id")
    @RequestMapping(value = "/{municipalityId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public MunicipalityDTO getMunicipalityById(@PathVariable("municipalityId") final Integer municipalityId, HttpServletResponse response, HttpServletRequest request) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting municipality by id " + municipalityId);
        try {
            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            RegistrationDTO registrationDTO = registrationService.getRegistrationByMunicipalityId(municipalityId);
            if (userDTO.getType() != 5 && (registrationDTO.getUserId() != userDTO.getId())) {
                permissionChecker.check(userDTO, RightConstants.MUNICIPALITIES_TABLE + municipalityId);
            }
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- The municipality cannot been retrieved", e);
            response.sendError(HttpStatus.NOT_FOUND.value());
        }
        return municipalityService.getMunicipalityById(municipalityId);
    }

    /*
    @ApiOperation(value = "Create municipality")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO createMunicipality(@RequestBody final MunicipalityDTO municipalityDTO,
                                          HttpServletResponse response) throws IOException {
        try {
            _log.info("createMunicipality");

            //check permission
            int municipalityId = municipalityDTO.getId();
            permissionChecker.check(RightConstants.MUNICIPALITIES_TABLE + municipalityId);

            MunicipalityValidator.validateMunicipality(municipalityDTO, lauService.getLauById(municipalityDTO.getLauId()),
                    nutsService.getNutsByLevel(0));

            MunicipalityDTO resMunicipality = municipalityService.createMunicipality(municipalityDTO);
            return new ResponseDTO(true, resMunicipality, null);
        } catch (AccessDeniedException ade) {
            if (_log.isErrorEnabled()) {
                _log.error("Error with permission on 'createMunicipality' operation.", ade);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'createMunicipality' operation.", e);
            }
            response.sendError(HttpStatus.BAD_REQUEST.value());
        }
        return new ResponseDTO(true, null, null);
    }
    */

    @ApiOperation(value = "Get municipality by specific id for thread")
    @RequestMapping(value = "/thread/{municipalityId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public MunicipalityDTO getMunicipalityThreadById(@PathVariable("municipalityId") final Integer municipalityId, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        UserDTO userDTO = userConnected;
        MunicipalityDTO municipality = municipalityService.getMunicipalityById(municipalityId);
        List<UserThreadsDTO> userThreadsDTOList = userThreadsService.getUserThreadsByUserId(userDTO.getId());
        if (userDTO.getType() == 5) {
            municipality.setRegistrations(null);
            return municipality;
        } else {
            for (UserThreadsDTO userThread : userThreadsDTOList) {
                ThreadDTO threadDTO = threadService.getThreadById(userThread.getThreadId());
                if (threadDTO.getTitle().equals(municipality.getName())) {
                    if (userThread.getUserId() == userDTO.getId()) {
                        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting municipality by id " + municipalityId + " for thread");
                        municipality.setRegistrations(null);
                        return municipality;
                    } else {
                        permissionChecker.check(userDTO, RightConstants.MUNICIPALITIES_TABLE + municipalityId);
                    }
                }
            }
            permissionChecker.check(userDTO, RightConstants.MUNICIPALITIES_TABLE + municipalityId);
            return null;
        }
    }

    @ApiOperation(value = "Update municipality details")
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public ResponseDTO updateMunicipalityDetails(@RequestBody final MunicipalityDTO municipalityDTO,
                                                 HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Updating municipality details");
        try {
            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            RegistrationDTO registrationDTO = registrationService.getRegistrationByMunicipalityId(municipalityDTO.getId());
            if (registrationDTO.getUserId() != userDTO.getId()) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            permissionChecker.check(userDTO, RightConstants.MUNICIPALITIES_TABLE + municipalityDTO.getId());
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + "- Municipality details updated successfully");
            return new ResponseDTO(true, municipalityService.updateMunicipalityDetails(municipalityDTO), null);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to update the details of this municipality", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- The details of this municipality cannot been updated", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
    }

    /* @ApiOperation(value = "Delete municipality by specific id")
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseDTO deleteMunicipality(@RequestBody final Integer municipalityId, HttpServletResponse response) throws IOException {
        try {
            _log.info("deleteMunicipality: " + municipalityId);

            //check permisssion
            permissionChecker.check(RightConstants.MUNICIPALITIES_TABLE + municipalityId);
            MunicipalityDTO resMunicipality = municipalityService.deleteMunicipality(municipalityId);
            return new ResponseDTO(true, resMunicipality, null);
        } catch (AccessDeniedException ade) {
            response.sendError(HttpStatus.NOT_FOUND.value());
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'deleteMunicipality' operation.", e);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
        }
        return new ResponseDTO(true, null, null);
    } */

    @ApiOperation(value = "Get municipalities by specific lau id")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-API", value = "public", required = false, allowMultiple = false, dataType = "string", paramType = "header")
    })
    @RequestMapping(value = "/lauId/{lauId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<MunicipalityDTO> getMunicipalitiesByLauId(@PathVariable("lauId") final Integer lauId, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting municipalities by lau id " + lauId);
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
        } catch (AccessDeniedException ade) {
            _log.error("User ECAS name: " + userConnected.getEcasUsername() + "- You have no permissions to retrieve these municipalities", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
        }
        return municipalityService.getMunicipalitiesByLauId(lauId);
    }

    /*
    @ApiOperation(value = "Get municipalities by specific user id")
    @RequestMapping(value = "/userId/{userId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<MunicipalityDTO> getMunicipalitiesByUserId(@PathVariable("userId") final Integer userId,
                                                           HttpServletResponse response) throws IOException {
        try {
            permissionChecker.check(RightConstants.USER_TABLE + userId);
        } catch (AccessDeniedException ade) {
            if (_log.isErrorEnabled()) {
                _log.error("Error with permission on 'getMunicipalitiesByUserId' operation.", ade);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
            throw new AccessDeniedException("");
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'getMunicipalitiesByUserId' operation.", e);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
            throw new AccessDeniedException("");
        }

        return municipalityService.getMunicipalitiesByUserId(userId);
    }
    */
}