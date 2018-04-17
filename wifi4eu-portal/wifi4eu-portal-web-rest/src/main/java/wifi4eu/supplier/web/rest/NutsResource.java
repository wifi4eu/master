package wifi4eu.supplier.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger _log = LoggerFactory.getLogger(LauResource.class);

    @ApiOperation(value = "Get all nuts")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-API", value = "public", required = false, allowMultiple = false, dataType = "string", paramType = "header")
    })
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<NutsDTO> allNuts() {
        _log.info("allNuts");
        return nutsService.getAllNuts();
    }

    @ApiOperation(value = "get nuts by specific id")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-API", value = "public", required = false, allowMultiple = false, dataType = "string", paramType = "header")
    })
    @RequestMapping(value = "/{nutsId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public NutsDTO getNutsById(@PathVariable("nutsId") final Integer nutsId) {
        _log.info("getNutsById " + nutsId);
        return nutsService.getNutsById(nutsId);
    }

    @ApiOperation(value = "get nuts by code")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-API", value = "public", required = false, allowMultiple = false, dataType = "string", paramType = "header")
    })
    @RequestMapping(value = "/code/{code}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public NutsDTO getNutsByCode(@PathVariable("code") final String code) {
        _log.info("getNutsByCode " + code);
        return nutsService.getNutsByCode(code);
    }

    @ApiOperation(value = "Get all nuts from a specific level")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-API", value = "public", required = false, allowMultiple = false, dataType = "string", paramType = "header")
    })
    @RequestMapping(value = "/level/{level}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<NutsDTO> getNutsByLevel(@PathVariable("level") final Integer level) {
        _log.info("getNutsByLevel " + level);
        return nutsService.getNutsByLevel(level);
    }

    @ApiOperation(value = "Get all nuts from a specific countryCode")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-API", value = "public", required = false, allowMultiple = false, dataType = "string", paramType = "header")
    })
    @RequestMapping(value = "/countryCode/{countryCode}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<NutsDTO> getNutsByCountryCode(@PathVariable("countryCode") final String countryCode) {
        _log.info("getNutsByCountryCode " + countryCode);
        return nutsService.getNutsByCountryCode(countryCode);
    }

    @ApiOperation(value = "Get all nuts from a specific countryCode and level order by Label Asc")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-API", value = "public", required = false, allowMultiple = false, dataType = "string", paramType = "header")
    })
    @RequestMapping(value = "/countryCode/{countryCode}/level/{level}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<NutsDTO> getNutsByCountryCodeAndLevelOrderByLabelAsc(@PathVariable("countryCode") final String countryCode, @PathVariable("level") final Integer level) {
        _log.info("getNutsByCountryCodeAndLevelOrderByLabelAsc " + countryCode + level);
        return nutsService.getNutsByCountryCodeAndLevelOrderByLabelAsc(countryCode, level);
    }
}