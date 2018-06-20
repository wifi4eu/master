package wifi4eu.wifi4eu.web.rest;


import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import wifi4eu.wifi4eu.service.azurequeue.AzureQueueService;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/azurequeue", description = "Manage azure queue operations")
public class AzureQueueResource {

    Logger _log = LogManager.getLogger(MayorResource.class);

    @Autowired
    AzureQueueService azureQueueService;

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
