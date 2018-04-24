package wifi4eu.supplier.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger _log = LoggerFactory.getLogger(InstallationSiteResource.class);


    @ApiOperation(value="Get all installation sites by beneficiary")
    @RequestMapping(value="/installation-site-list", method = RequestMethod.POST)
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




 /*   @ApiOperation(value="Get all installation sites by beneficiary")
    @RequestMapping(value="/installation-site-list/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<InstallationSiteDTO> getInstallationSiteListByBeneficiary(@PathVariable("id") Integer id ){

        return installationSiteService.findInstallationSiteListByBeneficiary(id);
    }
*/
}
