package wifi4eu.dgconn.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.ThreadDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.thread.ThreadService;

import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/thread", description = "Thread object REST API services")
@RequestMapping("thread")
public class ThreadResource {
    @Autowired
    private ThreadService threadService;

    Logger _log = LoggerFactory.getLogger(CallResource.class);

    @ApiOperation(value = "Get all the thread entries")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<ThreadDTO> allThreads() {
        return threadService.getAllThreads();
    }

    @ApiOperation(value = "Get thread by specific id")
    @RequestMapping(value = "/{threadId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ThreadDTO getThreadById(@PathVariable("threadId") final Integer threadId) {
        _log.info("getThreadById: " + threadId);
        return threadService.getThreadById(threadId);
    }

    @ApiOperation(value = "Create thread")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO createThread(@RequestBody final ThreadDTO threadDTO) {
        try {
            _log.info("createThread");
            ThreadDTO resThread = threadService.createThread(threadDTO);
            return new ResponseDTO(true, resThread, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'createThread' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }


    @ApiOperation(value = "Delete thread by specific id")
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseDTO deleteThread(@RequestBody final Integer threadId) {
        try {
            _log.info("deleteThread: " + threadId);
            ThreadDTO resThread = threadService.deleteThread(threadId);
            return new ResponseDTO(true, resThread, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'deleteThread' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "Get thread by specific type")
    @RequestMapping(value = "/type/{type}/reason/{reason}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ThreadDTO getThreadByTypeAndReason(@PathVariable("type") final Integer type, @PathVariable("reason") final String reason) {
        _log.info("getThreadByTypeAndReason: " + type);
        return threadService.getThreadByTypeAndReason(type, reason);
    }

    @ApiOperation(value = "Set mediation to thread")
    @RequestMapping(value = "{threadId}/setMediation", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO askMediationThread(@PathVariable("threadId") final Integer threadId) {
        try {
            _log.info("setMediationThread");
            ThreadDTO resThread = threadService.setMediationToThread(threadId);
            return new ResponseDTO(true, resThread, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'setMediationThread' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }
//    @ApiOperation(value = "Get all the thread that a user is in.")
//    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET, produces = "application/json")
//    @ResponseBody
//    public List<ThreadDTO> getUserThreads(@PathVariable("userId") final Integer userId) {
//        _log.info("getUserThreads: " + userId);
//        return threadService.getUserThreads(userId);
//    }
}