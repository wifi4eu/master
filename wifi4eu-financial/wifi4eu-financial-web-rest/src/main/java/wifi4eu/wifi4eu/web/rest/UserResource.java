package wifi4eu.wifi4eu.web.rest;

import com.google.common.cache.CacheLoader;
import io.jsonwebtoken.ExpiredJwtException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.BeneficiaryDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.dto.security.ActivateAccountDTO;
import wifi4eu.wifi4eu.common.dto.security.UserDTO;
import wifi4eu.wifi4eu.common.security.UserSessionCache;
import wifi4eu.wifi4eu.service.security.AuthJWTokenizer;
import wifi4eu.wifi4eu.service.security.UserService;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.http.HttpServletResponse;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutionException;

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

    @Autowired
    private UserSessionCache sessionCache;

    @ApiOperation(value = "Service to do Login with a user email and SHA512 password")
    @RequestMapping(value = "login", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO login(@RequestBody final UserDTO userDTO, final HttpServletResponse response) {
        ResponseDTO result;
        _log.info("userDTO: " + userDTO.getEcasEmail());
        try {
            UserDTO user = userService.login(userDTO);

            String token = AuthJWTokenizer.encode(user.getEcasEmail());
            sessionCache.userSessionCache.put(token, user);

            user.setPassword(""); // Remove password

            result = new ResponseDTO(true, user, null);
            response.addHeader("token", token);
        } catch (UnsupportedEncodingException ex) {
            result = new ResponseDTO(false, null, new ErrorDTO(0, "Error in encoding JWT"));
        } catch (UsernameNotFoundException ex) {
            result = new ResponseDTO(false, null, new ErrorDTO(0, "can't login"));
        }
        _log.info("result: " + result);
        return result;
    }

    @ApiOperation(value = "Service to refresh the Authentication token")
    @RequestMapping(value = "refresh", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO refreshToken(@RequestBody final String oldToken, final HttpServletResponse response) throws UnsupportedEncodingException {
        ResponseDTO result = null;

        try {
            //decode old hash to generate new one
            AuthJWTokenizer.decode(oldToken);

        } catch (ExpiredJwtException ex) {

            //Invalidate previous hash session
            UserDTO user = null;
            try {

                user = sessionCache.userSessionCache.get(oldToken);
                sessionCache.userSessionCache.invalidate(oldToken);

                //Create new token and add it
                String token = AuthJWTokenizer.encode(user.getEcasEmail());
                sessionCache.userSessionCache.put(token, user);

                result = new ResponseDTO(true, token, null);

            } catch (ExecutionException | CacheLoader.InvalidCacheLoadException e) {
                result = new ResponseDTO(false, null, new ErrorDTO(0, "Error getting the user: " + e.getMessage()));
            }

        }

        _log.info("result: " + result);
        return result;
    }

    @ApiOperation(value = "Service to logout")
    @RequestMapping(value = "logout", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO logout(@RequestBody final String token, final HttpServletResponse response) {

        ResponseDTO result = null;
        try {

            String hashEmail = (String) AuthJWTokenizer.decode(token).get("email");
            sessionCache.userSessionCache.invalidate(hashEmail);
            result = new ResponseDTO(true, "", null);

        } catch (UnsupportedEncodingException ex) {
            result = new ResponseDTO(false, null, new ErrorDTO(0, "Error in encoding JWT" + ex.getMessage()));
        }

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
    public ResponseDTO resendEmail(@RequestBody final BeneficiaryDTO beneficiaryDTO, final HttpServletResponse response) {
        _log.info("Resend email...");
        try {
            userService.resendEmail(beneficiaryDTO);
            return new ResponseDTO(true, null, null);
        } catch (Exception e) {
            ErrorDTO errorDTO = new ErrorDTO(0, e.getMessage());
            return new ResponseDTO(false, null, errorDTO);
        }
    }


    @ApiOperation(value = "Service to change password of a user")
    @RequestMapping(value = "/changePassword/{userId}", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO changePassword(@PathVariable("userId") final long userId, @RequestBody final String passwords, final HttpServletResponse response) {
        JsonReader jsonReader = Json.createReader(new StringReader(passwords));
        JsonObject jsonPasswords = jsonReader.readObject();
        jsonReader.close();

        String currentPassword = jsonPasswords.getString("currentPassword");
        String newPassword = jsonPasswords.getString("newPassword");

        try {
            UserDTO userDTO = userService.getUserById(userId);
            if (userDTO != null) {
                System.out.println("userDTO.getPassword: " + userDTO.getPassword());
                if (userDTO.getPassword().equals(currentPassword)) {
                    userDTO.setPassword(newPassword);
                    UserDTO updatedUserDTO = userService.saveUser(userDTO);
                    return new ResponseDTO(true, updatedUserDTO, null);
                } else {
                    return new ResponseDTO(false, "Password doesn't match.", null);
                }
            } else {
                return new ResponseDTO(false, "Any user has been found with the ID '" + userId + "'.", null);
            }
        } catch (Exception e) {
            ErrorDTO errorDTO = new ErrorDTO(0, e.getMessage());
            return new ResponseDTO(false, null, errorDTO);
        }
    }

}