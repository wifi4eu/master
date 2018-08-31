package wifi4eu.wifi4eu.web.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.RegistrationDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.util.RedisUtil;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.common.session.RecoverHttpSession;
import wifi4eu.wifi4eu.common.utils.RequestIpRetriever;
import wifi4eu.wifi4eu.entity.security.RightConstants;
import wifi4eu.wifi4eu.entity.user.UserContactDetails;
import wifi4eu.wifi4eu.repository.association.AssociationUsersRepository;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.util.RegistrationUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/user", description = "User object REST API services")
@RequestMapping("user")
public class UserResource {
    @Autowired
    private UserService userService;

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private PermissionChecker permissionChecker;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RegistrationUtils registrationUtils;

    @Autowired
    private AssociationUsersRepository associationUsersRepository;

    Logger _log = LogManager.getLogger(UserResource.class);

    @ApiOperation(value = "Get user by specific id")
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public UserDTO getUserById(@PathVariable("userId") final Integer userId, HttpServletResponse response) {
        UserDTO resUser = userService.getUserById(userId);
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Retrieving user by id " + userId);
        if (userConnected.getType() != 5) {
            permissionChecker.check(RightConstants.USER_TABLE + userId);
        }
        //check permission
        if (resUser != null) {
            resUser.setPassword(null);
        }
        return resUser;
    }

    @ApiOperation(value = "Update user details")
    @RequestMapping(value = "/update-user-details" , method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO updateUserDetails(@RequestBody final Map<String,Object> users, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        //Permissions
        ObjectMapper mapper = new ObjectMapper();
        List<UserContactDetails> usersList = mapper.convertValue(users.get("users"), new TypeReference<ArrayList<UserContactDetails>>(){});
        for (UserContactDetails user : usersList) {
            try {
                _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Updating user details by id " + user.getId());
                List<RegistrationDTO> registrations = registrationService.getRegistrationsByUserId(user.getId());
                for (RegistrationDTO registration : registrations) {
                    permissionChecker.check(RightConstants.REGISTRATIONS_TABLE + registration.getId());
                }
            } catch (AccessDeniedException ade) {
                _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - You have no permission to update user details", ade.getMessage
                        ());
                response.sendError(HttpStatus.NOT_FOUND.value());
                return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
            } catch (Exception e) {
                _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - The user details cannot been updated", e);
                response.sendError(HttpStatus.BAD_REQUEST.value());
                return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
            }
            return userService.updateUserDetails(userConnected, usersList);
        }
        return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
    }

