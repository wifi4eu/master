package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.BeneficiaryDTO;
import wifi4eu.wifi4eu.common.dto.model.LegalEntityDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.beneficiary.BeneficiaryService;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by rgarcita on 08/02/2017.
 */

<<<<<<< HEAD
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
=======
@CrossOrigin(origins = "http://localhost:4200")
>>>>>>> 5724206a41169b2aabf04520957857d22f950e21
@Controller
@Api(value = "/beneficiary", description = "BeneficiaryResource")
@RequestMapping("beneficiary")
public class BeneficiaryResource {

    Logger _log = Logger.getLogger(BeneficiaryResource.class);

    @Autowired
    private BeneficiaryService beneficiaryService;

    @ApiOperation(value = "create Beneficiary")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO create(@RequestBody final BeneficiaryDTO beneficiaryDTO, final HttpServletResponse response) {

        try {
            beneficiaryService.create(beneficiaryDTO);
            return new ResponseDTO(true, null, null);
        } catch (Exception e) {
            ErrorDTO errorDTO = new ErrorDTO(0, e.getMessage());
            return new ResponseDTO(false, null, errorDTO);
        }

    }

    @ApiOperation(value = "Update beneficiary information")
    @RequestMapping(value = "/{beneficiaryId}", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO update(@RequestBody final BeneficiaryDTO beneficiaryDTO, @PathVariable("beneficiaryId") final Long beneficiaryId, final HttpServletResponse response) {

        _log.info("beneficiary update");

        try {
            beneficiaryService.update(beneficiaryDTO);
            return new ResponseDTO(true, null, null);
        } catch (Exception e) {
            ErrorDTO errorDTO = new ErrorDTO(0, e.getMessage());
            return new ResponseDTO(false, null, errorDTO);
        }

    }

    @ApiOperation(value = "get legal Entity information")
    @RequestMapping(value = "/{legalEntityId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public LegalEntityDTO getLegalEntity(@PathVariable("legalEntityId") final Long legalEntityId, final HttpServletResponse response) {
        _log.info("getLegalEntity: " + legalEntityId);
        return beneficiaryService.getLegalEntity(legalEntityId);
    }

}
