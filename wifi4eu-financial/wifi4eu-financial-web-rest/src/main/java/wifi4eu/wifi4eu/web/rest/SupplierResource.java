package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.AccessPointDTO;
import wifi4eu.wifi4eu.common.dto.model.InstallationDTO;
import wifi4eu.wifi4eu.common.dto.model.LegalEntityDTO;
import wifi4eu.wifi4eu.common.dto.model.SupplierDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.supplier.SupplierService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin
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
            if (resSupplier == null) {
                return new ResponseDTO(false, null, null);
            }
            return new ResponseDTO(true, resSupplier, null);
        } catch (Exception e) {
            ErrorDTO errorDTO = new ErrorDTO(0, e.getMessage());
            return new ResponseDTO(false, null, errorDTO);
        }
    }

    @ApiOperation(value = "Get selected by supplierId")
    @RequestMapping(value = "/selectedBy/{supplierId}", method = RequestMethod.GET, produces = "application/JSON")
    @ResponseBody
    public List<LegalEntityDTO> getSelectedMeBySupplierId(@PathVariable("supplierId") final Long supplierId, final HttpServletResponse response) {
        _log.info("getSelectedBy " + supplierId);

        return supplierService.getSelectedMe(supplierId);
    }

    @ApiOperation(value = "Get installation by installationId")
    @RequestMapping(value = "/{installationId}/installation", method = RequestMethod.GET, produces = "application/JSON")
    @ResponseBody
    public InstallationDTO getInstallationById(@PathVariable("installationId") final Long installationId, final HttpServletResponse response) {
        _log.info("Get installation by installationId " + installationId);

        InstallationDTO installationDTO = supplierService.getInstallationById(installationId);
        if (installationDTO != null) {
            installationDTO.setAccessPoints(supplierService.getAccessPointsByInstallation(installationId));
        }
        return installationDTO;
    }

    @ApiOperation(value = "create access point")
    @RequestMapping(value = "/accessPoint", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO createAccessPoint(@RequestBody final AccessPointDTO accessPointDTO, final HttpServletResponse response) {
        try {
            _log.info("----> AccessPointDTO: " + accessPointDTO);
            AccessPointDTO resAccessPoint = supplierService.createAccessPoint(accessPointDTO);
            return new ResponseDTO(true, resAccessPoint, null);
        } catch (Exception e) {
            ErrorDTO errorDTO = new ErrorDTO(0, e.getMessage());
            return new ResponseDTO(false, null, errorDTO);
        }
    }

    @ApiOperation(value = "save supplier")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO saveSupplier(@RequestBody final SupplierDTO supplierDTO, final HttpServletResponse response) {
        try {
            SupplierDTO resSupplier = supplierService.saveSupplier(supplierDTO);
            return new ResponseDTO(true, resSupplier, null);
        } catch (Exception e) {
            ErrorDTO errorDTO = new ErrorDTO(0, e.getMessage());
            return new ResponseDTO(false, null, errorDTO);
        }
    }

    @ApiOperation(value = "Get legal entity by installation id")
    @RequestMapping(value = "/legalEntityByInstallation/{installationId}", method = RequestMethod.GET, produces = "application/JSON")
    @ResponseBody
    public LegalEntityDTO getLegalEntityByInstallationId(@PathVariable("installationId") final Long installationId, final HttpServletResponse response) {
        _log.info("getLegalEntityByInstallationId " + installationId);

        return supplierService.getLegalEntityByInstallationId(installationId);

    }
}
