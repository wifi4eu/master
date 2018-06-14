package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.entity.security.RightConstants;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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

    UserContext userContext;
    UserDTO userConnected;

    Logger _log = LogManager.getLogger(ApplicationResource.class);

    @ApiOperation(value = "Get application by call and registration id")
    @RequestMapping(value = "/call/{callId}/registration/{registrationId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ApplicationDTO getApplicationByCallIdAndRegistrationId(@PathVariable("callId") final Integer callId, @PathVariable("registrationId") final Integer registrationId, HttpServletResponse response) throws IOException {
        userContext = UserHolder.getUser();
        userConnected = userService.getUserByUserContext(userContext);
        if (_log.isInfoEnabled()) {
            _log.info("getApplicationByCall: " + callId + " & Registration: " + registrationId);
        }

        try {
            permissionChecker.check(RightConstants.REGISTRATIONS_TABLE + registrationId);
        } catch (Exception e) {
            _log.error("User ID: " + userConnected.getEcasEmail() + " - Permission not found", e.getMessage());
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

    @ApiOperation(value = "Get applications voucher info by call id")
    @RequestMapping(value = "/voucherInfo/call/{callId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<ApplicationVoucherInfoDTO> getApplicationsVoucherInfoByCall(@PathVariable("callId") final Integer callId, HttpServletResponse response) throws IOException {
        try {
            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if (userDTO.getType() != 5) {
                _log.error("User ID: " + userConnected.getEcasUsername() + " - You have no permissions to access");
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            return applicationService.getApplicationsVoucherInfoByCall(callId);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("User ID: " + userConnected.getEcasUsername() + " - Applications' voucher information not found on this call", e.getMessage());
                response.sendError(HttpStatus.NOT_FOUND.value());
            }
            return null;
        }
    }

    @ApiOperation(value = "Get applications voucher info by call id")
    @RequestMapping(value = "/voucherInfo/application/{applicationId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ApplicationVoucherInfoDTO applicationVoucherInfoDTOEndpoint(@PathVariable("applicationId") final Integer applicationId) {
        return null;
    }

    @ApiOperation(value = "Resource to generate ApplicantListItemDTO")
    @RequestMapping(value = "/getApplicantListItem", method = RequestMethod.GET)
    @ResponseBody
    public ApplicantListItemDTO getApplicantListItem() {
        return new ApplicantListItemDTO();
    }

    @ApiOperation(value = "Resource to generate PagingSortingDTO")
    @RequestMapping(value = "/getPagingSortingDTO", method = RequestMethod.GET)
    public PagingSortingDTO getPagingSortingDTO() {
        return new PagingSortingDTO();
    }

    @ApiOperation(value = "findDgconnApplicantsListByCallId")
    @RequestMapping(value = "/findDgconnApplicantsListByCallId/{callId}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO findDgconnApplicantsListByCallId(@PathVariable("callId") final Integer callId, @RequestParam("country") final String country, @RequestBody final PagingSortingDTO pagingSortingData, HttpServletResponse response) throws IOException {
        userContext = UserHolder.getUser();
        userConnected = userService.getUserByUserContext(userContext);
        try {
            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if (userDTO.getType() != 5) {
                _log.error("User ID: " + userConnected.getEcasUsername() + " - You have no permissions to access");
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }

            ResponseDTO res = new ResponseDTO(true, null, null);
            res.setData(applicationService.findDgconnApplicantsList(callId, country, null, pagingSortingData));
            res.setXTotalCount(municipalityService.getCountDistinctMunicipalitiesThatAppliedCall(callId, country));
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - The DGConn Applicants for this call are retrieved correctly");
            return res;
        } catch (Exception e) {
            _log.error("User ID: " + userConnected.getEcasUsername() + "- The DGConn Applicants cannot be retrieved", e.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "findDgconnApplicantsListByCallIdSearchingName")
    @RequestMapping(value = "/findDgconnApplicantsListByCallIdSearchingName/{callId}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO findDgconnApplicantsListByCallIdSearchingName(@PathVariable("callId") final Integer callId, @RequestParam("country") final String country, @RequestParam("name") final String name,
                                                                     @RequestBody final PagingSortingDTO pagingSortingData, HttpServletResponse response) throws IOException {
        userContext = UserHolder.getUser();
        userConnected = userService.getUserByUserContext(userContext);
        try {
            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if (userDTO.getType() != 5) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            ResponseDTO res = new ResponseDTO(true, null, null);
            res.setData(applicationService.findDgconnApplicantsList(callId, country, name, pagingSortingData));
            res.setXTotalCount(municipalityService.getCountDistinctMunicipalitiesThatAppliedCallContainingName(callId, country, name));
            _log.info("User ID: " + userConnected.getEcasUsername() + "- DGConn Applicants retrieved correctly");
            return res;
        } catch (Exception e) {
            _log.error("User ID: " + userConnected.getEcasUsername() + "- The applicants cannot be retrieved", e.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
        }
        return new ResponseDTO(false, null, null);
    }

    @ApiOperation(value = "Validate application")
    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO validateApplication(@RequestBody final ApplicationDTO applicationDTO, HttpServletResponse response) throws IOException {
        userContext = UserHolder.getUser();
        userConnected = userService.getUserByUserContext(userContext);
        try {
            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if (userDTO.getType() != 5) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            ApplicationDTO resApplication = applicationService.validateApplication(applicationDTO);
            _log.info("User ID: " + userConnected.getEcasUsername() + "- Application validated");
            return new ResponseDTO(true, resApplication, null);
        } catch (AccessDeniedException ade) {
            _log.error("User ID: " + userConnected.getEcasUsername() + "- You have no permissions to validate this application", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(0, ade.getMessage()));
        } catch (Exception e) {
            _log.error("User ID: " + userConnected.getEcasUsername() + "- Application cannot been validated", e.getMessage());
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "Get applications voucher2 info by call id")
    @RequestMapping(value = "/valid/call/{callId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Integer getApplicationsNotInvalidated(@PathVariable("callId") final Integer callId) {
        userContext = UserHolder.getUser();
        userConnected = userService.getUserByUserContext(userContext);
        try {
            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if (userDTO.getType() != 5) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            _log.info("User ID: " + userConnected.getEcasUsername() + "- Applications not invalidated are retrieved successfully");
            return applicationService.countApplicationsNotInvalidated(callId);
        } catch (AccessDeniedException ade) {
            _log.error("User ID: " + userConnected.getEcasUsername() + "- You have no permissions to retrieve applications not validated", ade.getMessage());
            return null;
        } catch (Exception e) {
            _log.error("User ID: " + userConnected.getEcasUsername() + "- Applications not validated cannot been retrieved", e.getMessage());
            return null;
        }
    }

    @ApiOperation(value = "Invalidate application")
    @RequestMapping(value = "/invalidate", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO invalidateApplication(@RequestBody final ApplicationDTO applicationDTO, HttpServletResponse response) throws IOException {
        userContext = UserHolder.getUser();
        userConnected = userService.getUserByUserContext(userContext);
        try {
            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if (userDTO.getType() != 5) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            ApplicationDTO resApplication = applicationService.invalidateApplication(applicationDTO);
            _log.info("User ID: " + userConnected.getEcasUsername() + "- Application invalidated successfully");
            return new ResponseDTO(true, resApplication, null);
        } catch (AccessDeniedException ade) {
            _log.error("User ID: " + userConnected.getEcasUsername() + "- You have no permissions to invalidate this application", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(0, ade.getMessage()));
        } catch (Exception e) {
            _log.error("User ID: " + userConnected.getEcasUsername() + "- Application cannot been invalidated", e.getMessage());
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, null);
        }
    }

    @ApiOperation(value = "Get applications by specific call and lau id")
    @RequestMapping(value = "/call/{callId}/lau/{lauId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<ApplicationDTO> getApplicationsByCallIdAndLauId(@PathVariable("callId") final Integer callId, @PathVariable("lauId") final Integer lauId, @RequestParam("currentDate") final Long currentDate, HttpServletResponse response) throws IOException {
        userContext = UserHolder.getUser();
        userConnected = userService.getUserByUserContext(userContext);
        try {
            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if (userDTO.getType() != 5) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            _log.info("User ID: " + userConnected.getEcasUsername() + "- Applications retrieved successfully");
            return applicationService.getApplicationsByCallIdAndLauId(callId, lauId);
        } catch (AccessDeniedException ade) {
            _log.error("User ID: " + userConnected.getEcasUsername() + "- You have no permissions to retrieve these applications", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
        } catch (Exception e) {
            _log.error("User ID: " + userConnected.getEcasUsername() + "- Applications cannot been retrieved", e.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
        }
        return null;
    }

    @ApiOperation(value = "Send legal documents correction request")
    @RequestMapping(value = "/sendLegalDocumentsCorrection", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO sendLegalDocumentsCorrection(@RequestBody final ApplicationDTO applicationDTO, HttpServletResponse response) throws IOException {
        userContext = UserHolder.getUser();
        userConnected = userService.getUserByUserContext(userContext);
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            ApplicationDTO resApplication = applicationService.sendLegalDocumentsCorrection(applicationDTO);
            _log.info("User ID: " + userConnected.getEcasUsername() + "- Legal documents correction request sent successfully");
            return new ResponseDTO(true, resApplication, null);
        } catch (AccessDeniedException ade) {
            _log.error("User ID: " + userConnected.getEcasUsername() + "- You have no permissions to request a legal documents' correction", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            _log.error("User ID: " + userConnected.getEcasUsername() + "- Request cannot been sent", e.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, null);
        }
    }

    @ApiOperation(value = "exportExcelDGConnApplicantsList")
    @RequestMapping(value = "/exportExcelDGConnApplicantsList", method = RequestMethod.POST, headers = "Accept=application/vnd.ms-excel", produces = "application/vnd.ms-excel")
    @ResponseBody
    public ResponseEntity<byte[]> exportExcelDGConnApplicantsList(@RequestParam("callId") final Integer callId, @RequestParam("country") final String country, HttpServletResponse response) throws IOException {
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            ResponseEntity<byte[]> responseReturn = null;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/vnd.ms-excel"));
            String filename = "dgconn-applicants.xls";
            headers.setContentDispositionFormData(filename, filename);
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
            responseReturn = new ResponseEntity<>(applicationService.exportExcelDGConnApplicantsList(callId, country), headers, HttpStatus.OK);
            _log.info("User ID: " + userConnected.getEcasUsername() + "- Excel exported successfully");
            return responseReturn;
        } catch (AccessDeniedException ade) {
            _log.error("User ID: " + userConnected.getEcasUsername() + "- You have no permissions to export the excel", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            _log.error("User ID: " + userConnected.getEcasUsername() + "- Excel cannot been exported", e.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        }
    }

    @ApiOperation(value = "exportExcelDGConnApplicantsListSearchingName")
    @RequestMapping(value = "/exportExcelDGConnApplicantsListSearchingName", method = RequestMethod.POST, headers = "Accept=application/vnd.ms-excel", produces = "application/vnd.ms-excel")
    @ResponseBody
    public ResponseEntity<byte[]> exportExcelDGConnApplicantsListSearchingName(@RequestParam("callId") final Integer callId, @RequestParam("country") final String country, @RequestParam("name") final String name, HttpServletResponse response) throws IOException {
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("");
            }
            ResponseEntity<byte[]> responseReturn = null;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/vnd.ms-excel"));
            String filename = "dgconn-applicants.xls";
            headers.setContentDispositionFormData(filename, filename);
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
            responseReturn = new ResponseEntity<>(applicationService.exportExcelDGConnApplicantsListContainingName(callId, country, name), headers, HttpStatus.OK);
            _log.info("User ID: " + userConnected.getEcasUsername() + "- Excel exported successfully");
            return responseReturn;
        } catch (AccessDeniedException ade) {
            _log.error("User ID: " + userConnected.getEcasUsername() + "- You have no permissions to export the excel", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            _log.error("User ID: " + userConnected.getEcasUsername() + "- Excel cannot been exported", e.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        }
    }
}