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
import wifi4eu.wifi4eu.common.dto.model.MayorDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.entity.security.RightConstants;
import wifi4eu.wifi4eu.service.mayor.MayorService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.user.UserService;

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

    @Autowired
    private UserService userService;

    Logger _log = LoggerFactory.getLogger(MayorResource.class);

    @ApiOperation(value = "Get all the mayors")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<MayorDTO> allMayors(HttpServletResponse response) throws IOException {
        _log.info("allMayors");
        try{
            if(userService.getUserByUserContext(UserHolder.getUser()).getType() != 5){
                throw new AccessDeniedException("");
            }
            else{
                return mayorService.getAllMayors();
            }
        } catch (Exception e){
            response.sendError(HttpStatus.NOT_FOUND.value());
        }
        return null;
    }

    @ApiOperation(value = "Get mayor by specific id")
    @RequestMapping(value = "/{mayorId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public MayorDTO getMayorById(@PathVariable("mayorId") final Integer mayorId, HttpServletResponse response) throws IOException {
        _log.info("getMayorById: " + mayorId);
        try {
            permissionChecker.check(RightConstants.MAYORS_TABLE+mayorId);
        } catch (Exception e){
            response.sendError(HttpStatus.NOT_FOUND.value());
        }
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

            //check permission
            int mayorId = mayorDTO.getId();
            permissionChecker.check(RightConstants.MAYORS_TABLE+mayorId);

            MayorDTO resMayor = mayorService.createMayor(mayorDTO);

            MayorDTO mayorDTO1 = mayorService.getMayorByMunicipalityId(mayorDTO.getMunicipalityId());
            if(mayorDTO1 != null) {
                resMayor.setEmail(mayorDTO1.getEmail());
            }
            return new ResponseDTO(true, resMayor, null);
        } catch (AccessDeniedException ade) {
            if (_log.isErrorEnabled()) {
                _log.error("Error with permission on 'createMayor' operation.", ade);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'createMayor' operation.", e);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
        }
        return new ResponseDTO(false, null, null);
    }

    @ApiOperation(value = "Delete mayor by specific id")
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseDTO deleteMayor(@RequestBody final Integer mayorId, HttpServletResponse response) throws IOException {
        try {
            _log.info("deleteMayor: " + mayorId);
            permissionChecker.check(RightConstants.MAYORS_TABLE+mayorId);
            MayorDTO resMayor = mayorService.deleteMayor(mayorId);
            return new ResponseDTO(true, resMayor, null);
        }
        catch (AccessDeniedException ade){
            response.sendError(HttpStatus.NOT_FOUND.value());
        }
        catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'deleteMayor' operation.", e);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
        }
        return new ResponseDTO(false, null, null);
    }

    @ApiOperation(value = "Get mayor by specific municipality id")
    @RequestMapping(value = "/municipalityId/{municipalityId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public MayorDTO getMayorByMunicipalityId(@PathVariable("municipalityId") final Integer municipalityId, HttpServletResponse response) throws IOException {
        if (_log.isInfoEnabled()) {
            _log.info("getMayorByMunicipalityId: " + municipalityId);
        }

        try{
            permissionChecker.check(RightConstants.MUNICIPALITIES_TABLE+municipalityId);
        } catch (Exception e){
            response.sendError(HttpStatus.NOT_FOUND.value());
        }

        return mayorService.getMayorByMunicipalityId(municipalityId);
    }
}