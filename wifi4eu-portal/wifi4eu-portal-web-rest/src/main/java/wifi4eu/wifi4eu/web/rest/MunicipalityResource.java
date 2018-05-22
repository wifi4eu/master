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

    @ApiOperation(value = "Get municipality by specific id")
    @RequestMapping(value = "/{municipalityId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public MunicipalityDTO getMunicipalityById(@PathVariable("municipalityId") final Integer municipalityId, HttpServletResponse response) throws IOException {
        _log.info("getMunicipalityById: " + municipalityId);
        try{
            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if (userDTO.getType() != 5) {
                permissionChecker.check(userDTO, RightConstants.MUNICIPALITIES_TABLE + municipalityId);
            }
        }catch (Exception e){
            response.sendError(HttpStatus.NOT_FOUND.value());
        }
        return municipalityService.getMunicipalityById(municipalityId);
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
            response.sendError(HttpStatus.NOT_FOUND.value());
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'createMunicipality' operation.", e);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
        }
        return new ResponseDTO(true, null, null);
    }

    @ApiOperation(value = "Get municipality by specific id for thread")
    @RequestMapping(value = "/thread/{municipalityId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public MunicipalityDTO getMunicipalityThreadById(@PathVariable("municipalityId") final Integer municipalityId, HttpServletResponse response) throws IOException {
        UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());

        MunicipalityDTO municipality =  municipalityService.getMunicipalityById(municipalityId);
        municipality.setRegistrations(null);
        return municipality;
    }

    @ApiOperation(value = "Update municipality details")
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public ResponseDTO updateMunicipalityDetails(@RequestBody final MunicipalityDTO municipalityDTO,
                                          HttpServletResponse response) throws IOException {
        try {
            //check permission
            int municipalityId = municipalityDTO.getId();
            permissionChecker.check(RightConstants.MUNICIPALITIES_TABLE + municipalityId);
            MunicipalityDTO resMunicipality = municipalityService.updateMunicipalityDetails(municipalityDTO);
            return new ResponseDTO(true, resMunicipality, null);
        }
        catch (AccessDeniedException ade) {
            if (_log.isErrorEnabled()) {
                _log.error("Error with permission on 'updating municipality' operation.", ade);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, null);
        }
        catch (Exception e){
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, null);
        }
    }

    @ApiOperation(value = "Delete municipality by specific id")
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseDTO deleteMunicipality(@RequestBody final Integer municipalityId, HttpServletResponse response) throws IOException {
        try {
            _log.info("deleteMunicipality: " + municipalityId);

            //check permisssion
            permissionChecker.check(RightConstants.MUNICIPALITIES_TABLE + municipalityId);
            MunicipalityDTO resMunicipality = municipalityService.deleteMunicipality(municipalityId);
            return new ResponseDTO(true, resMunicipality, null);
        } catch (AccessDeniedException ade) {
            response.sendError(HttpStatus.NOT_FOUND.value());
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'deleteMunicipality' operation.", e);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
        }
        return new ResponseDTO(true, null, null);
    }

    @ApiOperation(value = "Get municipalities by specific lau id")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-API", value = "public", required = false, allowMultiple = false, dataType = "string", paramType = "header")
    })
    @RequestMapping(value = "/lauId/{lauId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<MunicipalityDTO> getMunicipalitiesByLauId(@PathVariable("lauId") final Integer lauId, HttpServletResponse response) throws IOException {
        try{
            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if(userDTO.getType() != 5){
                throw new AccessDeniedException("");
            }
        }
        catch (AccessDeniedException ade) {
            response.sendError(HttpStatus.NOT_FOUND.value());
        }
        return municipalityService.getMunicipalitiesByLauId(lauId);
    }

    @ApiOperation(value = "Get municipalities by specific user id")
    @RequestMapping(value = "/userId/{userId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<MunicipalityDTO> getMunicipalitiesByUserId(@PathVariable("userId") final Integer userId,
                                                           HttpServletResponse response) throws IOException {

        try {
            permissionChecker.check(RightConstants.USER_TABLE + userId);
        } catch (AccessDeniedException ade) {
            if (_log.isErrorEnabled()) {
                _log.error("Error with permission on 'getMunicipalitiesByUserId' operation.", ade);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
            throw new AccessDeniedException("");
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'getMunicipalitiesByUserId' operation.", e);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
            throw new AccessDeniedException("");
        }

        return municipalityService.getMunicipalitiesByUserId(userId);
    }

}