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
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.BankAccountDTO;
import wifi4eu.wifi4eu.common.dto.model.BankAccountDocumentDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.common.utils.RequestIpRetriever;
import wifi4eu.wifi4eu.service.registration.legal_files.LegalFilesService;
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
@RequestMapping("bankAccount")
public class BankAccountResource {

    Logger _log = LogManager.getLogger(BankAccountResource.class);

    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private UserService userService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private PermissionChecker permissionChecker;

    @Autowired
    private LegalFilesService legalFilesService;

    @ApiOperation(value = "Get registration by specific id")
    @RequestMapping(value = "/{supplierId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO getBankAccountsBySupplierId(@PathVariable("supplierId") final Integer supplierId,
                                           HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting bank accounts of supplier with id " + supplierId);
        try {
            if (supplierService.getUserIdFromSupplier(supplierId) != userConnected.getId() && userConnected.getType() == 1) {
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

    @ApiOperation(value = "Save Bank Account")
    @RequestMapping(value = "/saveBankAccount", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO saveBankAccount(@RequestBody final BankAccountDTO bankAccountDTO, HttpServletResponse response, HttpServletRequest request) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);

        try {

            BankAccountDTO bankAccount = bankAccountService.save(bankAccountDTO);

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


    @ApiOperation(value = "Get registration by specific id")
    @RequestMapping(value = "documents/{supplierId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO getBankAccountDocsBySupplierId(@PathVariable("supplierId") final Integer supplierId,
                                                   HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting bank accounts documents of supplier with id " + supplierId);
        try {
            if (supplierService.getUserIdFromSupplier(supplierId) != userConnected.getId() && userConnected.getType() == 1) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - Supplier retrieved successfully");

            List<BankAccountDocumentDTO> bankAccountDocumentDTOList = bankAccountService.getBankAccountDcoumentsBySupplierId(supplierId);
            return new ResponseDTO(true, bankAccountDocumentDTOList, null);

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

    @ApiOperation(value = "Save Bank AccountDcoument")
    @RequestMapping(value = "/saveBankAccountDocument", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO saveBankAccountDocument(@RequestBody final BankAccountDocumentDTO bankAccountDocumentDTO, HttpServletResponse response, HttpServletRequest request) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);

        try {

            BankAccountDocumentDTO bankAccount = bankAccountService.save(bankAccountDocumentDTO, userConnected, RequestIpRetriever.getIp(request));

            _log.log(Level.getLevel("BUSINESS"), "[ " + RequestIpRetriever.getIp(request) + " ] - ECAS Username: " + userConnected.getEcasUsername
                    () + " - Deleted user information from the database");
            return new ResponseDTO(true, bankAccount, null);
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- This registration cannot been retrieved", e);
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseDTO(false, null, null);
        }
    }

    /*
     * DUMMY method returning BankAccountDTO for swagger
     */

    @ApiOperation(value = "Add Bank Document Dummy method")
    @RequestMapping(value = "/returnBankAccountDocument", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public BankAccountDocumentDTO returnBankAccountDocument(@RequestBody final BankAccountDocumentDTO bankAccountDocumentDTO) {
        return bankAccountDocumentDTO;
    }

    @ApiOperation(value = "Get registration by specific userThread id")
    @RequestMapping(value = "/getDocument/{supplierId}/{fileId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO getBankAccountDocument(@PathVariable("supplierId") final Integer supplierId,
                                         @PathVariable("fileId") final Integer fileId, HttpServletResponse response, HttpServletRequest request)
            throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting supplier by id "
                + supplierId + " and file id " + fileId);
       /* try {
            if (registrationId == null
                    || (!legalFilesService.hasUserPermissionForLegalFile(registrationId, userConnected.getId(), fileId)
                    && userConnected.getType() != 5)) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            permissionChecker.check(userConnected, RightConstants.SUP + registrationId);

        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername()
                    + "- You have no permissions to retrieve this registration", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        }*/

        BankAccountDocumentDTO bankAccountDocumentDTO = bankAccountService.getBankAccountDocumentById(fileId); // if file doesnt exist user doesnt have permission
        String fileName = bankAccountDocumentDTO.getFileName();
        String fileMime = bankAccountDocumentDTO.getFileMime();
        String fileExtension = legalFilesService.getExtensionFromMime(fileMime);

        // if fileMime is null or has lenght 0 fileExtension is null
        if (!Validator.isEmpty(fileName) && !Validator.isEmpty(bankAccountDocumentDTO.getAzureUri())
                && !Validator.isEmpty(fileExtension)) {
            // Recover the data from Azure, the database field only stores the url of the file
            String content = bankAccountService.downloadLegalFile(bankAccountDocumentDTO.getAzureUri());

            if (!Validator.isEmpty(content)) {
                try {
                    response.setContentType(fileMime);
                    response.setHeader("Content-disposition", "attachment; filename=\"" + fileName + fileExtension + "\"");

                    byte[] fileBytes = Base64Utils.decodeFromString(content);
                    response.getOutputStream().write(fileBytes);
                    response.getOutputStream().flush();
                    response.getOutputStream().close();
                } catch (Exception ex) {
                    _log.error("ECAS Username: " + userConnected.getEcasUsername()
                            + "- The registration cannot been retrieved", ex);
                    return new ResponseDTO(false, null,
                            new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
                }
            } else {
                _log.error("ECAS Username: " + userConnected.getEcasUsername()
                        + "- The File cannot been retrieved, file id : " + fileId);
                return new ResponseDTO(false, null,
                        new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
            }
        } else {
            _log.error("ECAS Username: " + userConnected.getEcasUsername()
                    + "- The File cannot been retrieved, file id : " + fileId);
            return new ResponseDTO(false, null,
                    new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
        }
        _log.log(Level.getLevel("BUSINESS"), "[ " + RequestIpRetriever.getIp(request) + " ] - ECAS Username: "
                + userConnected.getEcasUsername() + "- Legal files retrieved successfully, id: " + fileId);
        return new ResponseDTO(true, null, null);
    }
}