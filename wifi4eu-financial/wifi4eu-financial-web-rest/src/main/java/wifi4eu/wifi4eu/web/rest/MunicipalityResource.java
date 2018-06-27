package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import wifi4eu.wifi4eu.common.dto.model.MunicipalityDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.location.MunicipalityService;

@Controller
@Api(value = "/municipality", description = "Municipality")
@RequestMapping("municipality")
public class MunicipalityResource {

    Logger _log = LoggerFactory.getLogger(MunicipalityResource.class);

    @Autowired
    private MunicipalityService service;
    
    @ApiOperation(value = "Get all the municipalities")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<MunicipalityDTO> list() {
        return service.list();
    }

    @ApiOperation(value = "Get Municipality by id")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/JSON")
    @ResponseBody
    public MunicipalityDTO get(@PathVariable("id") final Long id, final HttpServletResponse response) {
        _log.info("getMunicipalityById " + id);

        return service.get(id);

    }
    
    @ApiOperation(value = "Get Municipality by jagate key")
    @RequestMapping(value = "/jagate/{jagateKey}", method = RequestMethod.GET, produces = "application/JSON")
    @ResponseBody
    public MunicipalityDTO getByJagateKey(@PathVariable("jagateKey") final String jagateKey, final HttpServletResponse response) {
        _log.info("getMunicipalityByJagateKey " + jagateKey);

        return service.getByJagateKey(jagateKey);

    }

    @ApiOperation(value = "create Municipality")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO createOrUpdate(@RequestBody final MunicipalityDTO dto, final HttpServletResponse response) {
        try {
            MunicipalityDTO resMunicipality = service.createOrUpdate(dto);
            return new ResponseDTO(true, resMunicipality, null);
        } catch (Exception e) {
            ErrorDTO errorDTO = new ErrorDTO(0, e.getMessage());
            return new ResponseDTO(false, null, errorDTO);
        }
    }

    @ApiOperation(value = "delete Municipality")
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseDTO deleteMunicipality(@RequestBody final Long id, final HttpServletResponse response) {
        try {
            MunicipalityDTO resMunicipality = service.delete(id);
            return new ResponseDTO(true, resMunicipality, null);
        } catch (Exception e) {
            ErrorDTO errorDTO = new ErrorDTO(0, e.getMessage());
            return new ResponseDTO(false, null, errorDTO);
        }
    }
}
