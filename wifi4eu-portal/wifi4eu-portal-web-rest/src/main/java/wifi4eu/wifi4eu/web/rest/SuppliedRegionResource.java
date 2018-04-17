package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.supplier.SupplierService;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/suppliedRegion", description = "Supplied region object REST API services")
@RequestMapping("suppliedRegion")
public class SuppliedRegionResource {
    @Autowired
    private SupplierService supplierService;

    Logger _log = LoggerFactory.getLogger(SuppliedRegionResource.class);

    @ApiOperation(value = "Get all the suppliedRegions grouped by regions")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO getSuppliedRegionsCountGroupedByRegionId() {
        _log.info("getSuppliedRegionsGroupedByRegionId");
        return new ResponseDTO(true, supplierService.getSuppliedRegionsCountGroupedByRegionId(), null);
    }
}