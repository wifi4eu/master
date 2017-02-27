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
import wifi4eu.wifi4eu.common.dto.model.LauDTO;
import wifi4eu.wifi4eu.entity.location.Lau;
import wifi4eu.wifi4eu.service.location.LocationService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by rgarcita on 08/02/2017.
 */
@Controller
@Api(description = "NutsResource")
@RequestMapping("lau")
public class LauResource {

    Logger _log = Logger.getLogger(LauResource.class);

    @Autowired
    private LocationService locationService;

    @ApiOperation(value = "get Lau by Country Code i.e: ES")
    @RequestMapping(value="/{countryCode}",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public List<LauDTO> findLauByCountryCode(@PathVariable("countryCode") final String countryCode, final HttpServletResponse response) {
        if(_log.isDebugEnabled()) {
            _log.debug("findLauByCountryCode: " + countryCode);
        }
        return locationService.getLauByCountryCode(countryCode);
    }


}
