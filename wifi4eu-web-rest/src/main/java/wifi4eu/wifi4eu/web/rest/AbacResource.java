package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import wifi4eu.wifi4eu.service.abac.AbacService;

import javax.json.JsonObject;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jmagrinc on 08/05/2017.
 */
@CrossOrigin(origins = "*")
@Controller
@Api(value = "/abac", description = "AbacResource")
@RequestMapping("abac")
public class AbacResource {
    Logger _log = Logger.getLogger(AbacResource.class);

    @Autowired
    private AbacService abacService;

    @ApiOperation(value = "Export Suppliers and Beneficiaries information.")
    @RequestMapping(value = "/exportAbacInformation", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String exportAbacInformation(HttpServletResponse response) {
        _log.info("exportAbacInformation");
        response.setHeader("Content-Disposition", "form-data; name=\"abacExportInformation.json\"; filename=\"abacExportInformation.json\"");
        response.setHeader("Content-Type", "application/json;charset=ISO-8859-1");
        response.setHeader("Pragma", "no-cache");
        return abacService.exportAbacInformation().toString();
    }
}
