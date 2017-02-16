package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.BeneficiaryDTO;
import wifi4eu.wifi4eu.common.dto.model.LegalEntityDTO;
import wifi4eu.wifi4eu.common.dto.security.UserDTO;
import wifi4eu.wifi4eu.service.security.UserService;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by rgarcita on 15/02/2017.
 */
@Controller
@Api(description = "UserResource")
@RequestMapping("user")
public class UserResource {


    Logger _log = LoggerFactory.getLogger(UserResource.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value = "get legal Entity information")
    @RequestMapping(value="login",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public String login(@RequestBody final UserDTO userDTO, final HttpServletResponse response) {
        _log.info("userDTO: " + userDTO.getEmail());
        String result = userService.login(userDTO);
        _log.info("result: " + result);
        return result;
    }

}
