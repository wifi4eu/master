package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.BeneficiaryDTO;
import wifi4eu.wifi4eu.common.dto.model.BenPubSupDTO;
import wifi4eu.wifi4eu.common.dto.model.LegalEntityDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.dto.security.UserDTO;
import wifi4eu.wifi4eu.service.beneficiary.BeneficiaryService;
import wifi4eu.wifi4eu.service.supplier.SupplierService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by rgarcita on 08/02/2017.
 */
@CrossOrigin(origins = "*")
@Controller
@Api(value = "/beneficiary", description = "BeneficiaryResource")
@RequestMapping("beneficiary")
public class BeneficiaryResource {

    Logger _log = Logger.getLogger(BeneficiaryResource.class);

    @Autowired
    private BeneficiaryService beneficiaryService;

    @Autowired
    private SupplierService supplierService;

    @ApiOperation(value = "create Beneficiary")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO create(@RequestBody final BeneficiaryDTO beneficiaryDTO, final HttpServletResponse response) {

        try {
            UserDTO userDTO = beneficiaryService.create(beneficiaryDTO);
            return new ResponseDTO(true, userDTO, null);
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

    @ApiOperation(value = "Apply for voucher")
    @RequestMapping(value = "/{beneficiaryId}/apply/{publicationId}", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO apply(@PathVariable("beneficiaryId") final Long beneficiaryId, @PathVariable("publicationId") final Long publicationId, final HttpServletResponse response) {

        _log.info("beneficiary apply for voucher | beneficiaryId: " + beneficiaryId + " publicationId: " + publicationId);

        try {
            beneficiaryService.apply(beneficiaryId, publicationId);
            return new ResponseDTO(true, null, null);
        } catch (Exception e) {
            ErrorDTO errorDTO = new ErrorDTO(0, e.getMessage());
            return new ResponseDTO(false, null, errorDTO);
        }

    }

    @ApiOperation(value = "Check if applied for voucher")
    @RequestMapping(value = "/{beneficiaryId}/checkApplied/{publicationId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public BenPubSupDTO findIfApplied(@PathVariable("beneficiaryId") final Long beneficiaryId, @PathVariable("publicationId") final Long publicationId, final HttpServletResponse response) {
        _log.info("Check if applied for voucher | beneficiaryId: " + beneficiaryId + " publicationId: " + publicationId);
        return beneficiaryService.findIfApplied(beneficiaryId, publicationId);
    }

    @ApiOperation(value = "get legal Entity information")
    @RequestMapping(value = "/{legalEntityId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public LegalEntityDTO getLegalEntity(@PathVariable("legalEntityId") final Long legalEntityId, final HttpServletResponse response) {
        _log.info("getLegalEntity: " + legalEntityId);
        return beneficiaryService.getLegalEntity(legalEntityId);
    }

    @ApiOperation(value = "Get awarded legal entities")
    @RequestMapping(value = "/awarded", method = RequestMethod.GET, produces = "application/JSON")
    @ResponseBody
    public List<LegalEntityDTO> getAwardedMunicipalities() {
        _log.info("get awarded municipalities");

        return supplierService.getAwardedMunicipalities();
    }

}
