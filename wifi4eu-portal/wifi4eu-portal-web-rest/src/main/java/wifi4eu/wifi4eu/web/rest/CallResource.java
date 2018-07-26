package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.CallDTO;
import wifi4eu.wifi4eu.common.dto.model.TimelineDTO;
import wifi4eu.wifi4eu.common.dto.model.VoucherManagementDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.service.call.CallService;
import wifi4eu.wifi4eu.service.user.UserService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/call", description = "Call object REST API services")
@RequestMapping("call")
public class CallResource {
    @Autowired
    private CallService callService;

    Logger _log = LogManager.getLogger(CallResource.class);

    @ApiOperation(value = "Get all the calls")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<CallDTO> allCalls() {
        return callService.getAllCalls();
    }

    @ApiOperation(value = "Get call by specific id")
    @RequestMapping(value = "/{callId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public CallDTO getCallById(@PathVariable("callId") final Integer callId) {
        return callService.getCallById(callId);
    }

    @ApiOperation(value = "Get the current call")
    @RequestMapping(value = "/current-active", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public CallDTO getCurrentCall() {
        return callService.getCurrentCall();
    }

    @ApiOperation(value = "Get the current call")
    @RequestMapping(value = "/current-active-modified", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public CallDTO getCurrentCallWithoutRelatedObjects() {
        // clean related Call objects to generate less traffic into apply page
        CallDTO call = callService.getCurrentCall();
        call.setTimelines(new ArrayList<TimelineDTO>());
        call.setVoucherManagements(new ArrayList<VoucherManagementDTO>());
        return call;
    }


    @ApiOperation(value = "Get if call is closed by specific id or not")
    @RequestMapping(value = "isCallClosed/{callId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public boolean isCallClosed(@PathVariable("callId") final Integer callId) {
        return false;
    }


    @ApiOperation(value = "time")
    @RequestMapping(value = "/time", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Date getTime() {
        return callService.getTime();
    }

}