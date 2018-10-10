package wifi4eu.wifi4eu.web.cnect.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import wifi4eu.wifi4eu.common.dto.model.ApplicationCommentDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.common.utils.RequestIpRetriever;
import wifi4eu.wifi4eu.service.application.ApplicationCommentService;
import wifi4eu.wifi4eu.service.user.UserService;
import wifi4eu.wifi4eu.web.authorisation.DashboardUsersOnly;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/application/comment", description = "Application comments from Commission/INEA")
@RequestMapping("application/comment")
@DashboardUsersOnly
public class ApplicationCommentResource {

    private static final Logger _log = LoggerFactory.getLogger(ApplicationCommentResource.class);

    @Autowired
    private ApplicationCommentService applicationCommentService;

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Create application comment")
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ApplicationCommentDTO createApplicationComment(@RequestBody ApplicationCommentDTO applicationCommentDTO, HttpServletResponse response, HttpServletRequest request) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        try {
            ApplicationCommentDTO responseApp = applicationCommentService.createApplicationComment(applicationCommentDTO);
            if (_log.isDebugEnabled()) {
                _log.debug("[{}] - ECAS Username: {} - Success on creating a comment for application: {}",
                        new Object[]{RequestIpRetriever.getIp(request), userConnected.getEcasUsername(), applicationCommentDTO.getApplicationId()});
            }
            return responseApp;
        }
        catch (Exception e){
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Application comments cannot be retrieved", e.getMessage());
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return null;
        }
    }

    @ApiOperation(value = "Get all comments for application")
    @RequestMapping(value = "/by-application/{applicationId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO getApplicationCommentsByApplication(@PathVariable("applicationId") Integer applicationId,
                                                           @RequestParam("page") Integer page,
                                                           @RequestParam("size") Integer size,
                                                           @RequestParam("field") String field,
                                                           @RequestParam("direction") String direction, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Retrieving Commission/INEA application comments");
        try{
            if(field.equalsIgnoreCase("username")){
                field = "user.ecasUsername";
            }
            Pageable pageable;
            if (direction.equals("ASC") || direction.equals("asc")) {
                pageable = new PageRequest(page, size, Sort.Direction.ASC, field);
            } else {
                pageable = new PageRequest(page, size, Sort.Direction.DESC, field);
            }
            ResponseDTO responseDTO = applicationCommentService.getApplicationCommentsByApplicationIdPaginated(applicationId, pageable);
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - Success on retrieving Commission/INEA comments for application " + applicationId);
            return responseDTO;
        }catch (Exception e){
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + " - Application comments cannot be retrieved", e.getMessage());
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return null;
        }
    }

}
