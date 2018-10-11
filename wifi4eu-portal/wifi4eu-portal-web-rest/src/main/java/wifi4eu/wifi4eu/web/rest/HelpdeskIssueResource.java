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
            
            if (helpdeskIssueDTO != null && helpdeskIssueDTO.getSummary() != null) {
                _log.info("Summary size [{}], summary [{}]", helpdeskIssueDTO.getSummary().length(), (helpdeskIssueDTO.getSummary().length() <= 20 ? helpdeskIssueDTO.getSummary() : helpdeskIssueDTO.getSummary().substring(0, 20))); 
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
}