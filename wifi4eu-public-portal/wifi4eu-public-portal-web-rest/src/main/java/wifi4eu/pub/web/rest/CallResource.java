package wifi4eu.pub.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    Logger _log = LogManager.getLogger(CallResource.class);

    @ApiOperation(value = "getCall")
    @RequestMapping(value = "/getCall", method = RequestMethod.GET)
    @ResponseBody
    public CallDTO getCall() {
        return new CallDTO();
    }

    @ApiOperation(value = "Get all the calls")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<CallDTO> allCalls() {
        if (_log.isInfoEnabled()) {
            _log.info("allCalls");
        }
        return callService.getAllCalls();
    }
}