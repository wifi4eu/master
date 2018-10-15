package wifi4eu.wifi4eu.web.rest;

import io.lettuce.core.dynamic.annotation.Param;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.Constant;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.entity.supplier.BankAccount;
import wifi4eu.wifi4eu.service.application.ApplicationService;
import wifi4eu.wifi4eu.service.beneficiary.BeneficiaryMyInstallationService;
import wifi4eu.wifi4eu.service.supplier.BankAccountService;
import wifi4eu.wifi4eu.service.supplier.SupplierService;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
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

    @Autowired
    BankAccountService bankAccountService;

    @Autowired
    ApplicationService applicationService;

    @ApiOperation(value = "Get all beneficiaries for my installation page")
    @RequestMapping(value = "/beneficiaries-list-installation", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO getMyInstallationData(@RequestParam("firstTime") final Boolean firstTime, @RequestParam("fieldOrder") final String
            fieldOrder, @RequestParam("order") final String orderDirection, @RequestParam("page") final Integer page, @RequestParam("rowsPerPage") final
    Integer rowsPerPage, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);

        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Retrieving beneficiary list for my installation page");
        try {
            SupplierDTO supplier = supplierService.getSupplierByUserId(userConnected.getId());
            if (userConnected.getType() != Constant.ROLE_SUPPLIER || supplier == null) {
                throw new AccessDeniedException("403 FORBIDDEN");
            }

            return beneficiaryMyInstallationService.getMyInstallationData(supplier.getId(), userConnected.getEcasUsername(), Validator.isNull
                    (firstTime) ? true : firstTime, fieldOrder, orderDirection, page, rowsPerPage);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to retrieve DGConn beneficiaries", ade
                    .getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- Beneficiary list cannot be retrieved", e.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
        }
    }

    @ApiOperation(value = "Get all beneficiaries for my installation page")
    @RequestMapping(value = "/attribute/{beneficiary}/{bankAccount}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO attributeBankAccountToBeneficiary(@PathVariable("beneficiary") final Integer beneficiaryId, @PathVariable("bankAccount")
    final Integer bankAccountId, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);

        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Retrieving beneficiary list for my installation page");
        try {
            //is this user a supplier
            SupplierDTO supplier = supplierService.getSupplierByUserId(userConnected.getId());
            if (userConnected.getType() != Constant.ROLE_SUPPLIER || supplier == null) {
                throw new AccessDeniedException("403 FORBIDDEN");
            }
            //iban either doesn't exist or doesn't belong to this supplier
            BankAccount bankAccount = bankAccountService.getBankAccountByIdAndSupplierId(bankAccountId, supplier.getId());
            if (Validator.isNull(bankAccount)) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            //checking if this beneficiary has selected this application
            if (applicationService.getApplicationById(beneficiaryId).getSupplierId() != supplier.getId()) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }

            return beneficiaryMyInstallationService.attributeBankAccountToBeneficiary(bankAccountId, beneficiaryId);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to retrieve DGConn beneficiaries", ade
                    .getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- Beneficiary list cannot be retrieved", e.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
        }
    }

    @ApiOperation(value = "SupplierMyInstallationDTO")
    @RequestMapping(value = "/Supplier-My-Installation-DTO", method = RequestMethod.POST)
    @ResponseBody
    public SupplierMyInstallationDTO getSupplierMyInstallationDTO(@RequestBody final SupplierMyInstallationDTO supplierMyInstallationDTO) {
        return supplierMyInstallationDTO;
    }

}
