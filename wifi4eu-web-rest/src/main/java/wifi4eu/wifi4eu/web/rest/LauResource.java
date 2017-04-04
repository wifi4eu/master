package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.LauDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.location.LocationService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by rgarcita on 08/02/2017.
 */
@CrossOrigin(origins = "*")
@Controller
@Api(value = "/lau", description = "NutsResource")
@RequestMapping("lau")
public class LauResource {

    Logger _log = Logger.getLogger(LauResource.class);

    @Autowired
    private LocationService locationService;

    @ApiOperation(value = "get Lau by Country Code i.e: ES")
    @RequestMapping(value = "/{countryCode}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<LauDTO> findLauByCountryCode(@PathVariable("countryCode") final String countryCode, final HttpServletResponse response) {
        if (_log.isDebugEnabled()) {
            _log.debug("findLauByCountryCode: " + countryCode);
        }
        return locationService.getLauByCountryCode(countryCode);
    }

    @ApiOperation(value = "create LAU")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO create(@RequestBody final LauDTO lauDTO, final HttpServletResponse response) {


        ErrorDTO errorDTO = new ErrorDTO(0, "unexpected");
        return new ResponseDTO(false, null, errorDTO);
    }


}
