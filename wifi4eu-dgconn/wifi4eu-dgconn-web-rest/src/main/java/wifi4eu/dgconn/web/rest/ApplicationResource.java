package wifi4eu.dgconn.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.ApplicationDTO;
import wifi4eu.wifi4eu.common.dto.model.ApplicationVoucherInfoDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.application.ApplicationService;

import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/application", description = "Application object REST API services")
@RequestMapping("application")
public class ApplicationResource {
    @Autowired
    ApplicationService applicationService;

    Logger _log = LogManager.getLogger(ApplicationResource.class);

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
        return applicationService.getApplicationByCallIdAndRegistrationId(callId, registrationId);
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
}