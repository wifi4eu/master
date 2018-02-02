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

import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/supplier", description = "Supplier object REST API services")
@RequestMapping("supplier")
public class SupplierResource {
    @Autowired
    private SupplierService supplierService;

    Logger _log = LoggerFactory.getLogger(SupplierResource.class);

    @ApiOperation(value = "Get supplier by specific user id")
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public SupplierDTO getSupplierByUserId(@PathVariable("userId") final Integer userId) {
        if (_log.isInfoEnabled()) {
            _log.info("getSupplierByUserId: " + userId);
        }
        return supplierService.getSupplierByUserId(userId);
    }
}