package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.SupplierDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.supplier.SupplierService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@Api(value = "/supplier", description = "Supplier services")
@RequestMapping("supplier")
public class SupplierResource {

    Logger _log = LoggerFactory.getLogger(SupplierResource.class);

    @Autowired
    private SupplierService supplierService;

    @ApiOperation(value = "Get all the suppliers")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<SupplierDTO> allSuppliers() {
        return supplierService.getAllSuppliers();
    }

    @ApiOperation(value = "Get supplier by supplierId")
    @RequestMapping(value = "/{supplierId}", method = RequestMethod.GET, produces = "application/JSON")
    @ResponseBody
    public SupplierDTO getSupplierById(@PathVariable("supplierId") final Long supplierId, final HttpServletResponse response) {
        _log.info("getSupplierById " + supplierId);

        return supplierService.getSupplierById(supplierId);

    }

    @ApiOperation(value = "create supplier")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO createSupplier(@RequestBody final SupplierDTO supplierDTO, final HttpServletResponse response) {
        try {
            _log.info("----> SupplierDTO: " + supplierDTO);
            SupplierDTO resSupplier = supplierService.createSupplier(supplierDTO);
            return new ResponseDTO(true, resSupplier, null);
        } catch (Exception e) {
            ErrorDTO errorDTO = new ErrorDTO(0, e.getMessage());
            return new ResponseDTO(false, null, errorDTO);
        }
    }
}