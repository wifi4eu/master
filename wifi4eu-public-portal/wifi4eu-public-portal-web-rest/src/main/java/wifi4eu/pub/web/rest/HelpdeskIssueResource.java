package wifi4eu.pub.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.HelpdeskIssueDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.helpdesk.HelpdeskService;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/helpdesk/issues", description = "Helpdesk issues REST API services")
@RequestMapping("helpdesk/issues")
public class HelpdeskIssueResource {
    @Autowired
    private HelpdeskService helpdeskService;

    Logger _log = LoggerFactory.getLogger(HelpdeskIssueResource.class);

    @ApiOperation(value = "Create helpdesk issue")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO createHelpdeskIssue(@RequestBody final HelpdeskIssueDTO helpdeskIssueDTO) {
        try {
            if (_log.isInfoEnabled()) {
                _log.info("createHelpdeskIssue");
            }
            HelpdeskIssueDTO resHelpdeskIssue = helpdeskService.createHelpdeskIssue(helpdeskIssueDTO);
            return new ResponseDTO(true, resHelpdeskIssue, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'createHelpdeskIssue' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }
}