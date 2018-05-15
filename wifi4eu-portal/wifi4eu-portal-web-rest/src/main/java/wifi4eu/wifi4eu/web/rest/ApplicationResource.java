package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.ApplicantListItemDTO;
import wifi4eu.wifi4eu.common.dto.model.ApplicationDTO;
import wifi4eu.wifi4eu.common.dto.model.ApplicationVoucherInfoDTO;
import wifi4eu.wifi4eu.common.dto.model.PagingSortingDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;

import javax.servlet.http.HttpServletResponse;
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

    Logger _log = LoggerFactory.getLogger(ApplicationResource.class);

    @ApiOperation(value = "Get all the applications")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<ApplicationDTO> allApplications() {
        if (_log.isInfoEnabled()) {
            _log.info("allApplications");
        }
        return applicationService.getAllApplications();
    }

    @ApiOperation(value = "Get application by specific id")
    @RequestMapping(value = "/{applicationId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ApplicationDTO getApplicationById(@PathVariable("applicationId") final Integer applicationId) {
        if (_log.isInfoEnabled()) {
            _log.info("getApplicationById: " + applicationId);
        }
        return applicationService.getApplicationById(applicationId);
    }

    @ApiOperation(value = "Create application")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO createApplication(@RequestBody final ApplicationDTO applicationDTO) {
        try {
            if (_log.isInfoEnabled()) {
                _log.info("createApplication");
            }
            ApplicationDTO resApplication = applicationService.createApplication(applicationDTO);
            return new ResponseDTO(true, resApplication, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'createApplication' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "Delete application by specific id")
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseDTO deleteApplication(@RequestBody final Integer applicationId) {
        try {
            if (_log.isInfoEnabled()) {
                _log.info("deleteApplication: " + applicationId);
            }
            ApplicationDTO resApplication = applicationService.deleteApplication(applicationId);
            return new ResponseDTO(true, resApplication, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'deleteApplication' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "Get applications by specific supplier id")
    @RequestMapping(value = "/supplier/{supplierId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<ApplicationDTO> getApplicationsBySupplierId(@PathVariable("supplierId") final Integer supplierId) {
        if (_log.isInfoEnabled()) {
            _log.info("getApplicationsBySupplierId");
        }
        return applicationService.getApplicationsBySupplierId(supplierId);
    }

    @ApiOperation(value = "Get application by call and registration id")
    @RequestMapping(value = "/call/{callId}/registration/{registrationId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ApplicationDTO getApplicationByCallIdAndRegistrationId(@PathVariable("callId") final Integer callId, @PathVariable("registrationId") final Integer registrationId) {
        if (_log.isInfoEnabled()) {
            _log.info("getApplicationByCall: " + callId + " & Registration: " + registrationId);
        }

        ApplicationDTO response = applicationService.getApplicationByCallIdAndRegistrationId(callId, registrationId);
        if (response == null) {
            response = new ApplicationDTO();
        }
        return response;
    }

    @ApiOperation(value = "Get applications voucher info by call id")
    @RequestMapping(value = "/voucherInfo/call/{callId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<ApplicationVoucherInfoDTO> getApplicationsVoucherInfoByCall(@PathVariable("callId") final Integer callId) {
        try {
            if (_log.isInfoEnabled()) {
                _log.info("getApplicationsVoucherInfoByCall: " + callId);
            }
            return applicationService.getApplicationsVoucherInfoByCall(callId);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.info("getApplicationsVoucherInfoByCall: " + callId);
            }
            return null;
        }
    }

    @ApiOperation(value = "Get applications voucher info by call id")
    @RequestMapping(value = "/voucherInfo/application/{applicationId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ApplicationVoucherInfoDTO getApplicationsVoucherInfoByApplication(@PathVariable("applicationId") final Integer applicationId) {
        try {
            if (_log.isInfoEnabled()) {
                _log.info("getApplicationsVoucherInfoByApplication: " + applicationId);
            }
            return applicationService.getApplicationsVoucherInfoByApplication(applicationId);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.info("getApplicationsVoucherInfoByApplication: " + applicationId);
            }
            return null;
        }
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
    public ResponseDTO findDgconnApplicantsListByCallId(@PathVariable("callId") final Integer callId, @RequestParam("country") final String country, @RequestBody final PagingSortingDTO pagingSortingData) {
        try {
            ResponseDTO res = new ResponseDTO(true, null, null);
            res.setData(applicationService.findDgconnApplicantsList(callId, country,null, pagingSortingData));
            res.setXTotalCount(municipalityService.getCountDistinctMunicipalitiesThatAppliedCall(callId, country));
            return res;
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("can't retrieve applicants", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "findDgconnApplicantsListByCallIdSearchingName")
    @RequestMapping(value = "/findDgconnApplicantsListByCallIdSearchingName/{callId}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO findDgconnApplicantsListByCallIdSearchingName(@PathVariable("callId") final Integer callId, @RequestParam("country") final String country, @RequestParam("name") final String name, @RequestBody final PagingSortingDTO pagingSortingData) {
        try {
            ResponseDTO res = new ResponseDTO(true, null, null);
            res.setData(applicationService.findDgconnApplicantsList(callId, country, name, pagingSortingData));
            res.setXTotalCount(municipalityService.getCountDistinctMunicipalitiesThatAppliedCallContainingName(callId, country, name));
            return res;
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("can't retrieve beneficiaries", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "Validate application")
    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO validateApplication(@RequestBody final ApplicationDTO applicationDTO) {
        try {
            if (_log.isInfoEnabled()) {
                _log.info("validateApplication");
            }
            ApplicationDTO resApplication = applicationService.validateApplication(applicationDTO);
            return new ResponseDTO(true, resApplication, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'validateApplication' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "Invalidate application")
    @RequestMapping(value = "/invalidate", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO invalidateApplication(@RequestBody final ApplicationDTO applicationDTO) {
        try {
            if (_log.isInfoEnabled()) {
                _log.info("invalidateApplication");
            }
            ApplicationDTO resApplication = applicationService.invalidateApplication(applicationDTO);
            return new ResponseDTO(true, resApplication, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'invalidateApplication' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "Get applications by specific call and lau id")
    @RequestMapping(value = "/call/{callId}/lau/{lauId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<ApplicationDTO> getApplicationsByCallIdAndLauId(@PathVariable("callId") final Integer callId, @PathVariable("lauId") final Integer lauId, @RequestParam("currentDate") final Long currentDate) {
        if (_log.isInfoEnabled()) {
            _log.info("getApplicationsByCallIdAndLauId");
        }
        return applicationService.getApplicationsByCallIdAndLauId(callId, lauId);
    }

    @ApiOperation(value = "Send legal documents correction request")
    @RequestMapping(value = "/sendLegalDocumentsCorrection", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO sendLegalDocumentsCorrection(@RequestBody final ApplicationDTO applicationDTO) {
        try {
            if (_log.isInfoEnabled()) {
                _log.info("sendLegalDocumentsCorrection");
            }
            ApplicationDTO resApplication = applicationService.sendLegalDocumentsCorrection(applicationDTO);
            return new ResponseDTO(true, resApplication, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'sendLegalDocumentsCorrection' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "exportExcelDGConnApplicantsList")
    @RequestMapping(value = "/exportExcelDGConnApplicantsList", method = RequestMethod.POST, headers = "Accept=application/vnd.ms-excel", produces = "application/vnd.ms-excel")
    @ResponseBody
    public ResponseEntity<byte[]> exportExcelDGConnApplicantsList(@RequestParam("callId") final Integer callId, @RequestParam("country") final String country) {
        ResponseEntity<byte[]> responseReturn = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/vnd.ms-excel"));
        String filename = "dgconn-applicants.xls";
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        responseReturn = new ResponseEntity<>(applicationService.exportExcelDGConnApplicantsList(callId, country), headers, HttpStatus.OK);
        return responseReturn;
    }

    @ApiOperation(value = "exportExcelDGConnApplicantsListSearchingName")
    @RequestMapping(value = "/exportExcelDGConnApplicantsListSearchingName", method = RequestMethod.POST, headers = "Accept=application/vnd.ms-excel", produces = "application/vnd.ms-excel")
    @ResponseBody
    public ResponseEntity<byte[]> exportExcelDGConnApplicantsListSearchingName(@RequestParam("callId") final Integer callId, @RequestParam("country") final String country, @RequestParam("name") final String name) {
        ResponseEntity<byte[]> responseReturn = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/vnd.ms-excel"));
        String filename = "dgconn-applicants.xls";
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        responseReturn = new ResponseEntity<>(applicationService.exportExcelDGConnApplicantsListContainingName(callId, country, name), headers, HttpStatus.OK);
        return responseReturn;
    }
}