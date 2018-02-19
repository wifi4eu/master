package wifi4eu.dgconn.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.CallDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.call.CallService;

import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/call", description = "Call object REST API services")
@RequestMapping("call")
public class CallResource {
    @Autowired
    private CallService callService;

    Logger _log = LoggerFactory.getLogger(CallResource.class);

    @ApiOperation(value = "Get all the calls")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<CallDTO> allCalls() {
        _log.info("allCalls");
        return callService.getAllCalls();
    }

    @ApiOperation(value = "Get call by specific id")
    @RequestMapping(value = "/{callId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public CallDTO getCallById(@PathVariable("callId") final Integer callId) {
        _log.info("getCallById: " + callId);
        return callService.getCallById(callId);
    }

    @ApiOperation(value = "Create call")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO createCall(@RequestBody final CallDTO callDTO) {

        //TODO:check DGConn permissions

        try {
            _log.info("createCall");
            CallDTO resCall = callService.createCall(callDTO);
            return new ResponseDTO(true, resCall, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'createCall' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "Delete call by specific id")
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseDTO deleteCall(@RequestBody final Integer callId) {

        //TODO: check DGConn permissions
        try {
            _log.info("deleteCall: " + callId);
            CallDTO resCall = callService.deleteCall(callId);
            return new ResponseDTO(true, resCall, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'deleteCall' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }
}