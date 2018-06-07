package wifi4eu.wifi4eu.web.rest;


import com.microsoft.azure.storage.queue.CloudQueueMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.AzureQueueDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
//import wifi4eu.wifi4eu.service.azurequeue.AzureQueueService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/azurequeue", description = "Manage azure queue operations")
public class AzureQueueResource {

    Logger _log = LoggerFactory.getLogger(MayorResource.class);

    //@Autowired
    //AzureQueueService azureQueueService;

    /*

    @ApiOperation(value = "Create mayor")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO addMessageAzureQueue(@RequestBody final AzureQueueDTO anAzureQueueMessageDTO,
                                   HttpServletResponse response) throws IOException {
        try {
            _log.info("addMessageAzureQueue");

            azureQueueService.createAzureQueue("stressqueue-1");
            azureQueueService.removeMessagesQueue();

            return new ResponseDTO(true, anAzureQueueMessageDTO, null);
        } catch (AccessDeniedException ade) {
            if (_log.isErrorEnabled()) {
                _log.error("Error with permission on 'addMessageAzureQueue' operation.", ade);
            }
            response.sendError(HttpStatus.FORBIDDEN.value());
            return new ResponseDTO(false, null, new ErrorDTO(403, ade.getMessage()));
        } catch (Exception e) {
            if (_log.isErrorEnabled()) {
                _log.error("Error on 'addMessageAzureQueue' operation.", e);
            }
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseDTO(false, null, new ErrorDTO(500, e.getMessage()));
        }
    }
    */
}
