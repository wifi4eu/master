package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.MunicipalityDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.entity.security.RightConstants;
import wifi4eu.wifi4eu.service.municipality.MunicipalityService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;

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

    Logger _log = LoggerFactory.getLogger(MunicipalityResource.class);

    @ApiOperation(value = "Get all the municipalities")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<MunicipalityDTO> allMunicipalities() {
        _log.info("allMunicipalities");
        return municipalityService.getAllMunicipalities();
    }

    @ApiOperation(value = "Get municipality by specific id")
    @RequestMapping(value = "/{municipalityId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public MunicipalityDTO getMunicipalityById(@PathVariable("municipalityId") final Integer municipalityId) {
        _log.info("getMunicipalityById: " + municipalityId);
        return municipalityService.getMunicipalityById(municipalityId);
    }

    @ApiOperation(value = "Create municipality")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO createMunicipality(@RequestBody final MunicipalityDTO municipalityDTO) {
        try {
            _log.info("createMunicipality");

            //check permission
            int municipalityId = municipalityDTO.getId();
            permissionChecker.check(RightConstants.MUNICIPALITIES_TABLE+municipalityId);

            MunicipalityDTO resMunicipality = municipalityService.createMunicipality(municipalityDTO);
            return new ResponseDTO(true, resMunicipality, null);
        } catch (AccessDeniedException ade) {
            if (_log.isErrorEnabled()) {
                _log.error("Error with permission on 'createMunicipality' operation.", ade);
            }
            return new ResponseDTO(false, null, new ErrorDTO(403, ade.getMessage()));
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'createMunicipality' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(500, e.getMessage()));
        }
    }

    @ApiOperation(value = "Delete municipality by specific id")
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseDTO deleteMunicipality(@RequestBody final Integer municipalityId) {
        try {
            _log.info("deleteMunicipality: " + municipalityId);
            MunicipalityDTO resMunicipality = municipalityService.deleteMunicipality(municipalityId);
            return new ResponseDTO(true, resMunicipality, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'deleteMunicipality' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "Get municipalities grouped by lau id")
    @RequestMapping(value = "/groupedByLauId", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<MunicipalityDTO> getMunicipalitiesGroupedByLauId() {
        _log.info("getMunicipalitiesGroupedByLauId: ");
        return municipalityService.getMunicipalitiesGroupedByLauId();
    }

    @ApiOperation(value = "Get municipalities by specific lau id")
    @RequestMapping(value = "/lauId/{lauId}",method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<MunicipalityDTO> getMunicipalitiesByLauId(@PathVariable("lauId") final Integer lauId) {
        if (_log.isInfoEnabled()) {
            _log.info("getMunicipalitiesByLauId:" + lauId);
        }
        return municipalityService.getMunicipalitiesByLauId(lauId);
    }

    @ApiOperation(value = "Get municipalities by specific user id")
    @RequestMapping(value = "/userId/{userId}",method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<MunicipalityDTO> getMunicipalitiesByUserId(@PathVariable("userId") final Integer userId) {
        if (_log.isInfoEnabled()) {
            _log.info("getMunicipalitiesByUserId:" + userId);
        }
        return municipalityService.getMunicipalitiesByUserId(userId);
    }
}