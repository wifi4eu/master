package wifi4eu.wifi4eu.web.rest;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
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
    public ResponseDTO importJson(@RequestBody final String jsonStringFile, final HttpServletResponse response) {
        _log.info("importJson");
        if (financialService.importJson(jsonStringFile)) {
            return new ResponseDTO(true, "Import succesful!", null);
        } else {
            return new ResponseDTO(false, "Something went wrong", new ErrorDTO(0, "Import failed"));
        }
    }

    @ApiOperation(value = "Export JSON file.")
    @RequestMapping(value = "/exportJson", method = RequestMethod.GET, produces = "application/JSON")
    @ResponseBody
    public ResponseDTO exportJson(final HttpServletResponse response) {
        _log.info("exportJson");
        String result = financialService.exportJson();
        if (!result.isEmpty()) {
            return new ResponseDTO(true, result, null);
        } else {
            return new ResponseDTO(false, "Something went wrong", new ErrorDTO(0, "Import failed"));
        }
    }
}
