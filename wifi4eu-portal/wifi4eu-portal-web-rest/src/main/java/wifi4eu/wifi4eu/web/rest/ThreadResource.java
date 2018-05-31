package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.ThreadDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.thread.ThreadService;
import wifi4eu.wifi4eu.service.thread.UserThreadsService;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/thread", description = "Thread object REST API services")
@RequestMapping("thread")
public class ThreadResource {
    @Autowired
    private ThreadService threadService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserThreadsService userThreadsService;

    @Autowired
    private PermissionChecker permissionChecker;

    Logger _log = LoggerFactory.getLogger(CallResource.class);

    @ApiOperation(value = "Get thread by specific id")
    @RequestMapping(value = "/{threadId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ThreadDTO getThreadById(@PathVariable("threadId") final Integer threadId, HttpServletResponse response) throws IOException {
        _log.info("getThreadById: " + threadId);
        try {
            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if (userThreadsService.getByUserIdAndThreadId(userDTO.getId(), threadId) == null) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
        } catch (AccessDeniedException ade) {
            if (_log.isErrorEnabled()) {
                _log.error("AccessDenied on 'getThreadById' operation.", ade);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        }
        return threadService.getThreadById(threadId);
    }

    @ApiOperation(value = "Get thread by specific type")
    @RequestMapping(value = "/type/{type}/reason/{reason}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ThreadDTO getThreadByTypeAndReason(@PathVariable("type") final Integer type, @PathVariable("reason") final String reason, HttpServletResponse response) throws IOException {
        _log.info("getThreadByTypeAndReason: " + type);
        try {
            UserDTO user = userService.getUserByUserContext(UserHolder.getUser());
            ThreadDTO thread = threadService.getThreadByTypeAndReason(type, reason);
            if (thread != null) {
                if (user.getType() != 5) {
                    if (userThreadsService.getByUserIdAndThreadId(user.getId(), thread.getId()) == null) {
                        throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
                    }
                }
            }
            return thread;
        } catch (AccessDeniedException ade) {
            if (_log.isErrorEnabled()) {
                _log.error("AccessDenied on 'getThreadByTypeAndReason' operation.", ade);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception ex){
            if (_log.isErrorEnabled()) {
                _log.error("AccessDenied on 'getThreadByTypeAndReason' operation.", ex);
            }
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return null;
        }
    }

    @ApiOperation(value = "Set mediation to thread")
    @RequestMapping(value = "{threadId}/setMediation", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO askMediationThread(@PathVariable("threadId") final Integer threadId, HttpServletResponse response) throws IOException {
        _log.info("setMediationThread");
        try {
            UserDTO user = userService.getUserByUserContext(UserHolder.getUser());
            if (userThreadsService.getByUserIdAndThreadId(user.getId(), threadId) == null && !permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            ThreadDTO resThread = threadService.setMediationToThread(threadId);
            return new ResponseDTO(true, resThread, null);
        } catch (AccessDeniedException ade) {
            if (_log.isErrorEnabled()) {
                _log.error("AccessDenied on 'askMediationThread' operation.", ade);
            }
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'setMediationThread' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
        }
    }
}