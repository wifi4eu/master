package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.SupplierDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.entity.security.RightConstants;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.supplier.SupplierService;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        }
        catch (AccessDeniedException ade) {
          response.sendError(HttpStatus.NOT_FOUND.value());
        }
        catch (Exception e){
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return supplierService.getAllSuppliers();
    }

    //TODO: limit access to this service
    @ApiOperation(value = "Get supplier by specific id")
    @RequestMapping(value = "/{supplierId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public SupplierDTO getSupplierById(@PathVariable("supplierId") final Integer supplierId, HttpServletResponse response) throws IOException {
        SupplierDTO supplierDTO = new SupplierDTO();
        try {
            _log.info("getSupplierById: " + supplierId);
            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if(supplierDTO.getUserId() != userDTO.getId() && userDTO.getType() != 5){
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            supplierDTO = supplierService.getSupplierById(supplierId);
        } 
        catch (AccessDeniedException ade) {
          response.sendError(HttpStatus.NOT_FOUND.value());
        }
        catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'getSupplierById' operation.", e);
            }
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return supplierDTO;
    }

    //TODO: is it necessary to be exposed? All the registration have to use submitSupplierRegistration endpoint?
    @ApiOperation(value = "Create supplier")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO createSupplier(@RequestBody final SupplierDTO supplierDTO, HttpServletResponse response) throws IOException {
        try {
            response.sendError(HttpStatus.NOT_FOUND.value());
            _log.info("createSupplier");
//            SupplierDTO resSupplier = supplierService.createSupplier(supplierDTO);
            return new ResponseDTO(true, null, null);
        }
        catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'createSupplier' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    //TODO: limit access to this service
    @ApiOperation(value = "Delete supplier by specific id")
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseDTO deleteSupplier(@RequestBody final Integer supplierId, HttpServletResponse response) throws IOException{
        try {
            SupplierDTO supplierDTO = supplierService.getSupplierById(supplierId);
            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());

            if(userDTO.getId() != supplierDTO.getUserId()){
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            _log.info("deleteSupplier: " + supplierId);
            SupplierDTO resSupplier = supplierService.deleteSupplier(supplierId);
            return new ResponseDTO(true, resSupplier, null);
        } catch (AccessDeniedException ade){
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), ade.getMessage()));
        }
        catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'deleteSupplier' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "Submit supplier registration")
    @RequestMapping(value = "/submitRegistration", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO submitSupplierRegistration(@RequestBody final SupplierDTO supplierDTO) {
        try {
            _log.info("submitSupplierRegistration");
            SupplierDTO resSupplier = supplierService.submitSupplierRegistration(supplierDTO);
            return new ResponseDTO(true, resSupplier, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'submitSupplierRegistration' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    //TODO: limit access to this endpoint
    @ApiOperation(value = "Get supplier by specific user id")
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public SupplierDTO getSupplierByUserId(@PathVariable("userId") final Integer userId, HttpServletResponse response) throws IOException {
        _log.info("getSupplierByUserId: " + userId);
        try{
            permissionChecker.check(RightConstants.USER_TABLE+userId);
        } catch (AccessDeniedException ade){
            response.sendError(HttpStatus.NOT_FOUND.value());
        } catch (Exception e) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return supplierService.getSupplierByUserId(userId);
    }

    @ApiOperation(value = "Get suppliers that have the same VAT and/or Account Number as the specific supplier")
    @RequestMapping(value = "/similarSuppliers/{supplierId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<SupplierDTO> findSimilarSuppliers(@PathVariable("supplierId") final Integer supplierId) {
        _log.info("allSuppliers");
        return supplierService.findSimilarSuppliers(supplierId);
    }

    @ApiOperation(value = "Request legal documents")
    @RequestMapping(value = "/requestLegalDocuments/{supplierId}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO requestLegalDocuments(@PathVariable("supplierId") final Integer supplierId) {
        try {
            if (_log.isInfoEnabled()) {
                _log.info("requestLegalDocuments for supplier: " + supplierId);
            }
            return new ResponseDTO(supplierService.requestLegalDocuments(supplierId), null, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'requestLegalDocuments' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "Invalidate supplier")
    @RequestMapping(value = "/invalidate", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO invalidateSupplier(@RequestBody final SupplierDTO supplierDTO) {
        try {
            _log.info("invalidateSupplier");
            SupplierDTO resSupplier = supplierService.invalidateSupplier(supplierDTO);
            return new ResponseDTO(true, resSupplier, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'invalidateSupplier' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }
}