package wifi4eu.pub.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.NutsDTO;
import wifi4eu.wifi4eu.service.location.NutsService;

import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/nuts", description = "Nuts object REST API services")
@RequestMapping("nuts")
public class NutsResource {

    @Autowired
    NutsService nutsService;

    Logger _log = LogManager.getLogger(NutsResource.class);

    @ApiOperation(value = "getNuts")
    @RequestMapping(value = "/getNuts", method = RequestMethod.GET)
    @ResponseBody
    public NutsDTO getNuts() {
        return new NutsDTO();
    }

    @ApiOperation(value = "Get all nuts from a specific level")
    @RequestMapping(value = "/level/{level}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<NutsDTO> getNutsByLevel(@PathVariable("level") final Integer level) {
        if (_log.isInfoEnabled()) {
            _log.info("getNutsByLevel " + level);
        }
        return nutsService.getNutsByLevel(level);
    }

    @ApiOperation(value = "Get all nuts from a specific countryCode")
    @RequestMapping(value = "/countryCode/{countryCode}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<NutsDTO> getNutsByCountryCode(@PathVariable("countryCode") final String countryCode) {
        if (_log.isInfoEnabled()) {
            _log.info("getNutsByCountryCode " + countryCode);
        }
        return nutsService.getNutsByCountryCode(countryCode);
    }

    @ApiOperation(value = "Get all nuts from a specific countryCode and level order by Label Asc")
    @RequestMapping(value = "/countryCode/{countryCode}/level/{level}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<NutsDTO> getNutsByCountryCodeAndLevelOrderByLabelAsc(@PathVariable("countryCode") final String countryCode, @PathVariable("level") final Integer level) {
        if (_log.isInfoEnabled()) {
            _log.info("getNutsByCountryCodeAndLevel " + countryCode + " " + level);
        }
        return nutsService.getNutsByCountryCodeAndLevelOrderByLabelAsc(countryCode, level);
    }
}