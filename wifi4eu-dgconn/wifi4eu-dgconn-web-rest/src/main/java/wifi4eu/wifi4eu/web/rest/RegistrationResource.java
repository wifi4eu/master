package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.util.*;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.exception.AppException;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.common.utils.RegistrationValidator;
import wifi4eu.wifi4eu.entity.security.RightConstants;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.registration.legal_files.*;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.thread.UserThreadsService;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
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
    private UserThreadsService userThreadsService;

    Logger _log = LoggerFactory.getLogger(RegistrationResource.class);

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
    @ResponseBody
    public ResponseDTO invalidateRegistration(@RequestBody final RegistrationDTO registrationDTO, HttpServletResponse response) throws IOException {
        try {
            _log.info("invalidateRegistration");

            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if (userDTO.getType() != 5) {
                if (userDTO.getId() != registrationDTO.getUserId()) {
                    throw new AccessDeniedException("Incorrect user id");
                }
                permissionChecker.check(userDTO, RightConstants.REGISTRATIONS_TABLE + registrationDTO.getId());
                permissionChecker.check(userDTO, RightConstants.USER_TABLE + registrationDTO.getUserId());
            }

            //RegistrationValidator.validate(registrationDTO);

            RegistrationDTO resRegistration = registrationService.invalidateRegistration(registrationDTO.getId());
            return new ResponseDTO(true, resRegistration, null);

        } catch (AccessDeniedException ade) {
            if (_log.isErrorEnabled()) {
                _log.error("Error with permission on 'createRegistration' operation.", ade);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
        } catch (Exception e) {
            response.sendError(HttpStatus.BAD_REQUEST.value());
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'createRegistration' operation.", e);
            }
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
    }

    @ApiOperation(value = "Delete legal documents")
    @RequestMapping(value = "/deleteDocuments", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseDTO deleteRegistrationDocuments(@RequestBody final RegistrationDTO registrationDTO, HttpServletResponse response) throws IOException {
        try {
            _log.info("createRegistration");

            UserContext userContext = UserHolder.getUser();
            UserDTO userDTO = userService.getUserByUserContext(userContext);

            if (userDTO.getId() != registrationDTO.getUserId()) {
                throw new AccessDeniedException("");
            }

            permissionChecker.check(userDTO, RightConstants.REGISTRATIONS_TABLE + registrationDTO.getId());

            RegistrationDTO resRegistration = registrationService.deleteRegistrationDocuments(registrationDTO);
            return new ResponseDTO(true, resRegistration, null);
        } catch (AccessDeniedException ade) {
            if (_log.isErrorEnabled()) {
                _log.error("AccessDenied on 'deleteRegistrationDocuments' operation.", ade);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'deleteRegistrationDocuments' operation.", e);
            }
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
    }

    @ApiOperation(value = "Update legal documents")
    @RequestMapping(value = "/updateDocuments", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseDTO updateRegistrationDocuments(@RequestBody final RegistrationDTO registrationDTO, HttpServletResponse response) throws IOException {
        try {
            _log.info("createRegistration");

            UserContext userContext = UserHolder.getUser();
            UserDTO userDTO = userService.getUserByUserContext(userContext);

            if (userDTO.getId() != registrationDTO.getUserId()) {
                throw new AccessDeniedException("");
            }

            permissionChecker.check(userDTO, RightConstants.REGISTRATIONS_TABLE + registrationDTO.getId());

            RegistrationDTO resRegistration = registrationService.updateRegistrationDocuments(registrationDTO);
            return new ResponseDTO(true, resRegistration, null);
        } catch (AccessDeniedException ade) {
            if (_log.isErrorEnabled()) {
                _log.error("AccessDenied on 'updateRegistrationDocuments' operation.", ade);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'updateRegistrationDocuments' operation.", e);
            }
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
    }

    /*
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
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'deleteRegistration' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
        }
    }
    */

    @ApiOperation(value = "Get registrations by specific user id")
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<RegistrationDTO> getRegistrationsByUserId(@PathVariable("userId") final Integer userId, @RequestParam("date") final Long timestamp, HttpServletResponse response) throws IOException {
        try {
            permissionChecker.check(RightConstants.USER_TABLE + userId);
            return registrationService.getRegistrationsByUserId(userId);
        } catch (AccessDeniedException ade) {
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'getRegistrationsByUserId' operation.", e);
            }
            return null;
        }
    }

    @ApiOperation(value = "Get registrations by specific municipality id")
    @RequestMapping(value = "/municipality/{municipalityId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public RegistrationDTO getRegistrationByMunicipalityId(@PathVariable("municipalityId") final Integer municipalityId, HttpServletResponse httpServletResponse) {
        _log.info("getRegistrationsByMunicipalityId: " + municipalityId);
        httpServletResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        httpServletResponse.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        httpServletResponse.setDateHeader("Expires", 0); // Proxies.

        UserDTO user = userService.getUserByUserContext(UserHolder.getUser());
        if (user.getType() != 5) {
            permissionChecker.check(RightConstants.MUNICIPALITIES_TABLE + municipalityId);
        }
        return registrationService.getRegistrationByMunicipalityId(municipalityId);
    }

    /*
    @ApiOperation(value = "Check if a certain user id registration is KO (deleted or suspended).")
    @RequestMapping(value = "/registrationKO/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseDTO checkIfRegistrationIsKO(@PathVariable("userId") final Integer userId, HttpServletResponse response) throws IOException {
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("");
            }
            _log.info("checkIfRegistrationIsKO: " + userId);
            return new ResponseDTO(true, registrationService.checkIfRegistrationIsKO(userId), null);

        } catch (AccessDeniedException ade) {
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'checkIfRegistrationIsKO' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()));
        }
    }
    */

    /*
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
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'getRegistrationByUserAndMunicipality' operation.", e);
            }
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }

        return registrationService.getRegistrationByUserAndMunicipality(userId, municipalityId);
    }
    */

    /*@ApiOperation(value = "Request legal documents")
    @RequestMapping(value = "/requestLegalDocuments/{registrationId}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO requestLegalDocuments(@PathVariable("registrationId") final Integer registrationId, HttpServletResponse response) throws IOException {
        try {
            if (_log.isInfoEnabled()) {
                _log.info("requestLegalDocuments for registration: " + registrationId);
            }

            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if (userDTO.getType() != 5) {
                throw new AccessDeniedException("");
            }
            return new ResponseDTO(registrationService.requestLegalDocuments(registrationId), null, null);

        } catch (AccessDeniedException ade) {
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;

        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'requestLegalDocuments' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }*/

    /*@ApiOperation(value = "Assign legal entity")
    @RequestMapping(value = "/assignLegalEntity/{registrationId}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO assignLegalEntity(@PathVariable("registrationId") final Integer registrationId, HttpServletResponse response) throws IOException {
        try {
            if (_log.isInfoEnabled()) {
                _log.info("assignLegalEntity for registration: " + registrationId);
            }
            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if (userDTO.getType() != 5) {
                throw new AccessDeniedException("");
            }
            return new ResponseDTO(registrationService.assignLegalEntity(registrationId), null, null);

        } catch (AccessDeniedException ade) {
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;

        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'assignLegalEntity' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }*/

    @ApiOperation(value = "Get registration by specific userThread id")
    @RequestMapping(value = "/userThread/{userThreadId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public RegistrationDTO getRegistrationByUserThreadId(@PathVariable("userThreadId") final Integer userThreadId) {
        _log.info("getRegistrationByUserThreadId: " + userThreadId);


        UserThreadsDTO userThreadDTO = userThreadsService.getUserThreadsById(userThreadId);
        RegistrationDTO registration = registrationService.getRegistrationByUserThreadId(userThreadDTO.getThreadId(), userThreadDTO.getUserId());

        UserContext userContext = UserHolder.getUser();
        UserDTO user = userService.getUserByUserContext(userContext);

        if (userThreadsService.getByUserIdAndThreadId(user.getId(), userThreadDTO.getThreadId()) != null) {

            //TODO Temporary solution to prevent information leaks
            // we check that the user has access to registrations table

            //registration.setLegalFile1(null);
            //registration.setLegalFile2(null);
            //registration.setLegalFile3(null);
            //registration.setLegalFile4(null);
            registration.setIpRegistration(null);
            registration.setMailCounter(0);
            registration.setRole(null);
            registration.setStatus(0);
            registration.setAssociationName(null);
            registration.setOrganisationId(0);
            registration.setUploadTime(0);
            registration.setAllFilesFlag(0);

            return registration;
        } else {
            throw new AppException("The user in session does not contain any thread registered with the id provided.");
        }
    }

    @ApiOperation(value = "Get registration by specific userThread id")
    @RequestMapping(value = "/registrations/{registrationId}/{fileType}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO getLegalFilesByFileType(@PathVariable("registrationId") final Integer registrationId, @PathVariable("fileType") final Integer fileType, HttpServletResponse response) {
        _log.info("getLegalFilesByFileType: " + registrationId + " " + fileType);

        UserContext userContext = UserHolder.getUser();
        UserDTO user = userService.getUserByUserContext(userContext);

        RegistrationDTO registration = registrationService.getRegistrationById(registrationId);
        if (registration != null && user != null && (registration.getUserId() == user.getId() || user.getType() == 5)) {
            LegalFilesDTO registrationFile = legalFilesService.getLegalFileByRegistrationIdFileType(registration.getId(), fileType);
            if (registrationFile != null) {
                String fileName = "";
                String fileMime = "";
                String fileExtension = "";
                switch (fileType) {
                    case 1:
                        fileName = "LegalFile1";
                        fileMime = registration.getLegalFile1Mime();
                        break;
                    case 2:
                        fileName = "LegalFile2";
                        fileMime = registration.getLegalFile2Mime();
                        break;
                    case 3:
                        fileName = "LegalFile3";
                        fileMime = registration.getLegalFile3Mime();
                        break;
                    case 4:
                        fileName = "LegalFile4";
                        fileMime = registration.getLegalFile4Mime();
                        break;
                }

                if (fileMime != null && fileMime.length() != 0) {
                    if (fileMime.contains("pdf")) {
                        fileExtension = "pdf";
                    } else if (fileMime.contains("png")) {
                        fileExtension = "png";
                    } else if (fileMime.contains("jpg") || fileMime.contains("jpeg")) {
                        fileExtension = "jpg";
                    }
                }

                if (fileMime != null && fileMime.length() != 0 && fileName != null && fileName.length() != 0 && !registrationFile.getFileData().isEmpty()) {
                    try {
                        response.setContentType(fileMime);
                        response.setHeader("Content-disposition", "inline; filename=\"" + fileName + "." + fileExtension + "\"");

                        byte[] fileBytes = Base64Utils.decodeFromString(registrationFile.getFileData());
                        response.getOutputStream().write(fileBytes);
                        response.getOutputStream().flush();
                        response.getOutputStream().close();
                    } catch (Exception ex) {
                        _log.error(ex.getMessage(), ex);
                    }
                }
            }
        } else {
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
        }
        return new ResponseDTO(true, null, null);
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
    public List<LegalFileCorrectionReasonDTO> getLegalFilesByRegistrationId(@PathVariable("registrationId") final Integer registrationId, @RequestParam("date") final Long timestamp, HttpServletResponse response) throws IOException {
        try {
            if (!permissionChecker.check(RightConstants.REGISTRATIONS_TABLE + registrationId)) {
                throw new AccessDeniedException("");
            }
            return registrationService.getLegalFilesByRegistrationId(registrationId);
        } catch (AccessDeniedException ade) {
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'getLegalFilesByRegistrationId' operation.", e);
            }
            return null;
        }
    }

    @ApiOperation(value = "Create/update a legal file")
    @RequestMapping(value = "/saveLegalFile", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO saveLegalFile(@RequestBody final LegalFileCorrectionReasonDTO legalFileDTO, HttpServletResponse response) throws IOException {
        try {
            _log.info("saveLegalFile");
            if (!permissionChecker.check(RightConstants.REGISTRATIONS_TABLE + legalFileDTO.getRegistrationId())) {
                throw new AccessDeniedException("");
            }
            LegalFileCorrectionReasonDTO resLegalFile = registrationService.saveLegalFile(legalFileDTO);
            return new ResponseDTO(true, resLegalFile, null);
        } catch (AccessDeniedException ade) {
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'saveLegalFileRegistration' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
        }
    }
}