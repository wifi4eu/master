package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.dto.security.ActivateAccountDTO;
import wifi4eu.wifi4eu.common.dto.security.UserDTO;
import wifi4eu.wifi4eu.service.security.UserService;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by rgarcita on 15/02/2017.
 */
@CrossOrigin(origins = "*")
@Controller
@Api(value = "/user", description = "UserResource")
@RequestMapping("user")
public class UserResource {


    Logger _log = LoggerFactory.getLogger(UserResource.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Service to do Login with a user email and SHA512 password")
    @RequestMapping(value = "login", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO login(@RequestBody final UserDTO userDTO, final HttpServletResponse response) {
        _log.info("userDTO: " + userDTO.getEmail());
        ResponseDTO result = userService.login(userDTO);
        _log.info("result: " + result);
        return result;
    }

    @ApiOperation(value = "Send forgot password mail with a link to reset password")
    @RequestMapping(value = "forgotpassword", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO forgotPassword(@RequestBody final String email, final HttpServletResponse response) {

        _log.info("forgot Password: " + email);

        try {
            userService.forgotPassword(email);
            return new ResponseDTO(true, null, null);
        } catch (Exception e) {
            ErrorDTO errorDTO = new ErrorDTO(0, e.getMessage());
            return new ResponseDTO(false, null, errorDTO);
        }

    }

    @ApiOperation(value = "Activate account or reset password")
    @RequestMapping(value = "activateaccount", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO activateAccount(@RequestBody final ActivateAccountDTO activateAccountDTO, final HttpServletResponse response) {

        _log.info("activate Account: ");

        try {
            userService.activateAccount(activateAccountDTO);
            return new ResponseDTO(true, null, null);
        } catch (Exception e) {
            ErrorDTO errorDTO = new ErrorDTO(0, e.getMessage());
            return new ResponseDTO(false, null, errorDTO);
        }


    }


    @ApiOperation(value = "Service to resend email with a link to activate account")
    @RequestMapping(value = "resendemail", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO resendEmail(@RequestBody final UserDTO userDTO, final HttpServletResponse response) {
        try {
            userService.sendActivateAccountMail(userDTO);
            return new ResponseDTO(true, null, null);
        } catch (Exception e) {
            ErrorDTO errorDTO = new ErrorDTO(0, e.getMessage());
            return new ResponseDTO(false, null, errorDTO);
        }
    }

}
