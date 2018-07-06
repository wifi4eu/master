package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.ApplicationCommentDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.entity.application.ApplicationComment;
import wifi4eu.wifi4eu.service.application.ApplicationCommentService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/application/comment", description = "Application comments from Commission/INEA")
@RequestMapping("application/comment")
public class ApplicationCommentResource {

    Logger _log = LogManager.getLogger(ApplicationCommentResource.class);

    @Autowired
    ApplicationCommentService applicationCommentService;

    @Autowired
    UserService userService;

    @Autowired
    PermissionChecker permissionChecker;

    @ApiOperation(value = "Create application comment")
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ApplicationCommentDTO createApplicationComment(@RequestBody ApplicationCommentDTO applicationCommentDTO, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        try {
            if(!permissionChecker.checkIfDashboardUser()){
                throw new AccessDeniedException("");
            }
        } catch (AccessDeniedException ade) {
            response.sendError(HttpStatus.NOT_FOUND.value());
        }
        catch (Exception ex){
            response.sendError(HttpStatus.BAD_REQUEST.value());
        }
        ApplicationCommentDTO responseApp = applicationCommentService.createApplicationComment(applicationCommentDTO);
        return responseApp;
    }

    @ApiOperation(value = "Get all comments for application")
    @RequestMapping(value = "/by-application/{applicationId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseDTO getApplicationCommentsByApplication(@PathVariable("applicationId") Integer applicationId,
                                                           @RequestParam("page") Integer page,
                                                           @RequestParam("size") Integer size,
                                                           @RequestParam("field") String field,
                                                           @RequestParam("direction") String direction, HttpServletResponse response) throws IOException {

        try{
            if(!permissionChecker.checkIfDashboardUser()){
                throw new AccessDeniedException("");
            }
            if(field.equalsIgnoreCase("username")){
                field = "user.ecasUsername";
            }
            Pageable pageable;
            if (direction.equals("ASC") || direction.equals("asc")) {
                pageable = new PageRequest(page, size, Sort.Direction.ASC, field);
            } else {
                pageable = new PageRequest(page, size, Sort.Direction.DESC, field);
            }
            return applicationCommentService.getApplicationCommentsByApplicationIdPaginated(applicationId, pageable);
        }catch (AccessDeniedException adex){
            response.sendError(HttpStatus.NOT_FOUND.value());
            return null;
        }catch (Exception ex){
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return null;
        }
    }

}
