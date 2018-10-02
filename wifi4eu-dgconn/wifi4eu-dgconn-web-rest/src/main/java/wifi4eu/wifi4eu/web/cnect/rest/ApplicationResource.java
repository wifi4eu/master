package wifi4eu.wifi4eu.web.cnect.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.entity.security.RightConstants;
import wifi4eu.wifi4eu.service.application.ApplicationAuthorizedPersonService;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    ApplicationAuthorizedPersonService applicationAuthorizedPersonService;

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

    @ApiOperation(value = "Get applications voucher info by call id")
    @RequestMapping(value = "/voucherInfo/call/{callId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<ApplicationVoucherInfoDTO> getApplicationsVoucherInfoByCall(@PathVariable("callId") final Integer callId, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting applications voucher by call id " + callId);
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }

            return applicationService.getApplicationsVoucherInfoByCall(callId);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Applications' voucher information not found on this call", e);
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
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting DGConn applicants by call id " + callId);
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }

            ResponseDTO res = new ResponseDTO(true, null, null);
            res.setData(applicationService.findDgconnApplicantsList(callId, country, null, pagingSortingData));
            res.setXTotalCount(municipalityService.getCountDistinctMunicipalitiesThatAppliedCall(callId, country));
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - The DGConn Applicants for this call are retrieved correctly");
            return res;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- The DGConn Applicants cannot be retrieved", e);
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "findDgconnApplicantsListByCallIdSearchingName")
    @RequestMapping(value = "/findDgconnApplicantsListByCallIdSearchingName/{callId}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO findDgconnApplicantsListByCallIdSearchingName(@PathVariable("callId") final Integer callId, @RequestParam("country") final String country, @RequestParam("name") final String name,
                                                                     @RequestBody final PagingSortingDTO pagingSortingData, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting DGConn applicants searching name by call id " + callId + ", country " + country + " and searching name " + name);
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }

            ResponseDTO res = new ResponseDTO(true, null, null);
            res.setData(applicationService.findDgconnApplicantsList(callId, country, name, pagingSortingData));
            res.setXTotalCount(municipalityService.getCountDistinctMunicipalitiesThatAppliedCallContainingName(callId, country, name));
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + "- DGConn Applicants' searching name retrieved correctly");
            return res;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- The applicants' searching name cannot be retrieved", e);
            response.sendError(HttpStatus.NOT_FOUND.value());
        }
        return new ResponseDTO(false, null, null);
    }

    @ApiOperation(value = "Get applications voucher2 info by call id")
    @RequestMapping(value = "/valid/call/{callId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Integer getApplicationsNotInvalidated(@PathVariable("callId") final Integer callId) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting applications voucher information by call id " + callId);
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }

            _log.info("ECAS Username: " + userConnected.getEcasUsername() + "- Applications not invalidated are retrieved successfully");
            return applicationService.countApplicationsNotInvalidated(callId);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to retrieve applications not validated", ade.getMessage());
            return null;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- Applications not validated cannot been retrieved", e);
            return null;
        }
    }

    @ApiOperation(value = "Get applications by specific call and lau id")
    @RequestMapping(value = "/call/{callId}/lau/{lauId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<ApplicationDTO> getApplicationsByCallIdAndLauId(@PathVariable("callId") final Integer callId, @PathVariable("lauId") final Integer lauId, @RequestParam("currentDate") final Long currentDate, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting applications by call id " + callId + " lau id" + lauId + " with date " + currentDate);
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }

            _log.info("ECAS Username: " + userConnected.getEcasUsername() + "- Applications retrieved successfully");
            return applicationService.getApplicationsByCallIdAndLauId(callId, lauId);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to retrieve these applications", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- Applications cannot been retrieved", e);
            response.sendError(HttpStatus.NOT_FOUND.value());
        }
        return null;
    }

    @ApiOperation(value = "Send legal documents correction request")
    @RequestMapping(value = "/sendLegalDocumentsCorrection", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO sendLegalDocumentsCorrection(@RequestBody final ApplicationDTO applicationDTO, HttpServletResponse response, HttpServletRequest request) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Sending legal documents' correction request");
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }

            ApplicationDTO resApplication = applicationService.sendLegalDocumentsCorrection(applicationDTO, request);
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + "- Legal documents correction request sent successfully");
            return new ResponseDTO(true, resApplication, null);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to request a legal documents' correction", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- Request cannot been sent", e);
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, null);
        }
    }

    @ApiOperation(value = "exportExcelDGConnApplicantsList")
    @RequestMapping(value = "/exportExcelDGConnApplicantsList", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO exportExcelDGConnApplicantsList(@RequestParam("callId") final Integer callId, @RequestParam("country") final String country, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Exporting Excel with DGConn Applicants by call id " + callId + " and country " + country);
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }

           /* ResponseEntity<byte[]> responseReturn = null;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/vnd.ms-excel"));
            String filename = "dgconn-applicants.xls";
            headers.setContentDispositionFormData(filename, filename);
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");*/
            applicationService.exportExcelDGConnApplicantsList(callId, country);
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + "- Excel export task is running successfully");
            return new ResponseDTO(true, null, null);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to export the excel", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- Excel cannot been exported", e.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        }
    }

    @ApiOperation(value = "exportExcelDGConnApplicantsListSearchingName")
    @RequestMapping(value = "/exportExcelDGConnApplicantsListSearchingName", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO exportExcelDGConnApplicantsListSearchingName(@RequestParam("callId") final Integer callId, @RequestParam("country") final String country, @RequestParam("name") final String name, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Exporting Excel with DGConn Applicants' searching name by call id " + callId + ",country " + country + " and searching name " + name);
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("");
            }

            /*ResponseEntity<byte[]> responseReturn = null;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/vnd.ms-excel"));
            String filename = "dgconn-applicants.xls";
            headers.setContentDispositionFormData(filename, filename);
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");*/
            applicationService.exportExcelDGConnApplicantsListContainingName(callId, country, name);
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + "- Excel export task is running successfully");
            return new ResponseDTO(true, null, null);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to export the excel", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- Excel cannot been exported", e);
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        }
    }

    @ApiOperation(value = "Send request correction e-mails for a specific call")
    @RequestMapping(value = "/sendCorrectionEmails", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO sendCorrectionEmails(@RequestParam("sendNotificationsPsswd") final String sendNotificationsPsswd, @RequestParam("callId") final Integer callId, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Sending request correction e-mails for call id " + callId);
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("");
            }

            ResponseDTO correctionRequest = applicationService.sendCorrectionEmails(sendNotificationsPsswd, callId);
            return correctionRequest;
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to send the request", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(0, ade.getMessage()));
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- Request cannot been sent", e);
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "Get the last correction request email information")
    @RequestMapping(value = "/getLastCorrectionRequestEmail", method = RequestMethod.POST)
    @ResponseBody
    public CorrectionRequestEmailDTO getLastCorrectionRequestEmail(@RequestParam("callId") final Integer callId, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Retrieving last request correction e-mail information for call id " + callId);
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("");
            }

            return applicationService.getLastCorrectionRequestEmailInCall(callId);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to retrieve the request", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- Request cannot been retrieved", e);
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        }
    }

    @ApiOperation(value = "Check if whether the correction request email option is available for a specific call")
    @RequestMapping(value = "/checkIfCorrectionRequestEmailIsAvailable", method = RequestMethod.POST)
    @ResponseBody
    public boolean checkIfCorrectionRequestEmailIsAvailable(@RequestParam("callId") final Integer callId, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Checking if the correction request email option is available for call id " + callId);
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("");
            }

            return applicationService.checkIfCorrectionRequestEmailIsAvailable(callId);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to check the option", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return false;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- Option cannot been checked", e);
            response.sendError(HttpStatus.NOT_FOUND.value());
            return false;
        }
    }

    @ApiOperation(value = "Reject application")
    @RequestMapping(value = "/reject", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO rejectApplicationVoucherAssigment(@RequestBody final Integer applicationId, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Rejecting application");
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }

            ApplicationDTO resApplication = applicationService.rejectApplicationVoucherAssigment(applicationId);
            return new ResponseDTO(true, resApplication, null);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to reject this application", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, null);
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- Application cannot been rejected", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, null);
        }
    }

    @ApiOperation(value = "Select application")
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO selectApplicationVoucherAssigment(@RequestBody final Integer applicationId, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Selecting application");
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }

            ApplicationDTO resApplication = applicationService.selectApplicationVoucherAssigment(applicationId);
            return new ResponseDTO(true, resApplication, null);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to select this application", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, null);
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- Application cannot been selected", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, null);
        }
    }

    @ApiOperation(value = "Select validated applications")
    @RequestMapping(value = "/valid-applications/{callId}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO countValidatedApplications(@PathVariable("callId") final Integer callId) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        ResponseDTO responseDTO = new ResponseDTO();
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Selecting validated applications");
        try {
            if (Validator.isNotNull(userConnected)) {
                if (permissionChecker.checkIfDashboardUser()) {
                    responseDTO.setSuccess(true);
                    responseDTO.setData(applicationService.getNumberOfValidatedApplications(callId));
                    _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - Validated applications retrieved correctly");
                } else {
                    responseDTO.setSuccess(false);
                    responseDTO.setData("");
                    responseDTO.setError(new ErrorDTO(401, "Access denied"));
                    _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Permission not found");
                }
            } else {
                responseDTO.setSuccess(false);
                responseDTO.setData("");
                responseDTO.setError(new ErrorDTO(404, "User not found"));
            }
        } catch (Exception e) {
            responseDTO.setSuccess(false);
            responseDTO.setData("");
            responseDTO.setError(new ErrorDTO(404, "Application not found"));
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- Validated applications cannot been retrieved", e);
        }
        return responseDTO;
    }

    @ApiOperation(value = "Download excel of the export of applicants list")
    @RequestMapping(value = "/downloadExportExcel", method = RequestMethod.POST, headers = "Accept=application/vnd.ms-excel", produces = "application/vnd.ms-excel")
    @ResponseBody
    public ResponseEntity<byte[]> downloadExportExcelApplicantsList(HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Exporting Excel with DGConn Applicants");
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("");
            }

            ResponseEntity<byte[]> responseReturn = null;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/vnd.ms-excel"));
            String filename = "dgconn-applicants_"+userConnected.getId()+".xls";
            headers.setContentDispositionFormData(filename, filename);
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
            responseReturn = new ResponseEntity<>(applicationService.downloadExportExcelApplicantsList(), headers, HttpStatus.OK);
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + "- Excel exported successfully");
            return responseReturn;
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to export the excel", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- Excel cannot been exported", e);
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        }
    }

}