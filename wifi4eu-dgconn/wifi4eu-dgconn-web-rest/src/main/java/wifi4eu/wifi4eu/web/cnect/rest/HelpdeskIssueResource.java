package wifi4eu.wifi4eu.web.cnect.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.HelpdeskIssueDTO;
import wifi4eu.wifi4eu.common.dto.model.NutsDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.common.utils.HelpdeskIssueValidator;
import wifi4eu.wifi4eu.service.helpdesk.HelpdeskService;
import wifi4eu.wifi4eu.service.location.NutsService;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/helpdesk/issues", description = "Helpdesk issues REST API services")
@RequestMapping("helpdesk/issues")
public class HelpdeskIssueResource {

    @Autowired
    private HelpdeskService helpdeskService;

    @Autowired
    private UserService userService;

    @Autowired
    NutsService nutsService;

    Logger _log = LogManager.getLogger(HelpdeskIssueResource.class);

    @ApiOperation(value = "Get all the helpdesk issues")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<HelpdeskIssueDTO> allHelpdeskIssues(HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting all the helpdesk issues");
        try {
            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if (userDTO.getType() != 5) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to retrieve the helpdesk issues", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- Helpdesk issues cannot been retrieved", e);
            response.sendError(HttpStatus.NOT_FOUND.value());
        }
        return helpdeskService.getAllHelpdeskIssues();
    }

    @ApiOperation(value = "Get helpdesk issue by specific id")
    @RequestMapping(value = "/{issueId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public HelpdeskIssueDTO getHelpdeskIssueById(@PathVariable("issueId") final Integer issueId, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Getting helpdesk issue by id " + issueId);
        try {
            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if (userDTO.getType() != 5) {
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- Helpdesk issue cannot been retrieved", e);
            response.sendError(HttpStatus.NOT_FOUND.value());
        }
        return helpdeskService.getHelpdeskIssueById(issueId);
    }

    @ApiOperation(value = "Create helpdesk issue")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO createHelpdeskIssue(@RequestBody final HelpdeskIssueDTO helpdeskIssueDTO, HttpServletResponse response) throws IOException {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Creating helpdesk issue");
        try {
            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if (!userDTO.getEcasEmail().equals(helpdeskIssueDTO.getFromEmail())) {
                throw new AccessDeniedException("Invalid access");
            }
            List<NutsDTO> nuts = nutsService.getNutsByLevel(0);
            HelpdeskIssueValidator.validateHelpdeskIssue(helpdeskIssueDTO, nuts);

            helpdeskIssueDTO.setCreateDate(new Date().getTime());
            helpdeskIssueDTO.setStatus(0);
            HelpdeskIssueDTO resHelpdeskIssue = helpdeskService.createHelpdeskIssue(helpdeskIssueDTO);
            _log.info("ECAS Username: " + userConnected.getEcasUsername() + "- Helpdesk issue created successfully");
            return new ResponseDTO(true, resHelpdeskIssue, null);
        } catch (AccessDeniedException ade) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- You have no permissions to create the helpdesk issue", ade.getMessage());
            response.sendError(HttpStatus.NOT_FOUND.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()));
        } catch (Exception e) {
            _log.error("ECAS Username: " + userConnected.getEcasUsername() + "- Helpdesk issue cannot been created", e);
            response.sendError(HttpStatus.BAD_REQUEST.value());
            return new ResponseDTO(false, null, new ErrorDTO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
        }
    }

    /*
    @ApiOperation(value = "Delete helpdesk by specific id")
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseDTO deleteHelpdeskIssue(@RequestBody final Integer issueId, HttpServletResponse response) throws IOException {
        try {
            _log.info("deleteHelpdeskIssue: " + issueId);
            UserDTO userDTO = userService.getUserByUserContext(UserHolder.getUser());
            if(userDTO.getType() != 5){
                response.sendError(HttpStatus.NOT_FOUND.value());
                throw new AccessDeniedException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            HelpdeskIssueDTO resHelpdeskIssue = helpdeskService.deleteHelpdeskIssue(issueId);
            return new ResponseDTO(true, resHelpdeskIssue, null);
        }
        catch (AccessDeniedException ade) {
          if (_log.isErrorEnabled()) {
            _log.error("Access denied on 'deleteHelpdeskIssue' operation.", ade);
        }
            response.sendError(HttpStatus.NOT_FOUND.value());
        }
        catch (Exception e) {
            response.sendError(HttpStatus.NOT_FOUND.value());
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'deleteHelpdeskIssue' operation.", e);
            }
        }
        return new ResponseDTO(false, null, null);
    }
    */
}