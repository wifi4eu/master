package wifi4eu.wifi4eu.web.cnect.rest;

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

    @ApiOperation(value = "Get if call is closed by specific id or not")
    @RequestMapping(value = "isCallClosed/{callId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public boolean isCallClosed(@PathVariable("callId") final Integer callId) {
        return callService.isCallClosed(callId);
    }

    @ApiOperation(value = "Get all the calls closed")
    @RequestMapping(value="/callsClosed", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<CallDTO> allCallsClosed() {
        return callService.getAllCallsClosed();
    }

    @ApiOperation(value = "Get all the calls closed notified")
    @RequestMapping(value="/callsClosedNotified", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<CallDTO> allCallsClosedNotified() {
        return callService.getAllCallsClosedNotified();
    }

    @ApiOperation(value = "Get all the calls closed pre selected")
    @RequestMapping(value="/callsClosedPreSelected", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<CallDTO> allCallsClosedPreSelected() {
        return callService.getAllCallsClosedPreSelected();
    }

//    @ApiOperation(value = "Create call")
//    @RequestMapping(method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED)
//    @ResponseBody
//    public ResponseDTO createCall(@RequestBody final CallDTO callDTO, HttpServletResponse response) throws
// IOException {
//
//        //TODO:check DGConn permissions
//
//        try {
//            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
//            if(userDTO.getType() != 5){
//                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
//            }
//            _log.info("createCall");
//            CallDTO resCall = callService.createCall(callDTO);
//            return new ResponseDTO(true, resCall, null);
//        }
//        catch (AccessDeniedException ade){
//            response.sendError(HttpStatus.NOT_FOUND.value());
//        }
//        catch (Exception e) {
//            if (_log.isErrorEnabled()) {
//                _log.error("Error on 'createCall' operation.", e);
//            }
//            response.sendError(HttpStatus.NOT_FOUND.value());
//        }
//        return new ResponseDTO(false, null, null);
//    }
//
//    @ApiOperation(value = "Delete call by specific id")
//    @RequestMapping(method = RequestMethod.DELETE)
//    @ResponseBody
//    public ResponseDTO deleteCall(@RequestBody final Integer callId, HttpServletResponse response) throws
// IOException {
//
//        //TODO: check DGConn permissions
//        try {
//            _log.info("deleteCall: " + callId);
//            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
//            if(userDTO.getType() != 5){
//                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
//            }
//            CallDTO resCall = callService.deleteCall(callId);
//            return new ResponseDTO(true, resCall, null);
//        }
//        catch (AccessDeniedException ade) {
//            response.sendError(HttpStatus.NOT_FOUND.value());
//            if (_log.isErrorEnabled()) {
//                _log.error("Error on 'deleteCall' operation.", e);
//            }
//        }
//        return new ResponseDTO(false, null, null);
//    }
}