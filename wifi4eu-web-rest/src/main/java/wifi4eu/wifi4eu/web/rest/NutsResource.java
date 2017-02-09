package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import wifi4eu.wifi4eu.common.dto.model.NutsDTO;
import wifi4eu.wifi4eu.service.location.LocationService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by rgarcita on 08/02/2017.
 */
@Controller
@Api(description = "NutsResource")
@RequestMapping("nuts")
public class NutsResource {

    Logger _log = Logger.getLogger(NutsResource.class);

    @Autowired
    private LocationService locationService;

    @ApiOperation(value="get all nuts")
    @RequestMapping(method = RequestMethod.GET,produces = "application/JSON")
    @ResponseBody
    public String findAllNuts() {

        _log.info("findAllNuts");
        //return locationService.getAllNuts();
        return "{id:1;name:'nuts'}";

    }

    @ApiOperation(value="get all nuts from level X")
    @RequestMapping(value ="/{level}",method = RequestMethod.GET,produces = "application/JSON")
    @ResponseBody
    public List<NutsDTO> findNutsByLevel(@PathVariable("level") final Long level, final HttpServletResponse response) {
        _log.info("findNutsByLevel " + level);

        return locationService.getNutsByLevel(level);

    }

}
