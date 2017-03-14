package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.NutsDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.location.LocationService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by rgarcita on 08/02/2017.
 */
@Controller
@Api(value="/nuts",description = "NutsResource")
@RequestMapping("nuts")
public class NutsResource {

    Logger _log = Logger.getLogger(NutsResource.class);

    @Autowired
    private LocationService locationService;

    @ApiOperation(value="get all nuts")
    @RequestMapping(method = RequestMethod.GET,produces = "application/JSON")
    @ResponseBody
    public List<NutsDTO> findAllNuts() {
        _log.info("findAllNuts");

        return locationService.getAllNuts();
    }

    @ApiOperation(value="get all nuts from level X")
    @RequestMapping(value ="/{level}",method = RequestMethod.GET,produces = "application/JSON")
    @ResponseBody
    public List<NutsDTO> findNutsByLevel(@PathVariable("level") final Long level, final HttpServletResponse response) {
        _log.info("findNutsByLevel " + level);

        return locationService.getNutsByLevel(level);

    }

    @ApiOperation(value = "create Nuts")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO create(@RequestBody final NutsDTO nutsDTO, final HttpServletResponse response) {

        ErrorDTO errorDTO = new ErrorDTO(0,"unexpected");
        return new ResponseDTO(false,null,errorDTO);

    }

}
