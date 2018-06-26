package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.supplier.SupplierService;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/suppliedRegion", description = "Supplied region object REST API services")
@RequestMapping("suppliedRegion")
public class SuppliedRegionResource {
    @Autowired
    private SupplierService supplierService;

    @ApiOperation(value = "Get all the suppliedRegions grouped by regions")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO getSuppliedRegionsCountGroupedByRegionId() {
        return new ResponseDTO(true, supplierService.getSuppliedRegionsCountGroupedByRegionId(), null);
    }
}