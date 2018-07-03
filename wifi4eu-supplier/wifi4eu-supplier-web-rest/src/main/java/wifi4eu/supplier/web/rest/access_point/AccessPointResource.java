package wifi4eu.supplier.web.rest.access_point;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.entity.access_point.AccessPoint;
import wifi4eu.wifi4eu.service.access_point.AccessPointService;
import wifi4eu.wifi4eu.service.user.UserService;

import java.util.Map;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/access-points", description = "Beneficiary object REST API services")
@RequestMapping("access-points")
public class AccessPointResource {

    @Autowired
    AccessPointService accessPointService;

    @Autowired
    UserService userService;

    Logger _log = LogManager.getLogger(AccessPointResource.class);

    @ApiOperation(value = "Get all Access Points per installation site ID")
    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO getAccessPointPerInstallationSite(@RequestBody final Map<String, Object> map) {
        return accessPointService.findAccessPointsPerInstallationSite(map);
    }

    @ApiOperation(value = "Add new access point per installation site")
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO addOrUpdateAccessPoint(@RequestBody final Map<String, Object> map) {
        return accessPointService.addOrUpdateAccessPoint(map);
    }

    @ApiOperation(value = "Get Access point by ID")
    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO getAccessPointById(@PathVariable("id") final int id) {
        return accessPointService.getAccessPointById(id);
    }

    @ApiOperation(value = "Delete Access Point by ID")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO deleteAccessPointById(@PathVariable("id") final int id) {
        return accessPointService.deleteAccessPointById(id);
    }

    @ApiOperation(value = "Edit Access Point")
    @RequestMapping(value = "/edit", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public ResponseDTO editBeneficiaryDisplayedListDTO(@RequestBody AccessPoint request) {
        ResponseDTO response = new ResponseDTO();
        response.setSuccess(false);
        response.setData("Not Implemented");
        return response;
    }

}
