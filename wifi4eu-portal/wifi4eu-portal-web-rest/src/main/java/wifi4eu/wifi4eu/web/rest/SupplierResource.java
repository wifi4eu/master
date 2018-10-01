package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.exception.AppException;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.common.utils.RequestIpRetriever;
import wifi4eu.wifi4eu.common.utils.SupplierValidator;
import wifi4eu.wifi4eu.common.utils.UserValidator;
import wifi4eu.wifi4eu.entity.security.RightConstants;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.supplier.SupplierService;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/supplier", description = "Supplier object REST API services")
@RequestMapping("supplier")
public class SupplierResource {

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private PermissionChecker permissionChecker;

    @Autowired
    private UserService userService;

    Logger _log = LoggerFactory.getLogger(SupplierResource.class);

    @ApiOperation(value = "Get supplier by specific id")
    @RequestMapping(value = "/{supplierId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public SupplierDTO getSupplierById(@PathVariable("supplierId") final Integer supplierId, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("User ID: " + userConnected.getEcasUsername() + " - Getting supplier by id " + supplierId);
        SupplierDTO supplierDTO = supplierService.getSupplierById(supplierId);
        try {
            if (supplierService.getUserIdFromSupplier(supplierDTO.getId()) != userConnected.getId() && userConnected.getType() != 5) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + "- Supplier retrieved successfully");
            return supplierService.getSupplierById(supplierId);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to retrieve this supplier", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- This supplier cannot been retrieved", e);
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return null;
    }

    // WARNING: Only municipalities that have ever been a awarded a voucher will be able to access
    @ApiOperation(value = "Get supplier details by specific id")
    @RequestMapping(value = "/details/{supplierId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public SupplierDTO getSupplierDetailsById(@PathVariable("supplierId") final Integer supplierId, @RequestParam("municipalityId") Integer municipalityId, HttpServletResponse response) throws IOException {
        SupplierDTO supplierDTO = new SupplierDTO();
        try {
            _log.info("getSupplierDetailsById: " + supplierId);
            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if (!permissionChecker.checkIfVoucherAwarded(userDTO, municipalityId)) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            supplierDTO = supplierService.getSupplierDetailsById(supplierId);
            return supplierDTO;
        } catch (AccessDeniedException ade) {
            if (_log.isErrorEnabled()) {
                _log.error("AccessDenied on 'getSupplierDetailsById' operation.", ade);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'getSupplierDetailsById' operation.", e);
            }
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return null;
    }

    /*
    //TODO: is it necessary to be exposed? All the registration have to use submitSupplierRegistration endpoint?
    @ApiOperation(value = "Create supplier")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO createSupplier(@RequestBody final SupplierDTO supplierDTO, HttpServletResponse response) throws IOException {
        try {
            _log.info("createSupplier");
            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if (supplierDTO.getUserId() != userDTO.getId()) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            SupplierValidator.validateSupplier(supplierDTO);
            SupplierDTO resSupplier = supplierService.createSupplier(supplierDTO);
            return new ResponseDTO(true, resSupplier, null);
        } catch (AccessDeniedException ade) {
            if (_log.isErrorEnabled()) {
                _log.error("AccessDenied on 'createSupplier' operation.", ade);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'createSupplier' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
        }
    }
    */

    @ApiOperation(value = "Update supplier")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO updateSupplier(@RequestBody final SupplierDTO supplierDTO, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Updating supplier");
        try {

            if (supplierService.getUserIdFromSupplier(supplierDTO.getId()) != userConnected.getId()) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }

            /*if (!supplierService.isSupplierEditable(userConnected)){
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }*/
            SupplierValidator.validateSupplierUpdate(supplierDTO);
            SupplierDTO resSupplier = supplierService.updateSupplier(supplierDTO);
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + "- Supplier updated successfully");
            return new ResponseDTO(true, resSupplier, null);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to update this supplier", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- This supplier cannot been updated", e);
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
        }
    }

    @ApiOperation(value = "update Contact Details")
    @RequestMapping(value = "update/contactDetails", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO updateContactDetails(@RequestBody final SupplierDTO supplierDTO, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Updating contact details");
        try {
            SupplierDTO supplier = supplierService.getSupplierByUserId(userConnected.getId());
            /*boolean access = false;
            for (UserDTO user : supplier.getUsers()) {
                if (user.getId() == userConnected.getId()) {
                    access = true;
                    break;
                }

            }
            if (!access) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }*/
            if (Validator.isNotNull(supplier)) {
                if (supplierDTO.getId() != supplier.getId()) {
                    throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
                }
            } else {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            List<UserDTO> resSupplier = supplierService.updateContactDetails(supplierDTO);
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + "- Contact details updated successfully");
            return new ResponseDTO(true, resSupplier, null);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to update these contact details", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- These contact details cannot been updated", e);
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
    }

    @ApiOperation(value = "update Supplier Details")
    @RequestMapping(value = "update/supplierDetails", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO updateSupplierDetails(@RequestBody final SupplierDTO supplierDTO, @RequestBody final UserDTO userDTO, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Updating supplier details");
        try {
            int supplierUserId = supplierService.getUserIdFromSupplier(supplierDTO.getId());
            if (supplierUserId != userConnected.getId()) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            SupplierDTO sendSupplierDTO = supplierService.getSupplierByUserId(supplierUserId);
            if (supplierDTO.getId() != sendSupplierDTO.getId()) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            SupplierValidator.validateSupplierUpdate(supplierDTO);
            SupplierDTO resSupplier = supplierService.updateSupplierDetails(sendSupplierDTO, supplierDTO.getName(), supplierDTO.getAddress(), supplierDTO.getAccountNumber(), supplierDTO.getWebsite(), supplierDTO.getLogo());
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + "- Supplier's details updated successfully");
            return new ResponseDTO(true, resSupplier, null);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to update this supplier's contact details", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- This supplier's contact details cannot been updated", e);
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
    }

    @ApiOperation(value = "Submit supplier registration")
    @RequestMapping(value = "/submitRegistration", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO submitSupplierRegistration(@RequestBody final SupplierDTO supplierDTO, HttpServletResponse response, HttpServletRequest request) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Submitting supplier registration");
        try {
            if (userConnected.getType() != 0) {
                throw new AppException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            SupplierValidator.validateSupplierCreate(supplierDTO);
            UserValidator.validateUser(userConnected);
            SupplierDTO resSupplier = supplierService.submitSupplierRegistration(supplierDTO);
            _log.log(Level.getLevel("BUSINESS"), "[ " + RequestIpRetriever.getIp(request) + " ] - ECAS Username: " + userConnected.getEcasUsername() + " - Supplier registration submitted successfully");
            return new ResponseDTO(true, resSupplier, null);
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- This registration cannot been submitted", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
    }

    @ApiOperation(value = "Get supplier by specific user id")
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public SupplierDTO getSupplierByUserId(@PathVariable("userId") final Integer userId, @RequestParam("date") final Long timestamp, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting supplier by user id " + userId);
        try {
            permissionChecker.check(RightConstants.USER_TABLE + userId);
            return supplierService.getSupplierByUserId(userId);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to retrieve this supplier", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- This supplier cannot been retrieved", e);
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return null;
        }
    }

    @ApiOperation(value = "Get suppliers that have the same VAT and/or Account Number as the specific supplier")
    @RequestMapping(value = "/similarSuppliers/{supplierId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<SupplierDTO> findSimilarSuppliers(@PathVariable("supplierId") final Integer supplierId, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to find similar suppliers", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        }
        return supplierService.findSimilarSuppliers(supplierId);
    }

    @ApiOperation(value = "Request legal documents")
    @RequestMapping(value = "/requestLegalDocuments/{supplierId}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO requestLegalDocuments(@PathVariable("supplierId") final Integer supplierId, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - requesting legal documents by supplier id " + supplierId);
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            return new ResponseDTO(supplierService.requestLegalDocuments(supplierId), null, null);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to request legal documents", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- These legal documents cannot been retrieved", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
    }

    @ApiOperation(value = "Invalidate supplier")
    @RequestMapping(value = "/invalidate", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO invalidateSupplier(@RequestBody final SupplierDTO supplierDTO, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Invalidating supplier");
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("");
            }
            SupplierDTO resSupplier = supplierService.invalidateSupplier(supplierDTO);
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + "- Supplier invalidated successfully");
            return new ResponseDTO(true, resSupplier, null);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to invalidate this supplier", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- This supplier cannot been invalidated", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
    }

    @ApiOperation(value = "getSupplierListItemDTO")
    @RequestMapping(value = "/getSupplierListItemDTO", method = RequestMethod.GET)
    @ResponseBody
    public SupplierListItemDTO getSupplierListItemDTO() {
        return new SupplierListItemDTO();
    }

    @ApiOperation(value = "Get suppliers registered by region")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-API", value = "public", required = false, allowMultiple = false, dataType = "string", paramType = "header")
    })
    @RequestMapping(value = "/all/region/{regionId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO getSuppliersRegisteredByRegion(@PathVariable("regionId") int regionId,
                                                      @RequestParam("page") int page, @RequestParam("size") int size) {
        if (page < 0) {
            page = 0;
        }
        if (size < 0) {
            size = 0;
        }

        Page<String> pageObj = supplierService.getSuppliersByRegionOrCountry("", regionId, new PageRequest(page, size));
        return new ResponseDTO(
                true,
                new SuppliersCacheDTO(pageObj.getContent(), new Date()),
                pageObj.getTotalElements(),
                null);
    }

    @ApiOperation(value = "Get suppliers registered by country")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-API", value = "public", required = false, allowMultiple = false, dataType = "string", paramType = "header")
    })
    @RequestMapping(value = "/all/country/{countryCode}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO getSuppliersRegisteredByCountry(@PathVariable("countryCode") String countryCode,
                                                       @RequestParam("page") int page, @RequestParam("size") int size) {
        if (page < 0) {
            page = 0;
        }
        if (size < 0) {
            size = 0;
        }
        Page<String> pageObj = supplierService.getSuppliersByRegionOrCountry(countryCode, 0, new PageRequest(page, size));
        return new ResponseDTO(
                true,
                new SuppliersCacheDTO(pageObj.getContent(), new Date()),
                pageObj.getTotalElements(),
                null);
    }

    @ApiOperation(value = "Get userId from supplier ")
    @RequestMapping(value = "/getUserId/{supplierId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseDTO getUserIdFromSupplier(@PathVariable("supplierId") final int supplierId) throws IOException {

        try {

            Integer userId = supplierService.getUserIdFromSupplier(supplierId);
            return new ResponseDTO(true, userId, null);

        } catch (Exception e) {
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "sendEmailToNewContact")
    @RequestMapping(value = "/sendEmailToNewContact", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO sendEmailToNewContact(@RequestBody String newUserEmail, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        try {

            UserDTO newUser = userService.getUserByEmail(userConnected.getEmail());

            if (newUser == null || newUser.getType() == 1) {
                int supplierId = supplierService.getSupplierByUserId(userConnected.getId()).getId();

                boolean emailSent = supplierService.sendEmailToContacts(newUserEmail, supplierId);
                supplierService.createSupplierUser(supplierId, null, newUserEmail, false);

                return new ResponseDTO(true, emailSent, null);
            } else {
                throw new AppException("User already registered");
            }


        } catch (Exception e) {
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }

    }

    //ADD CONTACT
//    @ApiOperation(value = "Deactivate supplier contact")
//    @RequestMapping(value = "/deactivateContact/{supplierId}/{userId}", method = RequestMethod.GET, produces = "application/json")
//    @ResponseStatus(HttpStatus.CREATED)
//    @ResponseBody
    public ResponseDTO deactivateSupplierContact(@PathVariable("supplierId") Integer supplierId, @PathVariable("userId") Integer userIdToDeactivate,
                                                 HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Invalidating supplier");
        try {
            permissionChecker.check(RightConstants.USER_TABLE + userConnected.getId());

            SupplierDTO supplier = supplierService.getSupplierByUserId(userIdToDeactivate);
            //verifying that user connected has permission on this supplier
            boolean access = false;
            for (UserDTO user : supplier.getUsers()) {
                if (user.getId() == userConnected.getId()) {
                    access = true;
                    break;
                }
            }
            if (!access) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }

            //user connected is not user to be deactivated
            if (userConnected.getId() == userIdToDeactivate) {
                response.sendError(HttpStatus.BAD_REQUEST.value());
                _log.info("ECAS Username: " + userConnected.getEcasUsername() + "- Trying to deactive itself.");
                return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
            }

            return new ResponseDTO(true, supplierService.deactivateSupplierContact(supplierId, userIdToDeactivate, userConnected.getEcasUsername()), null);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to deactivate this supplier contact", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- This supplier contact cannot been deactivated", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
    }

    // ADD CONTACT
    // @ApiOperation(value = "Generate invitation to be a supplier contact")
    // @RequestMapping(value = "/invitation-contact-supplier", method = RequestMethod.POST)
    // @ResponseBody
    public ResponseDTO invitateContactSupplier(@RequestParam("supplierId") final int supplierId, @RequestParam("newContactEmail") final String newContactEmail, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        try {
            if (Validator.isNull(userConnected) || userConnected.getType() != 1) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            return supplierService.invitateContactSupplier(userConnected, supplierId, newContactEmail.trim());
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Incorrect request when adding contacts for suppliers", e.getMessage());
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
    }

    // Get all suppliers that supply a specific region
    @ApiOperation(value = "Get suppliers by regionID")
    @RequestMapping(value = "/region/{regionId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<SupplierDTO> getSuppliersListByRegionId(@PathVariable("regionId") final Integer regionId, HttpServletResponse response) throws IOException {
        _log.info("getSuppliersListByRegionId");
        List<SupplierDTO> suppliersList = new ArrayList<>();
        try {
            suppliersList = supplierService.getSuppliersListByRegionId(regionId);
        } catch (Exception e) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return suppliersList;
    }

    // Get validated suppliers that supply a specific region
    // WARNING: only will be able to access municipalities with an awarded voucher
    @ApiOperation(value = "Get validated suppliers by regionID")
    @RequestMapping(value = "/region/{municipalityId}/validated", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<SupplierDTO> getValidatedSuppliersListByMunicipalityId(@PathVariable("municipalityId") final Integer municipalityId, HttpServletResponse response) throws IOException {
        List<SupplierDTO> suppliersList = new ArrayList<>();
        try {
            _log.info("getValidatedSuppliersListByMunicipalityId " + municipalityId);
            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if (!permissionChecker.checkIfVoucherAwarded(userDTO, municipalityId)) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            suppliersList = supplierService.getValidatedSuppliersListByMunicipalityId(municipalityId);
            return suppliersList;
        } catch (AccessDeniedException ade) {
            if (_log.isErrorEnabled()) {
                _log.error("AccessDenied on 'getValidatedSuppliersListByMunicipalityId' operation.", ade);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'getValidatedSuppliersListByMunicipalityId' operation.", e);
            }
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return null;
    }

    @ApiOperation(value = "Notify supplier by email that a beneficiary selected him")
    @RequestMapping(value = "/notifySelectedSupplier", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO notifySelectedSupplier(@RequestBody final int municipalityId) {
        _log.info("notify Selected Supplier: " + municipalityId);
        try {
            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if (!permissionChecker.checkIfVoucherAwarded(userDTO, municipalityId)) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            supplierService.notifySelectedSupplier(municipalityId);
            return new ResponseDTO(true, null, null);
        } catch (AccessDeniedException ade) {
            if (_log.isErrorEnabled()) {
                _log.error("AccessDenied on 'notifySelectedSupplier' operation", ade);
            }
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'notifySelectedSupplier' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
        return null;
    }

    @ApiOperation(value = "Notify supplier by email that a beneficiary has rejected him")
    @RequestMapping(value = "/notifyRejectedSupplier", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO notifyRejectedSupplier(@RequestBody final int municipalityId) {
        _log.info("notify Selected Supplier: " + municipalityId);
        try {
            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if (!permissionChecker.checkIfVoucherAwarded(userDTO, municipalityId)) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            supplierService.notifyRejectedSupplier(municipalityId);
            return new ResponseDTO(true, null, null);
        } catch (AccessDeniedException ade) {
            if (_log.isErrorEnabled()) {
                _log.error("AccessDenied on 'notifyRejectedSupplier' operation.", ade);
            }
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'notifyRejectedSupplier' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
        return null;
    }
}