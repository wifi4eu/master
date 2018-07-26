package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.LauDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.service.location.LauService;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/lau", description = "Lau object REST API services")
@RequestMapping("lau")
public class LauResource {

    @Autowired
    private LauService lauService;

    @Autowired
    private UserService userService;

    private final static String GET_LAU_BY_ID = "getLauById: ";
    private final static String GET_LAU_BY_COUNTRY_CODE_AND_LAU2 = "getLauByCountryCodeAndLau2: ";
    private final static String GET_LAUS_BY_COUNTRY_CODE = "getLausByCountryCode: ";
    private final static String GET_LAUS_BY_NUTS3 = "getLausByNuts3: ";
    private final static String GET_LAUS_BY_COUNTRY_CODE_AND_NAME1_STARTING_WITH_IGNORE_CASE = "getLausByCountryCodeAndName1StartingWithIgnoreCase: ";

    private Logger _log = LogManager.getLogger(LauResource.class);

    @ApiOperation(value = "Get lau by specific id")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-API", value = "public", required = false, allowMultiple = false, dataType = "string", paramType = "header")
    })
    @RequestMapping(value = "/{lauId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public LauDTO getLauById(@PathVariable("lauId") final Integer lauId) {
        return lauService.getLauById(lauId);
    }

    @ApiOperation(value = "Get lau by countryCode and lau2")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-API", value = "public", required = false, allowMultiple = false, dataType = "string", paramType = "header")
    })
    @RequestMapping(value = "/countryCode/{countryCode}/lau2/{lau2}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public LauDTO getLauByCountryCodeAndLau2(@PathVariable("countryCode") final String countryCode, @PathVariable("lau2") final String lau2) {
        return lauService.getLauByCountryCodeAndLau2(countryCode, lau2);
    }

    @ApiOperation(value = "Get laus by countryCode")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-API", value = "public", required = false, allowMultiple = false, dataType = "string", paramType = "header")
    })
    @RequestMapping(value = "/countryCode/{countryCode}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<LauDTO> getLausByCountryCode(@PathVariable("countryCode") final String countryCode) {
        return lauService.getLausByCountryCode(countryCode);
    }

    @ApiOperation(value = "Get laus by nuts3")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-API", value = "public", required = false, allowMultiple = false, dataType = "string", paramType = "header")
    })
    @RequestMapping(value = "/nuts3/{nuts3}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<LauDTO> getLausByNuts3(@PathVariable("nuts3") final String nuts3) {
        return lauService.getLausByNuts3(nuts3);
    }

    @ApiOperation(value = "Get laus by countryCode that start with name1, ignoring case")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-API", value = "public", required = false, allowMultiple = false, dataType = "string", paramType = "header")
    })
    @RequestMapping(value = "/countryCode/{countryCode}/name/{name1}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<LauDTO> getLausByCountryCodeAndName1ContainingIgnoreCase(@PathVariable("countryCode") final String countryCode, @PathVariable("name1") final String name1) {
        return lauService.getLausByCountryCodeAndName1ContainingIgnoreCase(countryCode, name1);
    }

}