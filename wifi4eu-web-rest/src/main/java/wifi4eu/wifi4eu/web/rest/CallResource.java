package wifi4eu.wifi4eu.web.rest;

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

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@Api(value = "/call", description = "Call services")
@RequestMapping("call")
public class CallResource {

    Logger _log = LoggerFactory.getLogger(CallResource.class);

    @Autowired
    private CallService callService;

    @ApiOperation(value = "Get all the calls")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<CallDTO> allCalls() {
        return callService.getAllCalls();
    }

    @ApiOperation(value = "Get call by callId")
    @RequestMapping(value = "/{callId}", method = RequestMethod.GET, produces = "application/JSON")
    @ResponseBody
    public CallDTO getCall(@PathVariable("callId") final Long callId, final HttpServletResponse response) {
        _log.info("getCall " + callId);

        return callService.getCall(callId);

    }

    @ApiOperation(value = "create call")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO createCall(@RequestBody final CallDTO callDTO, final HttpServletResponse response) {
        try {
            _log.info("----> CallDTO start date" + callDTO.getStartDate());
            CallDTO resCall = callService.createCall(callDTO);
            return new ResponseDTO(true, resCall, null);
        } catch (Exception e) {
            ErrorDTO errorDTO = new ErrorDTO(0, e.getMessage());
            return new ResponseDTO(false, null, errorDTO);
        }
    }
}