package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.user.UserService;

import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/user", description = "User object REST API services")
@RequestMapping("user")
public class UserResource {
    @Autowired
    private UserService userService;

    Logger _log = LoggerFactory.getLogger(UserResource.class);

    @ApiOperation(value = "Get all the users")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<UserDTO> allUsers() {
        _log.info("allUsers");
        return userService.getAllUsers();
    }

    @ApiOperation(value = "Get user by specific id")
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public UserDTO getUserById(@PathVariable("userId") final Integer userId) {
        _log.info("getUserById: " + userId);
        return userService.getUserById(userId);
    }

    @ApiOperation(value = "Create user")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO createUser(@RequestBody final UserDTO userDTO) {
        try {
            _log.info("createUser");
            UserDTO resUser = userService.createUser(userDTO);
            return new ResponseDTO(true, resUser, null);
        } catch (Exception e) {
            ErrorDTO errorDTO = new ErrorDTO(0, e.getMessage());
            return new ResponseDTO(false, null, errorDTO);
        }
    }

    @ApiOperation(value = "Delete user by specific id")
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseDTO deleteUser(@RequestBody final Integer userId) {
        try {
            _log.info("deleteUser: " + userId);
            UserDTO resUser = userService.deleteUser(userId);
            return new ResponseDTO(true, resUser, null);
        } catch (Exception e) {
            ErrorDTO errorDTO = new ErrorDTO(0, e.getMessage());
            return new ResponseDTO(false, null, errorDTO);
        }
    }

    @ApiOperation(value = "Get users by specific type number")
    @RequestMapping(value = "/type/{type}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<UserDTO> getUsersByType(@PathVariable("type") final Integer type) {
        _log.info("getUsersByType" + type);
        return userService.getUsersByType(type);
    }

    @ApiOperation(value = "Service to do Login with a user email and SHA512 password")
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO login(@RequestBody final UserDTO userDTO) {
        ResponseDTO result;
        try {
            _log.info("login: " + userDTO.getEmail());
            UserDTO resUser = userService.login(userDTO);
            resUser.setPassword(""); // Remove password
            return new ResponseDTO(true, resUser, null);
        } catch (UsernameNotFoundException ex) {
            return new ResponseDTO(false, null, new ErrorDTO(0, ex.getLocalizedMessage()));
        }
    }
}