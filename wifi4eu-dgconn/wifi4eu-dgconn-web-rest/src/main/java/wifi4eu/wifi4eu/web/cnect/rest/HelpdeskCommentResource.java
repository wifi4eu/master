package wifi4eu.wifi4eu.web.cnect.rest;

import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import wifi4eu.wifi4eu.service.helpdesk.HelpdeskService;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/helpdesk/comments", description = "Helpdesk comments REST API services")
@RequestMapping("helpdesk/comments")
public class HelpdeskCommentResource {
    @Autowired
    private HelpdeskService helpdeskService;

    Logger _log = LogManager.getLogger(CallResource.class);

    /*

    @ApiOperation(value = "Get all the helpdesk comments")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<HelpdeskCommentDTO> allHelpdeskComments() {
        _log.info("allHelpdeskComments");
        return helpdeskService.getAllHelpdeskComments();
    }

    @ApiOperation(value = "Get helpdesk comment by specific id")
    @RequestMapping(value = "/{commentId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public HelpdeskCommentDTO getHelpdeskCommentById(@PathVariable("commentId") final Integer commentId) {
        _log.info("getHelpdeskCommentById: " + commentId);
        return helpdeskService.getHelpdeskCommentById(commentId);
    }

    @ApiOperation(value = "Create helpdesk comment")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO createHelpdeskComment(@RequestBody final HelpdeskCommentDTO helpdeskCommentDTO) {
        try {
            _log.info("createHelpdeskComment");
            HelpdeskCommentDTO resHelpdeskComment = helpdeskService.createHelpdeskComment(helpdeskCommentDTO);
            return new ResponseDTO(true, resHelpdeskComment, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'createHelpdeskComment' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }


    @ApiOperation(value = "Delete helpdesk by specific id")
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseDTO deleteHelpdeskComment(@RequestBody final Integer commentId) {
        try {
            _log.info("deleteHelpdeskComment: " + commentId);
            HelpdeskCommentDTO resHelpdeskComment = helpdeskService.deleteHelpdeskComment(commentId);
            return new ResponseDTO(true, resHelpdeskComment, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'deleteHelpdeskComment' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }
    */
}