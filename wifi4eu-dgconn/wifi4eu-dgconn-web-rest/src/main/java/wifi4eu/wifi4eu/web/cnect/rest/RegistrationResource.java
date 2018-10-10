package wifi4eu.wifi4eu.web.cnect.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import wifi4eu.wifi4eu.common.dto.model.LegalFileCorrectionReasonDTO;
import wifi4eu.wifi4eu.common.dto.model.LegalFileDTO;
import wifi4eu.wifi4eu.common.dto.model.RegistrationDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.mapper.registration.legal_files.LegalFilesMapper;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.common.utils.RequestIpRetriever;
import wifi4eu.wifi4eu.entity.security.RightConstants;
import wifi4eu.wifi4eu.repository.registration.legal_files.LegalFilesRepository;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.registration.legal_files.LegalFilesService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.web.authorisation.DashboardUsersOnly;

import javax.servlet.http.HttpServletRequest;
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
	private LegalFilesService legalFilesService;

	@Autowired
	private PermissionChecker permissionChecker;

	@Autowired
	private UserService userService;

	@Autowired
	private LegalFilesRepository legalFilesRepository;

	@Autowired
	private LegalFilesMapper legalFilesMapper;

	private static final Logger _log = LogManager.getLogger(RegistrationResource.class);

	@ApiOperation(value = "Get registration by specific id")
	@RequestMapping(value = "/{registrationId}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public RegistrationDTO getRegistrationById(@PathVariable("registrationId") final Integer registrationId,
			HttpServletResponse response) throws IOException {
		UserContext userContext = UserHolder.getUser();
		UserDTO userConnected = userService.getUserByUserContext(userContext);
		_log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting registration by id "
				+ registrationId);
		try {
			permissionChecker.check(RightConstants.REGISTRATIONS_TABLE + registrationId);
		} catch (AccessDeniedException ade) {
			_log.error("ECAS Username: " + userConnected.getEcasUsername()
					+ "- You have no permissions to retrieve this registration", ade.getMessage());
			response.sendError(HttpStatus.NOT_FOUND.value());
			return null;
		} catch (Exception e) {
			_log.error(
					"ECAS Username: " + userConnected.getEcasUsername() + "- This registration cannot been retrieved",
					e);
			response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return null;
		}
		return registrationService.getRegistrationById(registrationId);
	}

	@ApiOperation(value = "Invalidate registration")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResponseDTO invalidateRegistration(@RequestBody final RegistrationDTO registrationDTO,
			HttpServletResponse response, HttpServletRequest request) throws IOException {
		UserContext userContext = UserHolder.getUser();
		UserDTO userConnected = userService.getUserByUserContext(userContext);
		_log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Invalidating registration");
		try {
			UserDTO userDTO = userConnected;
			if (userDTO.getType() != 5) {
				if (!registrationService.checkUserWithRegistration(registrationDTO.getId(), userConnected.getId())) {
					throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
				}
				permissionChecker.check(userDTO, RightConstants.REGISTRATIONS_TABLE + registrationDTO.getId());
			}
			// RegistrationValidator.validate(registrationDTO);
			RegistrationDTO resRegistration = registrationService.invalidateRegistration(registrationDTO.getId());
			_log.log(Level.getLevel("BUSINESS"), "[ " + RequestIpRetriever.getIp(request) + " ] - ECAS Username: "
					+ userConnected.getEcasUsername() + "- Registration invalidated successfully");
			return new ResponseDTO(true, resRegistration, null);
		} catch (AccessDeniedException ade) {
			_log.error("ECAS Username: " + userConnected.getEcasUsername()
					+ "- You have no permissions to invalidate registrations", ade.getMessage());
			response.sendError(HttpStatus.NOT_FOUND.value());
			return new ResponseDTO(false, null,
					new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
		} catch (Exception e) {
			_log.error(
					"ECAS Username: " + userConnected.getEcasUsername() + "- This registration cannot been invalidated",
					e);
			response.sendError(HttpStatus.BAD_REQUEST.value());
			return new ResponseDTO(false, null,
					new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
		}
	}

	@ApiOperation(value = "Get registrations by specific municipality id")
	@RequestMapping(value = "/municipality/{municipalityId}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public RegistrationDTO getRegistrationByMunicipalityId(@PathVariable("municipalityId") final Integer municipalityId,
			HttpServletResponse httpServletResponse) {
		UserContext userContext = UserHolder.getUser();
		UserDTO userConnected = userService.getUserByUserContext(userContext);
		_log.debug("User ECAS name: " + userConnected.getEcasUsername() + " - Getting registrations by munciipality id "
				+ municipalityId);
		httpServletResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		httpServletResponse.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		httpServletResponse.setDateHeader("Expires", 0); // Proxies.
		UserDTO user = userService.getUserByUserContext(UserHolder.getUser());
		if (user.getType() != 5) {
			permissionChecker.check(RightConstants.MUNICIPALITIES_TABLE + municipalityId);
		}
		return registrationService.getRegistrationByMunicipalityId(municipalityId);
	}

	@ApiOperation(value = "getLegalFile")
	@RequestMapping(value = "/getLegalFile", method = RequestMethod.GET)
	@ResponseBody
	public LegalFileCorrectionReasonDTO getLegalFile() {
		return new LegalFileCorrectionReasonDTO();
	}

	@ApiOperation(value = "Get legal files by registration id")
	@RequestMapping(value = "/getLegalFiles/{registrationId}", method = RequestMethod.GET)
	@ResponseBody
	public List<LegalFileCorrectionReasonDTO> getLegalFilesByRegistrationId(
			@PathVariable("registrationId") final Integer registrationId, @RequestParam("date") final Long timestamp,
			HttpServletResponse response, HttpServletRequest request) throws IOException {
		UserContext userContext = UserHolder.getUser();
		UserDTO userConnected = userService.getUserByUserContext(userContext);
		_log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting legal files by registration id "
				+ registrationId);
		try {
			if (!permissionChecker.check(RightConstants.REGISTRATIONS_TABLE + registrationId)) {
				throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
			}
			_log.log(Level.getLevel("BUSINESS"), "[ " + RequestIpRetriever.getIp(request) + " ] - ECAS Username: "
					+ userConnected.getEcasUsername() + "- Legal files retrieved successfully");
			return registrationService.getLegalFilesByRegistrationId(registrationId);
		} catch (AccessDeniedException ade) {
			_log.error("ECAS Username: " + userConnected.getEcasUsername()
					+ "- You have no permissions to retrieve these legal files", ade.getMessage());
			response.sendError(HttpStatus.NOT_FOUND.value());
			return null;
		} catch (Exception e) {
			_log.error(
					"ECAS Username: " + userConnected.getEcasUsername() + "- These legal files cannot been retrieved",
					e);
			return null;
		}
	}

	@ApiOperation(value = "Create/update a legal file")
	@RequestMapping(value = "/saveLegalFile", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResponseDTO saveLegalFile(@RequestBody final LegalFileCorrectionReasonDTO legalFileDTO,
			HttpServletResponse response, HttpServletRequest request) throws IOException {
		UserContext userContext = UserHolder.getUser();
		UserDTO userConnected = userService.getUserByUserContext(userContext);
		_log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Creating/updating a legal file");
		try {
			if (!permissionChecker.check(RightConstants.REGISTRATIONS_TABLE + legalFileDTO.getRegistrationId())) {
				throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
			}
			registrationService.clearCorrectionReason(legalFileDTO, userConnected);
			LegalFileCorrectionReasonDTO resLegalFile = registrationService.saveLegalFile(legalFileDTO);
			_log.log(Level.getLevel("BUSINESS"), "[ " + RequestIpRetriever.getIp(request) + " ] - ECAS Username: "
					+ userConnected.getEcasUsername() + "- Legal files saved successfully");
			return new ResponseDTO(true, resLegalFile, null);
		} catch (AccessDeniedException ade) {
			_log.error("ECAS Username: " + userConnected.getEcasUsername()
					+ "- You have no permissions to save legal files", ade.getMessage());
			response.sendError(HttpStatus.NOT_FOUND.value());
			return null;
		} catch (Exception e) {
			_log.error("ECAS Username: " + userConnected.getEcasUsername() + "- These legal file cannot been saved", e);
			return new ResponseDTO(false, null,
					new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
		}
	}

	@ApiOperation(value = "Get past of documents")
	@RequestMapping(value = "/{registrationId}/getHistory", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseDTO getHistoryAll(@PathVariable("registrationId") final Integer registrationId,
			HttpServletResponse response, HttpServletRequest request) throws IOException {
		UserContext userContext = UserHolder.getUser();
		UserDTO userConnected = userService.getUserByUserContext(userContext);
		_log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting History for documents"
				+ " of registration id " + registrationId);
		try {
			if (registrationId == null
					|| (!registrationService.checkUserWithRegistration(registrationId, userConnected.getId()))
							&& userConnected.getType() != 5) {
				throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
			}
			permissionChecker.check(userConnected, RightConstants.REGISTRATIONS_TABLE + registrationId);
			return new ResponseDTO(true, registrationService.getHistoryDocuments(registrationId), null);

		} catch (AccessDeniedException ade) {
			_log.error("ECAS Username: " + userConnected.getEcasUsername()
					+ "- You have no permissions to retrieve this registration", ade.getMessage());
			response.sendError(HttpStatus.NOT_FOUND.value());
			return null;
		}
	}

	// TODO: not used. Remove.
	@ApiOperation(value = "LegalFile not implemented")
	@RequestMapping(value = "/LegalFileNotImplemented", method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody
	@DashboardUsersOnly
	public ResponseDTO getDtoLegalFile(@RequestBody LegalFileDTO request) {
		return null;
	}

	@ApiOperation(value = "LegalFile downloaded")
	@RequestMapping(value = "/LegalFileDownloaded/{fileId}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseDTO getDownloadedLegalFile(@PathVariable ("fileId") Integer fileId) {
		UserContext userContext = UserHolder.getUser();
		UserDTO userConnected = userService.getUserByUserContext(userContext);
		LegalFileDTO legalFileDTO = legalFilesMapper.toDTO(legalFilesRepository.findOne(fileId));
		_log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Downloading file");
		try {
			if (!permissionChecker.check(RightConstants.REGISTRATIONS_TABLE + legalFileDTO.getRegistration())) {
				throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
			}
			legalFilesService.setNotNewFile(legalFileDTO);
			_log.info("ECAS Username: "
					+ userConnected.getEcasUsername() + "- Legal files downloaded successfully");
			return new ResponseDTO(true, legalFileDTO, null);
		} catch (AccessDeniedException ade) {
			_log.error("ECAS Username: " + userConnected.getEcasUsername()
					+ "- You have no permissions to download legal files", ade.getMessage());
			return new ResponseDTO(true, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
		} catch (Exception e) {
			_log.error("ECAS Username: " + userConnected.getEcasUsername() + "- These legal file cannot been downloaded", e);
			return new ResponseDTO(false, null,
					new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
		}
	}

	@ApiOperation(value = "Get legal files types with correction request disabled by registration id")
	@RequestMapping(value = "/getTypesDisabled/{registrationId}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseDTO getTypesDisabled(@PathVariable("registrationId") final Integer registrationId,
			HttpServletResponse response, HttpServletRequest request) throws IOException {
		UserContext userContext = UserHolder.getUser();
		UserDTO userConnected = userService.getUserByUserContext(userContext);
		_log.debug("ECAS Username: " + userConnected.getEcasUsername()
				+ " - Getting legal files types with correction request disabled by registration id " + registrationId);
		try {
			if (!permissionChecker.check(RightConstants.REGISTRATIONS_TABLE + registrationId)) {
				throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
			}
			_log.log(Level.getLevel("BUSINESS"), "[ " + RequestIpRetriever.getIp(request) + " ] - ECAS Username: "
					+ userConnected.getEcasUsername() + "- Legal files retrieved successfully");

			List<Integer> typesWithCorrectionDisabledList = registrationService
					.findTypeFilesWaitingUploadByRegistration(registrationId);
			return new ResponseDTO(true, typesWithCorrectionDisabledList, null);
		} catch (AccessDeniedException ade) {
			_log.error(
					"ECAS Username: " + userConnected.getEcasUsername()
							+ "- You have no permissions to retrieve these legal files types with correction request",
					ade.getMessage());
			return new ResponseDTO(false, null,
					new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
		} catch (Exception e) {
			_log.error("ECAS Username: " + userConnected.getEcasUsername()
					+ "- These legal files types with correction request cannot been retrieved", e);
			return new ResponseDTO(false, null,
					new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
		}
	}
}