package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import wifi4eu.wifi4eu.common.Constant;
import wifi4eu.wifi4eu.common.dto.model.BeneficiaryListItemDTO;
import wifi4eu.wifi4eu.common.dto.model.BeneficiaryMyInstallationDTO;
import wifi4eu.wifi4eu.common.dto.model.SupplierDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.service.beneficiary.BeneficiaryMyInstallationService;
import wifi4eu.wifi4eu.service.supplier.SupplierService;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/beneficiary", description = "Beneficiary object REST API services")
@RequestMapping("beneficiary")
public class BeneficiaryMyInstallationResource {

    Logger _log = LogManager.getLogger(BeneficiaryMyInstallationResource.class);

    @Autowired
    UserService userService;

    @Autowired
    SupplierService supplierService;

    @Autowired
    BeneficiaryMyInstallationService beneficiaryMyInstallationService;

    @ApiOperation(value = "Get all beneficiaries for my installation page")
    @RequestMapping(value = "/beneficiaries-list-installation", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO getBeneficiariesListMyInstallation(HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);

        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Retrieving beneficiary list for my installation page");
        try {
            SupplierDTO supplier = supplierService.getSupplierByUserId(userConnected.getId());
            if (userConnected.getType() != Constant.ROLE_SUPPLIER ||  supplier== null) {
                throw new AccessDeniedException("403 FORBIDDEN");
            }
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to retrieve the beneficiary list", e.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
        }
        return beneficiaryMyInstallationService.findBeneficiariesListMyInstallation(userConnected.getId(), userConnected.getEcasUsername());
    }

    @ApiOperation(value = "getBeneficiaryMyInstallation")
    @RequestMapping(value = "/get-Beneficiary-My-Installation", method = RequestMethod.GET)
    @ResponseBody
    public BeneficiaryMyInstallationDTO getBeneficiaryMyInstallation() {
        return new BeneficiaryMyInstallationDTO();
    }

}
