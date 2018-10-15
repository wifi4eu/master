package wifi4eu.wifi4eu.web.cnect.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import wifi4eu.wifi4eu.common.dto.model.LogEmailDTO;
import wifi4eu.wifi4eu.common.dto.model.MunicipalityDTO;
import wifi4eu.wifi4eu.common.dto.model.RegistrationDTO;
import wifi4eu.wifi4eu.common.dto.model.ThreadDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.model.UserThreadsDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.entity.security.RightConstants;
import wifi4eu.wifi4eu.repository.registration.RegistrationUsersRepository;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.thread.ThreadService;
import wifi4eu.wifi4eu.service.thread.UserThreadsService;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.web.util.authorisation.DashboardUsersOnly;

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
    private UserThreadsService userThreadsService;

    @Autowired
    private ThreadService threadService;

    @Autowired
    private RegistrationUsersRepository registrationUsersRepository;

    private static final Logger _log = LoggerFactory.getLogger(MunicipalityResource.class);

    @ApiOperation(value = "Get municipality by specific id")
    @RequestMapping(value = "/{municipalityId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public MunicipalityDTO getMunicipalityById(@PathVariable("municipalityId") final Integer municipalityId, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting municipality by id " + municipalityId);
        try {
            if (userConnected.getType() != 5) {
                Integer registrationId = registrationService.getRegistrationIdByMunicipalityId(municipalityId);
                if (registrationUsersRepository.findByUserIdAndRegistrationId(userConnected.getId(), registrationId) == null) {
                    permissionChecker.check(userConnected, RightConstants.MUNICIPALITIES_TABLE + municipalityId);
                }
            }
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- The municipality cannot been retrieved", e);
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        }
        return municipalityService.getMunicipalityById(municipalityId);
    }

    @ApiOperation(value = "Get municipality by specific id")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-API", value = "public", required = false, allowMultiple = false, dataType =
                    "string", paramType = "header")
    })
    @RequestMapping(value = "/usersMunicipality/{municipalityId}", method = RequestMethod.GET, produces =
            "application/json")
    @ResponseBody
    public ResponseDTO getUsersMunicipalityById(@PathVariable("municipalityId") final Integer municipalityId) {
        return municipalityService.getUsersMunicipalityById(municipalityId);
    }

    @ApiOperation(value = "Get municipality by specific id for thread")
    @RequestMapping(value = "/thread/{municipalityId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public MunicipalityDTO getMunicipalityThreadById(@PathVariable("municipalityId") final Integer municipalityId) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Retrieving municipality by id " + municipalityId + " for thread");
        MunicipalityDTO municipality = municipalityService.getMunicipalityById(municipalityId);
        if (userConnected.getType() == 5) {
            municipality.setRegistrations(null);
            return municipality;
        } else {
            List<UserThreadsDTO> userThreadsDTOList = userThreadsService.getUserThreadsByUserId(userConnected.getId());
            for (UserThreadsDTO userThread : userThreadsDTOList) {
                ThreadDTO threadDTO = threadService.getThreadById(userThread.getThreadId());
                if (threadDTO.getTitle().equals(municipality.getName())) {
                    if (userThread.getUserId() == userConnected.getId()) {
                        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Retrieving municipality by id " + municipalityId + " for thread id " + threadDTO.getId());                        municipality.setRegistrations(null);
                        return municipality;
                    } else {
                        permissionChecker.check(userConnected, RightConstants.MUNICIPALITIES_TABLE + municipalityId);
                    }
                }
            }
            permissionChecker.check(userConnected, RightConstants.MUNICIPALITIES_TABLE + municipalityId);
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
            Integer registrationId = registrationService.getRegistrationIdByMunicipalityId(municipalityDTO.getId());
            if (registrationUsersRepository.findByUserIdAndRegistrationId(userDTO.getId(), registrationId) == null) {
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

    @ApiOperation(value = "Get municipalities by specific lau id")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-API", value = "public", required = false, allowMultiple = false, dataType = "string", paramType = "header")
    })
    @RequestMapping(value = "/lauId/{lauId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    @DashboardUsersOnly
    public List<MunicipalityDTO> getMunicipalitiesByLauId(@PathVariable("lauId") final Integer lauId, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting municipalities by lau id " + lauId);

        return municipalityService.getMunicipalitiesByLauId(lauId);
    }

    @ApiOperation(value = "Get all correspondence for a municipality")
    @RequestMapping(value = "/correspondence/{municipalityId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO getCorrespondenceByMunicipality(@PathVariable("municipalityId") Integer municipalityId,
                                                                  @RequestParam("page") Integer page,
                                                                  @RequestParam("size") Integer size,
                                                                  @RequestParam("field") String field,
                                                                  @RequestParam("direction") String direction, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Retrieving Correspondance of a municipality : " + municipalityId);
        try {
            if(!permissionChecker.checkIfDashboardUser()){
                throw new java.nio.file.AccessDeniedException("Access denied: getCorrespondenceByMunicipality");
            }
            if(field.equalsIgnoreCase("username")){
                field = "user.ecasUsername";
            }
            Pageable pageable;
            if (direction.equals("ASC") || direction.equals("asc")) {
                pageable = new PageRequest(page, size, Sort.Direction.ASC, field);
            } else {
                pageable = new PageRequest(page, size, Sort.Direction.DESC, field);
            }
            ResponseDTO responseDTO = municipalityService.getCorrespondenceByMunicipalityId(municipalityId, pageable);
                    _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - Success on retrieving Correspondence for municipality" + municipalityId);
            return responseDTO;
        } catch (java.nio.file.AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - You have no permissions to retrieve correspondence municipality" , ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e){
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Municipality correspondence cannot be retrieved", e.getMessage());
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return null;
        }
    }

    @ApiOperation(value = "Create correspondence")
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public LogEmailDTO createApplicationComment() throws IOException {
        return null;
    }
}