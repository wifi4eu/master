package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import wifi4eu.wifi4eu.common.dto.model.CallDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.entity.call.CallCustom;
import wifi4eu.wifi4eu.service.call.CallCustomService;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/callcustom", description = "Call object REST API services")
@RequestMapping("callcustom")
public class CallCustomResource {

    @Autowired
    CallCustomService callCustomService;

    @ApiOperation(value = "Get the call to apply")
    @RequestMapping(value = "/applyvoucher", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO getCallForApply(@RequestParam("date") final Long timestamp) {
        ResponseDTO response = new ResponseDTO();
        response.setSuccess(true);
        response.setData(callCustomService.getCallForApply());
        return response;
    }

    @ApiOperation(value = "Edit CallCustom")
    @RequestMapping(value  = "/edit", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public ResponseDTO editUser(@RequestBody CallCustom request){
        ResponseDTO response = new ResponseDTO();
        response.setSuccess(false);
        response.setData("Not implemented");
        return response;
    }

}
