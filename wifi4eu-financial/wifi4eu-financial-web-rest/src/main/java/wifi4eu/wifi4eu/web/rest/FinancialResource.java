package wifi4eu.wifi4eu.web.rest;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.financial.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


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
    @RequestMapping(value = "/exportAbacInformation", method = RequestMethod.GET, produces = "application/JSON")
    @ResponseBody
    public ResponseDTO exportAbacInformation(final HttpServletResponse response) {
        _log.info("exportAbacInformation");
        return financialService.exportAbacInformation();
    }

    @ApiOperation(value = "LE Search.")
    @RequestMapping(value = "/leSearch", method = RequestMethod.GET, produces = "application/JSON")
    @ResponseBody
    public ResponseDTO leSearch(final HttpServletResponse response) {
        _log.info("leSearch");
        try {
            String result = LegalEntitySync.leSearch();

            if (!result.isEmpty()) {
                return new ResponseDTO(true, result, null);
            } else {
                return new ResponseDTO(false, "Something went wrong", new ErrorDTO(0, "Can not connect to mock"));
            }

        } catch (IOException e) {
            return new ResponseDTO(false, "Something went wrong", new ErrorDTO(0, e.getStackTrace().toString()));
        }

    }

    @ApiOperation(value = "BC Search.")
    @RequestMapping(value = "/bcSearch", method = RequestMethod.GET, produces = "application/JSON")
    @ResponseBody
    public ResponseDTO bcSearch(final HttpServletResponse response) {
        _log.info("bcSearch");
        try {
            String result = BudgetaryCommitmentSync.bcSearch();

            if (!result.isEmpty()) {
                return new ResponseDTO(true, result, null);
            } else {
                return new ResponseDTO(false, "Something went wrong", new ErrorDTO(0, "Can not connect to mock"));
            }

        } catch (IOException e) {
            return new ResponseDTO(false, "Something went wrong", new ErrorDTO(0, e.getStackTrace().toString()));
        }

    }

    @ApiOperation(value = "LE Create.")
    @RequestMapping(value = "/leCreate", method = RequestMethod.GET, produces = "application/JSON")
    @ResponseBody
    public ResponseDTO leCreate(final HttpServletResponse response) {
        _log.info("leCreate");
        try {
            String result = LegalEntityAsync.leCreate();

            if (!result.isEmpty()) {
                return new ResponseDTO(true, result, null);
            } else {
                return new ResponseDTO(false, "Something went wrong", new ErrorDTO(0, "Can not connect to mock"));
            }

        } catch (IOException e) {
            return new ResponseDTO(false, "Something went wrong", new ErrorDTO(0, e.getStackTrace().toString()));
        }

    }


    @ApiOperation(value = "BC Create.")
    @RequestMapping(value = "/bcCreate", method = RequestMethod.GET, produces = "application/JSON")
    @ResponseBody
    public ResponseDTO bcCreate(final HttpServletResponse response) {
        _log.info("bcCreate");
        try {
            String result = BudgetaryCommitmentAsync.bcCreate();

            if (!result.isEmpty()) {
                return new ResponseDTO(true, result, null);
            } else {
                return new ResponseDTO(false, "Something went wrong", new ErrorDTO(0, "Can not connect to mock"));
            }

        } catch (IOException e) {
            return new ResponseDTO(false, "Something went wrong", new ErrorDTO(0, e.getStackTrace().toString()));
        }

    }
}



