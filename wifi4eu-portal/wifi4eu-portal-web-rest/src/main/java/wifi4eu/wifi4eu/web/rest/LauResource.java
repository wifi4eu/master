package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.LauDTO;
import wifi4eu.wifi4eu.service.location.LauService;

import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/lau", description = "Lau object REST API services")
@RequestMapping("lau")
public class LauResource {
    @Autowired
    LauService lauService;

    Logger _log = LoggerFactory.getLogger(LauResource.class);

    @ApiOperation(value = "Get lau by specific id")
    @RequestMapping(value = "/{lauId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public LauDTO getLauById(@PathVariable("lauId") final Integer lauId) {
        _log.info("getLauById: " + lauId);
        return lauService.getLauById(lauId);
    }

    @ApiOperation(value = "Get lau by countryCode and lau2")
    @RequestMapping(value = "/countryCode/{countryCode}/lau2/{lau2}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public LauDTO getLauByCountryCodeAndLau2(@PathVariable("countryCode") final String countryCode, @PathVariable("lau2") final String lau2) {
        _log.info("getLauByCountryCodeAndLau2: " + countryCode + " | " + lau2);
        return lauService.getLauByCountryCodeAndLau2(countryCode, lau2);
    }

    @ApiOperation(value = "Get laus by countryCode")
    @RequestMapping(value = "/countryCode/{countryCode}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<LauDTO> getLausByCountryCode(@PathVariable("countryCode") final String countryCode) {
        _log.info("getLausByCountryCode: " + countryCode);
        return lauService.getLausByCountryCode(countryCode);
    }

    @ApiOperation(value = "Get laus by nuts3")
    @RequestMapping(value = "/nuts3/{nuts3}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<LauDTO> getLausByNuts3(@PathVariable("nuts3") final String nuts3) {
        _log.info("getLausByNuts3: " + nuts3);
        return lauService.getLausByNuts3(nuts3);
    }
}