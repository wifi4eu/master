package wifi4eu.wifi4eu.web.cnect.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import wifi4eu.wifi4eu.common.dto.model.ApplicationDTO;
import wifi4eu.wifi4eu.common.dto.model.ApplicationInvalidateReasonDTO;
import wifi4eu.wifi4eu.common.dto.model.InvalidReasonViewDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.service.application.ApplicationInvalidateReasonService;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.web.authorisation.DashboardUsersOnly;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/invalidateReason", description = "Application Invalidate Reason object REST API services")
@RequestMapping("/invalidateReason")
public class ApplicationInvalidateReasonResource {

	@Autowired
	private ApplicationInvalidateReasonService applicationInvalidateReasonService;

	@Autowired
	private UserService userService;

	private static final Logger _log = LoggerFactory.getLogger(ApplicationInvalidateReasonResource.class);

	@ApiOperation(value = "Get application by call and registration id")
	@RequestMapping(value = "empty", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ApplicationInvalidateReasonDTO applicationinvalidatereason() {
		return new ApplicationInvalidateReasonDTO();
	}

	@ApiOperation(value = "Get invalidate reasons by application ID")
	@RequestMapping(value = "/by-application/{applicationId}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	@DashboardUsersOnly
	public List<ApplicationInvalidateReasonDTO> getInvalidateReasonsByApplication(@PathVariable("applicationId") Integer applicationID, HttpServletResponse response) throws IOException {
		UserContext userContext = UserHolder.getUser();
		UserDTO userConnected = userService.getUserByUserContext(userContext);
		_log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting invalidate reasons by application ID " + applicationID);
		try {
			_log.info("ECAS Username: " + userConnected.getEcasUsername() + "- Invalidate reasons by application ID " + applicationID + "retrieved successfully");
			List<ApplicationInvalidateReasonDTO> result = applicationInvalidateReasonService.getInvalidateReasonByApplicationId(applicationID);
			return result;
		} catch (Exception e) {
			_log.error("ECAS Username: " + userConnected.getEcasUsername() + "- Application cannot been invalidated", e);
			response.sendError(HttpStatus.BAD_REQUEST.value());
			return null;
		}
	}

	@ApiOperation(value = "Invalidate application")
	@RequestMapping(value = "/invalidate", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	@DashboardUsersOnly
	public ResponseEntity<List<ApplicationInvalidateReasonDTO>> invalidateApplicationWithReason(@RequestBody InvalidReasonViewDTO invalidReasonViewDTO, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		UserContext userContext = UserHolder.getUser();
		UserDTO userConnected = userService.getUserByUserContext(userContext);
		_log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Invalidating applications");
		try {
			_log.info("ECAS Username: " + userConnected.getEcasUsername() + "- Application invalidated successfully");
			List<ApplicationInvalidateReasonDTO> result = applicationInvalidateReasonService.invalidateApplication(invalidReasonViewDTO, request);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			_log.error("ECAS Username: " + userConnected.getEcasUsername() + "- Application cannot been invalidated", e);
			response.sendError(HttpStatus.BAD_REQUEST.value());
			return null;
		}
	}

	@ApiOperation(value = "Validate application")
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	@ResponseBody
	@DashboardUsersOnly
	public ResponseDTO validateApplication(@RequestBody final ApplicationDTO applicationDTO, HttpServletResponse response, HttpServletRequest request) throws IOException {
		UserContext userContext = UserHolder.getUser();
		UserDTO userConnected = userService.getUserByUserContext(userContext);
		_log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Validating applications");
		try {
			ApplicationDTO resApplication = applicationInvalidateReasonService.validateApplication(applicationDTO, request);
			_log.info("ECAS Username: " + userConnected.getEcasUsername() + "- Application validated");
			return new ResponseDTO(true, resApplication, null);
		} catch (Exception e) {
			_log.error("ECAS Username: " + userConnected.getEcasUsername() + "- Application cannot been validated", e);
			response.sendError(HttpStatus.BAD_REQUEST.value());
			return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
		}
	}

	@ApiOperation(value = "Get application by call and registration id")
	@RequestMapping(value = "/can-change-status/by-application/{applicationId}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	@DashboardUsersOnly
	public ResponseDTO changeStatusApplicationEnabled(@PathVariable("applicationId") Integer applicationID, HttpServletRequest request, HttpServletResponse response) throws IOException {
		UserContext userContext = UserHolder.getUser();
		UserDTO userConnected = userService.getUserByUserContext(userContext);
		try {
			Map<String, Boolean> checks = applicationInvalidateReasonService.changeStatusApplicationEnabled(applicationID, request);
			_log.info("ECAS Username: " + userConnected.getEcasUsername() + "- Validation to change application status retrieved");
			return new ResponseDTO(true, checks, null);
		} catch (Exception e) {
			_log.error("ECAS Username: " + userConnected.getEcasUsername() + "- Validation to change application status cannot be retrieved", e);
			response.sendError(HttpStatus.BAD_REQUEST.value());
			return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
		}
	}

}
