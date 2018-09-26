package wifi4eu.wifi4eu.web.cnect.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.reporting.ReportingService;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/reporting", description = "Reporting System")
@RequestMapping("reporting")
public class ReportingResource {

    @Autowired
    ReportingService reportingService;

    @ApiOperation(value = "Call Open")
    @RequestMapping(value  = "/call-open", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO generateCallOpenReport(){
        return reportingService.generateCallOpenReport();
    }

    @ApiOperation(value = "Pre Selection Lisr")
    @RequestMapping(value  = "/pre-selection", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO generatePreSelectionReport(){
        return reportingService.generatePreSelectionReport();
    }

    @ApiOperation(value = "Notifications Sent Out")
    @RequestMapping(value  = "/notifications-sent-out", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO generateNotificationsSentOutReport(){
        return reportingService.generateNotificationSentOutReport();
    }

    @ApiOperation(value = "KPI - Time to Inform")
    @RequestMapping(value  = "/time-to-inform", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO generateTimeToInformReport(){
        return reportingService.generateTimeToInformReport();
    }

    @ApiOperation(value = "Types IR")
    @RequestMapping(value  = "/types-ir", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO generateTypesInstallationReport(){
        return reportingService.generateTypesInstallationReport();
    }

}
