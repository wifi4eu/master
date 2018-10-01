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
import wifi4eu.wifi4eu.common.dto.model.ThreadDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.thread.ThreadService;
import wifi4eu.wifi4eu.service.thread.UserThreadsService;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    Logger _log = LogManager.getLogger(ThreadResource.class);

    @ApiOperation(value = "Get thread by specific id")
    @RequestMapping(value = "/{threadId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ThreadDTO getThreadById(@PathVariable("threadId") final Integer threadId, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting thread by id " + threadId);
        try {
            if (userThreadsService.getByUserIdAndThreadId(userConnected.getId(), threadId) == null) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to retrieve this thread", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        }
        return threadService.getThreadById(threadId);
    }


    @ApiOperation(value = "Get thread by specific type")
    @RequestMapping(value = "/type/{type}/reason/{reason}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO getThreadByTypeAndReason(@PathVariable("type") final Integer type, @PathVariable("reason") final String reason, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting thread by type " + type + " and reason " + reason);
        try {
            ThreadDTO thread = threadService.getThreadByTypeAndReason(type, reason);
            if (thread != null) {
                if (userConnected.getType() != 5) {
                    if (userThreadsService.getByUserIdAndThreadId(userConnected.getId(), thread.getId()) == null) {
                        throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
                    }
                }
            }
            return new ResponseDTO(true, thread, null);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to retrieve this thread", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- This thread cannot been retrieved", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return null;
        }
    }

    //COMMENTED BY ORDER OF BERT 06/09/2018
    /*@ApiOperation(value = "Set mediation to thread")
    @RequestMapping(value = "{threadId}/setMediation", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO askMediationThread(@PathVariable("threadId") final Integer threadId, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Setting mediation to thread with id " + threadId);
        try {
            if (userThreadsService.getByUserIdAndThreadId(userConnected.getId(), threadId) == null && !permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            ThreadDTO resThread = threadService.setMediationToThread(threadId);
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + "- Mediation set to thread successfully");
            return new ResponseDTO(true, resThread, null);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to set mediation to threads", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- This thread cannot been set with mediation", e);
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
        }
    }*/
}