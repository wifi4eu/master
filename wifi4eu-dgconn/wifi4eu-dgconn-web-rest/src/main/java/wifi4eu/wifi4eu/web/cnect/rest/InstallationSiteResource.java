package wifi4eu.wifi4eu.web.cnect.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.entity.installation.InstallationSite;
import wifi4eu.wifi4eu.service.installation.InstallationSiteService;

import java.util.Map;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/installation-site", description = "Installation Site object REST API services")
@RequestMapping("installation-site")
public class InstallationSiteResource {

    @Autowired
    private InstallationSiteService installationSiteService;

    @ApiOperation(value="Get all installation sites by beneficiary")
    @RequestMapping(value="/list", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO getInstallationSiteListByBeneficiary(@RequestBody final Map<String, Object> installationText){
        return installationSiteService.findInstallationSitesByBeneficiariesOrdered(installationText);
    }

    @ApiOperation(value = "Edit Installation Site")
    @RequestMapping(value = "/edit", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public ResponseDTO editInstallationSiteDTO(@RequestBody InstallationSite request) {
        ResponseDTO response = new ResponseDTO();
        response.setSuccess(false);
        response.setData("Not Implemented");
        return response;
    }

    @ApiOperation(value = "Get installation site details")
    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseDTO getInstallationSite(@PathVariable("id") int id){
        return installationSiteService.getInstallationReport(id);
    }

}
