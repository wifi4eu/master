package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.HelpdeskCommentDTO;
import wifi4eu.wifi4eu.common.dto.model.HelpdeskDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.helpdesk.HelpdeskService;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/helpdesk", description = "Helpdesk services")
@RequestMapping("helpdesk")
public class HelpdeskResource {

    Logger _log = LoggerFactory.getLogger(HelpdeskResource.class);

    @Autowired
    private HelpdeskService helpdeskService;

    @ApiOperation(value = "Get all the helpdesk entries")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<HelpdeskDTO> allHelpdeskIssues() {
        List<HelpdeskDTO> issues = helpdeskService.getAllHelpdeskIssues();
        if (issues != null) {
            for (int i = 0; i < issues.size(); i++) {
                issues.get(i).setComments(helpdeskService.getHelpdeskIssueComments(issues.get(i).getIssueId()));
//                List<HelpdeskCommentDTO> comments = helpdeskService.getHelpdeskIssueComments(issues.get(i).getIssueId());
//                if (comments != null) {
//                    issues.get(i).setComments(comments);
//                }
            }
        }
        return issues;
    }

    @ApiOperation(value = "Get helpdesk issue by issueId")
    @RequestMapping(value = "/{issueId}", method = RequestMethod.GET, produces = "application/JSON")
    @ResponseBody
    public HelpdeskDTO getHelpdeskIssue(@PathVariable("issueId") final Long issueId, final HttpServletResponse response) {
        _log.info("getHelpdeskIssue " + issueId);
        HelpdeskDTO issue = helpdeskService.getHelpdeskIssue(issueId);
        issue.setComments(helpdeskService.getHelpdeskIssueComments(issueId));
        return issue;

    }

    @ApiOperation(value = "create helpdesk issue")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO createHelpdeskIssue(@RequestBody final HelpdeskDTO helpdeskDTO, final HttpServletResponse response) {
        try {
            HelpdeskDTO resHelpdesk = helpdeskService.createHelpdeskIssue(helpdeskDTO);
            return new ResponseDTO(true, resHelpdesk, null);
        } catch (Exception e) {
            ErrorDTO errorDTO = new ErrorDTO(0, e.getMessage());
            return new ResponseDTO(false, null, errorDTO);
        }
    }
}
