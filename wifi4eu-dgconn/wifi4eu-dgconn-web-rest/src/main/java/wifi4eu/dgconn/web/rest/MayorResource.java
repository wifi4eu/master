package wifi4eu.dgconn.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.MayorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.entity.security.RightConstants;
import wifi4eu.wifi4eu.service.mayor.MayorService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/mayor", description = "Mayor object REST API services")
@RequestMapping("mayor")
public class MayorResource {
    @Autowired
    private MayorService mayorService;

    @Autowired
    private PermissionChecker permissionChecker;

    Logger _log = LoggerFactory.getLogger(MayorResource.class);

    @ApiOperation(value = "Get all the mayors")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<MayorDTO> allMayors() {
        _log.info("allMayors");
        return mayorService.getAllMayors();
    }

    @ApiOperation(value = "Get mayor by specific id")
    @RequestMapping(value = "/{mayorId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public MayorDTO getMayorById(@PathVariable("mayorId") final Integer mayorId) {
        _log.info("getMayorById: " + mayorId);
        return mayorService.getMayorById(mayorId);
    }

    @ApiOperation(value = "Create mayor")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO createMayor(@RequestBody final MayorDTO mayorDTO,
                                   HttpServletResponse response) throws IOException {
        try {
            _log.info("createMayor");
            MayorDTO resMayor = mayorService.createMayor(mayorDTO);

            //check permission
            int mayorId = mayorDTO.getId();
            permissionChecker.check(RightConstants.MAYORS_TABLE+mayorId);

            return new ResponseDTO(true, resMayor, null);
        } catch (AccessDeniedException ade) {
            if (_log.isErrorEnabled()) {
                _log.error("Error with permission on 'createMayor' operation.", ade);
            }
            response.sendError(HttpStatus.FORBIDDEN.value());
            return new ResponseDTO(false, null, new ErrorDTO(403, ade.getMessage()));
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'createMayor' operation.", e);
            }
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseDTO(false, null, new ErrorDTO(500, e.getMessage()));
        }
    }

    @ApiOperation(value = "Delete mayor by specific id")
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseDTO deleteMayor(@RequestBody final Integer mayorId) {
        try {
            _log.info("deleteMayor: " + mayorId);
            MayorDTO resMayor = mayorService.deleteMayor(mayorId);
            return new ResponseDTO(true, resMayor, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'deleteMayor' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "Get mayor by specific municipality id")
    @RequestMapping(value = "/municipalityId/{municipalityId}",method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public MayorDTO getMayorByMunicipalityId(@PathVariable("municipalityId") final Integer municipalityId) {
        if (_log.isInfoEnabled()) {
            _log.info("getMayorByMunicipalityId: " + municipalityId);
        }
        return mayorService.getMayorByMunicipalityId(municipalityId);
    }
}