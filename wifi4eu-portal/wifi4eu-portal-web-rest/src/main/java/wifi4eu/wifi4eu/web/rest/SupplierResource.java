package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;
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
import wifi4eu.wifi4eu.entity.security.RightConstants;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.supplier.SupplierService;
import wifi4eu.wifi4eu.service.user.UserService;

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

    //TODO: limit access to this service
    @ApiOperation(value = "Get supplier deatils by specific id")
    @RequestMapping(value = "/details/{supplierId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public SupplierDTO getSupplierDetailsById(@PathVariable("supplierId") final Integer supplierId, HttpServletResponse response) throws IOException {
        SupplierDTO supplierDTO = new SupplierDTO();
        try {
            _log.info("getSupplierDetailsById: " + supplierId);
            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
/*             if(supplierDTO.getUserId() != userDTO.getId() && userDTO.getType() != 5){
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            } */
            supplierDTO = supplierService.getSupplierDetailsById(supplierId);
        } 
/*         catch (AccessDeniedException ade) {
          response.sendError(HttpStatus.NOT_FOUND.value());
        } */
        catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'getSupplierDetailsById' operation.", e);
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
            _log.info("createSupplier");
            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if(supplierDTO.getUserId() != userDTO.getId()){
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            SupplierDTO resSupplier = supplierService.createSupplier(supplierDTO);
            return new ResponseDTO(true, resSupplier, null);
        }
        catch (AccessDeniedException ade) {
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
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

    @ApiOperation(value = "getSupplierListItemDTO")
    @RequestMapping(value = "/getSupplierListItemDTO", method = RequestMethod.GET)
    @ResponseBody
    public SupplierListItemDTO getSupplierListItemDTO() {
        return new SupplierListItemDTO();
    }

    @ApiOperation(value = "findDgconnSuppliersList")
    @RequestMapping(value = "/findDgconnSuppliersList", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO findDgconnSuppliersList(@RequestParam("page") final Integer page, @RequestParam("count") final Integer count, @RequestParam("orderField") String orderField, @RequestParam("orderType") Integer orderType) {
        try {
            return new ResponseDTO(true, supplierService.findDgconnSuppliersList(null, page, count, orderField, orderType), supplierService.getCountAllSuppliers(), null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'findDgconnSuppliersList': ", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "findDgconnSuppliersListSearchingName")
    @RequestMapping(value = "/findDgconnSuppliersListSearchingName", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO findDgconnSuppliersListSearchingName(@RequestParam("name") final String name, @RequestParam("page") final Integer page, @RequestParam("count") final Integer count, @RequestParam("orderField") String orderField, @RequestParam("orderType") Integer orderType) {
        try {
            return new ResponseDTO(true, supplierService.findDgconnSuppliersList(name, page, count, orderField, orderType), supplierService.getCountAllSuppliersContainingName(name), null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'findDgconnSuppliersListSearchingName' (" + name + "): ", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "Get suppliers registered by region")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-API", value = "public", required = false, allowMultiple = false, dataType = "string", paramType = "header")
    })
    @RequestMapping(value = "/all/region/{regionId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO getSuppliersRegisteredByRegion(@PathVariable("regionId") int regionId,
                                                      @RequestParam("page") int page, @RequestParam("size") int size){
        if(page < 0) { page = 0; }
        if(size < 0) { size = 0; }

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
                                                       @RequestParam("page") int page, @RequestParam("size") int size){
        if(page < 0) { page = 0; }
        if(size < 0) { size = 0; }
        Page<String> pageObj = supplierService.getSuppliersByRegionOrCountry(countryCode, 0, new PageRequest(page, size));
        return new ResponseDTO(
                true,
                new SuppliersCacheDTO(pageObj.getContent(), new Date()),
                pageObj.getTotalElements(),
                null);
    }

    // New creation
    @ApiOperation(value = "Get suppliers by regionID")
    @RequestMapping(value = "/region/{regionId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<SupplierDTO> getSuppliersListByRegionId(@PathVariable("regionId") final Integer regionId, HttpServletResponse response) throws IOException {
        _log.info("getSuppliersListByRegionId");
        List<SupplierDTO> suppliersList = new ArrayList<>();
        try {
            suppliersList = supplierService.getSuppliersListByRegionId(regionId);
        }
        catch (Exception e){
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return suppliersList;
    }


}