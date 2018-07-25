package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.ApplicationDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.entity.security.RightConstants;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/application", description = "Application object REST API services")
@RequestMapping("application")
public class ApplicationResource {

    @Autowired
    ApplicationService applicationService;

    @Autowired
    MunicipalityService municipalityService;

    @Autowired
    PermissionChecker permissionChecker;

    @Autowired
    UserService userService;

    Logger _log = LogManager.getLogger(ApplicationResource.class);

    @ApiOperation(value = "Get application by call and registration id")
    @RequestMapping(value = "/call/{callId}/registration/{registrationId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ApplicationDTO getApplicationByCallIdAndRegistrationId(@PathVariable("callId") final Integer callId, @PathVariable("registrationId") final Integer registrationId, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting applications by call id " + callId + " and registration id " + registrationId);
        try {
            permissionChecker.check(RightConstants.REGISTRATIONS_TABLE + registrationId);
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Permission not found", e.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
        }

        ApplicationDTO responseApp = applicationService.getApplicationByCallIdAndRegistrationId(callId, registrationId);
        if (responseApp == null) {
            _log.warn("ECAS Username: " + userConnected.getEcasUsername() + " - Application not found");
            responseApp = new ApplicationDTO();
        } else {
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - Application is retrieved correctly");
        }
        return responseApp;
    }

    @ApiOperation(value = "Check if municipality has edit permissions")
    @RequestMapping(value = "/municipality/{municipalityId}/editable", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO isMunicipalityEditable(@PathVariable("municipalityId") final Integer municipalityId, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Checking municipality " + municipalityId + " is editable");
        try {
            // this rightconstants was with registrations_table, check if it works with municipalities
            permissionChecker.check(RightConstants.MUNICIPALITIES_TABLE + municipalityId);
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Permission not found", e.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
        }

        ResponseDTO responseDTO = new ResponseDTO();
        try {
            boolean checkIfEditable = municipalityService.isMunicipalityEditable(municipalityId);
            responseDTO.setSuccess(true);
            responseDTO.setData(checkIfEditable);
            responseDTO.setError(new ErrorDTO());
        } catch (Exception e) {
            responseDTO.setSuccess(false);
            responseDTO.setData("Error on query");
            responseDTO.setError(new ErrorDTO());
            response.sendError(HttpStatus.NOT_FOUND.value());
        }
        return responseDTO;
    }

    @ApiOperation(value = "Check if municipality has edit permissions")
    @RequestMapping(value = "/registration/application/{callId}/{userId}/{registrationId}/{municipalityId}/{uploadDocTimestamp}/{queueTimestamp}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO registerApplication(@PathVariable("callId") final Integer callId,
                                           @PathVariable("userId") final Integer userId,
                                           @PathVariable("registrationId") final Integer registrationId,
                                           @PathVariable("municipalityId") final Integer municipalityId,
                                           @PathVariable("uploadDocTimestamp") final Long uploadDocTimestamp,
                                           @PathVariable("queueTimestamp") final Long queueTimestamp,
                                           HttpServletRequest request,
                                           HttpServletResponse response) throws IOException {

        ResponseDTO responseDTO = new ResponseDTO();
        try {
            ApplicationDTO applicationDTO = applicationService.registerApplication(callId, userId, registrationId, municipalityId, uploadDocTimestamp, queueTimestamp, request);
            responseDTO.setSuccess(true);
            responseDTO.setData(applicationDTO);
            responseDTO.setError(new ErrorDTO());
        } catch (Exception e) {
            responseDTO.setSuccess(false);
            responseDTO.setData("Error on query");
            responseDTO.setError(new ErrorDTO());
            response.sendError(HttpStatus.NOT_FOUND.value());
        }
        return responseDTO;
    }

}