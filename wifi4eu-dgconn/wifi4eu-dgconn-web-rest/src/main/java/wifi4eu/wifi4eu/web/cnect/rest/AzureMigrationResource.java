package wifi4eu.wifi4eu.web.cnect.rest;

import java.io.IOException;
import java.util.concurrent.Executors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.service.migration.AzureMigrationService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.user.UserService;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/azure", description = "Azure object REST API services")
@RequestMapping(value = "azure")
public class AzureMigrationResource {
	
	Logger _log = LogManager.getLogger(RegistrationResource.class);

	@Autowired
	private AzureMigrationService azureMigrationService;
	
	@Autowired
	private PermissionChecker permissionChecker;
	
	@Autowired
	private UserService userService;

	@ApiOperation(value = "Initiates files migration")
	@RequestMapping(value = "/blob", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseDTO migrate(HttpServletResponse response, HttpServletRequest request) throws IOException {
		UserContext userContext = UserHolder.getUser();
		UserDTO userConnected = userService.getUserByUserContext(userContext);
		_log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Initiating legal files migration from database to Azure");
		try {
			if (userConnected.getType() != 5) {
				throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
			}
			
			// Initiate the migration
			Executors.newSingleThreadExecutor().execute(azureMigrationService);

			return new ResponseDTO(true, null, null);
		} catch (AccessDeniedException ade) {
			_log.error("ECAS Username: " + userConnected.getEcasUsername()
					+ "- You have no permissions to initiate migration", ade.getMessage());
			response.sendError(HttpStatus.NOT_FOUND.value());
			return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
		} catch (Exception e) {
			_log.error("ECAS Username: " + userConnected.getEcasUsername() + "- The migration couldn't be initiated", e);
			response.sendError(HttpStatus.BAD_REQUEST.value());
			return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
		}		
	}
}