package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.BeneficiaryDTO;
import wifi4eu.wifi4eu.common.dto.model.LegalEntityDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.security.UserService;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by rgarcita on 08/02/2017.
 */

@Controller
@Api(description = "BeneficiaryResource")
@RequestMapping("beneficiary")
public class BeneficiaryResource {

    Logger _log = LoggerFactory.getLogger(BeneficiaryResource.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value = "create Beneficiary")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody final BeneficiaryDTO beneficiaryDTO, final HttpServletResponse response) {

        userService.create(beneficiaryDTO);

    }

    @ApiOperation(value = "Update beneficiary information")
    @RequestMapping(value="/{beneficiaryId}",method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO update(@RequestBody final BeneficiaryDTO beneficiaryDTO, final HttpServletResponse response){

        _log.info("beneficiary update");

        try {
            userService.update(beneficiaryDTO);
            return new ResponseDTO(true,null,null);
        }catch(Exception e){
            ErrorDTO errorDTO = new ErrorDTO(0,e.getMessage());
            return new ResponseDTO(false,null,errorDTO);
        }

    }

    @ApiOperation(value = "get legal Entity information")
    @RequestMapping(value="/{legalEntityId}",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public LegalEntityDTO getLegalEntity(@PathVariable("legalEntityId") final Long legalEntityId, final HttpServletResponse response) {
        _log.info("getLegalEntity: " + legalEntityId);
        return userService.getLegalEntity(legalEntityId);
    }

}
