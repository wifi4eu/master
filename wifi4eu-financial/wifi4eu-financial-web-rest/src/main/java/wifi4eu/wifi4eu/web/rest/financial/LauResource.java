package wifi4eu.wifi4eu.web.rest.financial;

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

    @ApiOperation(value = "get Lau by NUTS3 i.e: ES513")
    @RequestMapping(value = "/nuts3/{nuts3}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<LauDTO> findLauByNuts3(@PathVariable("nuts3") final String nuts3, final HttpServletResponse response) {
        if (_log.isDebugEnabled()) {
            _log.debug("findLauByNuts3: " + nuts3);
        }
        return locationService.getLauByNuts3(nuts3);
    }

    @ApiOperation(value = "create LAU")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO create(@RequestBody final LauDTO lauDTO, final HttpServletResponse response) {


        ErrorDTO errorDTO = new ErrorDTO(0, "unexpected");
        return new ResponseDTO(false, null, errorDTO);
    }

    @ApiOperation(value = "get Lau by LAU2 and Country Code i.e: 08019")
    @RequestMapping(value = "/lau2/{lau2}/countryCode/{countryCode}", method = RequestMethod.GET, produces = "application/JSON")
    @ResponseBody
    public LauDTO findLauByLau2AndCountryCode(@PathVariable("lau2") final String lau2, @PathVariable("countryCode") final String countryCode, final HttpServletResponse response) {
        if (_log.isDebugEnabled()) {
            _log.debug("find Lau By LAU2: " + lau2 + " and country code: " + countryCode);
        }
        return locationService.getLauByLau2AndCountryCode(lau2, countryCode);
    }

}
