package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.SupplierUserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.supplier.SupplierService;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/supplierUser", description = "SupplierUser object REST API services")
@RequestMapping("supplierUser")
public class SupplierUserResource {

    @Autowired
    private SupplierService supplierService;

    Logger _log = LogManager.getLogger(SupplierUserResource.class);

    @ApiOperation(value = "Create supplier user")
    @RequestMapping(value = "/create/{supplierId}/{userEmail}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO createSupplierUser(@PathVariable("supplierId") final int supplierId, @PathVariable("userEmail") final String userEmail) throws IOException {

        _log.debug("SupplierId : " + supplierId + " , supplierUserEmail : " + userEmail + " - Creating SupplierUser");

        try {

            SupplierUserDTO supplierUserDTO = supplierService.createSupplierUser(supplierId, null, userEmail, false);
            _log.debug("SupplierId : " + supplierId + " , supplierUserEmail : " + userEmail + " - Created SupplierUser");

            return new ResponseDTO(true, supplierUserDTO, null);

        } catch (Exception e) {
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "Register supplier user")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO registerSupplierUser(@RequestParam("userEmail") final String userEmail) throws IOException {

        try {

            List<SupplierUserDTO> supplierUserDTOList = supplierService.findByEmail(userEmail);

            if (supplierUserDTOList == null || supplierUserDTOList.isEmpty()) {
                return new ResponseDTO(false, null, new ErrorDTO(0, "NOT EXISTS"));
            }

            List<SupplierUserDTO> supplierUserDTOToUpdate = supplierService.registerSupplierUserIfApplies(supplierUserDTOList);

            return new ResponseDTO(true, supplierUserDTOToUpdate, null);

        }catch (Exception ex){
            return new ResponseDTO(false, null, new ErrorDTO(0, ex.getMessage()));
        }
    }
}