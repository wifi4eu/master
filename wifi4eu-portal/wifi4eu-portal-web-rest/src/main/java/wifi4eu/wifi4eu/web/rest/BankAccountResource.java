package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.Constant;
import wifi4eu.wifi4eu.common.dto.model.BankAccountDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.common.utils.RequestIpRetriever;
import wifi4eu.wifi4eu.entity.supplier.BankAccount;
import wifi4eu.wifi4eu.entity.supplier.Supplier;
import wifi4eu.wifi4eu.repository.supplier.BankAccountRepository;
import wifi4eu.wifi4eu.repository.supplier.SupplierRepository;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.supplier.BankAccountService;
import wifi4eu.wifi4eu.service.supplier.SupplierService;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/bankAccount", description = "Bank accounts of supplier")
@RequestMapping("BankAccount")
public class BankAccountResource {

    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private UserService userService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private PermissionChecker permissionChecker;

    @Autowired
    SupplierRepository supplierRepository;

    Logger _log = LogManager.getLogger(BankAccountResource.class);

    @ApiOperation(value = "Get registration by specific id")
    @RequestMapping(value = "/{supplierId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO getBankAccountsBySupplierId(@PathVariable("supplierId") final Integer supplierId,
                                           HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting bank accounts of supplier with id " + supplierId);
        try {
            if (supplierService.getUserIdFromSupplier(supplierId) != userConnected.getId() && userConnected.getType() != Constant.ROLE_SUPPLIER) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - Supplier retrieved successfully");

            List<BankAccountDTO> bankAccountDTOList = bankAccountService.getBankAccountsBySupplierId(supplierId);
            return new ResponseDTO(true, bankAccountDTOList, null);

        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername()
                    + "- You have no permissions to retrieve this registration", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, null);
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- This registration cannot been retrieved", e);
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseDTO(false, null, null);
        }
    }

    @ApiOperation(value = "Add Bank Account")
    @RequestMapping(value = "/addBankAccount", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO createBankAccount(@RequestBody final BankAccountDTO bankAccountDTO, HttpServletResponse response, HttpServletRequest request) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);

        try {

            BankAccountDTO bankAccount = bankAccountService.create(bankAccountDTO);

            _log.log(Level.getLevel("BUSINESS"), "[ " + RequestIpRetriever.getIp(request) + " ] - ECAS Username: " + userConnected.getEcasUsername
                    () + " - Deleted user information from the database");
            return new ResponseDTO(true, bankAccount, null);
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- This registration cannot been retrieved", e);
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseDTO(false, null, null);
        }
    }

    @ApiOperation(value = "Deletion of IBAN")
    @RequestMapping(value = "/delete/{ibanId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO deleteIban(@PathVariable("ibanId") final Integer ibanId, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Deleting iban with the id " + ibanId);
        try {
            //permissions
            //user is not a supplier
            Supplier supplier = supplierRepository.getByUserId(userConnected.getId());
            if(userConnected.getType() != Constant.ROLE_SUPPLIER || Validator.isNull(supplier)){
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            //iban either doesn't exist or doesn't belong to this supplier
            BankAccount bankAccount = bankAccountService.getBankAccountByIdAndSupplierId(ibanId, supplier.getId());
            if (Validator.isNull(bankAccount)){
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            return bankAccountService.deleteBankAccount(bankAccount);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to delete this iban", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- This iban cannot be deleted", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
    }

    /*
     * DUMMY method returning BankAccountDTO for swagger
     */

    @ApiOperation(value = "Add Bank Dummy method")
    @RequestMapping(value = "/returnBankAccount", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public BankAccountDTO returnBankAccount(@RequestBody final BankAccountDTO bankAccountDTO) {
        return bankAccountDTO;
    }

}
