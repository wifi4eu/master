package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.abac.AbacService;

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
    public ResponseDTO exportAbacInformation(HttpServletResponse response) {
        _log.info("exportAbacInformation");

        response.setHeader("Content-Disposition", "form-data; name=\"abacExportInformation.json\"; filename=\"abacExportInformation.json\"");
        response.setHeader("Content-Type", "application/json;charset=ISO-8859-1");
        response.setHeader("Pragma", "no-cache");

        return abacService.exportAbacInformation();
    }

    @ApiOperation(value = "Imports ABAC information")
    @RequestMapping(value = "/importAbacInformation", method = RequestMethod.POST, produces = "application/JSON")
    @ResponseBody
    public ResponseDTO importAbacInformation(@RequestBody final String jsonStringFile, final HttpServletResponse response) {
        return abacService.processAbacInformation(jsonStringFile);
    }

    @ApiOperation(value = "Returns information about the state of the applications for a given Publication")
    @RequestMapping(value = "/publications/{publicationId}", method = RequestMethod.GET, produces = "application/JSON")
    @ResponseBody
    public ResponseDTO getPublicationAppliersInfo(@PathVariable("publicationId") final Long publicationId, final HttpServletResponse response) {
        return abacService.getPublicationAppliersInfo(publicationId);
    }

}
