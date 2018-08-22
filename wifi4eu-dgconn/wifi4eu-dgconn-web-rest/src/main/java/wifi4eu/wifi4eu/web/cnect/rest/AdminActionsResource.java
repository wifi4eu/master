package wifi4eu.wifi4eu.web.cnect.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.AdminActionsDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.admin.AdminActionsService;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/admin-actions", description = "Admin actions")
@RequestMapping("admin-actions")
public class AdminActionsResource {

    @Autowired
    AdminActionsService adminActionsService;

    @ApiOperation(value = "Get admin actions by action name")
    @RequestMapping(value = "/by-name/{name}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseDTO getByActionName(@PathVariable("name") String name){
        return new ResponseDTO(true, adminActionsService.getByActionName(name), new ErrorDTO());
    }

    @ApiOperation(value = "Disabled")
    @RequestMapping(value = "/disabled", method = RequestMethod.GET)
    @ResponseBody
    public AdminActionsDTO disabledMethod(){
        return new AdminActionsDTO();
    }

}
