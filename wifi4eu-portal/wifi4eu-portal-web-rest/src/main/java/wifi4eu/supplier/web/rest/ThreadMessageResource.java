package wifi4eu.supplier.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.ThreadMessageDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.thread.ThreadMessageService;

import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/thread/messages", description = "ThreadMessage object REST API services")
@RequestMapping("thread/messages")
public class ThreadMessageResource {
    @Autowired
    private ThreadMessageService threadMessageService;

    Logger _log = LoggerFactory.getLogger(CallResource.class);

    @ApiOperation(value = "Get all the thread messages entries")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<ThreadMessageDTO> allThreadMessages() {
        return threadMessageService.getAllThreadMessages();
    }

    @ApiOperation(value = "Get thread message by specific id")
    @RequestMapping(value = "/{threadMessageId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ThreadMessageDTO getThreadMessageById(@PathVariable("threadMessageId") final Integer threadMessageId) {
        _log.info("getThreadMessageById: " + threadMessageId);
        return threadMessageService.getThreadMessageById(threadMessageId);
    }

    @ApiOperation(value = "Create thread message")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO createThreadMessage(@RequestBody final ThreadMessageDTO threadMessageDTO) {
        try {
            _log.info("createThreadMessage");
            ThreadMessageDTO resThreadMessage = threadMessageService.createThreadMessage(threadMessageDTO);
            return new ResponseDTO(true, resThreadMessage, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'createThreadMessage' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }


    @ApiOperation(value = "Delete thread message by specific id")
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseDTO deleteThreadMessage(@RequestBody final Integer threadMessageId) {
        try {
            _log.info("deleteThreadMessage: " + threadMessageId);
            ThreadMessageDTO resThreadMessage = threadMessageService.deleteThreadMessage(threadMessageId);
            return new ResponseDTO(true, resThreadMessage, null);
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'deleteThreadMessage' operation.", e);
            }
            return new ResponseDTO(false, null, new ErrorDTO(0, e.getMessage()));
        }
    }
}