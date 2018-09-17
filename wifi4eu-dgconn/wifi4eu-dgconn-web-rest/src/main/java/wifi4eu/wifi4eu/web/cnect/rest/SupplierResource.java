package wifi4eu.wifi4eu.web.cnect.rest;

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
import wifi4eu.wifi4eu.common.dto.model.SupplierDTO;
import wifi4eu.wifi4eu.common.dto.model.SupplierListItemDTO;
import wifi4eu.wifi4eu.common.dto.model.SuppliersCacheDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.exception.AppException;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.common.utils.RequestIpRetriever;
import wifi4eu.wifi4eu.common.utils.SupplierValidator;
import wifi4eu.wifi4eu.entity.security.RightConstants;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.supplier.SupplierService;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

    Logger _log = LogManager.getLogger(SupplierResource.class);

    /*
    //TODO: limit access to this service
    @ApiOperation(value = "Get all the suppliers")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<SupplierDTO> allSuppliers(HttpServletResponse response) throws IOException {
        _log.info("allSuppliers");
        try {
            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if (userDTO.getType() != 5) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
        } catch (AccessDeniedException ade) {
            if (_log.isErrorEnabled()) {
                _log.error("AccessDenied on 'allSuppliers' operation.", ade);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'allSuppliers' operation.", e);
            }
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return supplierService.getAllSuppliers();
    }
    */

    //TODO: limit access to this service
    @ApiOperation(value = "Get supplier by specific id")
    @RequestMapping(value = "/{supplierId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public SupplierDTO getSupplierById(@PathVariable("supplierId") final Integer supplierId, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("User ID: " + userConnected.getEcasUsername() + " - Getting supplier by id " + supplierId);
        SupplierDTO supplierDTO = supplierService.getSupplierById(supplierId);
        try {
            UserDTO userDTO = userConnected;
            if (supplierService.getUserIdFromSupplier(supplierDTO.getId()) != userDTO.getId() && userDTO.getType() != 5) {
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
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO updateSupplier(@RequestBody final SupplierDTO supplierDTO, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Updating supplier");
        try {
            UserDTO userDTO = userConnected;
            if (supplierService.getUserIdFromSupplier(supplierDTO.getId()) != userDTO.getId()) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
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

    @ApiOperation(value = "update Supplier Details")
    @RequestMapping(value = "update/supplierDetails", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO updateSupplierDetails(@RequestBody final SupplierDTO supplierDTO, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Updating supplier details");
        try {
            UserDTO userDTO = userConnected;
            int supplierUserId = supplierService.getUserIdFromSupplier(supplierDTO.getId());
            if (supplierUserId != userDTO.getId()) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            SupplierDTO sendSupplierDTO = supplierService.getSupplierByUserId(supplierUserId);
            if (supplierDTO.getId() != sendSupplierDTO.getId()) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            SupplierDTO resSupplier = supplierService.updateSupplierDetails(sendSupplierDTO, supplierDTO.getName(), supplierDTO.getAddress(), supplierDTO.getVat(), supplierDTO.getBic(), supplierDTO.getLogo());
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

    //TODO: limit access to this endpoint
    @ApiOperation(value = "Get supplier by specific user id")
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public SupplierDTO getSupplierByUserId(@PathVariable("userId") final Integer userId, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting supplier by user id " + userId);
        try {
            permissionChecker.check(RightConstants.USER_TABLE + userId);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to retrieve this supplier", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- This supplier cannot been retrieved", e);
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return supplierService.getSupplierByUserId(userId);
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

    @ApiOperation(value = "Get suppliers that have the same VAT and/or Account Number as the specific supplier paged")
    @RequestMapping(value = "/similarSuppliers/paged/{supplierId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO findSimilarSuppliersPaged(@PathVariable("supplierId") final Integer supplierId,
                                                 @RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                                 @RequestParam(value = "size", defaultValue = "20") Integer size ,
                                                 HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        if(Validator.isNull(offset)){
            offset = 0;
        }
        if(Validator.isNull(size)){
            size = 10;
        }
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to find similar suppliers", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        }
        return supplierService.findSimilarSuppliersPaged(supplierId, offset,  size);
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

    @ApiOperation(value = "findDgconnSuppliersList")
    @RequestMapping(value = "/findDgconnSuppliersList", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO findDgconnSuppliersList(@RequestParam("page") final Integer page, @RequestParam("count") final Integer count, @RequestParam("orderField") String orderField, @RequestParam("orderType") Integer orderType, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting DGConn suppliers by page " + page + ", count" + count + ", order field" + orderField + " and order type " + orderType);
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("");
            }
            return new ResponseDTO(true, supplierService.findDgconnSuppliersList(null, page, count, orderField, orderType), supplierService.getCountAllSuppliers(), null);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to retrieve the DGConn suppliers", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- Theses suppliers cannot been retrieved", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
    }

    @ApiOperation(value = "findDgconnSuppliersListSearchingName")
    @RequestMapping(value = "/findDgconnSuppliersListSearchingName", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO findDgconnSuppliersListSearchingName(@RequestParam("name") final String name, @RequestParam("page") final Integer page, @RequestParam("count") final Integer count, @RequestParam("orderField") String orderField, @RequestParam("orderType") Integer orderType, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting DGConn suppliers by page " + page + ", count" + count + ", order field" + orderField + " and order type " + orderType + " and searching name " + name);
        try {
            if (!permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException("");
            }
            return new ResponseDTO(true, supplierService.findDgconnSuppliersList(name, page, count, orderField, orderType), supplierService.getCountAllSuppliersContainingName(name), null);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to retrieve the DGConn suppliers name", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- Theses suppliers name cannot been retrieved", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
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
}