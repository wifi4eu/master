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

    Logger _log = LogManager.getLogger(CallResource.class);

    /*
    @ApiOperation(value = "Get all the userThreads entries")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<UserThreadsDTO> allUserThreads() {
        return userThreadsService.getAllUserThreads();
    }
    */

    @ApiOperation(value = "Get userThreads by specific id")
    @RequestMapping(value = "/{userThreadsId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public UserThreadsDTO getUserThreadsById(@PathVariable("userThreadsId") final Integer userThreadsId) {
        _log.info("getUserThreadsById: " + userThreadsId);

        UserThreadsDTO userThreadsDTO = userThreadsService.getUserThreadsById(userThreadsId);

        permissionChecker.check(RightConstants.USER_TABLE + userThreadsDTO.getUserId());

        return userThreadsDTO;
    }

    /*

    @ApiOperation(value = "Create userThreads")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO createUserThreads(@RequestBody final UserThreadsDTO userThreadsDTO) {
        try {
            _log.info("createUserThreads");
            UserThreadsDTO resUserThreads = userThreadsService.createUserThreads(userThreadsDTO);
            return new ResponseDTO(true, resUserThreads, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'createUserThreads' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    */

    /*

    @ApiOperation(value = "Delete userThreads by specific id")
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseDTO deleteUserThreads(@RequestBody final Integer userThreadsId) {
        try {
            _log.info("deleteUserThreads: " + userThreadsId);
            UserThreadsDTO resUserThreads = userThreadsService.deleteUserThreads(userThreadsId);
            return new ResponseDTO(true, resUserThreads, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'deleteUserThreads' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    */

    @ApiOperation(value = "Get Threads by specific user id")
    @RequestMapping(value = "/userId/{userId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<UserThreadsDTO> getUserThreadsByUserId(@PathVariable("userId") final Integer userId) {
        _log.info("getUserThreadsByUserId: " + userId);

        permissionChecker.check(RightConstants.USER_TABLE + userId);

        return userThreadsService.getUserThreadsByUserId(userId);
    }

    @ApiOperation(value = "Get User by specific thread id")
    @RequestMapping(value = "/threadId/{threadId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<UserThreadsDTO> getUserThreadsByThreadId(@PathVariable("threadId") final Integer threadId, HttpServletResponse response) throws IOException {
        _log.info("getUserThreadsByThreadId: " + threadId);

        List<UserThreadsDTO> listUserThreadsDTO = userThreadsService.getUserThreadsByThreadId(threadId);

        boolean isUserThread = false;

        UserDTO currentUserDTO = userService.getUserByUserContext(UserHolder.getUser());

        for (UserThreadsDTO utDTO : listUserThreadsDTO) {
            if (utDTO.getUserId() == currentUserDTO.getId()) {
                isUserThread = true;
                break;
            }
        }

        if (!isUserThread) {
            try {
                if (userService.getUserByUserContext(UserHolder.getUser()).getType() != 5) {
                    throw new AccessDeniedException("");
                }
            } catch (AccessDeniedException ade) {
                if (_log.isErrorEnabled()) {
                    _log.error("Error on 'getUserThreadsByThreadId' operation.", ade);
                }
                response.sendError(HttpStatus.NOT_FOUND.value());
            } catch (Exception e) {
                if (_log.isErrorEnabled()) {
                    _log.error("Error on 'getUserThreadsByThreadId' operation.", e);
                }
                response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
            }
        }

        return listUserThreadsDTO;
    }

}