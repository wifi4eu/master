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
import wifi4eu.wifi4eu.common.dto.model.BankAccountDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.common.utils.RequestIpRetriever;
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
            if (supplierService.getUserIdFromSupplier(supplierId) != userConnected.getId() && userConnected.getType() != 5) {
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

    @ApiOperation(value = "Delete bank account by specific id")
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseDTO deleteBankAccount(@RequestBody final Integer bankAccountId, HttpServletResponse response, HttpServletRequest request) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);

        try {

            BankAccountDTO bankAccountDTO = bankAccountService.deleteSupplier(bankAccountId);

            _log.log(Level.getLevel("BUSINESS"), "[ " + RequestIpRetriever.getIp(request) + " ] - ECAS Username: " + userConnected.getEcasUsername
                    () + " - Deleted user information from the database");
            return new ResponseDTO(true, bankAccountDTO, null);
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- This registration cannot been retrieved", e);
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseDTO(false, null, null);
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
