package wifi4eu.pub.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.MunicipalityCacheDTO;
import wifi4eu.wifi4eu.common.dto.model.MunicipalityDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;

import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/municipality", description = "Municipality object REST API services")
@RequestMapping("municipality")
public class MunicipalityResource {
    @Autowired
    private MunicipalityService municipalityService;

    Logger _log = LoggerFactory.getLogger(MunicipalityResource.class);

    @ApiOperation(value = "Get municipality by specific id")
    @RequestMapping(value = "/{municipalityId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public MunicipalityDTO getMunicipalityById(@PathVariable("municipalityId") final Integer municipalityId) {
        _log.info("getMunicipalityById: " + municipalityId);
        return municipalityService.getMunicipalityById(municipalityId);
    }

    @ApiOperation(value = "Get municipalities grouped by lau id")
    @RequestMapping(value = "/groupedByLauId", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO getMunicipalitiesCountGroupedByLauId() {
        if (_log.isInfoEnabled()) {
            _log.info("getMunicipalitiesGroupedByLauId");
        }
        return new ResponseDTO(true, municipalityService.getMunicipalitiesCountGroupedByLauId(), null);
    }

    @ApiOperation(value = "Get municipalities of region")
    @RequestMapping(value = "/region/{code}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public MunicipalityCacheDTO getMunicipalitiesRegistered(@PathVariable("code") final String code) {
        _log.info("getMunicipalitiesRegisteredByRegion " + code);
        return municipalityService.getMunicipalitiesRegisteredByRegion(code);
    }

    @ApiOperation(value = "Get municipalities by country")
    @RequestMapping(value = "/country/{countryCode}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public MunicipalityCacheDTO getMunicipalitiesRegisteredByCountry(@PathVariable("countryCode") final String code) {
        _log.info("getMunicipalitiesRegisteredByRegion " + code);
        return municipalityService.getMunicipalitiesByCountry(code);
    }
}