package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.exception.AppException;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.common.utils.AzureBlobConnector;
import wifi4eu.wifi4eu.common.utils.RequestIpRetriever;
import wifi4eu.wifi4eu.entity.registration.LegalFile;
import wifi4eu.wifi4eu.entity.security.RightConstants;
import wifi4eu.wifi4eu.repository.registration.legal_files.LegalFilesRepository;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.registration.legal_files.LegalFilesService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.thread.UserThreadsService;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    private UserThreadsService userThreadsService;

    @Autowired
    private LegalFilesRepository legalFilesRepository;


    Logger _log = LogManager.getLogger(RegistrationResource.class);

/*    @ApiOperation(value = "Get all the registrations")
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
    }*/

    @ApiOperation(value = "Get registration by specific id")
    @RequestMapping(value = "/{registrationId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public RegistrationDTO getRegistrationById(@PathVariable("registrationId") final Integer registrationId, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting registration by id " + registrationId);
        try {
            permissionChecker.check(RightConstants.REGISTRATIONS_TABLE + registrationId);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to retrieve this registration", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- This registration cannot been retrieved", e);
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return registrationService.getRegistrationById(registrationId);
    }

    @ApiOperation(value = "Invalidate registration")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO invalidateRegistration(@RequestBody final RegistrationDTO registrationDTO, HttpServletResponse response, HttpServletRequest request) throws IOException {
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
            //RegistrationValidator.validate(registrationDTO);
            RegistrationDTO resRegistration = registrationService.invalidateRegistration(registrationDTO.getId());
            _log.log(Level.getLevel("BUSINESS"), "[ " + RequestIpRetriever.getIp(request) + " ] - ECAS Username: " + userConnected.getEcasUsername() + "- Registration invalidated successfully");
            return new ResponseDTO(true, resRegistration, null);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to invalidate registrations", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- This registration cannot been invalidated", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
    }

    @ApiOperation(value = "Confirm or request revision of installation report")
    @RequestMapping(value = "/confirmOrRejectReport", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO confirmOrRejectInstallationReport(@RequestBody final Map<String, Object> map, HttpServletRequest request) {
        return registrationService.confirmOrRejectInstallationAndSendCNS(map, request);
    }


    @ApiOperation(value = "Update legal documents")
    @RequestMapping(value = "/{registrationId}/uploadDocuments", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public ResponseDTO uploadRegistrationDocuments(@RequestBody final LegalFilesViewDTO legalFileDTOS, @PathVariable("registrationId") final Integer registrationId, HttpServletResponse response,
                                                   HttpServletRequest request) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Updating legal documents");
        try {
            UserDTO userDTO = userConnected;
            if (!registrationService.checkUserWithRegistration(registrationId, userConnected.getId())) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            permissionChecker.check(userDTO, RightConstants.REGISTRATIONS_TABLE + registrationId);
            ResponseDTO result = registrationService.uploadRegistrationDocuments(registrationId, legalFileDTOS.getArrayOfFiles(), request);
            _log.log(Level.getLevel("BUSINESS"), "[ " + RequestIpRetriever.getIp(request) + " ] - ECAS Username: " + userConnected.getEcasUsername
                    () + "- Documents updated successfully");
            return result;
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to update documents", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- These documents cannot been updated", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
    }

    @ApiOperation(value = "Get registrations by specific user id")
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<RegistrationDTO> getRegistrationsByUserId(@PathVariable("userId") final Integer userId, @RequestParam("date") final Long timestamp, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting registrations by user id " + userId);
        try {
            permissionChecker.check(RightConstants.USER_TABLE + userId);
            List<RegistrationDTO> registrationResult = new ArrayList<>();
            registrationResult = registrationService.getRegistrationsByUserId(userId);
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + "- Registration retrieved successfully");
            return registrationResult;
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to retrieve this registration", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- This registration cannot been retrieved", e);
            return null;
        }
    }

    @ApiOperation(value = "Get registrations by specific municipality id")
    @RequestMapping(value = "/municipality/{municipalityId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public RegistrationDTO getRegistrationByMunicipalityId(@PathVariable("municipalityId") final Integer municipalityId, HttpServletResponse httpServletResponse) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("User ECAS name: " + userConnected.getEcasUsername() + " - Getting registrations by munciipality id " + municipalityId);
        httpServletResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        httpServletResponse.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        httpServletResponse.setDateHeader("Expires", 0); // Proxies.
        UserDTO user = userService.getUserByUserContext(UserHolder.getUser());
        if (user.getType() != 5) {
            permissionChecker.check(RightConstants.MUNICIPALITIES_TABLE + municipalityId);
        }
        return registrationService.getRegistrationByMunicipalityId(municipalityId);
    }

    @ApiOperation(value = "Get registration by specific userThread id")
    @RequestMapping(value = "/userThread/{userThreadId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public RegistrationDTO getRegistrationByUserThreadId(@PathVariable("userThreadId") final Integer userThreadId) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting registrations by user thread id " + userThreadId);
        UserThreadsDTO userThreadDTO = userThreadsService.getUserThreadsById(userThreadId);
        RegistrationDTO registration = registrationService.getRegistrationByUserThreadId(userThreadDTO.getThreadId(), userThreadDTO.getUserId());
        if (userThreadsService.getByUserIdAndThreadId(userConnected.getId(), userThreadDTO.getThreadId()) != null) {
            registration.setIpRegistration(null);
            registration.setMailCounter(0);
            registration.setRole(null);
            registration.setStatus(0);
            registration.setAssociationName(null);
            registration.setOrganisationId(0);
            return registration;
        } else {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You don't have any thread registered with this id");
            throw new AppException("The user in session does not contain any thread registered with the id provided.");
        }
    }

    @ApiOperation(value = "Get registration by specific userThread id")
    @RequestMapping(value = "/getDocument/{registrationId}/{fileId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO getLegalFilesById(@PathVariable("registrationId") final Integer registrationId, @PathVariable("fileId") final Integer fileId, HttpServletResponse response, HttpServletRequest request) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting registration by id " + registrationId + " and file id " + fileId);
        try {
            if (registrationId == null || (!legalFilesService.hasUserPermissionForLegalFile(registrationId, userConnected.getId(), fileId) && userConnected.getType() != 5)) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            permissionChecker.check(userConnected, RightConstants.REGISTRATIONS_TABLE + registrationId);

        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to retrieve this registration", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        }

        LegalFile legalFile = legalFilesRepository.findOne(fileId); //if file doesnt exist user doesnt have permission
        String fileName = legalFile.getFileName();
        String fileMime = legalFile.getFileMime();
        String fileExtension = legalFilesService.getExtensionFromMime(fileMime);
        
        
        ////////////////////////////////////////////////////////////////
        String data = legalFile.getFileData();
        String fileNameDownload = data.substring(data.lastIndexOf("/") + 1);
        AzureBlobConnector azureBlobConnector = new AzureBlobConnector();
        String content = null;
        String containerName = "wifi4eu";
        
        try {
        	_log.info("Downloading container [{}] fileName[{}]", containerName, fileNameDownload);
        	content = azureBlobConnector.downloadText(containerName, fileNameDownload);
        } catch (Exception e) {
        	_log.error("ERROR", e);
        }
        ////////////////////////////////////////////////////////////////

        
        
        //if fileMime is null or has lenght 0 fileExtension is null
        if (fileName != null && fileName.length() != 0 && !legalFile.getFileData().isEmpty() && fileExtension != null) {
            try {
                response.setContentType(fileMime);
                response.setHeader("Content-disposition", "inline; filename=\"" + fileName + fileExtension + "\"");

                //byte[] fileBytes = Base64Utils.decodeFromString(legalFile.getFileData());
                byte[] fileBytes = Base64Utils.decodeFromString(content);
                response.getOutputStream().write(fileBytes);
                response.getOutputStream().flush();
                response.getOutputStream().close();
            } catch (Exception ex) {
                _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- The registration cannot been retrieved", ex);
                return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
            }
        } else{
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- The File cannot been retrieved, file id : " + fileId);
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
        }
        _log.log(Level.getLevel("BUSINESS"), "[ " + RequestIpRetriever.getIp(request) + " ] - ECAS Username: " + userConnected.getEcasUsername() +
                "- Legal files retrieved successfully, id: "+ fileId);
        return new ResponseDTO(true, null, null);
    }

    @ApiOperation(value = "Get past of documents for type")
    @RequestMapping(value = "/getHistory/{registrationId}/{type}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO getHistoryForType(@PathVariable("registrationId") final Integer registrationId, @PathVariable("type") final Integer type,
                                         HttpServletResponse response, HttpServletRequest request) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting History for document type " + type + " and registration id " +
                registrationId);
        try {
            if (registrationId == null || (!registrationService.checkUserWithRegistration(registrationId, userConnected.getId())) && userConnected
                    .getType() != 5) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            permissionChecker.check(userConnected, RightConstants.REGISTRATIONS_TABLE + registrationId);
            return new ResponseDTO(true, registrationService.getHistoryDocuments(registrationId, type, userConnected.getId()), null);

        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to retrieve this registration", ade
                    .getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        }
    }

    @ApiOperation(value = "Get past of documents")
    @RequestMapping(value = "/{registrationId}/getHistory", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO getHistoryAll(@PathVariable("registrationId") final Integer registrationId,
                                         HttpServletResponse response, HttpServletRequest request) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting History for documents" + " of registration id " +
                registrationId);
        try {
            if (registrationId == null || (!registrationService.checkUserWithRegistration(registrationId, userConnected.getId())) && userConnected
                    .getType() != 5) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            permissionChecker.check(userConnected, RightConstants.REGISTRATIONS_TABLE + registrationId);
            return new ResponseDTO(true, registrationService.getHistoryDocuments(registrationId, null, userConnected.getId()), null);

        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to retrieve this registration", ade
                    .getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        }
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
    public List<LegalFileCorrectionReasonDTO> getLegalFilesByRegistrationId(@PathVariable("registrationId") final Integer registrationId, @RequestParam("date") final Long timestamp, HttpServletResponse response, HttpServletRequest request) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting legal files by registration id " + registrationId);
        try {
            if (!permissionChecker.check(RightConstants.REGISTRATIONS_TABLE + registrationId)) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            _log.log(Level.getLevel("BUSINESS"), "[ " + RequestIpRetriever.getIp(request) + " ] - ECAS Username: " + userConnected.getEcasUsername() + "- Legal files retrieved successfully");
            return registrationService.getLegalFilesByRegistrationId(registrationId);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to retrieve these legal files", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- These legal files cannot been retrieved", e);
            return null;
        }
    }

    @ApiOperation(value = "Create/update a legal file")
    @RequestMapping(value = "/saveLegalFile", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO saveLegalFile(@RequestBody final LegalFileCorrectionReasonDTO legalFileDTO, HttpServletResponse response, HttpServletRequest request) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Creating/updating a legal file");
        try {
            if (!permissionChecker.check(RightConstants.REGISTRATIONS_TABLE + legalFileDTO.getRegistrationId())) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            LegalFileCorrectionReasonDTO resLegalFile = registrationService.saveLegalFile(legalFileDTO);
            _log.log(Level.getLevel("BUSINESS"), "[ " + RequestIpRetriever.getIp(request) + " ] - ECAS Username: " + userConnected.getEcasUsername() + "- Legal files saved successfully");
            return new ResponseDTO(true, resLegalFile, null);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to save legal files", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- These legal file cannot been saved", e);
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
        }
    }

    @ApiOperation(value = "Update association name")
    @RequestMapping(value = "/updateAssociationName", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseDTO updateAssociationName(@RequestBody final RegistrationDTO registrationDTO, HttpServletResponse response, HttpServletRequest request) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Creating/updating a legal file");
        try {
            if (userConnected == null) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            permissionChecker.check(userConnected, RightConstants.REGISTRATIONS_TABLE + registrationDTO.getId());
            List<RegistrationDTO> registrations = registrationService.updateAssociationName(registrationDTO.getAssociationName(), userConnected.getId());
            _log.log(Level.getLevel("BUSINESS"), "[ " + RequestIpRetriever.getIp(request) + " ] - ECAS Username: " + userConnected.getEcasUsername() + "- Legal files saved successfully");
            return new ResponseDTO(true, registrations, null);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to update association name", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- These association name cannot been saved", e);
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
        }
    }

}