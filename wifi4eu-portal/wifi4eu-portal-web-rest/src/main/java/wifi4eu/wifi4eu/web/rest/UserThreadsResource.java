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
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.model.UserThreadsDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.entity.security.RightConstants;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.thread.UserThreadsService;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/userThreads", description = "UserThreads object REST API services")
@RequestMapping("userThreads")
public class UserThreadsResource {

    @Autowired
    private UserThreadsService userThreadsService;

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionChecker permissionChecker;

    Logger _log = LogManager.getLogger(UserThreadsResource.class);

    @ApiOperation(value = "Get userThreads")
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public UserThreadsDTO getUserThreadsById() {
        return new UserThreadsDTO();
    }

    @ApiOperation(value = "Get Threads by specific user id")
    @RequestMapping(value = "/userId/{userId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<UserThreadsDTO> getUserThreadsByUserId(@PathVariable("userId") final Integer userId) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Retrieving threads by user id " + userId);
        permissionChecker.check(RightConstants.USER_TABLE + userId);
        return userThreadsService.getUserThreadsByUserId(userId);
    }

    @ApiOperation(value = "Get User by specific thread id")
    @RequestMapping(value = "/threadId/{threadId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<UserThreadsDTO> getUserThreadsByThreadId(@PathVariable("threadId") final Integer threadId, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Retrieving user by thread id " + threadId);
        List<UserThreadsDTO> listUserThreadsDTO = userThreadsService.getUserThreadsByThreadId(threadId);
        boolean isUserThread = false;
        for (UserThreadsDTO utDTO : listUserThreadsDTO) {
            if (utDTO.getUserId() == userConnected.getId()) {
                isUserThread = true;
                _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - User thread with id " + utDTO.getId() + " is from this user");
                break;
            }
        }
        if (!isUserThread) {
            try {
                if (userService.getUserByUserContext(UserHolder.getUser()).getType() != 5) {
                    throw new AccessDeniedException("");
                }
            } catch (AccessDeniedException ade) {
                _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - You have no permission to retrieve users by thread", ade.getMessage());
                response.sendError(HttpStatus.NOT_FOUND.value());
            } catch (Exception e) {
                _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - The user cannot been retrieved", e);
                response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
            }
        }
        return listUserThreadsDTO;
    }

}