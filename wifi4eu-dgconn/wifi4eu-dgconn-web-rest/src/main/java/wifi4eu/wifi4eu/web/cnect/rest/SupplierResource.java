package wifi4eu.wifi4eu.web.cnect.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import wifi4eu.wifi4eu.common.dto.model.SupplierDTO;
import wifi4eu.wifi4eu.common.dto.model.SupplierListItemDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.service.supplier.SupplierService;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.web.authorisation.DashboardUsersOnly;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/supplier", description = "Supplier object REST API services")
@RequestMapping("supplier")
public class SupplierResource {

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private UserService userService;

    private static final Logger _log = LoggerFactory.getLogger(SupplierResource.class);

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

    @ApiOperation(value = "Get suppliers that have the same VAT and/or Account Number as the specific supplier paged")
    @RequestMapping(value = "/similarSuppliers/paged/{supplierId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    @DashboardUsersOnly
    public ResponseDTO findSimilarSuppliersPaged(@PathVariable("supplierId") final Integer supplierId,
                                                 @RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                                 @RequestParam(value = "size", defaultValue = "20") Integer size) {
        if(Validator.isNull(offset)){
            offset = 0;
        }
        if(Validator.isNull(size)){
            size = 10;
        }
        return supplierService.findSimilarSuppliersPaged(supplierId, offset,  size);
    }

    @ApiOperation(value = "Request legal documents")
    @RequestMapping(value = "/requestLegalDocuments/{supplierId}", method = RequestMethod.POST)
    @ResponseBody
    @DashboardUsersOnly
    public ResponseDTO requestLegalDocuments(@PathVariable("supplierId") final Integer supplierId, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - requesting legal documents by supplier id " + supplierId);
        try {
            return new ResponseDTO(supplierService.requestLegalDocuments(supplierId), null, null);
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
    @DashboardUsersOnly
    public ResponseDTO invalidateSupplier(@RequestBody final SupplierDTO supplierDTO, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Invalidating supplier");
        try {
            SupplierDTO resSupplier = supplierService.invalidateSupplier(supplierDTO);
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + "- Supplier invalidated successfully");
            return new ResponseDTO(true, resSupplier, null);
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- This supplier cannot been invalidated", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
    }

    // TODO: not used. Remove.
    @ApiOperation(value = "getSupplierListItemDTO")
    @RequestMapping(value = "/getSupplierListItemDTO", method = RequestMethod.GET)
    @ResponseBody
    public SupplierListItemDTO getSupplierListItemDTO() {
        return new SupplierListItemDTO();
    }

    @ApiOperation(value = "findDgconnSuppliersList")
    @RequestMapping(value = "/findDgconnSuppliersList", method = RequestMethod.POST)
    @ResponseBody
    @DashboardUsersOnly
    public ResponseDTO findDgconnSuppliersList(@RequestParam("page") final Integer page, @RequestParam("count") final Integer count, @RequestParam("orderField") String orderField, @RequestParam("orderType") Integer orderType, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting DGConn suppliers by page " + page + ", count" + count + ", order field" + orderField + " and order type " + orderType);
        try {
            return new ResponseDTO(true, supplierService.findDgconnSuppliersList(null, page, count, orderField, orderType), supplierService.getCountAllSuppliers(), null);
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- Theses suppliers cannot been retrieved", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
    }

    @ApiOperation(value = "findDgconnSuppliersListSearchingName")
    @RequestMapping(value = "/findDgconnSuppliersListSearchingName", method = RequestMethod.POST)
    @ResponseBody
    @DashboardUsersOnly
    public ResponseDTO findDgconnSuppliersListSearchingName(@RequestParam("name") final String name, @RequestParam("page") final Integer page, @RequestParam("count") final Integer count, @RequestParam("orderField") String orderField, @RequestParam("orderType") Integer orderType, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting DGConn suppliers by page " + page + ", count" + count + ", order field" + orderField + " and order type " + orderType + " and searching name " + name);
        try {
            return new ResponseDTO(true, supplierService.findDgconnSuppliersList(name, page, count, orderField, orderType), supplierService.getCountAllSuppliersContainingName(name), null);
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- Theses suppliers name cannot been retrieved", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
    }

}