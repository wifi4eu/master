package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.MunicipalityDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.entity.security.RightConstants;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/municipality", description = "Municipality object REST API services")
@RequestMapping("municipality")
public class MunicipalityResource {
    @Autowired
    private MunicipalityService municipalityService;

    @Autowired
    private PermissionChecker permissionChecker;

    @Autowired
    private UserService userService;

    Logger _log = LoggerFactory.getLogger(MunicipalityResource.class);

    @ApiOperation(value = "Get all the municipalities")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-API", value = "public", required = false, allowMultiple = false, dataType = "string", paramType = "header")
    })
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<MunicipalityDTO> allMunicipalities() {
        _log.info("allMunicipalities");
        return municipalityService.getAllMunicipalities();
    }

    @ApiOperation(value = "Get municipality by specific id")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-API", value = "public", required = false, allowMultiple = false, dataType = "string", paramType = "header")
    })
    @RequestMapping(value = "/{municipalityId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public MunicipalityDTO getMunicipalityById(@PathVariable("municipalityId") final Integer municipalityId) {
        _log.info("getMunicipalityById: " + municipalityId);
        return municipalityService.getMunicipalityById(municipalityId);
    }

    @ApiOperation(value = "Get municipality by specific id")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-API", value = "public", required = false, allowMultiple = false, dataType =
                    "string", paramType = "header")
    })
    @RequestMapping(value = "/usersMunicipality/{municipalityId}", method = RequestMethod.GET, produces =
            "application/json")
    @ResponseBody
    public ResponseDTO getUsersMunicipalityById(@PathVariable("municipalityId") final Integer municipalityId) {
        return municipalityService.getUsersMunicipalityById(municipalityId);
    }

    @ApiOperation(value = "Create municipality")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO createMunicipality(@RequestBody final MunicipalityDTO municipalityDTO,
                                          HttpServletResponse response) throws IOException {
        try {
            _log.info("createMunicipality");

            //check permission
            int municipalityId = municipalityDTO.getId();
            permissionChecker.check(RightConstants.MUNICIPALITIES_TABLE + municipalityId);

            MunicipalityDTO resMunicipality = municipalityService.createMunicipality(municipalityDTO);
            return new ResponseDTO(true, resMunicipality, null);
        } catch (AccessDeniedException ade) {
            if (_log.isErrorEnabled()) {
                _log.error("Error with permission on 'createMunicipality' operation.", ade);
            }
            response.sendError(HttpStatus.FORBIDDEN.value());
            return new ResponseDTO(false, null, new ErrorDTO(403, ade.getMessage()));
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'createMunicipality' operation.", e);
            }
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseDTO(false, null, new ErrorDTO(500, e.getMessage()));
        }
    }

    @ApiOperation(value = "Delete municipality by specific id")
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseDTO deleteMunicipality(@RequestBody final Integer municipalityId, HttpServletResponse response) throws IOException {
        try {
            _log.info("deleteMunicipality: " + municipalityId);

            //check permisssion
            permissionChecker.check(RightConstants.MUNICIPALITIES_TABLE+municipalityId);
            MunicipalityDTO resMunicipality = municipalityService.deleteMunicipality(municipalityId);
            return new ResponseDTO(true, resMunicipality, null);
        }
        catch (AccessDeniedException ade){
            response.sendError(HttpStatus.FORBIDDEN.value());
            return new ResponseDTO(false, null, new ErrorDTO(403, ade.getMessage()));
        }
        catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'deleteMunicipality' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "Get municipalities by specific lau id")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-API", value = "public", required = false, allowMultiple = false, dataType = "string", paramType = "header")
    })
    @RequestMapping(value = "/lauId/{lauId}",method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<MunicipalityDTO> getMunicipalitiesByLauId(@PathVariable("lauId") final Integer lauId) {
        if (_log.isInfoEnabled()) {
            _log.info("getMunicipalitiesByLauId:" + lauId);
        }
        return municipalityService.getMunicipalitiesByLauId(lauId);
    }

    @ApiOperation(value = "Get municipalities by specific user id")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-API", value = "public", required = false, allowMultiple = false, dataType = "string", paramType = "header")
    })
    @RequestMapping(value = "/userId/{userId}",method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<MunicipalityDTO> getMunicipalitiesByUserId(@PathVariable("userId") final Integer userId,
                                                           HttpServletResponse response) throws IOException {
        if (_log.isInfoEnabled()) {
            _log.info("getMunicipalitiesByUserId:" + userId);
        }

        try {
            permissionChecker.check(RightConstants.USER_TABLE + userId);
        } catch (AccessDeniedException ade) {
            if (_log.isErrorEnabled()) {
                _log.error("Error with permission on 'getMunicipalitiesByUserId' operation.", ade);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());

        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'getMunicipalitiesByUserId' operation.", e);
            }
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }

        return municipalityService.getMunicipalitiesByUserId(userId);
    }

    @ApiOperation(value = "Get municipalities grouped by lau id")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-API", value = "public", required = false, allowMultiple = false, dataType = "string", paramType = "header")
    })
    @RequestMapping(value = "/groupedByLauId", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO getMunicipalitiesCountGroupedByLauId() {
        if (_log.isInfoEnabled()) {
            _log.info("getMunicipalitiesGroupedByLauId");
        }
        return new ResponseDTO(true, municipalityService.getMunicipalitiesCountGroupedByLauId(), null);
    }
}