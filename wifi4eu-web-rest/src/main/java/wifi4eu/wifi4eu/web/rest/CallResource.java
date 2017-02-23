package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.codegen.CompilerConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.BeneficiaryDTO;
import wifi4eu.wifi4eu.common.dto.model.PublicationCallDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.call.CallService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by rgarcita on 22/02/2017.
 */

@Controller
@Api(description = "Publication of the call services")
@RequestMapping("call")
public class CallResource {

    Logger _log = LoggerFactory.getLogger(CallResource.class);

    @Autowired
    private CallService callService;


    @ApiOperation(value = "Get the active publication of the call")
    @RequestMapping(value="active",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public PublicationCallDTO activeCall(){

        return callService.getActiveCall();
    }

    @ApiOperation(value = "Get all the publication of the call")
    @RequestMapping(method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public List<PublicationCallDTO> allCalls(){

        return callService.getAllCalls();
    }

    @ApiOperation(value = "create Call")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createCall(@RequestBody final PublicationCallDTO publicationCallDTO, final HttpServletResponse response) {

        /* TODO: validate user rights, only DG Connect users can create a Call */

        callService.createCall(publicationCallDTO);

    }

}
