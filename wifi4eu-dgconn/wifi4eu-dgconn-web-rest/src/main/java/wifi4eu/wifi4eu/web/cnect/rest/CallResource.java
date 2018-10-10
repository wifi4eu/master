package wifi4eu.wifi4eu.web.cnect.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.CallDTO;
import wifi4eu.wifi4eu.service.call.CallService;

import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/call", description = "Call object REST API services")
@RequestMapping("call")
public class CallResource {
    @Autowired
    private CallService callService;

    @ApiOperation(value = "Get all the calls")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<CallDTO> allCalls() {
        return callService.getAllCalls();
    }

    // TODO: not used. Remove.
    @ApiOperation(value = "Get call by specific id")
    @RequestMapping(value = "/{callId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public CallDTO getCallById(@PathVariable("callId") final Integer callId) {
        return callService.getCallById(callId);
    }


    @ApiOperation(value = "Get if call is closed by specific id or not")
    @RequestMapping(value = "isCallClosed/{callId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public boolean isCallClosed(@PathVariable("callId") final Integer callId) {
        return callService.isCallClosed(callId);
    }

}