    @ApiOperation(value = "Delete user by specific id")
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseDTO deleteUser(@RequestBody final Integer userId, HttpServletResponse response, HttpServletRequest request) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Removing user by id " + userId);
        try {
            //check permission
            permissionChecker.check(RightConstants.USER_TABLE + userId);
            ResponseDTO serviceResponse = userService.deleteUser(userId, request);
            _log.log(Level.getLevel("BUSINESS"), "[ " + RequestIpRetriever.getIp(request) + " ] - ECAS Username: " + userConnected.getEcasUsername
                    () + " - Deleted user information from the database");
            return serviceResponse;
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - You have no permission to remove this user", ade.getMessage());
            response.sendError(HttpStatus.FORBIDDEN.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.getReasonPhrase()));
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - The user cannot been removed", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
    }


    @ApiOperation(value = "Service to do Login with a ECAS User")
    @RequestMapping(value = "/ecaslogin", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO ecasLogin(HttpServletResponse response) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Logging in with ECAS User");
        // get registrationUsers relation pending to be approved for the user logging in
        userConnected = userService.checkIfInvitedUser(userConnected);
        try {
            Cookie cookie = userService.getCSRFCookie();
            redisUtil.sync(userConnected.getId());
            if (cookie != null) {
                response.addCookie(cookie);
            }
            return new ResponseDTO(true, userConnected, null);
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Cannot be logged in", e);
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
    }

    @ApiOperation(value = "Service to do Login with a ECAS User")
    @RequestMapping(value = "/complete-contact-details", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO completeInvitateContactDetails(@RequestBody final UserDTO userDTO, HttpServletResponse response) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        ResponseDTO responseDTO = new ResponseDTO();
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Logging in with ECAS User");
        try {

            if (userService.createAddContact(userDTO, userConnected)) {
                responseDTO.setSuccess(true);
                responseDTO.setData(userConnected);
                return responseDTO;
            }
            responseDTO.setSuccess(false);
            responseDTO.setData("-");

        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Error filling the missing fields of contact beneficiary", e);
            responseDTO.setSuccess(false);
            responseDTO.setData("-");
            responseDTO.setError(new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
        return responseDTO;
    }


    @ApiOperation(value = "Service to do Logout with a ECAS User")
    @RequestMapping(value = "/ecaslogout", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO ecasLogout() {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Logging out from ECAS User");
        try {
            return new ResponseDTO(true, userService.getLogoutEnviroment(), null);
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Cannot be logged out", e);
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
    }

    @ApiOperation(value = "Service to do Login with a ECAS User")
    @RequestMapping(value = "/ecasChangePassword", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO ecasChangePassword() {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Changing ECAS password");
        try {
            return new ResponseDTO(true, userService.getChangePassword(), null); //permissionChecker.check(RightConstants.USER_TABLE+userId);
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Cannot change ECAS password", e);
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
    }

    @ApiOperation(value = "Logout session")
    @RequestMapping(value = "/logout", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String doCompleteSignOut() {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Logging out session");
        final HttpSession session = RecoverHttpSession.session();
        String outMessage = "page.logout";

        if (session == null) {
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - Session has expired");
            outMessage = "page.not.session";
        } else {
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - Session is expiring");
            doLogout(session);
        }
        return outMessage;
    }

    private void doLogout(HttpSession session) {
        session.invalidate();
    }

    @ApiOperation(value = "Update new language for user")
    @RequestMapping(value = "/updateLanguage", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseDTO updateLanguage(@RequestBody final String language, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userDTO = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userDTO.getEcasUsername() + " - Updating user language notification emails by id " + userDTO.getId());
        try {
            userDTO = userService.updateLanguage(userDTO, language);
            return new ResponseDTO(true, userDTO, null);
        } catch (Exception e) {
            _log.error("ECAS Username: " + userDTO.getEcasUsername() + " - Cannot change notifications language", e);
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
    }

    @ApiOperation(value = "Get all users from registration")
    @RequestMapping(value = "/registrationUsers/{registrationId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<UserContactDetails> getUsersFromRegistration(@PathVariable("registrationId") Integer registrationId) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Retrieving users from registration");
        try {
            return registrationService.findUsersContactDetailsByRegistrationId(registrationId);
            // return registrationService.getUsersFromRegistration(registrationId);
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- Users cannot been retrieved", e);
            return null;
        }
    }

    @ApiOperation(value = "Get all users from association")
    @RequestMapping(value = "/registrationUsers-from-association/{idAssociation}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<UserContactDetails> getUsersFromAssociation(@PathVariable("idAssociation") Integer idAssociation, boolean isOrganization) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Retrieving users from registration");
        try {
            registrationUtils.checkAssociationPermissions(idAssociation);
            return registrationService.findUsersContactDetailsByAssociationId(idAssociation);
            // return registrationService.getUsersFromRegistration(registrationId);
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- Users cannot been retrieved", e);
            return null;
        }
    }

    @ApiOperation(value = "Edit method")
    @RequestMapping(value = "/edit", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public ResponseDTO editDummy(@RequestBody UserContactDetails userContactDetails) {
        return new ResponseDTO(true, "not implemented", new ErrorDTO());
    }


    @ApiOperation(value = "Update new language for user")
    @RequestMapping(value = "/checkIfApplied", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO checkIfApplied() {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            if (Validator.isNotNull(userConnected)) {
                if (userConnected.getType() != 3) {
                    throw new AccessDeniedException("");
                }
                responseDTO.setSuccess(true);
                responseDTO.setData(userService.checkIfApplied(userConnected));
            } else {
                responseDTO.setSuccess(false);
                responseDTO.setData("");
                responseDTO.setError(new ErrorDTO(400, "User not found"));
            }

        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- Users cannot been checked", e);
            responseDTO.setSuccess(false);
            responseDTO.setData("");
            responseDTO.setError(new ErrorDTO(400, "Bad Request"));
        }

        return responseDTO;
    }

    @ApiOperation(value = "Check if user has voucher assigned applications")
    @RequestMapping(value = "/checkIfVoucher", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO checkIfVoucherAwarded() {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            if(Validator.isNotNull(userConnected)){
                if(userConnected.getType() != 3){
                    throw new AccessDeniedException("");
                }
                responseDTO.setSuccess(true);
                responseDTO.setData(userService.checkIfVoucherAwarded(userConnected));
            } else {
                responseDTO.setSuccess(false);
                responseDTO.setData("");
                responseDTO.setError(new ErrorDTO(400, "User not found"));
            }
        }catch(Exception e){
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- User cannot been checked", e);
            responseDTO.setSuccess(false);
            responseDTO.setData("");
            responseDTO.setError(new ErrorDTO(400, "Bad Request"));
        }
        return responseDTO;
    }

    @ApiOperation(value = "Deactivate user from registration")
    @RequestMapping(value = "/registrationUsers/deactivate/{userId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO deactivateRegistrationUser(@PathVariable("userId") Integer userId,
                                                  HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Deactivating user " + userId );
        try {
            //user connected cannot deactivate itself
            if (userConnected.getId() == userId) {
                _log.info("ECAS Username: " + userConnected.getEcasUsername() + "- Trying to deactive itself.");
                response.sendError(HttpStatus.BAD_REQUEST.value());
                return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
            }
            //user connected has to have permission for all registrations related to this user
            List<RegistrationDTO> registrationDTOS = registrationService.getRegistrationsByUserId(userId);
            if (registrationDTOS.isEmpty()) {
                _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- Cannot been retrieved user's registrations");
                response.sendError(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR.value());
                return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
            } else {
                for (RegistrationDTO registrationDTO :registrationDTOS) {
                    permissionChecker.check(RightConstants.REGISTRATIONS_TABLE + registrationDTO.getId());
                }
            }

            return userService.deactivateRegistrationUser(registrationDTOS, userId, userConnected.getEcasUsername());
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to retrieve this registration", ade
                    .getMessage());
            response.sendError(org.springframework.http.HttpStatus.NOT_FOUND.value());
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- This registration cannot been retrieved", e);
            response.sendError(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return new ResponseDTO();
    }
}