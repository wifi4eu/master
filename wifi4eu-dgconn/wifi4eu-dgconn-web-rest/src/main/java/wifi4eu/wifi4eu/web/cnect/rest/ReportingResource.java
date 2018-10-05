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
    private ReportingService reportingService;

    @ApiOperation(value = "Call Open")
    @RequestMapping(value  = "/call-open", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO generateCallOpenReport(){
        return reportingService.generateCallOpenReport();
    }

    @ApiOperation(value = "Types IR")
    @RequestMapping(value  = "/types-ir", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO generateTypesInstallationReport(){
        return reportingService.generateTypesInstallationReport();
    }

}
