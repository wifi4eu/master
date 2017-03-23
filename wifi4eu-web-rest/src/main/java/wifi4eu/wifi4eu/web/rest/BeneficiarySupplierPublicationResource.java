package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.BeneficiarySupplierPublicationDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.supplier.BeneficiarySupplierPublicationService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@Api(value = "/beneficiarysupplierpublication", description = "BeneficiarySupplierPublication services")
@RequestMapping("beneficiarysupplierpublication")
public class BeneficiarySupplierPublicationResource {

    Logger _log = LoggerFactory.getLogger(BeneficiarySupplierPublicationResource.class);

    @Autowired
    private BeneficiarySupplierPublicationService beneficiarySupplierPublicationService;

    @ApiOperation(value = "Get all the beneficiarysupplierpublication")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<BeneficiarySupplierPublicationDTO> allBeneficiarySupplierPublications() {
        return beneficiarySupplierPublicationService.getAllBeneficiarySupplierPublications();
    }

    @ApiOperation(value = "Get beneficiarysupplierpublication by benSupplierPublicationId")
    @RequestMapping(value = "/{benSupplierPublicationId}", method = RequestMethod.GET, produces = "application/JSON")
    @ResponseBody
    public BeneficiarySupplierPublicationDTO getBeneficiarySupplierPublicationById(@PathVariable("benSupplierPublicationId") final Long benSupplierPublicationId, final HttpServletResponse response) {
        _log.info("getBeneficiarySupplierPublicationById " + benSupplierPublicationId);

        return beneficiarySupplierPublicationService.getBeneficiarySupplierPublicationById(benSupplierPublicationId);

    }

    @ApiOperation(value = "create beneficiarySupplierPublication")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO createBeneficiarySupplierPublication(@RequestBody final BeneficiarySupplierPublicationDTO beneficiarySupplierPublicationDTO, final HttpServletResponse response) {
        try {
            _log.info("----> BeneficiarySupplierPublicationDTO: " + beneficiarySupplierPublicationDTO);
            BeneficiarySupplierPublicationDTO resBeneficiarySupplierPublication = beneficiarySupplierPublicationService.createBeneficiarySupplierPublication(beneficiarySupplierPublicationDTO);
            return new ResponseDTO(true, resBeneficiarySupplierPublication, null);
        } catch (Exception e) {
            ErrorDTO errorDTO = new ErrorDTO(0, e.getMessage());
            return new ResponseDTO(false, null, errorDTO);
        }
    }
}