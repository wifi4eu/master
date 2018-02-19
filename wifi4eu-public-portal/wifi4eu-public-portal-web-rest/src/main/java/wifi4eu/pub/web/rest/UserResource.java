package wifi4eu.pub.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.user.UserService;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/user", description = "User object REST API services")
@RequestMapping("user")
public class UserResource {
    @Autowired
    private UserService userService;

    @Autowired
    private RegistrationService registrationService;

    Logger _log = LoggerFactory.getLogger(UserResource.class);

    @ApiOperation(value = "Service to do Login with a user email and SHA512 password")
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO login(@RequestBody final UserDTO userDTO) {
        try {
            _log.info("login: " + userDTO.getEcasEmail());
            UserDTO resUser = userService.login(userDTO);
            resUser.setPassword(null);
            if (registrationService.checkIfRegistrationIsKO(resUser.getId())) {
                return new ResponseDTO(false, resUser, null);
            }
            return new ResponseDTO(true, resUser, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'login' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }

    @ApiOperation(value = "Service to resend email with a link to activate account")
    @RequestMapping(value = "/resendEmail", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO resendEmail(@RequestBody final String email) {
        try {
            _log.info("Resend email to '" + email + "'...");
            if (userService.resendEmail(email)) {
                return new ResponseDTO(true, null, null);
            }
            return new ResponseDTO(false, null, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'resendEmail' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }
}