package wifi4eu.supplier.web.rest.beneficiary;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.BeneficiaryDisplayedListDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.beneficiary.BeneficiaryDisplayedListService;
import wifi4eu.wifi4eu.service.user.UserService;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/beneficiary", description = "Beneficiary object REST API services")
@RequestMapping("beneficiary")
public class BeneficiaryDisplayedListResource {

    @Autowired
    private BeneficiaryDisplayedListService beneficiaryDisplayedListService;

    @Autowired
    UserService userService;

    Logger _log = LogManager.getLogger(BeneficiaryDisplayedListResource.class);

    @ApiOperation(value = "Get all beneficiaries")
    @RequestMapping(value = "/beneficiaries-list", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO getBeneficiariesList() {
        return beneficiaryDisplayedListService.findBeneficiariesList();
    }

    @ApiOperation(value = "Confirm wifi indicator municipality (registration table)")
    @RequestMapping(value = "/confirm-wifindicator/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO confirmWifiIndicatorByMunicipalityId(@PathVariable("id") int id) {
        return beneficiaryDisplayedListService.confirmWifiIndicatorByMunicipalityId(id);
    }

    @ApiOperation(value = "Edit Beneficiary")
    @RequestMapping(value = "/edit", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public ResponseDTO editBeneficiaryDisplayedListDTO(@RequestBody BeneficiaryDisplayedListDTO request) {
        ResponseDTO response = new ResponseDTO();
        response.setSuccess(false);
        response.setData("Not Implemented");
        return response;
    }

}
