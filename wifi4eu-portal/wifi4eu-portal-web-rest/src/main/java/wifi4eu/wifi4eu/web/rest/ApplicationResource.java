package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import wifi4eu.wifi4eu.entity.security.RightConstants;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.user.UserService;

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

    Logger _log = LoggerFactory.getLogger(ApplicationResource.class);

    @ApiOperation(value = "Get application by call and registration id")
    @RequestMapping(value = "/call/{callId}/registration/{registrationId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ApplicationDTO getApplicationByCallIdAndRegistrationId(@PathVariable("callId") final Integer callId, @PathVariable("registrationId") final Integer registrationId, HttpServletResponse response) throws IOException {
        if (_log.isInfoEnabled()) {
            _log.info("getApplicationByCall: " + callId + " & Registration: " + registrationId);
        }

        try {
            permissionChecker.check(RightConstants.REGISTRATIONS_TABLE + registrationId);
        } catch (Exception e) {
            response.sendError(HttpStatus.NOT_FOUND.value());
        }

        ApplicationDTO responseApp = applicationService.getApplicationByCallIdAndRegistrationId(callId, registrationId);
        if (responseApp == null) {
            responseApp = new ApplicationDTO();
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
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }

            if (_log.isInfoEnabled()) {
                _log.info("getApplicationsVoucherInfoByCall: " + callId);
            }
            return applicationService.getApplicationsVoucherInfoByCall(callId);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.info("getApplicationsVoucherInfoByCall: " + callId);
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
        try {

            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if (userDTO.getType() != 5) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }

            ResponseDTO res = new ResponseDTO(true, null, null);
            res.setData(applicationService.findDgconnApplicantsList(callId, country, null, pagingSortingData));
            res.setXTotalCount(municipalityService.getCountDistinctMunicipalitiesThatAppliedCall(callId, country));
            return res;
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("can't retrieve applicants", e);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "findDgconnApplicantsListByCallIdSearchingName")
    @RequestMapping(value = "/findDgconnApplicantsListByCallIdSearchingName/{callId}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO findDgconnApplicantsListByCallIdSearchingName(@PathVariable("callId") final Integer callId, @RequestParam("country") final String country, @RequestParam("name") final String name,
                                                                     @RequestBody final PagingSortingDTO pagingSortingData, HttpServletResponse response) throws IOException {
        try {

            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if (userDTO.getType() != 5) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }

            ResponseDTO res = new ResponseDTO(true, null, null);
            res.setData(applicationService.findDgconnApplicantsList(callId, country, name, pagingSortingData));
            res.setXTotalCount(municipalityService.getCountDistinctMunicipalitiesThatAppliedCallContainingName(callId, country, name));
            return res;
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("can't retrieve applicants", e);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
        }
        return new ResponseDTO(false, null, null);
    }

    @ApiOperation(value = "Validate application")
    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO validateApplication(@RequestBody final ApplicationDTO applicationDTO, HttpServletResponse response) throws IOException {
        try {
            if (_log.isInfoEnabled()) {
                _log.info("validateApplication");
            }

            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if (userDTO.getType() != 5) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }

            ApplicationDTO resApplication = applicationService.validateApplication(applicationDTO);
            return new ResponseDTO(true, resApplication, null);
        } catch (AccessDeniedException e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'validateApplication' operation.", e);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'validateApplication' operation.", e);
            }
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "Get applications voucher2 info by call id")
    @RequestMapping(value = "/valid/call/{callId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Integer getApplicationsNotInvalidated(@PathVariable("callId") final Integer callId) {
        try {
            if (_log.isInfoEnabled()) {
                _log.info("getApplicationsVoucherInfoByCall: " + callId);
            }
            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if (userDTO.getType() != 5) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }

            return applicationService.countApplicationsNotInvalidated(callId);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.info("getApplicationsVoucherInfoByCall: " + callId);
            }
            return null;
        }
    }

    @ApiOperation(value = "Invalidate application")
    @RequestMapping(value = "/invalidate", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO invalidateApplication(@RequestBody final ApplicationDTO applicationDTO, HttpServletResponse response) throws IOException {
        try {
            if (_log.isInfoEnabled()) {
                _log.info("invalidateApplication");
            }

            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if (userDTO.getType() != 5) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }

            ApplicationDTO resApplication = applicationService.invalidateApplication(applicationDTO);
            return new ResponseDTO(true, resApplication, null);
        } catch (AccessDeniedException e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'invalidateApplication' operation.", e);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'invalidateApplication' operation.", e);
            }
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, null);
        }
    }

    @ApiOperation(value = "Get applications by specific call and lau id")
    @RequestMapping(value = "/call/{callId}/lau/{lauId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<ApplicationDTO> getApplicationsByCallIdAndLauId(@PathVariable("callId") final Integer callId, @PathVariable("lauId") final Integer lauId, @RequestParam("currentDate") final Long currentDate, HttpServletResponse response) throws IOException {
        if (_log.isInfoEnabled()) {
            _log.info("getApplicationsByCallIdAndLauId");
        }

        try {
            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if (userDTO.getType() != 5) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            return applicationService.getApplicationsByCallIdAndLauId(callId, lauId);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'getApplicationsByCallIdAndLauId' operation.", e);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
        }
        return null;
    }

    @ApiOperation(value = "Send legal documents correction request")
    @RequestMapping(value = "/sendLegalDocumentsCorrection", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO sendLegalDocumentsCorrection(@RequestBody final ApplicationDTO applicationDTO, HttpServletResponse response) throws IOException {
        try {
            if (_log.isInfoEnabled()) {
                _log.info("sendLegalDocumentsCorrection");
            }
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("");
            }
            ApplicationDTO resApplication = applicationService.sendLegalDocumentsCorrection(applicationDTO);
            return new ResponseDTO(true, resApplication, null);
        } catch (AccessDeniedException ade) {
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'sendLegalDocumentsCorrection' operation.", e);
            }
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
                throw new AccessDeniedException("");
            }
            ResponseEntity<byte[]> responseReturn = null;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/vnd.ms-excel"));
            String filename = "dgconn-applicants.xls";
            headers.setContentDispositionFormData(filename, filename);
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
            responseReturn = new ResponseEntity<>(applicationService.exportExcelDGConnApplicantsList(callId, country), headers, HttpStatus.OK);
            return responseReturn;
        } catch (AccessDeniedException ade) {
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
            return responseReturn;
        } catch (AccessDeniedException ade) {
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        }
    }

    @ApiOperation(value = "Send request correction e-mails for a specific call")
    @RequestMapping(value = "/sendCorrectionEmails", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO sendCorrectionEmails(@RequestParam("callId") final Integer callId, HttpServletResponse response) throws IOException {
        try {
            if (_log.isInfoEnabled()) {
                _log.info("sendCorrectionEmails");
            }
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("");
            }
            CorrectionRequestEmailDTO correctionRequest = applicationService.sendCorrectionEmails(callId);
            return new ResponseDTO(true, correctionRequest, null);
        } catch (AccessDeniedException ade) {
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(0, ade.getMessage()));
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'sendCorrectionEmails' operation.", e);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "Get the last correction request email information")
    @RequestMapping(value = "/getLastCorrectionRequestEmail", method = RequestMethod.POST)
    @ResponseBody
    public CorrectionRequestEmailDTO getLastCorrectionRequestEmail(@RequestParam("callId") final Integer callId, HttpServletResponse response) throws IOException {
        try {
            if (_log.isInfoEnabled()) {
                _log.info("getLastCorrectionRequestEmail");
            }
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("");
            }
            return applicationService.getLastCorrectionRequestEmailInCall(callId);
        } catch (AccessDeniedException ade) {
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'getLastCorrectionRequestEmail' operation.", e);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        }
    }

    @ApiOperation(value = "Check if whether the correction request email option is available for a specific call")
    @RequestMapping(value = "/checkIfCorrectionRequestEmailIsAvailable", method = RequestMethod.POST)
    @ResponseBody
    public boolean checkIfCorrectionRequestEmailIsAvailable(@RequestParam("callId") final Integer callId, HttpServletResponse response) throws IOException {
        try {
            if (_log.isInfoEnabled()) {
                _log.info("checkIfCorrectionRequestEmailIsAvailable");
            }
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("");
            }
            return applicationService.checkIfCorrectionRequestEmailIsAvailable(callId);
        } catch (AccessDeniedException ade) {
            response.sendError(HttpStatus.NOT_FOUND.value());
            return false;
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'checkIfCorrectionRequestEmailIsAvailable' operation.", e);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
            return false;
        }
    }

    @ApiOperation(value = "Reject application")
    @RequestMapping(value = "/reject", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO rejectApplicationVoucherAssigment(@RequestBody final Integer applicationId, HttpServletResponse response) throws IOException {
        try {
            if (_log.isInfoEnabled()) {
                _log.info("rejectApplicationVoucherAssigment");
            }

            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if (userDTO.getType() != 5) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }

            ApplicationDTO resApplication = applicationService.rejectApplicationVoucherAssigment(applicationId);
            return new ResponseDTO(true, resApplication, null);
        } catch (AccessDeniedException e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'rejectApplicationVoucherAssigment' operation.", e);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'rejectApplicationVoucherAssigment' operation.", e);
            }
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, null);
        }
    }

    @ApiOperation(value = "Reject application")
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO selectApplicationVoucherAssigment(@RequestBody final Integer applicationId, HttpServletResponse response) throws IOException {
        try {
            if (_log.isInfoEnabled()) {
                _log.info("selectApplicationVoucherAssigment");
            }

            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if (userDTO.getType() != 5) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }

            ApplicationDTO resApplication = applicationService.selectApplicationVoucherAssigment(applicationId);
            return new ResponseDTO(true, resApplication, null);
        } catch (AccessDeniedException e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'selectApplicationVoucherAssigment' operation.", e);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'selectApplicationVoucherAssigment' operation.", e);
            }
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, null);
        }
    }
}