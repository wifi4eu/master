package wifi4eu.wifi4eu.web.cnect.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.ThreadMessageDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.thread.ThreadMessageService;
import wifi4eu.wifi4eu.service.thread.UserThreadsService;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/thread/messages", description = "ThreadMessage object REST API services")
@RequestMapping("thread/messages")
public class ThreadMessageResource {
    @Autowired
    private ThreadMessageService threadMessageService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserThreadsService userThreadsService;

    @Autowired
    private PermissionChecker permissionChecker;

    Logger _log = LogManager.getLogger(ThreadMessageResource.class);

    @ApiOperation(value = "Create thread message")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO createThreadMessage(@RequestBody final ThreadMessageDTO threadMessageDTO, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Creating thread message");
        try {
            UserDTO user = userConnected;
            if (userThreadsService.getByUserIdAndThreadId(user.getId(), threadMessageDTO.getThreadId()) == null && !permissionChecker.checkIfDashboardUser()) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            if (threadMessageDTO.getAuthorId() != user.getId()) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            threadMessageDTO.setCreateDate(new Date().getTime());
            ThreadMessageDTO resThreadMessage = threadMessageService.createThreadMessage(threadMessageDTO);
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + "- Thread message created successfully");
            return new ResponseDTO(true, resThreadMessage, null);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to create thread messages", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- This thread message cannot been created", e);
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
    }
}