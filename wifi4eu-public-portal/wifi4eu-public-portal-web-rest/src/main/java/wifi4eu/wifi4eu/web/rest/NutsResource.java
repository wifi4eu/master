package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    Logger _log = LoggerFactory.getLogger(NutsResource.class);

    @ApiOperation(value = "Get nuts by specific id")
    @RequestMapping(value = "/{nutsId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public NutsDTO getNutsById(@PathVariable("nutsId") final Integer nutsId) {
        _log.info("getNutsById: " + nutsId);
        return nutsService.getNutsById(nutsId);
    }

    @ApiOperation(value = "Get all nuts from a specific level")
    @RequestMapping(value = "/level/{level}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<NutsDTO> getNutsByLevel(@PathVariable("level") final Integer level) {
        if (_log.isInfoEnabled()) {
            _log.info("getNutsByLevel: " + level);
        }
        return nutsService.getNutsByLevel(level);
    }
}