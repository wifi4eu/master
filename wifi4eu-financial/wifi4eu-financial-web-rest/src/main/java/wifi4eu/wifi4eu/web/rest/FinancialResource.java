package wifi4eu.wifi4eu.web.rest;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.financial.FinancialService;

import javax.servlet.http.HttpServletResponse;


/**
 * Created by lviverof on 29/08/2017.
 */
@CrossOrigin(origins = "*")
@Controller
@Api(value = "/financial", description = "FinancialResource")
@RequestMapping("financial")
public class FinancialResource {
    Logger _log = Logger.getLogger(FinancialResource.class);

    @Autowired
    private FinancialService financialService;

    @ApiOperation(value = "Import JSON file.")
    @RequestMapping(value = "/importJson", method = RequestMethod.POST, produces = "application/JSON")
    @ResponseBody
    public String importJson(@RequestBody final String jsonStringFile, final HttpServletResponse response) {
        _log.info("importJson");
        return financialService.importJson(jsonStringFile);
    }

    @ApiOperation(value = "Export JSON file.")
    @RequestMapping(value = "/exportJson", method = RequestMethod.POST, produces = "application/JSON")
    @ResponseBody
    public String exportJson(final HttpServletResponse response) {
        _log.info("exportJson");
        return financialService.exportJson();
    }
}
