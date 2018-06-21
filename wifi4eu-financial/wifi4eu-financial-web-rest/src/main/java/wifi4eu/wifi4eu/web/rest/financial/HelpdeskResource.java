package wifi4eu.wifi4eu.web.rest.financial;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.HelpdeskCommentDTO;
import wifi4eu.wifi4eu.common.dto.model.HelpdeskIssueDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.helpdesk.HelpdeskService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/helpdesk", description = "Helpdesk services")
@RequestMapping("helpdesk")
public class HelpdeskResource {

    Logger _log = LoggerFactory.getLogger(HelpdeskResource.class);

    private static final String CSV_FILE_NAME = "issues.csv";

    @Autowired
    private HelpdeskService helpdeskService;

    @ApiOperation(value = "Get all the helpdesk entries")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<HelpdeskIssueDTO> allHelpdeskIssues() {
        List<HelpdeskIssueDTO> issues = helpdeskService.getAllHelpdeskIssues();
        if (issues != null) {
            for (int i = 0; i < issues.size(); i++) {
                Integer value=issues.get(i).getId();
                issues.get(i).setComments(helpdeskService.getHelpdeskIssueComments(value.longValue()));
            }
        }
        return issues;
    }

    @ApiOperation(value = "Get helpdesk issue by issueId")
    @RequestMapping(value = "/{issueId}", method = RequestMethod.GET, produces = "application/JSON")
    @ResponseBody
    public HelpdeskIssueDTO getHelpdeskIssue(@PathVariable("issueId") final Long issueId, final HttpServletResponse response) {
        _log.info("getHelpdeskIssue " + issueId);
        HelpdeskIssueDTO issue = helpdeskService.getHelpdeskIssue(issueId);
        issue.setComments(helpdeskService.getHelpdeskIssueComments(issueId));
        return issue;

    }

    @ApiOperation(value = "create helpdesk issue")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO createHelpdeskIssue(@RequestBody final HelpdeskIssueDTO helpdeskDTO, final HttpServletResponse response) {
        try {
            HelpdeskIssueDTO resHelpdesk = helpdeskService.createHelpdeskIssue(helpdeskDTO);
            return new ResponseDTO(true, resHelpdesk, null);
        } catch (Exception e) {
            ErrorDTO errorDTO = new ErrorDTO(0, e.getMessage());
            return new ResponseDTO(false, null, errorDTO);
        }
    }

    @ApiOperation(value = "create helpdesk comment")
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO createHelpdeskComment(@RequestBody final HelpdeskCommentDTO helpdeskCommentDTO, final HttpServletResponse response) {
        try {
            HelpdeskCommentDTO resHelpdeskComment = helpdeskService.createHelpdeskComment(helpdeskCommentDTO);
            return new ResponseDTO(true, resHelpdeskComment, null);
        } catch (Exception e) {
            ErrorDTO errorDTO = new ErrorDTO(0, e.getMessage());
            return new ResponseDTO(false, null, errorDTO);
        }
    }

    @ApiOperation(value = "Get helpdesk issue by issueId")
    @RequestMapping(value = "/export")
    @ResponseBody
    public FileSystemResource exportHelpdeskIssues(final HttpServletResponse response) {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename='"+CSV_FILE_NAME+"'");

        return new FileSystemResource(helpdeskService.exportHelpdeskIssues());
    }
}
